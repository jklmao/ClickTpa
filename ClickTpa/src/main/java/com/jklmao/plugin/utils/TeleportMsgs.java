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

	private ClickTpa clicktpa;

	public TeleportMsgs(ClickTpa plugin) {
		clicktpa = plugin;
	}

	public void sendRequestMsg(TeleportType type, Player player, Player target) {

		TextComponent accept = new TextComponent(getMsg("Click-to-accept"));
		Text acceptHoverText = new Text(getMsg("Hover-message-on-accept"));
		accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[] { acceptHoverText }));
		accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept " + player.getName()));

		TextComponent deny = new TextComponent(getMsg("Click-to-deny"));
		Text denyHoverText = new Text(getMsg("Hover-message-on-deny"));
		deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[] { denyHoverText }));
		deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpadeny " + player.getName()));

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
		} else {
			TextComponent emptyspace = new TextComponent("  ");
			target.spigot().sendMessage(new BaseComponent[] { accept, emptyspace, deny });
		}

		String requestsent = getMsg("Player-sent-request").replaceAll("%target%", target.getName());
		player.sendMessage(requestsent);

	}

	public void successfulTPATitle(Player teleporter, Player waiter) {

		if (doSendTitle()) {
			String successMsg = getMsg("On-screen-teleported");
			teleporter.sendTitle(successMsg, "", 1, 20, 1);
		}

		teleporter.sendMessage(getMsg("Currently-teleporting"));
		waiter.sendMessage(getMsg("Currently-teleporting"));

	}

	public void currentlyTeleportingTitle(int secs, Player teleporter) {

		if (doSendTitle()) {
			String mainTitle = clicktpa.getConfig().getStringList("On-screen-teleporting").get(0);
			String subTitle = clicktpa.getConfig().getStringList("On-screen-teleporting").get(1);
			teleporter.sendTitle(colorize(mainTitle), colorize(subTitle), 1, secs * 20, 1);

		}
	}

	public void sendMoveBeforeTPAHERETitle(Player player, Player target) {

		if (doSendTitle()) {
			String cancelMsg = getMsg("On-screen-canceled-tp");
			player.sendTitle(cancelMsg, "", 1, 30, 1);
		}

		target.sendMessage(getMsg("Player-moved-before-tp").replaceAll("%player%", player.getName()));
		player.sendMessage(getMsg("Player-moved-before-tp").replaceAll("%player%", player.getName()));

	}

	public void sendMoveBeforeTPATitle(Player player, Player target) {

		if (doSendTitle()) {
			String cancelMsg = getMsg("On-screen-canceled-tp");
			target.sendTitle(cancelMsg, "", 1, 30, 1);
		}

		target.sendMessage(getMsg("Player-moved-before-tp").replaceAll("%player%", target.getName()));
		player.sendMessage(getMsg("Player-moved-before-tp").replaceAll("%player%", target.getName()));

	}

	private boolean doSendTitle() {
		return clicktpa.getConfig().getBoolean("Send-on-screen-message");
	}

	@Override
	public String getMsg(String path) {
		return colorize(clicktpa.getConfig().getString(path));
	}

}
