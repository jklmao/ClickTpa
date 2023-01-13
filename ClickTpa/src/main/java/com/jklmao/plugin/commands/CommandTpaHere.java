package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.TeleportMode;
import com.jklmao.plugin.utils.TeleportMsgs;
import com.jklmao.plugin.utils.TeleportType;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpaHere implements CommandExecutor {

	private ClickTpa clicktpa;
	private BukkitTask task;
	private final TeleportMsgs msgs = new TeleportMsgs();
	private TpaInfoList info;

	public CommandTpaHere(ClickTpa pl) {
		this.clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tpahere")) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Tpahere-usage")));
				return true;
			}
			final Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("No-player-found")));
				return true;
			}
			if (target.equals(p)) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-teleporting-self")));
				return true;
			}

			if (clicktpa.getTpaPlayers().get(p).getMode() == TeleportMode.TPTOGGLE_ON) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-Is-TpToggled")));
				return true;
			}

			if (clicktpa.getTpaPlayers().get(target).getMode() == TeleportMode.TPTOGGLE_ON) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Target-Is-TpToggled").replaceAll("%target%", target.getName())));
				return true;
			}

			if (clicktpa.getTpaPlayers().get(p).getMode() == TeleportMode.DEFAULT) {

				for (TpaInfoList list : clicktpa.getTpaPlayers().get(target).getTpaList()) {

					if (list.getRequester() == p) {
						p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-already-requested")));
						return true;
					}
				}

				// create a new tpa info
				info = new TpaInfoList(TeleportType.TPAHERE, p);

				clicktpa.getTpaPlayers().get(target).getTpaList().add(info);
				clicktpa.getTpaCancel().put(p, target);
				msgs.sendRequestMsg(clicktpa, TeleportType.TPAHERE, p, target);
				startTimer(p, target);
				return true;
			}

		} else {
			sender.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-only-command")));
			return true;

		}
		return true;
	}

	private void startTimer(Player p, Player target) {

		task = Bukkit.getScheduler().runTaskTimer(clicktpa, new Runnable() {

			int time = clicktpa.getConfig().getInt("Request-expire-time") * 4;

			@Override
			public void run() {
				if (time == 0) {
					task.cancel();
					p.sendMessage(colorize(clicktpa.getConfig().getString("Player-teleportation-request-expire")));
					target.sendMessage(colorize(clicktpa.getConfig().getString("Target-teleportation-request-expire")));

					// expired request
					clicktpa.getTpaPlayers().get(target).getTpaList().remove(info);
					clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.DEFAULT);
					task = null;
					return;
				}

				if (!target.isOnline()) {
					task.cancel();
					task = null;
					return;
				} else {

					if (!clicktpa.getTpaPlayers().get(target).getTpaList().contains(info)) {
						task.cancel();
						task = null;
						return;
					}
				}

				if (clicktpa.getTpaPlayers().get(p).getMode() == TeleportMode.TELEPORTING) {
					task.cancel();
					task = null;
					return;
				}

				time = time - 1;
			}

		}, 0, 5);

	}

	public String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
