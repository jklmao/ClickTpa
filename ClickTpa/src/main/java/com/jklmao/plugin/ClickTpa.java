package com.jklmao.plugin;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.jklmao.plugin.commands.CommandReload;
import com.jklmao.plugin.commands.CommandTpCancel;
import com.jklmao.plugin.commands.CommandTpToggle;
import com.jklmao.plugin.commands.CommandTpa;
import com.jklmao.plugin.commands.CommandTpaDeny;
import com.jklmao.plugin.commands.CommandTpaHere;
import com.jklmao.plugin.commands.CommandTpo;
import com.jklmao.plugin.commands.CommandTpoHere;
import com.jklmao.plugin.commands.Commands;
import com.jklmao.plugin.events.PlayerEvents;
import com.jklmao.plugin.utils.CustomList;

public final class ClickTpa extends JavaPlugin {
	public static ClickTpa instance;

	private HashMap<Player, Player> tpacommandlist = new HashMap<>();

	private HashMap<Player, Player> tpaherecommandlist = new HashMap<>();

	private HashMap<String, String> tpacancel = new HashMap<>();

	private ArrayList<Player> tptoggled = new ArrayList<>();

	private ArrayList<Player> willTeleport = new ArrayList<>();

	private ArrayList<Player> whosFault = new ArrayList<>();

	private ArrayList<Player> graceList = new ArrayList<>();

	private HashMap<Player, CustomList> tpaInfo = new HashMap<>();

	@Override
	public void onEnable() {
		commandHandler();
		instance = this;
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
		getLogger().info("ClickTPA has been loaded Successfully!");

	}

	public HashMap<Player, Player> getHash() {
		return this.tpacommandlist;
	}

	public HashMap<Player, Player> getTpaHere() {
		return this.tpaherecommandlist;
	}

	public HashMap<String, String> getTpaCancel() {
		return this.tpacancel;
	}

	public ArrayList<Player> getTpToggled() {
		return this.tptoggled;
	}

	public ArrayList<Player> getTeleportStatus() {
		return this.willTeleport;
	}

	public ArrayList<Player> getWhosFault() {
		return this.whosFault;
	}

	public ArrayList<Player> getGraceList() {
		return this.graceList;
	}

	public HashMap<Player, CustomList> getTpaInfo() {
		return this.tpaInfo;
	}

	public void reloadTheConfig() {
		reloadConfig();
	}

	public void commandHandler() {
		getCommand("tpa").setExecutor(new CommandTpa(this));
		getCommand("tpahere").setExecutor(new CommandTpaHere(this));
		getCommand("tpacancel").setExecutor(new CommandTpCancel(this));
		getCommand("tpaccept").setExecutor(new Commands(this));
		getCommand("tpdeny").setExecutor(new CommandTpaDeny(this));
		getCommand("tpo").setExecutor(new CommandTpo(this));
		getCommand("tpohere").setExecutor(new CommandTpoHere(this));
		getCommand("tptoggle").setExecutor(new CommandTpToggle(this));
		getCommand("clicktparl").setExecutor(new CommandReload(this));
	}
}
