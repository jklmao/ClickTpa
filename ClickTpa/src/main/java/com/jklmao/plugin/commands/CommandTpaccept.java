package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.enums.TeleportMode;
import com.jklmao.plugin.enums.TeleportType;
import com.jklmao.plugin.events.TpaCountdownListener;
import com.jklmao.plugin.utils.ConfigUtil;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpaccept implements CommandExecutor, ConfigUtil {

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

		Player p = (Player) sender;

		if (!p.hasPermission("clicktpa.tpaccept")) {
			p.sendMessage(getMsg("Insufficient-permission"));
			return true;
		}

		if (args.length == 0) {
			p.sendMessage(getMsg("Tpaccept-usage"));
			return true;
		}

		Player target = Bukkit.getPlayer(args[0]);

		if (target == null) {
			p.sendMessage(getMsg("No-player-found"));
			return true;
		}

		if (!target.isOnline()) {
			p.sendMessage(getMsg("Target-is-offline"));

			for (TpaInfoList list : clicktpa.getTpaPlayers().get(p).getTpaList()) {
				if (list.getRequester() == target) {
					clicktpa.getTpaPlayers().get(p).getTpaList().remove(list);
					clicktpa.getTpaCancel().remove(target);
					return true;
				}
			}
		}

		if (clicktpa.getTpaPlayers().get(p).getTpaList().isEmpty()) {
			p.sendMessage(getMsg("Player-no-pendingtpa-message"));
			return true;
		}

		TpaInfoList tpaInfo = null;

		if (clicktpa.getTpaPlayers().get(p).getTpaList().size() > 0) {

			boolean hasRequester = false;
			for (TpaInfoList list : clicktpa.getTpaPlayers().get(p).getTpaList()) {

				if (list.getRequester() == target) {
					hasRequester = true;
					tpaInfo = list;
					break;
				}
			}

			if (!hasRequester) {
				p.sendMessage(getMsg("Player-no-pendingtpa-message"));
				return true;
			}

		}

		p.sendMessage(getMsg("Player-got-accepted-tpa"));
		target.sendMessage(getMsg("Target-accepted-tpa-request"));

		TpaCountdownListener cdListener = new TpaCountdownListener(clicktpa);

		switch (tpaInfo.getType()) {

		case TPA:
			target.sendMessage(getMsg("Countdown-until-tpa"));
			clicktpa.getTpaPlayers().get(target).setMode(TeleportMode.TELEPORTING);
			clicktpa.getGraceList().add(target);
			cdListener.tpaCountdown(seconds, TeleportType.TPA, p, target);
			break;
		case TPAHERE:
			p.sendMessage(getMsg("Countdown-until-tpa"));
			clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.TELEPORTING);
			clicktpa.getGraceList().add(p);
			cdListener.tpaCountdown(seconds, TeleportType.TPAHERE, p, target);
			break;
		}

		clicktpa.getTpaCancel().remove(target);

		return true;
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}