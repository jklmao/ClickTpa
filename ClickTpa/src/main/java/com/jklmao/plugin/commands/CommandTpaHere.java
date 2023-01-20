package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.enums.TeleportMode;
import com.jklmao.plugin.enums.TeleportType;
import com.jklmao.plugin.events.RequestExpireListener;
import com.jklmao.plugin.utils.ConfigUtil;
import com.jklmao.plugin.utils.TeleportMsgs;
import com.jklmao.plugin.utils.TpaInfoList;

public class CommandTpaHere implements CommandExecutor, ConfigUtil {

	private ClickTpa clicktpa;
	private final TeleportMsgs msgs = new TeleportMsgs();
	private TpaInfoList info;

	public CommandTpaHere(ClickTpa pl) {
		clicktpa = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tpahere")) {
				p.sendMessage(getMsg("Insufficient-permission"));
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(getMsg("Tpahere-usage"));
				return true;
			}
			final Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(getMsg("No-player-found"));
				return true;
			}
			if (target.equals(p)) {
				p.sendMessage(getMsg("Player-teleporting-self"));
				return true;
			}

			if (clicktpa.getTpaPlayers().get(p).getMode() == TeleportMode.TPTOGGLE_ON) {
				p.sendMessage(getMsg("Player-Is-TpToggled"));
				return true;
			}

			if (clicktpa.getTpaPlayers().get(target).getMode() == TeleportMode.TPTOGGLE_ON) {
				p.sendMessage(getMsg("Target-Is-TpToggled").replaceAll("%target%", target.getName()));
				return true;
			}

			if (clicktpa.getTpaPlayers().get(p).getMode() == TeleportMode.DEFAULT) {

				for (TpaInfoList list : clicktpa.getTpaPlayers().get(target).getTpaList()) {

					if (list.getRequester() == p) {
						p.sendMessage(getMsg("Player-already-requested"));
						return true;
					}
				}

				// create a new tpa info
				info = new TpaInfoList(TeleportType.TPAHERE, p);

				clicktpa.getTpaPlayers().get(target).getTpaList().add(info);
				clicktpa.getTpaCancel().put(p, target);
				msgs.sendRequestMsg(clicktpa, TeleportType.TPAHERE, p, target);
				//
				RequestExpireListener expireTimer = new RequestExpireListener(clicktpa, info);
				expireTimer.startTimer(p, target);
				//
				return true;
			}

		} else {
			sender.sendMessage(getMsg("Player-only-command"));
			return true;

		}
		return true;
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
