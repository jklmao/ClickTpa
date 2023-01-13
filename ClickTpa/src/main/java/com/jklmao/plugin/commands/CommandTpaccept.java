package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.events.TpaCountdownListener;
import com.jklmao.plugin.utils.TeleportMode;
import com.jklmao.plugin.utils.TeleportType;
import com.jklmao.plugin.utils.TpaInfoList;

import net.md_5.bungee.api.ChatColor;

public class CommandTpaccept implements CommandExecutor {
	private int seconds;
	private ClickTpa clicktpa;
	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

	public CommandTpaccept(ClickTpa pl) {
		clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		seconds = clicktpa.getConfig().getInt("Seconds-until-tpa");

		if (!(sender instanceof Player)) {
			sender.sendMessage(colorize(clicktpa.getConfig().getString("Player-only-command")));
			return true;
		} else {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tpaccept")) {
				p.sendMessage(colorize(clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(colorize(clicktpa.getConfig().getString("Tpaccept-usage")));
				return true;
			}

			Player target = Bukkit.getPlayer(args[0]);

			if (target == null) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("No-player-found")));
				return true;
			}

			if (!target.isOnline()) {
				p.sendMessage(colorize(clicktpa.getConfig().getString("Target-is-offline")));

				for (TpaInfoList list : clicktpa.getTpaPlayers().get(p).getTpaList()) {
					if (list.getRequester() == target) {
						clicktpa.getTpaPlayers().get(p).getTpaList().remove(list);
						clicktpa.getTpaCancel().remove(target);
						return true;
					}
				}
			}

			if (clicktpa.getTpaPlayers().get(p).getTpaList().isEmpty()) {
				p.sendMessage(colorize(clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
				return true;
			}

			TpaInfoList tpaInfo = null;

			if (clicktpa.getTpaPlayers().get(p).getTpaList().size() > 0) {

				boolean hasRequester = false;
				for (TpaInfoList list : clicktpa.getTpaPlayers().get(p).getTpaList()) {

					if (list.getRequester() != target) {
						hasRequester = false;
					} else {
						hasRequester = true;
						tpaInfo = list;
						break;
					}
				}

				if (hasRequester == false) {
					p.sendMessage(colorize(clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
					return true;
				}

			}

			p.sendMessage(colorize(clicktpa.getConfig().getString("Player-got-accepted-tpa")));
			target.sendMessage(colorize(clicktpa.getConfig().getString("Target-accepted-tpa-request")));

			TpaCountdownListener cdListener = new TpaCountdownListener();

			switch (tpaInfo.getType()) {

			case TPA:
				target.sendMessage(colorize(clicktpa.getConfig().getString("Countdown-until-tpa")));
				clicktpa.getTpaPlayers().get(target).setMode(TeleportMode.TELEPORTING);
				clicktpa.getGraceList().add(target);
				cdListener.tpaCountdown(clicktpa, seconds, TeleportType.TPA, p, target);
				break;
			case TPAHERE:
				p.sendMessage(colorize(clicktpa.getConfig().getString("Countdown-until-tpa")));
				clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.TELEPORTING);
				clicktpa.getGraceList().add(p);
				cdListener.tpaCountdown(clicktpa, seconds, TeleportType.TPAHERE, p, target);
				break;
			}
			clicktpa.getTpaCancel().remove(target);

			return true;
		}
	}

	public String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}