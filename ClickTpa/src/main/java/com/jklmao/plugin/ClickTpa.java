package com.jklmao.plugin;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
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
		getLogger().info("ClickTPA has been loaded Successfully!");
		getServer().getPluginManager().registerEvents((Listener) new PlayerEvents(this), (Plugin) this);
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
		getCommand("tpa").setExecutor((CommandExecutor) new CommandTpa(this));
		getCommand("tpahere").setExecutor((CommandExecutor) new CommandTpaHere(this));
		getCommand("tpacancel").setExecutor((CommandExecutor) new CommandTpCancel(this));
		getCommand("tpaccept").setExecutor((CommandExecutor) new Commands(this));
		getCommand("tpdeny").setExecutor((CommandExecutor) new CommandTpaDeny(this));
		getCommand("tpo").setExecutor((CommandExecutor) new CommandTpo(this));
		getCommand("tpohere").setExecutor((CommandExecutor) new CommandTpoHere(this));
		getCommand("tptoggle").setExecutor((CommandExecutor) new CommandTpToggle(this));
		getCommand("clicktparl").setExecutor((CommandExecutor) new CommandReload(this));
	}
}
