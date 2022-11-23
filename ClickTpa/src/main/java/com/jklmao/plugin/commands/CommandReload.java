package com.jklmao.plugin.commands;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;

public class CommandReload implements CommandExecutor {
	private ClickTpa clicktpa;

	public FileConfiguration config;

	public File configFile;

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String prefix = "&4&l[Click&b&lTpa]";
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.reload")) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
			} else {
				this.clicktpa.saveDefaultConfig();
				this.clicktpa.reloadConfig();
				sender.sendMessage(colorize(String.valueOf(prefix) + " &aThe plugin has been reloaded!"));
			}
		} else {
			this.clicktpa.saveDefaultConfig();
			this.clicktpa.reloadConfig();
			sender.sendMessage(colorize(String.valueOf(prefix) + " &aThe plugin has been reloaded!"));
		}
		return true;
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public CommandReload(ClickTpa pl) {
		this.clicktpa = pl;
		this.clicktpa.saveDefaultConfig();
	}
}
