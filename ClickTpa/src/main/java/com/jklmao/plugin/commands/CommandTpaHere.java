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
import com.jklmao.plugin.enums.TeleportMode;
import com.jklmao.plugin.enums.TeleportType;
import com.jklmao.plugin.events.RequestExpireListener;
import com.jklmao.plugin.utils.ConfigUtil;
import com.jklmao.plugin.utils.TeleportMsgs;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpaHere implements CommandExecutor, TabCompleter, ConfigUtil {

	private ClickTpa clicktpa;
	private TeleportMsgs msgs;

	public CommandTpaHere(ClickTpa pl) {
		clicktpa = pl;
		msgs = new TeleportMsgs(clicktpa);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(getMsg("Player-only-command"));
			return true;
		}

		final Player p = (Player) sender;
		if (!p.hasPermission("clicktpa.tpahere")) {
			p.sendMessage(getMsg("Insufficient-permission"));
			return true;
		}
		if (args.length == 0) {
			p.sendMessage(getMsg("Tpahere-usage"));
			return true;
		}

		// Nicked players
		Player target = Bukkit.getPlayer(args[0]);

		if (clicktpa.getConfig().getBoolean("Allow-nicknames")) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.getDisplayName().toLowerCase().contains(args[0].toLowerCase())) {
					target = player;
					break;
				}
			}
		}

		if (target == null) {
			p.sendMessage(getMsg("No-player-found"));
			return true;
		}
		if (target == p) {
			p.sendMessage(getMsg("Player-teleporting-self"));
			return true;
		}
		if (clicktpa.getTpaPlayers().get(p).getMode() == TeleportMode.TPTOGGLE_ON) {
			p.sendMessage(getMsg("Player-is-toggled"));
			return true;
		}
		if (clicktpa.getTpaPlayers().get(target).getMode() == TeleportMode.TPTOGGLE_ON) {
			p.sendMessage(getMsg("Target-is-toggled").replaceAll("%target%", target.getName()));
			return true;
		}

		if (!p.hasPermission("clicktpa.bypassworld.*")) {
			for (String worldName : clicktpa.getConfig().getStringList("Blacklisted-worlds")) {
				String targetWorld = target.getWorld().getName();

				if (worldName.equalsIgnoreCase(targetWorld)) {
					if (p.hasPermission("clicktpa.bypassworld." + worldName)) {
						break;
					} else {
						p.sendMessage(getMsg("Blacklisted-world-no-permission"));
						return true;
					}
				}
			}
		}

		if (clicktpa.getTpaPlayers().get(p).getMode() == TeleportMode.DEFAULT) {

			for (TpaInfoList list : clicktpa.getTpaPlayers().get(target).getTpaList()) {

				if (list.getRequester() == p) {
					p.sendMessage(getMsg("Already-requested"));
					return true;
				}
			}

			// create a new tpa info
			TpaInfoList info = new TpaInfoList(TeleportType.TPAHERE, p);

			clicktpa.getTpaPlayers().get(target).getTpaList().add(info);
			clicktpa.getTpaCancel().put(p, target);
			msgs.sendRequestMsg(TeleportType.TPAHERE, p, target);
			//
			RequestExpireListener expireTimer = new RequestExpireListener(clicktpa, info);
			expireTimer.startTimer(p, target);
			//
			return true;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

		if (args.length == 0) {
			List<String> playerNames = new ArrayList<>();
			for (Player p : Bukkit.getOnlinePlayers())
				playerNames.add(p.getName());

			playerNames.remove(sender.getName());
			return playerNames;
		}
		return null;
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
