package com.jklmao.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.TeleportMode;

import net.md_5.bungee.api.ChatColor;

public class CommandTpToggle implements CommandExecutor {
	private ClickTpa clicktpa;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tptoggle")) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			}
			if (p.hasPermission("clicktpa.tptoggle")) {

				TeleportMode mode = clicktpa.getTpaPlayers().get(p).getMode();

				switch (mode) {

				case DEFAULT:
					// turn on tptoggle
					clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.TPTOGGLE_ON);
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-TpToggle-On")));
					break;
				case TPTOGGLE_ON:
					clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.DEFAULT);
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-TpToggle-Off")));
					break;
				case TELEPORTING:
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("TpToggle-While-Teleporting")));
					break;
				}
				return true;
			}
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
