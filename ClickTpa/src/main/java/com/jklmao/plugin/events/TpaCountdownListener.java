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

	private ClickTpa clicktpa;
	private TeleportMsgs tpMsgs;
	private BukkitTask cdTask;

	public TpaCountdownListener(ClickTpa plugin) {
		clicktpa = plugin;
		tpMsgs = new TeleportMsgs(clicktpa);
	}

	public void tpaCountdown(int secs, TeleportType type, Player sender, Player target) {

		switch (type) {
		case TPA:
			tpMsgs.currentlyTeleportingTitle(secs, target);
			break;
		case TPAHERE:
			tpMsgs.currentlyTeleportingTitle(secs, sender);
			break;
		}

		cdTask = Bukkit.getScheduler().runTaskTimer(clicktpa, new Runnable() {
			int time = secs * 2;

			@Override
			public void run() {

				if (disconnectListener(sender, target)) {
					return;
				}

				moveListener(type, sender, target);

				if (time == 0) {

					if (disconnectListener(sender, target)) {
						return;
					}

					teleport(type, sender, target);
					cdTask.cancel();
				}

				time = time - 1;

			}

		}, 0, 10);

	}

	private void teleport(TeleportType type, Player sender, Player target) {
		switch (type) {
		case TPA:
			target.teleport(sender);
			tpMsgs.successfulTPATitle(target, sender);
			clicktpa.getTpaPlayers().get(target).setMode(TeleportMode.DEFAULT);
			break;
		case TPAHERE:
			sender.teleport(target);
			tpMsgs.successfulTPATitle(sender, target);
			clicktpa.getTpaPlayers().get(sender).setMode(TeleportMode.DEFAULT);
			break;
		}

		removeTpaInfo(sender, target);

	}

	private void moveListener(TeleportType type, Player sender, Player target) {

		switch (type) {
		case TPA:

			if (!clicktpa.getGraceList().contains(target)) {
				cdTask.cancel();
				tpMsgs.sendMoveBeforeTPATitle(sender, target);
				removeTpaInfo(sender, target);
			}

			return;
		case TPAHERE:

			if (!clicktpa.getGraceList().contains(sender)) {
				cdTask.cancel();
				tpMsgs.sendMoveBeforeTPAHERETitle(sender, target);
				removeTpaInfo(sender, target);

			}

			return;
		}
	}

	private boolean disconnectListener(Player sender, Player target) {

		if (!sender.isOnline()) {
			cdTask.cancel();
			cdTask = null;
			target.sendMessage(tpMsgs.getMsg("Target-teleportion-canceled"));
			clicktpa.getGraceList().remove(target);
			return true;
		}

		if (!target.isOnline()) {
			cdTask.cancel();
			cdTask = null;
			sender.sendMessage(tpMsgs.getMsg("Target-teleportion-canceled"));
			clicktpa.getGraceList().remove(sender);

			return true;
		}
		return false;

	}

	private void removeTpaInfo(Player sender, Player target) {

		for (TpaInfoList tpaInfo : clicktpa.getTpaPlayers().get(sender).getTpaList()) {

			if (tpaInfo.getRequester() != target) {
				continue;
			} else {
				clicktpa.getTpaPlayers().get(sender).getTpaList().remove(tpaInfo);
				return;
			}
		}

	}

}
