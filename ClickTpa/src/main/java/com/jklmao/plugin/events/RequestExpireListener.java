package com.jklmao.plugin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.enums.TeleportMode;
import com.jklmao.plugin.utils.ConfigUtil;
import com.jklmao.plugin.utils.TpaInfoList;

public class RequestExpireListener implements ConfigUtil {

	private ClickTpa clicktpa;
	private TpaInfoList info;
	//
	private BukkitTask task;

	public RequestExpireListener(ClickTpa plugin, TpaInfoList tpaInfo) {
		clicktpa = plugin;
		info = tpaInfo;
	}

	public void startTimer(Player p, Player target) {

		task = Bukkit.getScheduler().runTaskTimer(clicktpa, new Runnable() {

			int time = clicktpa.getConfig().getInt("Request-expire-time") * 4;

			@Override
			public void run() {

				if (!p.isOnline()) {
					task.cancel();
					task = null;
					return;
				}

				if (time == 0) {
					task.cancel();
					task = null;
					p.sendMessage(getMsg("Request-expire"));
					target.sendMessage(getMsg("Request-expire"));

					// expired request
					clicktpa.getTpaPlayers().get(target).getTpaList().remove(info);
					clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.DEFAULT);
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

					if (clicktpa.getTpaPlayers().get(p).getMode() == TeleportMode.TELEPORTING) {
						task.cancel();
						task = null;
						return;
					}
				}

				time = time - 1;
			}

		}, 0, 5);

	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
