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
import com.jklmao.plugin.utils.ConfigUtil;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpaDeny implements CommandExecutor, TabCompleter, ConfigUtil {

	private ClickTpa clicktpa;

	public CommandTpaDeny(ClickTpa pl) {
		clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(getMsg("Player-only-command"));
			return true;
		}

		final Player p = (Player) sender;

		if (!p.hasPermission("clicktpa.tpadeny")) {
			p.sendMessage(getMsg("Insufficient-permission"));
			return true;
		}

		if (args.length == 0) {
			p.sendMessage(getMsg("Tpdeny-usage"));
			return true;
		}

		if (clicktpa.getTpaPlayers().get(p).getTpaList().isEmpty()) {
			p.sendMessage(getMsg("No-pending-tpa"));
			return true;
		}
		final Player target = Bukkit.getPlayer(args[0]);

		if (target == p) {
			p.sendMessage(getMsg("Tpdeny-usage"));
			return true;
		}

		if (target == null) {
			p.sendMessage(getMsg("No-player-found"));
			return true;
		}

		if (target.isOnline()) {

			target.sendMessage(getMsg("Player-denied-request").replaceAll("%target%", p.getName()));
			p.sendMessage(getMsg("Target-denied-request").replaceAll("%player%", target.getName()));

		} else
			p.sendMessage(getMsg("Target-is-offline").replaceAll("%target%", target.getName()));

		for (TpaInfoList list : clicktpa.getTpaPlayers().get(p).getTpaList()) {
			if (list.getRequester() == target) {
				clicktpa.getTpaPlayers().get(p).getTpaList().remove(list);
				clicktpa.getTpaCancel().remove(target);
				return true;
			}
		}

		return true;

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
