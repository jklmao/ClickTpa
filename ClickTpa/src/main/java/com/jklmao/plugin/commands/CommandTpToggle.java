package com.jklmao.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.enums.TeleportMode;
import com.jklmao.plugin.utils.ConfigUtil;

public class CommandTpToggle implements CommandExecutor, ConfigUtil {

	private ClickTpa clicktpa;

	public CommandTpToggle(ClickTpa pl) {
		clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tptoggle")) {
				p.sendMessage(getMsg("Insufficient-permission"));
				return true;
			}
			if (p.hasPermission("clicktpa.tptoggle")) {

				TeleportMode mode = clicktpa.getTpaPlayers().get(p).getMode();

				switch (mode) {

				case DEFAULT:
					// turn on tptoggle
					clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.TPTOGGLE_ON);
					p.sendMessage(getMsg("Player-TpToggle-On"));
					break;
				case TPTOGGLE_ON:
					clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.DEFAULT);
					p.sendMessage(getMsg("Player-TpToggle-Off"));
					break;
				case TELEPORTING:
					p.sendMessage(getMsg("TpToggle-While-Teleporting"));
					break;
				}
				return true;
			}
		}
		sender.sendMessage(getMsg("Player-only-command"));
		return true;
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
