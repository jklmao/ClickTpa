package com.jklmao.plugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.CustomList;
import com.jklmao.plugin.utils.TeleportMode;

public class PlayerEvents implements Listener {
	private ClickTpa clicktpa;

	public PlayerEvents(ClickTpa pl) {
		this.clicktpa = pl;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		CustomList list = new CustomList();

		list.setMode(TeleportMode.DEFAULT);

		clicktpa.getTpaPlayers().put(e.getPlayer(), list);

	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {

		clicktpa.getTpaPlayers().remove(e.getPlayer());

	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (this.clicktpa.getConfig().getBoolean("Allow-player-to-move"))
			return;
		Player p = e.getPlayer();
		if (!this.clicktpa.getGraceList().contains(p))
			return;

		if (this.clicktpa.getGraceList().contains(p)) {
			if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
				this.clicktpa.getGraceList().remove(p);
				clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.DEFAULT);
			}
		}
	}
}
