package com.jklmao.plugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.enums.TeleportMode;
import com.jklmao.plugin.utils.CustomList;

public class PlayerEvents implements Listener {
	private ClickTpa clicktpa;
	private CustomList list = new CustomList();

	public PlayerEvents(ClickTpa pl) {
		clicktpa = pl;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		clicktpa.getTpaPlayers().put(e.getPlayer(), list);
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		clicktpa.getTpaPlayers().remove(e.getPlayer());
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (clicktpa.getConfig().getBoolean("Allow-player-to-move"))
			return;
		Player p = e.getPlayer();
		if (!clicktpa.getGraceList().contains(p))
			return;

		if (clicktpa.getGraceList().contains(p)) {
			if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
				clicktpa.getGraceList().remove(p);
				clicktpa.getTpaPlayers().get(p).setMode(TeleportMode.DEFAULT);
			}
		}
	}
}
