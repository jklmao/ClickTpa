package com.jklmao.plugin.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.jklmao.plugin.ClickTpa;
import com.jklmao.plugin.utils.CustomList;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;

public class CommandTpa implements CommandExecutor {
	private ClickTpa clicktpa;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tpa")) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Tpa-usage")));
				return true;
			}
			final Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("No-player-found")));
				return true;
			}
			if (target.equals(p)) {
				p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-teleporting-self")));
				return true;
			}
			if (target != null) {
				if (this.clicktpa.getTpToggled().contains(p)) {
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-Is-TpToggled")));
					return true;
				}
				if (this.clicktpa.getTpToggled().contains(target)) {
					p.sendMessage(colorize(
						this.clicktpa.getConfig().getString("Target-Is-TpToggled").replaceAll("%target%", target.getName())));
					return true;
				}
				if (this.clicktpa.getHash().containsKey(p)) {
					p.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-already-requested")));
					return true;
				}
				if (!this.clicktpa.getTpToggled().contains(target)) {
					this.clicktpa.getHash().put(p, p);
					this.clicktpa.getHash().put(target, target);
					this.clicktpa.getTeleportStatus().add(p);
					CustomList info = new CustomList();
					info.setTarget(target);
					info.setType(0);
					this.clicktpa.getTpaInfo().put(p, info);
					addThemToList(target, p);
					TextComponent eemptyspace = new TextComponent("    ");
					TextComponent bemptyspace = new TextComponent("       ");

					TextComponent accept = new TextComponent(colorize(this.clicktpa.getConfig().getString("Click-to-accept")));
					Text acceptHoverText = new Text(colorize(this.clicktpa.getConfig().getString("Hover-message-on-accept")));
					accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[] { acceptHoverText }));

					TextComponent deny = new TextComponent(colorize(this.clicktpa.getConfig().getString("Click-to-deny")));
					Text denyHoverText = new Text(colorize(this.clicktpa.getConfig().getString("Hover-message-on-deny")));
					deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Content[] { denyHoverText }));

					TextComponent requestsent = new TextComponent(colorize(
						this.clicktpa.getConfig().getString("Player-sent-request").replaceAll("%target%", target.getName())));

					List<String> tpa = this.clicktpa.getConfig().getStringList("Tpa-message");
					for (String m : tpa) {
						target.sendMessage(colorize(m).replaceAll("%player%", p.getName())
							.replaceAll("%accept%", accept.getText()).replaceAll("%deny%", deny.getText()));
					}
					accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept " + p.getName()));
					deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpadeny " + p.getName()));

					if (this.clicktpa.getConfig().getBoolean("Added-accept-deny-space")) {
						target.spigot().sendMessage(new BaseComponent[] { bemptyspace, accept, eemptyspace, deny });
						p.spigot().sendMessage(requestsent);
					} else {
						target.spigot().sendMessage(new BaseComponent[] { accept, deny });
						p.spigot().sendMessage(requestsent);
					}
				}
				(new BukkitRunnable() {
					@Override
					public void run() {
						if (CommandTpa.this.clicktpa.getHash().containsKey(p)
							&& CommandTpa.this.clicktpa.getHash().containsKey(target)) {
							CommandTpa.this.clicktpa.getHash().remove(p);
							CommandTpa.this.clicktpa.getHash().remove(target);
							p.sendMessage(CommandTpa.this
								.colorize(CommandTpa.this.clicktpa.getConfig().getString("Player-teleportation-request-expire")));
							target.sendMessage(CommandTpa.this
								.colorize(CommandTpa.this.clicktpa.getConfig().getString("Target-teleportation-request-expire")));
						}
					}
				}).runTaskLaterAsynchronously(ClickTpa.instance, 2400L);
			}
			return true;
		}
		sender.sendMessage(colorize(this.clicktpa.getConfig().getString("Player-only-command")));
		return true;
	}

	public void addThemToList(Player sender, Player recipient) {
		String senderName = sender.getName();
		String recipientName = recipient.getName();
		this.clicktpa.getTpaCancel().put(recipientName, senderName);
	}

	public String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public CommandTpa(ClickTpa pl) {
		this.clicktpa = pl;
	}
}
