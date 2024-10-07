package com.jklmao.plugin.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.enums.TeleportMode;
import com.jklmao.plugin.enums.TeleportType;
import com.jklmao.plugin.events.TpaCountdownListener;
import com.jklmao.plugin.utils.ConfigUtil;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpaccept implements CommandExecutor, TabCompleter, ConfigUtil {

	private ClickTpa clicktpa;

	public CommandTpaccept(ClickTpa pl) {
		clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int seconds = clicktpa.getConfig().getInt("Seconds-until-tpa");

		if (!(sender instanceof Player)) {
			sender.sendMessage(getMsg("Player-only-command"));
			return true;
		}

		final Player p = (Player) sender;

		if (!p.hasPermission("clicktpa.tpaccept")) {
			p.sendMessage(getMsg("Insufficient-permission"));
			return true;
		}

		if (args.length == 0) {
			p.sendMessage(getMsg("Tpaccept-usage"));
			return true;
		}

		if (clicktpa.getTpaPlayers().get(p).getTpaList().isEmpty()) {
			p.sendMessage(getMsg("No-pending-tpa"));
			return true;
		}

		final Player target = Bukkit.getPlayer(args[0]);

		if (target == p) {
			p.sendMessage(getMsg("Tpaccept-usage"));
			return true;
		}

		if (target == null) {
			p.sendMessage(getMsg("No-player-found"));
			return true;
		}

		if (!target.isOnline()) {
			p.sendMessage(getMsg("Target-is-offline").replaceAll("%target%", target.getName()));

			for (TpaInfoList list : clicktpa.getTpaPlayers().get(p).getTpaList()) {
				if (list.getRequester() == target) {
					clicktpa.getTpaPlayers().get(p).getTpaList().remove(list);
					clicktpa.getTpaCancel().remove(target);
					return true;
				}
			}
		}

		if (clicktpa.getTpaPlayers().get(p).getTpaList().size() == 0) {
			p.sendMessage(getMsg("No-pending-tpa"));
			return true;
		} else {

			TpaInfoList tpaInfo = null;
			boolean hasRequester = false;

			for (TpaInfoList list : clicktpa.getTpaPlayers().get(p).getTpaList()) {

				if (list.getRequester() == target) {
					hasRequester = true;
					tpaInfo = list;
					break;
				}
			}

			if (!hasRequester) {
				p.sendMessage(getMsg("No-pending-tpa"));
				return true;
			}

			target.sendMessage(getMsg("Player-accepted-request").replaceAll("%target%", p.getName()));
			p.sendMessage(getMsg("Target-accepted-request").replaceAll("%player%", target.getName()));

			TpaCountdownListener cdListener = new TpaCountdownListener(clicktpa);

			switch (tpaInfo.getType()) {

			case TPA:
				target.sendMessage(getMsg("Countdown-until-tpa"));
				clicktpa.getTpaPlayers().get(target).setMode(TeleportMode.TELEPORTING);
				clicktpa.getGraceList().add(target);
				cdListener.tpaCountdown(seconds, TeleportType.TPA, p, target); // target = person who sent the request
				break;
			case TPAHERE:
				p.sendMessage(getMsg("Countdown-until-tpa"));
				clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.TELEPORTING);
				clicktpa.getGraceList().add(p);
				cdListener.tpaCountdown(seconds, TeleportType.TPAHERE, p, target);
				break;
			}

			cdListener.removeTpaInfo(p, target);
			clicktpa.getTpaCancel().remove(target);

			return true;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

		if (args.length == 0) {
			Player p = (Player) sender;
			List<String> currentReq = new ArrayList<String>();

			for (TpaInfoList request : clicktpa.getTpaPlayers().get(p).getTpaList())
				currentReq.add(request.getRequester().getName());

			return currentReq;

		}
		return null;
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}