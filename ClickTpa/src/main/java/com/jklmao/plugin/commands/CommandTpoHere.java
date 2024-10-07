package com.jklmao.plugin.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.ConfigUtil;

public class CommandTpoHere implements CommandExecutor, TabCompleter, ConfigUtil {

	private ClickTpa clicktpa;

	public CommandTpoHere(ClickTpa pl) {
		clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(getMsg("Player-only-command"));
			return true;
		}

		Player p = (Player) sender;
		if (!p.hasPermission("clicktpa.tpohere")) {
			p.sendMessage(getMsg("Insufficient-permission"));
			return true;
		}
		if (args.length == 0) {
			p.sendMessage(getMsg("Tpohere-usage"));
			return true;
		}
		Player target = Bukkit.getPlayer(args[0]);
		if (target == null) {
			p.sendMessage(getMsg("No-player-found"));
			return true;
		}
		if (target.equals(p)) {
			p.sendMessage(getMsg("Player-teleporting-self"));
			return true;
		}
		p.sendMessage(getMsg("Currently-teleporting"));
		target.sendMessage(getMsg("Currently-teleporting"));
		target.teleport(p);
		return true;

	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

		List<String> playerNames = new ArrayList<>();
		for (Player p : Bukkit.getOnlinePlayers())
			playerNames.add(p.getName());

		playerNames.remove(sender.getName());
		if (args.length == 0)
			return playerNames;

		return null;
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
