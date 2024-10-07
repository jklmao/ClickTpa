package com.jklmao.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.ConfigUtil;

public class CommandReload implements CommandExecutor, ConfigUtil {

	private ClickTpa clicktpa;
	final private String prefix = "&4&l[Click&b&lTpa]";

	public CommandReload(ClickTpa pl) {
		clicktpa = pl;
		clicktpa.saveDefaultConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			if (!sender.hasPermission("clicktpa.reload")) {
				sender.sendMessage(getMsg("Insufficient-permission"));
				return true;
			}
		}

		clicktpa.saveDefaultConfig();
		clicktpa.reloadConfig();
		sender.sendMessage(colorize(prefix + " &aThe plugin's config has been reloaded!"));
		sender.sendMessage(colorize("&8Note: Restart your server to reload the config to prevent breakage."));

		return true;
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
