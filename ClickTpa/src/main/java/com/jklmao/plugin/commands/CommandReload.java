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

			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.reload")) {
				p.sendMessage(getMsg("Insufficient-permission"));
				return true;
			}
		}

		clicktpa.saveDefaultConfig();
		clicktpa.reloadConfig();
		sender.sendMessage(colorize(prefix + " &aThe plugin's config has been reloaded!"));

		return true;
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
