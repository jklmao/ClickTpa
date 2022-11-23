package com.jklmao.plugin.utils;

import org.bukkit.entity.Player;

public class CustomList {
	private Player target;

	private int type;

	public void setTarget(Player t) {
		this.target = t;
	}

	public Player getTarget() {
		return this.target;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}
}
