package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.ConfigUtil;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpCancel implements CommandExecutor, ConfigUtil {
	private ClickTpa clicktpa;

	public CommandTpCancel(ClickTpa pl) {
		clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (!p.hasPermission("clicktpa.tpacancel")) {
				p.sendMessage(getMsg("Insufficient-permission"));
				return true;
			}

			if (clicktpa.getTpaCancel().containsKey(p)) {

				Player poorRejectedGuy = Bukkit.getServer().getPlayer(clicktpa.getTpaCancel().get(p).getName());

				if (poorRejectedGuy == null) {
					p.sendMessage(getMsg("Tpacancel-message"));
					clicktpa.getTpaCancel().remove(p);
					return true;
				}

				if (poorRejectedGuy.isOnline()) {

					p.sendMessage(getMsg("Tpacancel-message"));
					poorRejectedGuy.sendMessage(getMsg("Tpacancel-message"));
					removeTpaInfo(p, poorRejectedGuy);

					return true;
				}

				p.sendMessage(getMsg("Tpacancel-message"));
				removeTpaInfo(p, poorRejectedGuy);
				return true;

			} else {
				p.sendMessage(getMsg("Player-no-pendingtpa-message"));
				return true;
			}
		}
		sender.sendMessage(getMsg("Player-only-command"));
		return true;
	}

	private void removeTpaInfo(Player p, Player target) {

		for (TpaInfoList list : clicktpa.getTpaPlayers().get(target).getTpaList()) {
			if (list.getRequester() == p) {
				clicktpa.getTpaPlayers().get(target).getTpaList().remove(list);
				clicktpa.getTpaCancel().remove(p);
				return;
			}
		}

	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
