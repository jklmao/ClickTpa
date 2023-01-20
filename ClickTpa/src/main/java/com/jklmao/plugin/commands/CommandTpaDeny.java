package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.ConfigUtil;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpaDeny implements CommandExecutor, ConfigUtil {

	private ClickTpa clicktpa;

	public CommandTpaDeny(ClickTpa pl) {
		clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tpadeny")) {
				p.sendMessage(getMsg("Insufficient-permission"));
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(getMsg("Tpdeny-usage"));
				return true;
			}
			final Player target = Bukkit.getPlayer(args[0]);

			if (target == null) {
				p.sendMessage(getMsg("No-player-found"));
				return true;
			}

			if (target.isOnline()) {

				boolean hasRequester = false;

				for (TpaInfoList list : clicktpa.getTpaPlayers().get(p).getTpaList()) {
					if (list.getRequester() == target) {
						clicktpa.getTpaPlayers().get(p).getTpaList().remove(list);
						clicktpa.getTpaCancel().remove(target);
						hasRequester = true;
						break;
					}
				}

				if (hasRequester) {
					p.sendMessage(getMsg("Player-deny-tpa-message"));
					target.sendMessage(getMsg("Target-deny-tpa-message"));
					clicktpa.getTpaCancel().remove(target);
					return true;
				} else {
					p.sendMessage(getMsg("Player-no-pendingtpa-message"));
					return true;
				}

			} else {
				p.sendMessage(getMsg("Target-is-offline"));
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
