package com.jklmao.plugin.utils;

import java.util.List;

import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.enums.TeleportType;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;

public class TeleportMsgs implements ConfigUtil {

	public void sendRequestMsg(ClickTpa clicktpa, TeleportType type, Player player, Player target) {

		TextComponent accept = new TextComponent(getMsg("Click-to-accept"));
		Text acceptHoverText = new Text(getMsg("Hover-message-on-accept"));
		accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[] { acceptHoverText }));
		accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept " + player.getName()));

		TextComponent deny = new TextComponent(getMsg("Click-to-deny"));
		Text denyHoverText = new Text(getMsg("Hover-message-on-deny"));
		deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[] { denyHoverText }));
		deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpadeny " + player.getName()));

		String requestsent = getMsg("Player-sent-request").replaceAll("%target%", target.getName());

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

		if (clicktpa.getConfig().getBoolean("Center-accept-deny-msg")) {

			TextComponent eemptyspace = new TextComponent("    ");
			TextComponent bemptyspace = new TextComponent("       ");
			target.spigot().sendMessage(new BaseComponent[] { bemptyspace, accept, eemptyspace, deny });
			player.sendMessage(requestsent);
		} else {
			TextComponent emptyspace = new TextComponent("  ");
			target.spigot().sendMessage(new BaseComponent[] { accept, emptyspace, deny });
			player.sendMessage(requestsent);
		}

	}

	public void successfulTPATitle(ClickTpa clicktpa, Player teleporter, Player waiter) {

		if (sendTitle(clicktpa)) {
			String successMsg = getMsg("On-screen-teleported");
			teleporter.sendTitle(successMsg, "", 1, 20, 1);
		}

		teleporter.sendMessage(getMsg("Target-currently-teleporting"));
		waiter.sendMessage(getMsg("Player-currently-teleporting"));

	}

	public void currentlyTeleportingTitle(ClickTpa clicktpa, int secs, Player teleporter) {

		if (sendTitle(clicktpa)) {
			String mainTitle = clicktpa.getConfig().getStringList("On-screen-teleporting").get(0);
			String subTitle = clicktpa.getConfig().getStringList("On-screen-teleporting").get(1);
			teleporter.sendTitle(colorize(mainTitle), colorize(subTitle), 1, secs * 20, 1);

		}
	}

	public void sendMoveBeforeTPAHERETitle(ClickTpa clicktpa, Player player, Player target) {

		if (sendTitle(clicktpa)) {
			String cancelMsg = getMsg("On-screen-canceled-tp");
			player.sendTitle(cancelMsg, "", 1, 30, 1);
		}

		target.sendMessage(getMsg("Player-moved-before-tp").replaceAll("%player%", player.getName()));
		player.sendMessage(getMsg("Player-moved-before-tp").replaceAll("%player%", player.getName()));

	}

	public void sendMoveBeforeTPATitle(ClickTpa clicktpa, Player player, Player target) {

		if (sendTitle(clicktpa)) {
			String cancelMsg = getMsg("On-screen-canceled-tp");
			target.sendTitle(cancelMsg, "", 1, 30, 1);
		}

		target.sendMessage(getMsg("Player-moved-before-tp").replaceAll("%player%", target.getName()));
		player.sendMessage(getMsg("Player-moved-before-tp").replaceAll("%player%", target.getName()));

	}

	private boolean sendTitle(ClickTpa clicktpa) {
		return clicktpa.getConfig().getBoolean("Send-on-screen-message");
	}

	@Override
	public String getMsg(ClickTpa clicktpa, String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
