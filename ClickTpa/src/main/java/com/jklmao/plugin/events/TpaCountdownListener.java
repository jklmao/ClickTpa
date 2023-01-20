package com.jklmao.plugin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.enums.TeleportMode;
import com.jklmao.plugin.enums.TeleportType;
import com.jklmao.plugin.utils.TeleportMsgs;
import com.jklmao.plugin.utils.TpaInfoList;

public class TpaCountdownListener {

	private final TeleportMsgs tpMsgs = new TeleportMsgs();
	private BukkitTask cdTask;

	public void tpaCountdown(ClickTpa plugin, int secs, TeleportType type, Player sender, Player target) {

		switch (type) {
		case TPA:
			tpMsgs.currentlyTeleportingTitle(plugin, secs, target);
			break;
		case TPAHERE:
			tpMsgs.currentlyTeleportingTitle(plugin, secs, sender);
			break;
		}

		cdTask = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
			int time = secs * 2;

			@Override
			public void run() {

				// if a player moves

				if (time == 0) {
					teleport(plugin, type, sender, target);
					cdTask.cancel();
				} else {
					moveListener(plugin, type, sender, target);
				}

				time = time - 1;

			}

		}, 0, 10);

	}

	private void teleport(ClickTpa plugin, TeleportType type, Player sender, Player target) {
		switch (type) {
		case TPA:
			target.teleport(sender);
			tpMsgs.successfulTPATitle(plugin, target, sender);
			plugin.getTpaPlayers().get(target).setMode(TeleportMode.DEFAULT);
			break;
		case TPAHERE:
			sender.teleport(target);
			tpMsgs.successfulTPATitle(plugin, sender, target);
			plugin.getTpaPlayers().get(sender).setMode(TeleportMode.DEFAULT);
			break;
		}

		removeTpaInfo(plugin, sender, target);

	}

	private void moveListener(ClickTpa plugin, TeleportType type, Player sender, Player target) {

		switch (type) {
		case TPA:

			if (!plugin.getGraceList().contains(target)) {
				cdTask.cancel();
				tpMsgs.sendMoveBeforeTPATitle(plugin, sender, target);
				removeTpaInfo(plugin, sender, target);
			}

			return;
		case TPAHERE:

			if (!plugin.getGraceList().contains(sender)) {
				cdTask.cancel();
				tpMsgs.sendMoveBeforeTPAHERETitle(plugin, sender, target);
				removeTpaInfo(plugin, sender, target);

			}

			return;
		}
	}

	private void removeTpaInfo(ClickTpa plugin, Player sender, Player target) {

		for (TpaInfoList tpaInfo : plugin.getTpaPlayers().get(sender).getTpaList()) {

			if (tpaInfo.getRequester() != target) {
				continue;
			} else {
				plugin.getTpaPlayers().get(sender).getTpaList().remove(tpaInfo);
				return;
			}
		}

	}

}
