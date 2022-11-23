package com.jklmao.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;

import net.md_5.bungee.api.ChatColor;

public class CommandTpToggle implements CommandExecutor {
	private ClickTpa clicktpa;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tptoggle")) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			}
			if (p.hasPermission("clicktpa.tptoggle")) {
				if (!this.clicktpa.getTpToggled().contains(p)) {
					this.clicktpa.getTpToggled().add(p);
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-TpToggle-Off")));
					return true;
				}
				if (this.clicktpa.getTpToggled().contains(p)) {
					this.clicktpa.getTpToggled().remove(p);
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-TpToggle-On")));
					return true;
				}
				return true;
			}
			return true;
		}
		sender.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-only-command")));
		return true;
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public CommandTpToggle(ClickTpa pl) {
		this.clicktpa = pl;
	}
}
