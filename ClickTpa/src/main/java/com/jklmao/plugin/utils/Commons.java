package com.jklmao.plugin.utils;

import net.md_5.bungee.api.ChatColor;

public class Commons {

	@SuppressWarnings("unused")
	private static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
