package com.jklmao.plugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.jklmao.plugin.ClickTpa;

public class PlayerEvents implements Listener {
	private ClickTpa clicktpa;

	public PlayerEvents(ClickTpa pl) {
		this.clicktpa = pl;
	}

	@EventHandler
	public void onWalk(PlayerMoveEvent e) {
		if (this.clicktpa.getConfig().getBoolean("Allow-player-to-move"))
			return;
		Player p = e.getPlayer();
		if (!this.clicktpa.getGraceList().contains(p))
			return;
		if (this.clicktpa.getGraceList().contains(p)) {
			if (e.getFrom().getX() != e.getTo().getX() || e.getFrom().getZ() != e.getTo().getZ()) {
				this.clicktpa.getTeleportStatus().remove(p);
				this.clicktpa.getWhosFault().add(p);
				this.clicktpa.getGraceList().remove(p);
			}
		} else {
			return;
		}
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
