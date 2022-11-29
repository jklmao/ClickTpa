package com.jklmao.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.jklmao.plugin.ClickTpa;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {
	private int seconds;
	private int countdown;
	private ClickTpa clicktpa;
	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		this.seconds = this.clicktpa.getConfig().getInt("Seconds-until-tpa");
		if (!(sender instanceof Player)) {
			sender.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-only-command")));
			return true;
		} else {
			Player p = (Player) sender;
			if (!p.hasPermission("clicktpa.tpaccept")) {
				p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Insufficient-permission")));
				return true;
			} else if (args.length == 0) {
				p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Tpaccept-usage")));
				return true;
			} else {
				Player target = Bukkit.getPlayer(args[0]);
				if (args.length >= 1) {
					if (target != null) {
						if (!target.isOnline()) {
							p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Target-is-offline")));
							this.clearLists(p, target);
							return true;
						}

						if (!this.clicktpa.getHash().containsKey(target) && !this.clicktpa.getTpaHere().containsKey(target)) {
							if (this.clicktpa.getTpaHere().containsKey(p) && this.clicktpa.getHash().containsKey(p)) {
								return true;
							}

							p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
							return true;
						}

						p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-got-accepted-tpa")));
						target.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Target-accepted-tpa-request")));
						if (this.clicktpa.getHash().containsKey(target)) {
							target.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Countdown-until-tpa")));
						} else {
							p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Countdown-until-tpa")));
						}

						this.clicktpa.getHash().remove(p);
						this.clicktpa.getHash().remove(target);
						this.clicktpa.getTpaHere().remove(p);
						this.clicktpa.getTpaHere().remove(target);
						this.clicktpa.getTpaCancel().remove(p.getName());
						this.clicktpa.getTpaCancel().remove(target.getName());
						if (this.clicktpa.getTpaInfo().get(target).getType() == 0) {
							this.clicktpa.getGraceList().add(target);
						}

						if (this.clicktpa.getTpaInfo().get(target).getType() == 1) {
							this.clicktpa.getGraceList().add(p);
						}

						this.clicktpa.getTpaInfo().remove(target);
						this.countdown = this.clicktpa.getServer().getScheduler().scheduleSyncRepeatingTask(this.clicktpa, () -> {
							if (this.seconds != -1) {
								if (this.seconds != 0) {
									if (!this.clicktpa.getTeleportStatus().contains(target) && !this.clicktpa.getTeleportStatus().contains(p)) {
										this.clicktpa.getServer().getScheduler().cancelTask(this.countdown);

										if (!this.clicktpa.getTeleportStatus().contains(target) || !this.clicktpa.getTeleportStatus().contains(p)) {
											if (this.clicktpa.getWhosFault().contains(p)) {
												target.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-moved-before-tp")
													.replaceAll("%player%", p.getName())));
												p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-moved-before-tp")
													.replaceAll("%player%", p.getName())));
												this.clicktpa.getWhosFault().remove(p);
												this.clicktpa.getWhosFault().remove(target);
											}

											if (this.clicktpa.getWhosFault().contains(target)) {
												target.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-moved-before-tp")
													.replaceAll("%player%", target.getName())));
												p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-moved-before-tp")
													.replaceAll("%player%", target.getName())));
												this.clicktpa.getWhosFault().remove(target);
												this.clicktpa.getWhosFault().remove(p);
											}
										}
									} else {
										--this.seconds;
									}
								} else {
									this.clicktpa.getTeleportStatus().remove(p);
									this.clicktpa.getTeleportStatus().remove(target);

									if (clicktpa.getTpaInfo().get(target).getType() == 1) {
										p.teleport(target);

									} else if (clicktpa.getTpaInfo().get(target).getType() == 0) {
										target.teleport(p);
									}

									p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Target-currently-teleporting")));
									target.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-currently-teleporting")));
									this.clicktpa.getServer().getScheduler().cancelTask(this.countdown);
								}
							}

						}, 0L, 20L);
						return true;
					}

					if (target == null) {
						if (this.clicktpa.getHash().containsKey(target) && !this.clicktpa.getTpaHere().containsKey(target)) {
							if (!this.clicktpa.getHash().containsKey(target) && !this.clicktpa.getTpaHere().containsKey(target)) {
								return true;
							}

							this.clearLists(p, target);
							p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Player-no-pendingtpa-message")));
							return true;
						}

						this.clearLists(p, target);
						p.sendMessage(this.colorize(this.clicktpa.getConfig().getString("Target-is-offline")));
						return true;
					}
				}

				return true;
			}
		}
	}

	private void clearLists(Player player, Player target) {
		this.clicktpa.getHash().remove(player);
		this.clicktpa.getHash().remove(target);
		this.clicktpa.getTpaHere().remove(player);
		this.clicktpa.getTpaHere().remove(target);
		this.clicktpa.getTeleportStatus().remove(player);
		this.clicktpa.getTeleportStatus().remove(target);
		this.clicktpa.getTpaCancel().remove(player.getName());
		this.clicktpa.getTpaCancel().remove(target.getName());
	}

	public String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public Commands(ClickTpa pl) {
		this.clicktpa = pl;
	}
}