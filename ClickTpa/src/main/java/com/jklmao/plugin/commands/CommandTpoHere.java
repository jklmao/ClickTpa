package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;

import net.md_5.bungee.api.ChatColor;

public class CommandTpoHere implements CommandExecutor {
	private ClickTpa clicktpa;

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tpohere")) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Tpohere-usage")));
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("No-player-found")));
				return true;
			}
			if (target.equals(p)) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-teleporting-self")));
				return true;
			}
			p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-currently-teleporting")));
			target.teleport(p);
			target.sendMessage(colorize(this.clicktpa.getConfig().getString("Target-currently-teleporting")));
			return true;
		}
		sender.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-only-command")));
		return true;
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public CommandTpoHere(ClickTpa pl) {
		this.clicktpa = pl;
	}
}
