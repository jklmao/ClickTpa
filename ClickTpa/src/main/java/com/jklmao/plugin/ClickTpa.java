package com.jklmao.plugin;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.jklmao.plugin.commands.CommandReload;
import com.jklmao.plugin.commands.CommandTpCancel;
import com.jklmao.plugin.commands.CommandTpToggle;
import com.jklmao.plugin.commands.CommandTpa;
import com.jklmao.plugin.commands.CommandTpaDeny;
import com.jklmao.plugin.commands.CommandTpaHere;
import com.jklmao.plugin.commands.CommandTpaccept;
import com.jklmao.plugin.commands.CommandTpo;
import com.jklmao.plugin.commands.CommandTpoHere;
import com.jklmao.plugin.events.PlayerEvents;
import com.jklmao.plugin.utils.CustomList;

public final class ClickTpa extends JavaPlugin {

	private HashSet<Player> graceList = new HashSet<>();
	private HashMap<Player, Player> tpaCancel = new HashMap<>();
	private HashMap<Player, CustomList> playerTpaList = new HashMap<>();

	@Override
	public void onEnable() {
		commandHandler();
		addAllPlayers();

		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
		getLogger().info("ClickTpa v1.7.5 has been loaded successfully!");
		getLogger().info("---------------------------------------");
		getLogger().info("To any ClickTpa users who have a version before '1.7.5':");
		getLogger().info("There has been an update to the config; some messages have been removed.");
		getLogger().info("Therefore, if your config.yml is not updated, you will get errors.");
		getLogger().info("---------------------------------------");

	}

	public HashSet<Player> getGraceList() {
		return this.graceList;
	}

	public HashMap<Player, Player> getTpaCancel() {
		return tpaCancel;
	}

	public HashMap<Player, CustomList> getTpaPlayers() {
		return this.playerTpaList;
	}

	private void commandHandler() {
		getCommand("tpa").setExecutor(new CommandTpa(this));
		getCommand("tpahere").setExecutor(new CommandTpaHere(this));
		getCommand("tpacancel").setExecutor(new CommandTpCancel(this));
		getCommand("tpaccept").setExecutor(new CommandTpaccept(this));
		getCommand("tpdeny").setExecutor(new CommandTpaDeny(this));
		getCommand("tpo").setExecutor(new CommandTpo(this));
		getCommand("tpohere").setExecutor(new CommandTpoHere(this));
		getCommand("tptoggle").setExecutor(new CommandTpToggle(this));
		getCommand("clicktparl").setExecutor(new CommandReload(this));

		getCommand("tpa").setTabCompleter(new CommandTpa(this));
		getCommand("tpahere").setTabCompleter(new CommandTpaHere(this));
		getCommand("tpaccept").setTabCompleter(new CommandTpaccept(this));
		getCommand("tpdeny").setTabCompleter(new CommandTpaDeny(this));
		getCommand("tpo").setTabCompleter(new CommandTpo(this));
		getCommand("tpohere").setTabCompleter(new CommandTpoHere(this));

	}

	private void addAllPlayers() {

		CustomList list = new CustomList();

		for (Player p : Bukkit.getOnlinePlayers()) {
			playerTpaList.put(p, list);
		}

	}

}
