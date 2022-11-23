package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;

public class CommandTpaDeny implements CommandExecutor {
	private ClickTpa clicktpa;

	String targetsname = new String();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tpadeny")) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Tpdeny-usage")));
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if (target != null) {
				if (target.isOnline()) {
					if (this.clicktpa.getHash().containsKey(target) || this.clicktpa.getTpaHere().containsKey(target)) {
						clearLists(p, target);
						p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-deny-tpa-message")));
						target.sendMessage(colorize(this.clicktpa.getConfig().getString("Target-deny-tpa-message")));
						return true;
					}
					if (!this.clicktpa.getHash().containsKey(p) || !this.clicktpa.getTpaHere().containsKey(p)) {
						p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
						return true;
					}
				} else {
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Target-is-offline")));
					clearLists(p, target);
					return true;
				}
			} else {
				if (!this.clicktpa.getHash().containsKey(target) || !this.clicktpa.getTpaHere().containsKey(target)) {
					clearLists(p, target);
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Target-is-offline")));
					return true;
				}
				if (this.clicktpa.getHash().containsKey(target) || this.clicktpa.getTpaHere().containsKey(target)) {
					clearLists(p, target);
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
					return true;
				}
			}
			return true;
		}
		sender.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-only-command")));
		return true;
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
		this.clicktpa.getGraceList().remove(player);
		this.clicktpa.getGraceList().remove(target);
		this.clicktpa.getTpaInfo().remove(target);
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public CommandTpaDeny(ClickTpa pl) {
		this.clicktpa = pl;
	}
}
