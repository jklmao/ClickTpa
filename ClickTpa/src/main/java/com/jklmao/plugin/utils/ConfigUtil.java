package com.jklmao.plugin.utils;

import net.md_5.bungee.api.ChatColor;

public interface ConfigUtil {

	default String getMsg(String path) {
		return null;
	}

	default String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
