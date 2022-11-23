package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;

public class CommandTpCancel implements CommandExecutor {
	private ClickTpa clicktpa;

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = null;
		if (sender instanceof Player) {
			p = (Player) sender;
			if (p != null) {
				if (!p.hasPermission("clicktpa.tpacancel")) {
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
					return true;
				}
				if (this.clicktpa.getTpaCancel().containsKey(p.getName())) {
					Player poorRejectedGuy = Bukkit.getServer()
							.getPlayer((String) this.clicktpa.getTpaCancel().get(p.getName()));
					clearLists(p, poorRejectedGuy);
					if (poorRejectedGuy != null) {
						p.sendMessage(colorize(this.clicktpa.getConfig().getString("Tpacancel-message")));
						poorRejectedGuy.sendMessage(colorize(this.clicktpa.getConfig().getString("Tpacancel-message")));
						return true;
					}
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
				} else if (!this.clicktpa.getTpaCancel().containsKey(p.getName())) {
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
					return true;
				}
			}
			return true;
		}
		sender.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-only-command")));
		return true;
	}

	public String returnStatementPlayer(String configMessages, Player player) {
		return this.clicktpa.getConfig().getString(configMessages).replaceAll("%player%", player.getName());
	}

	public String returnStatementTarget(String configMessages, Player target) {
		return this.clicktpa.getConfig().getString(configMessages).replaceAll("%target%", target.getName());
	}

	private void clearLists(Player player, Player target) {
		this.clicktpa.getHash().remove(player);
		this.clicktpa.getHash().remove(target);
		this.clicktpa.getTpaHere().remove(player);
		this.clicktpa.getTpaHere().remove(target);
		this.clicktpa.getTeleportStatus().remove(player);
		this.clicktpa.getTeleportStatus().remove(target);
		this.clicktpa.getTpaCancel().remove(player.getName());
		this.clicktpa.getTpaCancel().remove(target.getName());
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public CommandTpCancel(ClickTpa pl) {
		this.clicktpa = pl;
	}
}
