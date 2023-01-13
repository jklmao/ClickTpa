package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpCancel implements CommandExecutor {
	private ClickTpa clicktpa;

	public CommandTpCancel(ClickTpa pl) {
		this.clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (!p.hasPermission("clicktpa.tpacancel")) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			}

			if (this.clicktpa.getTpaCancel().containsKey(p)) {

				Player poorRejectedGuy = Bukkit.getServer().getPlayer(this.clicktpa.getTpaCancel().get(p).getName());

				if (poorRejectedGuy == null) {
					p.sendMessage(colorize(clicktpa.getConfig().getString("Tpacancel-message")));
					clicktpa.getTpaCancel().remove(p);
					return true;
				}

				if (poorRejectedGuy.isOnline()) {

					p.sendMessage(colorize(clicktpa.getConfig().getString("Tpacancel-message")));
					poorRejectedGuy.sendMessage(colorize(clicktpa.getConfig().getString("Tpacancel-message")));
					removeTpaInfo(p, poorRejectedGuy);

					return true;
				}

				p.sendMessage(colorize(clicktpa.getConfig().getString("Tpacancel-message")));
				removeTpaInfo(p, poorRejectedGuy);
				return true;

			} else {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
				return true;
			}
		}
		sender.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-only-command")));
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

	public String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
