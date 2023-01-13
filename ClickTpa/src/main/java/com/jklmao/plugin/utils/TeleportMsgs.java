package com.jklmao.plugin.utils;

import java.util.List;

import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;

public class TeleportMsgs {

	public TeleportMsgs() {
	}

	public void sendRequestMsg(ClickTpa clicktpa, TeleportType type, Player player, Player target) {

		TextComponent eemptyspace = new TextComponent("    ");
		TextComponent bemptyspace = new TextComponent("       ");

		TextComponent accept = new TextComponent(colorize(clicktpa.getConfig().getString("Click-to-accept")));
		Text acceptHoverText = new Text(colorize(clicktpa.getConfig().getString("Hover-message-on-accept")));
		accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[] { acceptHoverText }));

		TextComponent deny = new TextComponent(colorize(clicktpa.getConfig().getString("Click-to-deny")));
		Text denyHoverText = new Text(colorize(clicktpa.getConfig().getString("Hover-message-on-deny")));
		deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[] { denyHoverText }));

		TextComponent requestsent = new TextComponent(
			colorize(clicktpa.getConfig().getString("Player-sent-request").replaceAll("%target%", target.getName())));

		List<String> tpa = null;

		switch (type) {
		case TPA:
			tpa = clicktpa.getConfig().getStringList("Tpa-message");
			break;
		case TPAHERE:
			tpa = clicktpa.getConfig().getStringList("Tpahere-message");
			break;
		}

		for (String m : tpa) {
			target.sendMessage(
				colorize(m).replaceAll("%player%", player.getName()).replaceAll("%accept%", accept.getText()).replaceAll("%deny%", deny.getText()));
		}
		accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept " + player.getName()));

		deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpadeny " + player.getName()));

		if (clicktpa.getConfig().getBoolean("Added-accept-deny-space")) {
			target.spigot().sendMessage(new BaseComponent[] { bemptyspace, accept, eemptyspace, deny });
			player.spigot().sendMessage(requestsent);
		} else {
			target.spigot().sendMessage(new BaseComponent[] { accept, deny });
			player.spigot().sendMessage(requestsent);
		}

	}

	public void successfulTPATitle(ClickTpa clicktpa, Player teleporter, Player waiter) {

		String successMsg = clicktpa.getConfig().getString("On-screen-teleported");

		if (clicktpa.getConfig().getBoolean("Send-on-screen-message")) {
			teleporter.sendTitle(colorize(successMsg), "", 1, 20, 1);
		}

		teleporter.sendMessage(colorize(clicktpa.getConfig().getString("Target-currently-teleporting")));
		waiter.sendMessage(colorize(clicktpa.getConfig().getString("Player-currently-teleporting")));

	}

	public void currentlyTeleportingTitle(ClickTpa clicktpa, int secs, Player teleporter) {

		if (clicktpa.getConfig().getBoolean("Send-on-screen-message")) {

			String mainTitle = clicktpa.getConfig().getStringList("On-screen-teleporting").get(0);
			String subTitle = clicktpa.getConfig().getStringList("On-screen-teleporting").get(1);

			teleporter.sendTitle(colorize(mainTitle), colorize(subTitle), 1, secs * 20, 1);

		}
	}

	public void sendMoveBeforeTPAHERETitle(ClickTpa clicktpa, Player player, Player target) {

		target.sendMessage(colorize(clicktpa.getConfig().getString("Player-moved-before-tp").replaceAll("%player%", player.getName())));
		player.sendMessage(colorize(clicktpa.getConfig().getString("Player-moved-before-tp").replaceAll("%player%", player.getName())));

		if (clicktpa.getConfig().getBoolean("Send-on-screen-message")) {
			String cancelMsg = clicktpa.getConfig().getString("On-screen-canceled-tp");
			player.sendTitle(colorize(cancelMsg), "", 1, 30, 1);
		}
	}

	public void sendMoveBeforeTPATitle(ClickTpa clicktpa, Player player, Player target) {

		target.sendMessage(colorize(clicktpa.getConfig().getString("Player-moved-before-tp").replaceAll("%player%", target.getName())));
		player.sendMessage(colorize(clicktpa.getConfig().getString("Player-moved-before-tp").replaceAll("%player%", target.getName())));

		if (clicktpa.getConfig().getBoolean("Send-on-screen-message")) {
			String cancelMsg = clicktpa.getConfig().getString("On-screen-canceled-tp");
			target.sendTitle(colorize(cancelMsg), "", 1, 30, 1);
		}
	}

	private String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
