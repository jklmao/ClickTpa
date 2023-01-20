package com.jklmao.plugin.utils;

import org.bukkit.entity.Player;

import com.jklmao.plugin.enums.TeleportType;

public class TpaInfoList {

	private TeleportType type;
	private Player target;

	public TpaInfoList(TeleportType t, Player p) {
		type = t;
		target = p;
	}

	public Player getRequester() {
		return target;
	}

	public TeleportType getType() {
		return type;
	}
}
