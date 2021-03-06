package me.noodles.staff.menu;

import org.bukkit.event.inventory.*;
import org.bukkit.potion.*;

import me.noodles.staff.Main;
import me.noodles.staff.inv.InvCreator;
import me.noodles.staff.inv.InvNames;
import me.noodles.staff.items.Items;

import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;

public class Event implements Listener
{
    int killed;
	String prefix;
    int SpigotDownloads;
    int varCharHashMap;
    String DoubleArrow;
    String Creative;
    String Survival;
    String Spectator;
    String Adventure;
    String Heal;
    String Feed;
    String WhitelistON;
    String WhitelistOFF;
    String WeatherRain;
    String WeatherClear;
    String TimeSixAM;
    String TimeSevenAM;
    String TimeEightAM;
    String TimeNineAM;
    String TimeTenAM;
    String TimeElevenAM;
    String TimeTwelvePM;
    String TimeOnePM;
    String TimeTwoPM;
    String TimeThreePM;
    String TimeFourPM;
    String TimeFivePM;
    String TimeSixPM;
    String TimeSevenPM;
    String TimeEightPM;
    String TimeNinePM;
    String TimeTenPM;
    String TimeElevenPM;
    String TimeTwelveAM;
    String TimeOneAM;
    String TimeTwoAM;
    String TimeThreeAM;
    String TimeFourAM;
    String TimeFiveAM;
    String MainMenu;
    String FlyON;
    String FlyOFF;
    String ClearInv;
    String SpeedMenu;
    String JumpMenu;
    String Speed1;
    String Speed2;
    String Speed3;
    String Speed4;
    String Speed5;
    String Speed6;
    String Speed7;
    String Speed8;
    String Jump1;
    String Jump2;
    String Jump3;
    String Jump4;
    String Jump5;
    String Jump6;
    String Jump7;
    String Jump8;
    String EffectsClear;
    String MobMenu;
    String ExtraMobMenu;
    String SpawnCreeper;
    String SpawnSpider;
    String SpawnSkeleton;
    String SpawnZombie;
    String SpawnSlime;
    String SpawnGhast;
    String SpawnZombiePig;
    String SpawnEnderman;
    String SpawnCaveSpider;
    String SpawnSilverfish;
    String SpawnBlaze;
    String SpawnMagmaCube;
    String SpawnBat;
    String SpawnWitch;
    String SpawnPig;
    String SpawnSheep;
    String SpawnCow;
    String SpawnChicken;
    String SpawnSquid;
    String SpawnWolf;
    String SpawnMushroom;
    String SpawnOcelot;
    String SpawnHorse;
    String SpawnVillager;
    String SpawnIronGolem;
    String SpawnSnowGolem;
    String SpawnGiant;
    String SpawnWither;
    String SpawnEnderDragon;
    String Invisibility;
    String WatherBreathing;
    String NightVision;
    String Slowness;
    String StrengthMenu;
    String Strength1;
    String Strength2;
    String Strength3;
    String Strength4;
    String Strength5;
    String Strength6;
    String Strength7;
    String Strength8;
    String VanishON;
    String VanishOFF;
    String servermanager;
    String ServerManagerMenu;
    String SpawnRabbit;
    String SpawnGuardian;
    String AdminSword;
    String AdminBow;
    String AdminStick;
    String AdminItemMenu;
    String DifficultyPeace;
    String DifficultyEasy;
    String DifficultyNormal;
    String DifficultyHard;
    String Difficutly;
    String DifficultyMenu;
    String GamemodeMenu;
    String TimeMenu;
    String ToolsMenu;
    String EffectsMenu;
    String ClearChat;
    String TrollMenu;
    String CowTroll;
    String CowTrollPlayer;
    String LightningTroll;
    String LightningTrollPlayer;
    String BlindnessTroll;
    String BlindnessTrollPlayer;
    String SlownessTroll;
    String SlownessTrollPlayer;
    String NauseaTroll;
    String NauseaTrollPlayer;
    String JumpTroll;
    String JumpTrollPlayer;
    String WeaknessTroll;
    String WeaknessTrollPlayer;
    String MobManagerMenu;
    String MobClear;
    String FlyMenu;
    String VanishMenu;
    String FeedAndHealMenu;

    
    public Event() {
        this.DoubleArrow = new StringBuilder().append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").toString();
        this.prefix = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Prefix"));
        this.Creative = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Creative"));
        this.Survival = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Survival"));
        this.Spectator = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Spectator"));
        this.Adventure = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Adventure"));
        this.Heal = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Heal"));
        this.Feed = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Feed"));
        this.WhitelistON = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.WhitelistON"));
        this.WhitelistOFF = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.WhitelistOFF"));
        this.WeatherRain = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.WeatherRain"));
        this.WeatherClear = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.WeatherClear"));
        this.TimeSixAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeSixAM"));
        this.TimeSevenAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeSevenAM"));
        this.TimeEightAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeEightAM"));
        this.TimeNineAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeNineAM"));
        this.TimeTenAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeTenAM"));
        this.TimeElevenAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeElevenAM"));
        this.TimeTwelvePM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeTwelvePM"));
        this.TimeOnePM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeOnePM"));
        this.TimeTwoPM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeTwoPM"));
        this.TimeThreePM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeThreePM"));
        this.TimeFourPM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeFourPM"));
        this.TimeFivePM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeFivePM"));
        this.TimeSixPM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeSixPM"));
        this.TimeSevenPM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeSevenPM"));
        this.TimeEightPM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeEightPM"));
        this.TimeNinePM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeNinePM"));
        this.TimeTenPM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeTenPM"));
        this.TimeElevenPM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeElevenPM"));
        this.TimeTwelveAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeTwelveAM"));
        this.TimeOneAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeOneAM"));
        this.TimeTwoAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeTwoAM"));
        this.TimeThreeAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeThreeAM"));
        this.TimeFourAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeFourAM"));
        this.TimeFiveAM = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeFiveAM"));
        this.MainMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.MainMenu"));
        this.FlyON = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.FlyON"));
        this.FlyOFF = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.FlyOFF"));
        this.ClearInv = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.ClearInv"));
        this.SpeedMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpeedMenu"));
        this.JumpMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.JumpMenu"));
        this.Speed1 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Speed1"));
        this.Speed2 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Speed2"));
        this.Speed3 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Speed3"));
        this.Speed4 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Speed4"));
        this.Speed5 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Speed5"));
        this.Speed6 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Speed6"));
        this.Speed7 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Speed7"));
        this.Speed8 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Speed8"));
        this.Jump1 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Jump1"));
        this.Jump2 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Jump2"));
        this.Jump3 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Jump3"));
        this.Jump4 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Jump4"));
        this.Jump5 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Jump5"));
        this.Jump6 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Jump6"));
        this.Jump7 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Jump7"));
        this.Jump8 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Jump8"));
        this.EffectsClear = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.EffectsClear"));
        this.MobMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.MobMenu"));
        this.ExtraMobMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.ExtraMobMenu"));
        this.SpawnCreeper = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnCreeper"));
        this.SpawnSkeleton = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnSkeleton"));
        this.SpawnSpider = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnSpider"));
        this.SpawnZombie = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnZombie"));
        this.SpawnSlime = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnSlime"));
        this.SpawnGhast = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnGhast"));
        this.SpawnZombiePig = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnZombiePig"));
        this.SpawnCaveSpider = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnCaveSpider"));
        this.SpawnSilverfish = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnSilverfish"));
        this.SpawnBlaze = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnBlaze"));
        this.SpawnMagmaCube = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnMagmaCube"));
        this.SpawnBat = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnBat"));
        this.SpawnWitch = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnWitch"));
        this.SpawnPig = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnPig"));
        this.SpawnSheep = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnSheep"));
        this.SpawnCow = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnCow"));
        this.SpawnChicken = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnChicken"));
        this.SpawnSquid = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnSquid"));
        this.SpawnWolf = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnWolf"));
        this.SpawnMushroom = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnMushroom"));
        this.SpawnOcelot = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnOcelot"));
        this.SpawnHorse = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnHorse"));
        this.SpawnVillager = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnVillager"));
        this.SpawnIronGolem = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnIronGolem"));
        this.SpawnSnowGolem = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnSnowGolem"));
        this.SpawnGiant = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnGiant"));
        this.SpawnWither = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnWither"));
        this.SpawnEnderDragon = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnEnderDragon"));
        this.Invisibility = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Invisibility"));
        this.WatherBreathing = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.WatherBreathing"));
        this.NightVision = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.NightVision"));
        this.Slowness = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Slowness"));
        this.StrengthMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.StrengthMenu"));
        this.Strength1 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Strength1"));
        this.Strength2 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Strength2"));
        this.Strength3 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Strength3"));
        this.Strength4 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Strength4"));
        this.Strength5 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Strength5"));
        this.Strength6 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Strength6"));
        this.Strength7 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Strength7"));
        this.Strength8 = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.Strength8"));
        this.VanishON = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.VanishON"));
        this.VanishOFF = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.VanishOFF"));
        this.ServerManagerMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.ServerManagerMenu"));
        this.SpawnRabbit = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnRabbit"));
        this.SpawnGuardian = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SpawnGuardian"));
        this.AdminSword = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.AdminSword"));
        this.AdminBow = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.AdminBow"));
        this.AdminStick = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.AdminStick"));
        this.AdminItemMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.AdminItemMenu"));
        this.DifficultyPeace = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.DifficultyPeace"));
        this.DifficultyEasy = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.DifficultyEasy"));
        this.DifficultyNormal = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.DifficultyNormal"));
        this.DifficultyHard = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.DifficultyHard"));
        this.DifficultyMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.DifficultyMenu"));
        this.GamemodeMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.GamemodeMenu"));
        this.TimeMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TimeMenu"));
        this.ToolsMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.ToolsMenu"));
        this.EffectsMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.EffectsMenu"));
        this.ClearChat = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.ClearChat"));
        this.CowTroll = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.CowTroll"));
        this.TrollMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.TrollMenu"));
        this.CowTrollPlayer = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.CowTrollPlayer"));
        this.LightningTrollPlayer = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.LightningTrollPlayer"));
        this.LightningTroll = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.LightningTroll"));
        this.BlindnessTroll = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.BlindnessTroll"));
        this.BlindnessTrollPlayer = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.BlindnessTrollPlayer"));
        this.SlownessTroll = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SlownessTroll"));
        this.SlownessTrollPlayer = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.SlownessTrollPlayer"));
        this.NauseaTroll = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.NauseaTroll"));
        this.NauseaTrollPlayer = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.NauseaTrollPlayer"));
        this.JumpTroll = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.JumpTroll"));
        this.JumpTrollPlayer = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.JumpTrollPlayer"));
        this.WeaknessTroll = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.WeaknessTroll"));
        this.WeaknessTrollPlayer = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.WeaknessTrollPlayer"));
        this.MobManagerMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.MobManagerMenu"));
        this.MobClear = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.MobClear"));
        this.FlyMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.FlyMenu"));
        this.VanishMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.VanishMenu"));
        this.FeedAndHealMenu = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.FeedAndHealMenu"));



        this.SpigotDownloads = 1024;
        this.varCharHashMap = 512;
        this.killed = 0;
    }
    
    
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getName().equals(InvNames.invname) || e.getInventory().getName().equals(InvNames.secInv) || e.getInventory().getName().equals(InvNames.timeset) || e.getInventory().getName().equals(InvNames.whitelist) || e.getInventory().getName().equals(InvNames.weather) || e.getInventory().getName().equals(InvNames.effects) || e.getInventory().getName().equals(InvNames.speed) || e.getInventory().getName().equals(InvNames.jumpboost) || e.getInventory().getName().equals(InvNames.tools) || e.getInventory().getName().equals(InvNames.extramobs) || e.getInventory().getName().equals(InvNames.mobs) || e.getInventory().getName().equals(InvNames.difficulty) || e.getInventory().getName().equals(InvNames.strength) || e.getInventory().getName().equals(InvNames.servermanager) || e.getInventory().getName().equals(InvNames.adminitems) || e.getInventory().getName().equals(InvNames.troll) || e.getInventory().getName().equals(InvNames.mobmanager) || e.getInventory().getName().equals(InvNames.flymenu) || e.getInventory().getName().equals(InvNames.vanishmenu) || e.getInventory().getName().equals(InvNames.feedandhealmenu) || e.getInventory().getName().equals(InvNames.bInv)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
        }
        Player p = (Player)e.getWhoClicked();
        if (e.getCurrentItem() == null)
        	return;
        if (e.getCurrentItem().equals((Object)Items.stone(p))) {
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Creative));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.dirt(p))) {
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Survival));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Grass(p))) {
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Spectator));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.CobbleStone(p))) {
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Adventure));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Blaze(p))) {
        	if(!p.hasPermission("staffmode.gamemode")) return;
        	p.openInventory(InvCreator.secInv);
            p.sendMessage(prefix + DoubleArrow + GamemodeMenu);
        }
        if (e.getCurrentItem().equals((Object)Items.Barrier(p))) {
        	if(!p.hasPermission("staffmode.gamemode")) return;
        	p.openInventory(InvCreator.timeset);
            p.sendMessage(prefix + DoubleArrow + TimeMenu);
        }   
        if (e.getCurrentItem().equals((Object)Items.Sponge(p))) {
            p.setHealth(20.0);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Heal));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Bread(p))) {
            p.setFoodLevel(20);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Feed));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.WhitelistON(p))) {
            Bukkit.getServer().setWhitelist(true);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.WhitelistON));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.WhitelistOFF(p))) {
            Bukkit.getServer().setWhitelist(false);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.WhitelistOFF));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.WeatherRain(p))) {
            World world = p.getWorld();
            world.setStorm(true);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.WeatherRain));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.WeatherClear(p))) {
            World world = p.getWorld();
            world.setStorm(false);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.WeatherClear));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.SIXAM(p))) {
            p.getWorld().setTime(24000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeSixAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.SEVENAM(p))) {
            p.getWorld().setTime(1000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeSevenAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.EIGHTAM(p))) {
            p.getWorld().setTime(2000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeEightAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.NINEAM(p))) {
            p.getWorld().setTime(3000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeNineAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.TENAM(p))) {
            p.getWorld().setTime(4000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeTenAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.ELEVENAM(p))) {
            p.getWorld().setTime(5000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeElevenAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.TWELVEPM(p))) {
            p.getWorld().setTime(6000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeTwelvePM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.ONEPM(p))) {
            p.getWorld().setTime(7000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeOnePM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.TWOPM(p))) {
            p.getWorld().setTime(8000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeTwoPM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.THREEPM(p))) {
            p.getWorld().setTime(9000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeThreePM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.FOURPM(p))) {
            p.getWorld().setTime(10000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeFourPM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.FIVEPM(p))) {
            p.getWorld().setTime(11000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeFivePM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.SIXPM(p))) {
            p.getWorld().setTime(12000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeSixPM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.SEVENPM(p))) {
            p.getWorld().setTime(13000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeSevenPM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.EIGHTPM(p))) {
            p.getWorld().setTime(14000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeEightPM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.NINEPM(p))) {
            p.getWorld().setTime(15000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeNinePM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.TENPM(p))) {
            p.getWorld().setTime(16000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeTenPM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.ELEVENPM(p))) {
            p.getWorld().setTime(17000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeElevenPM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.TWELVEAM(p))) {
            p.getWorld().setTime(18000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeTwelveAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.ONEAM(p))) {
            p.getWorld().setTime(19000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeOneAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.TWOAM(p))) {
            p.getWorld().setTime(18000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeTwoAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.THREEAM(p))) {
            p.getWorld().setTime(21000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeThreeAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.FOURAM(p))) {
            p.getWorld().setTime(22000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeFourAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.FIVEAM(p))) {
            p.getWorld().setTime(22000L);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TimeFiveAM));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.BACK(p))) {
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.MainMenu));
            p.openInventory(InvCreator.StaffGui);
        }
        if (e.getCurrentItem().equals((Object)Items.TOOLS(p))) {
        	if(!p.hasPermission("staffmode.tools")) return;
        	p.openInventory(InvCreator.tools);
            p.sendMessage(prefix + DoubleArrow + ToolsMenu);
        }   
        if (e.getCurrentItem().equals((Object)Items.FlyOn(p))) {
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.FlyON));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.FlyOff(p))) {
            p.setAllowFlight(false);
            p.setFlying(false);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.FlyOFF));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.InvClear(p))) {
            p.getInventory().clear();
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.ClearInv));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Speed(p))) {
        	p.openInventory(InvCreator.speed);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpeedMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.JumpBoost(p))) {
            p.openInventory(InvCreator.jumpboost);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.JumpMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.EFFECTS(p))) {
        	if(!p.hasPermission("staffmode.effects")) return;
        	p.openInventory(InvCreator.effects);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.EffectsMenu));
        }     
        if (e.getCurrentItem().equals((Object)Items.Speed1(p))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 1));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Speed1));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.RemoveEffects(p))) {
            p.getActivePotionEffects().clear();
            for (PotionEffect pe : p.getActivePotionEffects()) {
                p.removePotionEffect(pe.getType());
            }
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.EffectsClear));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Speed2(p))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 2));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Speed2));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Speed3(p))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 3));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Speed3));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Speed4(p))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 4));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Speed4));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Speed5(p))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 5));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Speed5));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Speed6(p))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 6));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Speed6));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Speed7(p))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 7));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Speed7));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Speed8(p))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 8));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Speed8));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Jumpboost1(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 1));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Jump1));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Jumpboost2(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 2));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Jump2));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Jumpboost3(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 3));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Jump3));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Jumpboost4(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 4));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Jump4));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Jumpboost5(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 5));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Jump5));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Jumpboost6(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 6));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Jump6));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Jumpboost7(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 7));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Jump7));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Jumpboost8(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 8));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Jump8));
            e.getWhoClicked().closeInventory();
        }  
        if (e.getCurrentItem().equals((Object)Items.MobMenu(p))) {
        	if(!p.hasPermission("staffmode.mobs")) return;
        	p.openInventory(InvCreator.mobs);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.MobMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.MobCreeper(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnCreeper));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobSkeleton(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnSkeleton));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobSpider(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnSpider));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobZombie(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnZombie));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobSlime(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.SLIME);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnSlime));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobGhast(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.GHAST);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnGhast));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobZombiePig(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG_ZOMBIE);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnZombiePig));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobEnderman(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDERMAN);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnEnderman));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobCaveSpider(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.CAVE_SPIDER);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnCaveSpider));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobSilverFish(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.SILVERFISH);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnSilverfish));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobBlaze(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.BLAZE);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnBlaze));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.PotionNight(p))) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 10000000, 0));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.NightVision));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobMagmaCube(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.MAGMA_CUBE);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnMagmaCube));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobBat(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnBat));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobWitch(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.WITCH);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnWitch));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobPig(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnPig));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobSheep(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.SHEEP);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnSheep));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobCow(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.COW);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnCow));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobChicken(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.CHICKEN);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnChicken));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobSquid(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.SQUID);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnSquid));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobWolf(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnWolf));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobMooshroom(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.MUSHROOM_COW);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnMushroom));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobOcelot(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.OCELOT);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnOcelot));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobHorse(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnHorse));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobVillager(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnVillager));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.ExtraMobs(p))) {
            p.openInventory(InvCreator.extramobs);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.ExtraMobMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.MobIron(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.IRON_GOLEM);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnIronGolem));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobSnow(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.SNOWMAN);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnSnowGolem));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobGiant(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.GIANT);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnGiant));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobWither(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.WITHER);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnWither));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobDragon(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDER_DRAGON);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnEnderDragon));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobRabbit(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.RABBIT);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnRabbit));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.MobGuardian(p))) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.GUARDIAN);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SpawnGuardian));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Invis(p))) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10000000, 0));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Invisibility));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.PotionWater(p))) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 10000000, 0));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.WatherBreathing));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.StrengthMenu(p))) {
            p.openInventory(InvCreator.strength);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.StrengthMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.Strength1(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180000000, 1));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Strength1));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Strength2(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180000000, 2));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Strength2));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Strength3(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180000000, 3));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Strength3));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Strength4(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180000000, 4));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Strength4));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Strength5(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180000000, 5));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Strength5));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Strength6(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180000000, 6));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Strength6));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Strength7(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180000000, 7));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Strength7));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Strength8(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180000000, 8));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Strength8));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Slowness(p))) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 180000000, 0));
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.Slowness));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.Support(p))) {
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + ChatColor.GRAY + "Support:" + ChatColor.RED + " http://support.bghdnetwork.net");
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.ServerManager(p))) {
        	if(!p.hasPermission("staffmode.servermanager")) return;
        	p.openInventory(InvCreator.servermanager);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.ServerManagerMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.AdminSword(p))) {
            ItemStack is = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta isMeta = is.getItemMeta();
            isMeta.addEnchant(Enchantment.DAMAGE_ALL, 1000, true);
            isMeta.addEnchant(Enchantment.DURABILITY, 1000, true);
            isMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append(ChatColor.UNDERLINE).append("Admin Sword").toString());
            is.setItemMeta(isMeta);
            p.getInventory().addItem(new ItemStack[] { is });
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.AdminSword));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.AdminStick(p))) {
            ItemStack is = new ItemStack(Material.STICK, 1);
            ItemMeta isMeta = is.getItemMeta();
            isMeta.addEnchant(Enchantment.KNOCKBACK, 15, true);
            isMeta.addEnchant(Enchantment.DURABILITY, 1000, true);
            isMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append(ChatColor.UNDERLINE).append("Admin Stick").toString());
            is.setItemMeta(isMeta);
            p.getInventory().addItem(new ItemStack[] { is });
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.AdminStick));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.AdminBow(p))) {
            ItemStack is = new ItemStack(Material.BOW, 1);
            ItemStack is2 = new ItemStack(Material.ARROW, 1);
            ItemMeta isMeta2 = is.getItemMeta();
            isMeta2.addEnchant(Enchantment.ARROW_INFINITE, 1000, true);
            isMeta2.addEnchant(Enchantment.DURABILITY, 1000, true);
            isMeta2.addEnchant(Enchantment.ARROW_KNOCKBACK, 1000, true);
            isMeta2.addEnchant(Enchantment.ARROW_FIRE, 1000, true);
            isMeta2.addEnchant(Enchantment.ARROW_DAMAGE, 1000, true);
            isMeta2.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append(ChatColor.UNDERLINE).append("Admin Bow").toString());
            is.setItemMeta(isMeta2);
            ItemMeta is2Meta = is2.getItemMeta();
            is2Meta.addEnchant(Enchantment.DURABILITY, 1000, true);
            is2Meta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append(ChatColor.UNDERLINE).append("Admin Arrow").toString());
            is2.setItemMeta(is2Meta);
            p.getInventory().addItem(new ItemStack[] { is });
            p.getInventory().addItem(new ItemStack[] { is2 });
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.AdminBow));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.AdminItemMenu(p))) {
        	if(!p.hasPermission("staffmode.adminitems")) return;
        	p.openInventory(InvCreator.adminitems);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.AdminItemMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.DifficultyPeace(p))) {
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "difficulty 0");
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.DifficultyPeace));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.DifficultyEasy(p))) {
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "difficulty 1");
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.DifficultyEasy));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.DifficultyNormal(p))) {
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "difficulty 2");
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.DifficultyNormal));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.DifficultyHard(p))) {
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "difficulty 3");
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.DifficultyHard));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.DifficultyMenu(p))) {
        	if(!p.hasPermission("staffmode.difficulty")) return;
        	p.openInventory(InvCreator.difficulty);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.DifficultyMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.TrollMenu(p))) {
        	if(!p.hasPermission("staffmode.trolls")) return;
        	p.openInventory(InvCreator.troll);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.TrollMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.MobManagerMenu(p))) {
        	if(!p.hasPermission("staffmode.mobmanager")) return;
        	p.openInventory(InvCreator.mobmanager);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.MobManagerMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.FlyMenu(p))) {
        	p.openInventory(InvCreator.flymenu);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.FlyMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.VanishMenu(p))) {
        	p.openInventory(InvCreator.vanishmenu);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.VanishMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.FeedAndHealMenu(p))) {
        	p.openInventory(InvCreator.feedandhealmenu);
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.FeedAndHealMenu));
        }
        if (e.getCurrentItem().equals((Object)Items.MobClear(p))) {
              p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.MobClear));
        	  World[] array;
  	        for (int length = (array = Bukkit.getServer().getWorlds().toArray(new World[0])).length, i = 0; i < length; ++i) {
  	            final World world = array[i];
  	            for (final LivingEntity mobs : world.getLivingEntities()) {
  	                if (!(mobs instanceof Player)) {
  	                    mobs.remove();
  	                    ++this.killed;
        }
  	              e.getWhoClicked().closeInventory();
  	            }
  	        }
        }
  	            
        
        
        
        
     // PUT ABOVE
        if (e.getCurrentItem().equals((Object)Items.LightningTroll(p)))  {
        	for (Player players : Bukkit.getOnlinePlayers()) {
        		players.getWorld().strikeLightningEffect(players.getLocation());
        		players.getWorld().strikeLightningEffect(players.getLocation());
        		players.getWorld().strikeLightningEffect(players.getLocation());
        		players.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.LightningTrollPlayer));
                p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.LightningTroll));
                e.getWhoClicked().closeInventory();
            }
        	}
        if (e.getCurrentItem().equals((Object)Items.SlownessTroll(p)))  {
        	for (Player players : Bukkit.getOnlinePlayers()) {
        		players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 4));
        		players.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SlownessTrollPlayer));
                p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SlownessTroll));
                e.getWhoClicked().closeInventory();
            }
        	}
        if (e.getCurrentItem().equals((Object)Items.JumpTroll(p)))  {
        	for (Player players : Bukkit.getOnlinePlayers()) {
        		players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 4));
        		players.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.JumpTrollPlayer));
                p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.JumpTroll));
                e.getWhoClicked().closeInventory();
            }
        	}
        if (e.getCurrentItem().equals((Object)Items.WeaknessTroll(p)))  {
        	for (Player players : Bukkit.getOnlinePlayers()) {
        		players.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 4));
        		players.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.WeaknessTrollPlayer));
                p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.WeaknessTroll));
                e.getWhoClicked().closeInventory();
            }
        	}
        if (e.getCurrentItem().equals((Object)Items.NauseaTroll(p)))  {
        	for (Player players : Bukkit.getOnlinePlayers()) {
        		players.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 4));
        		players.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.NauseaTrollPlayer));
                p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.NauseaTroll));
                e.getWhoClicked().closeInventory();
            }
        	}
        if (e.getCurrentItem().equals((Object)Items.BlindnessTroll(p)))  {
        	for (Player players : Bukkit.getOnlinePlayers()) {
        		players.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 4));
        		players.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SlownessTrollPlayer));
                p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.SlownessTroll));
                e.getWhoClicked().closeInventory();
            }
        	}
        if (e.getCurrentItem().equals((Object)Items.CowTroll(p)))  {
        	for (Player players : Bukkit.getOnlinePlayers()) {
        		players.getWorld().spawnEntity(players.getLocation(), EntityType.COW);
                p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.CowTroll));
                players.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.CowTrollPlayer));
                e.getWhoClicked().closeInventory();
            }
        	}
        if (e.getCurrentItem().equals((Object)Items.ClearChat(p)))  {
        	for (Player players : Bukkit.getOnlinePlayers()) {
                for (int i = 0; i < 600; ++i) {
                    players.sendMessage("");
            }
        	}
        Bukkit.broadcastMessage(String.valueOf(this.prefix) + this.DoubleArrow + String.valueOf(this.ClearChat));
        Bukkit.broadcastMessage(" ");
        e.getWhoClicked().closeInventory();
    }
    
        if (e.getCurrentItem().equals((Object)Items.VanishON(p))) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.hidePlayer(p);
                p.setAllowFlight(true);
                p.setFlying(true);
            }
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.VanishON));
            e.getWhoClicked().closeInventory();
        }
        if (e.getCurrentItem().equals((Object)Items.VanishOFF(p))) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.showPlayer(p);
                p.setAllowFlight(false);
                p.setFlying(false);
            }
            p.sendMessage(String.valueOf(String.valueOf(this.prefix)) + this.DoubleArrow + String.valueOf(this.VanishOFF));
            e.getWhoClicked().closeInventory();
        }
        e.getCurrentItem().equals((Object)Items.Glass(p));
        if (e.getCurrentItem().equals((Object)Items.Blaze(p))) {
            InvCreator.secInv.setItem(5, Items.stone(p));
            InvCreator.secInv.setItem(3, Items.dirt(p));
            InvCreator.secInv.setItem(1, Items.CobbleStone(p));
            InvCreator.secInv.setItem(7, Items.Grass(p));
            InvCreator.secInv.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.secInv.getItem(i) == null) {
                    InvCreator.secInv.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.secInv);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.Gravel(p))) {
            InvCreator.bInv.setItem(4, Items.Sponge(p));
            InvCreator.bInv.setItem(3, Items.Bread(p));
            InvCreator.bInv.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.bInv.getItem(i) == null) {
                    InvCreator.bInv.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.bInv);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.Barrier(p))) {
            InvCreator.timeset.setItem(4, Items.FOURAM(p));
            InvCreator.timeset.setItem(3, Items.THREEAM(p));
            InvCreator.timeset.setItem(0, Items.TWELVEAM(p));
            InvCreator.timeset.setItem(1, Items.ONEAM(p));
            InvCreator.timeset.setItem(2, Items.TWOAM(p));
            InvCreator.timeset.setItem(6, Items.SIXAM(p));
            InvCreator.timeset.setItem(7, Items.SEVENAM(p));
            InvCreator.timeset.setItem(5, Items.FIVEAM(p));
            InvCreator.timeset.setItem(8, Items.EIGHTAM(p));
            InvCreator.timeset.setItem(9, Items.NINEAM(p));
            InvCreator.timeset.setItem(10, Items.TENAM(p));
            InvCreator.timeset.setItem(11, Items.ELEVENAM(p));
            InvCreator.timeset.setItem(12, Items.TWELVEPM(p));
            InvCreator.timeset.setItem(13, Items.ONEPM(p));
            InvCreator.timeset.setItem(14, Items.TWOPM(p));
            InvCreator.timeset.setItem(15, Items.THREEPM(p));
            InvCreator.timeset.setItem(16, Items.FOURPM(p));
            InvCreator.timeset.setItem(17, Items.FIVEPM(p));
            InvCreator.timeset.setItem(18, Items.SIXPM(p));
            InvCreator.timeset.setItem(19, Items.SEVENPM(p));
            InvCreator.timeset.setItem(20, Items.EIGHTPM(p));
            InvCreator.timeset.setItem(21, Items.NINEPM(p));
            InvCreator.timeset.setItem(22, Items.TENPM(p));
            InvCreator.timeset.setItem(23, Items.ELEVENPM(p));
            InvCreator.timeset.setItem(24, Items.Glass(p));
            InvCreator.timeset.setItem(25, Items.Glass(p));
            InvCreator.timeset.setItem(26, Items.BACK(p));
            for (int i = 0; i < 27; ++i) {
                if (InvCreator.timeset.getItem(i) == null) {
                    InvCreator.timeset.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.timeset);
        }
     }
        if (e.getCurrentItem().equals((Object)Items.Whitelist(p))) {
            InvCreator.whitelist.setItem(3, Items.WhitelistON(p));
            InvCreator.whitelist.setItem(5, Items.WhitelistOFF(p));
            InvCreator.whitelist.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.whitelist.getItem(i) == null) {
                    InvCreator.whitelist.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.whitelist);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.FlyMenu(p))) {
            InvCreator.flymenu.setItem(3, Items.FlyOn(p));
            InvCreator.flymenu.setItem(5, Items.FlyOff(p));
            InvCreator.flymenu.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.flymenu.getItem(i) == null) {
                    InvCreator.flymenu.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.flymenu);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.VanishMenu(p))) {
            InvCreator.vanishmenu.setItem(3, Items.VanishON(p));
            InvCreator.vanishmenu.setItem(5, Items.VanishOFF(p));
            InvCreator.vanishmenu.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.vanishmenu.getItem(i) == null) {
                    InvCreator.vanishmenu.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.vanishmenu);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.FeedAndHealMenu(p))) {
            InvCreator.feedandhealmenu.setItem(3, Items.Bread(p));
            InvCreator.feedandhealmenu.setItem(5, Items.Sponge(p));
            InvCreator.feedandhealmenu.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.feedandhealmenu.getItem(i) == null) {
                    InvCreator.feedandhealmenu.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.feedandhealmenu);
        }
      }
        
        
        if (e.getCurrentItem().equals((Object)Items.Weather(p))) {
            InvCreator.weather.setItem(3, Items.WeatherRain(p));
            InvCreator.weather.setItem(5, Items.WeatherClear(p));
            InvCreator.weather.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.weather.getItem(i) == null) {
                    InvCreator.weather.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.weather);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.TOOLS(p))) {
            InvCreator.tools.setItem(1, Items.FeedAndHealMenu(p));
            InvCreator.tools.setItem(6, Items.InvClear(p));
            InvCreator.tools.setItem(0, Items.FlyMenu(p));
            InvCreator.tools.setItem(7, Items.ClearChat(p));
            InvCreator.tools.setItem(2, Items.VanishMenu(p));
            InvCreator.tools.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.tools.getItem(i) == null) {
                    InvCreator.tools.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.tools);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.EFFECTS(p))) {
            InvCreator.effects.setItem(4, Items.PotionWater(p));
            InvCreator.effects.setItem(3, Items.Invis(p));
            InvCreator.effects.setItem(0, Items.JumpBoost(p));
            InvCreator.effects.setItem(1, Items.Speed(p));
            InvCreator.effects.setItem(2, Items.StrengthMenu(p));
            InvCreator.effects.setItem(6, Items.Slowness(p));
            InvCreator.effects.setItem(7, Items.RemoveEffects(p));
            InvCreator.effects.setItem(5, Items.PotionNight(p));
            InvCreator.effects.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.effects.getItem(i) == null) {
                    InvCreator.effects.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.effects);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.Speed(p))) {
            InvCreator.speed.setItem(4, Items.Speed5(p));
            InvCreator.speed.setItem(3, Items.Speed4(p));
            InvCreator.speed.setItem(0, Items.Speed1(p));
            InvCreator.speed.setItem(1, Items.Speed2(p));
            InvCreator.speed.setItem(2, Items.Speed3(p));
            InvCreator.speed.setItem(6, Items.Speed7(p));
            InvCreator.speed.setItem(7, Items.Speed8(p));
            InvCreator.speed.setItem(5, Items.Speed6(p));
            InvCreator.speed.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.speed.getItem(i) == null) {
                    InvCreator.speed.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.speed);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.JumpBoost(p))) {
            InvCreator.jumpboost.setItem(4, Items.Jumpboost5(p));
            InvCreator.jumpboost.setItem(3, Items.Jumpboost4(p));
            InvCreator.jumpboost.setItem(0, Items.Jumpboost1(p));
            InvCreator.jumpboost.setItem(1, Items.Jumpboost2(p));
            InvCreator.jumpboost.setItem(2, Items.Jumpboost3(p));
            InvCreator.jumpboost.setItem(6, Items.Jumpboost7(p));
            InvCreator.jumpboost.setItem(7, Items.Jumpboost8(p));
            InvCreator.jumpboost.setItem(5, Items.Jumpboost6(p));
            InvCreator.jumpboost.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.jumpboost.getItem(i) == null) {
                    InvCreator.jumpboost.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.jumpboost);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.MobMenu(p))) {
            InvCreator.mobs.setItem(4, Items.MobSlime(p));
            InvCreator.mobs.setItem(3, Items.MobZombie(p));
            InvCreator.mobs.setItem(0, Items.MobCreeper(p));
            InvCreator.mobs.setItem(1, Items.MobSkeleton(p));
            InvCreator.mobs.setItem(2, Items.MobSpider(p));
            InvCreator.mobs.setItem(6, Items.MobZombiePig(p));
            InvCreator.mobs.setItem(7, Items.MobEnderman(p));
            InvCreator.mobs.setItem(5, Items.MobGhast(p));
            InvCreator.mobs.setItem(8, Items.MobCaveSpider(p));
            InvCreator.mobs.setItem(9, Items.MobSilverFish(p));
            InvCreator.mobs.setItem(10, Items.MobBlaze(p));
            InvCreator.mobs.setItem(11, Items.MobMagmaCube(p));
            InvCreator.mobs.setItem(12, Items.MobBat(p));
            InvCreator.mobs.setItem(13, Items.MobWitch(p));
            InvCreator.mobs.setItem(14, Items.MobPig(p));
            InvCreator.mobs.setItem(15, Items.MobSheep(p));
            InvCreator.mobs.setItem(16, Items.MobCow(p));
            InvCreator.mobs.setItem(17, Items.MobChicken(p));
            InvCreator.mobs.setItem(18, Items.MobSquid(p));
            InvCreator.mobs.setItem(19, Items.MobWolf(p));
            InvCreator.mobs.setItem(20, Items.MobMooshroom(p));
            InvCreator.mobs.setItem(21, Items.MobOcelot(p));
            InvCreator.mobs.setItem(22, Items.MobHorse(p));
            InvCreator.mobs.setItem(23, Items.MobVillager(p));
            InvCreator.mobs.setItem(24, Items.MobRabbit(p));
            InvCreator.mobs.setItem(25, Items.ExtraMobs(p));
            InvCreator.mobs.setItem(26, Items.BACK(p));
            for (int i = 0; i < 27; ++i) {
                if (InvCreator.mobs.getItem(i) == null) {
                    InvCreator.mobs.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.mobs);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.ExtraMobs(p))) {
            InvCreator.extramobs.setItem(4, Items.MobWither(p));
            InvCreator.extramobs.setItem(3, Items.MobGiant(p));
            InvCreator.extramobs.setItem(0, Items.MobIron(p));
            InvCreator.extramobs.setItem(1, Items.MobSnow(p));
            InvCreator.extramobs.setItem(2, Items.MobGuardian(p));
            InvCreator.extramobs.setItem(5, Items.MobDragon(p));
            InvCreator.extramobs.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.extramobs.getItem(i) == null) {
                    InvCreator.extramobs.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.extramobs);
        }
     }
        if (e.getCurrentItem().equals((Object)Items.DifficultyMenu(p))) {
            InvCreator.difficulty.setItem(3, Items.DifficultyEasy(p));
            InvCreator.difficulty.setItem(1, Items.DifficultyPeace(p));
            InvCreator.difficulty.setItem(7, Items.DifficultyHard(p));
            InvCreator.difficulty.setItem(5, Items.DifficultyNormal(p));
            InvCreator.difficulty.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.difficulty.getItem(i) == null) {
                    InvCreator.difficulty.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.difficulty);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.StrengthMenu(p))) {
            InvCreator.strength.setItem(4, Items.Strength5(p));
            InvCreator.strength.setItem(3, Items.Strength4(p));
            InvCreator.strength.setItem(0, Items.Strength1(p));
            InvCreator.strength.setItem(1, Items.Strength2(p));
            InvCreator.strength.setItem(2, Items.Strength3(p));
            InvCreator.strength.setItem(6, Items.Strength7(p));
            InvCreator.strength.setItem(7, Items.Strength8(p));
            InvCreator.strength.setItem(5, Items.Strength6(p));
            InvCreator.strength.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.strength.getItem(i) == null) {
                    InvCreator.strength.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.strength);
        }
       }
        if (e.getCurrentItem().equals((Object)Items.ServerManager(p))) {
        	InvCreator.servermanager.setItem(1, Items.MobManagerMenu(p));
        	InvCreator.servermanager.setItem(3, Items.Weather(p));
            InvCreator.servermanager.setItem(5, Items.Whitelist(p));
            InvCreator.servermanager.setItem(8, Items.BACK(p));          
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.servermanager.getItem(i) == null) {
                    InvCreator.servermanager.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.servermanager);
        }
       }
        if (e.getCurrentItem().equals((Object)Items.AdminItemMenu(p))) {
            InvCreator.adminitems.setItem(5, Items.AdminBow(p));
            InvCreator.adminitems.setItem(3, Items.AdminSword(p));
            InvCreator.adminitems.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.adminitems.getItem(i) == null) {
                    InvCreator.adminitems.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.adminitems);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.TrollMenu(p))) {
            InvCreator.troll.setItem(4, Items.NauseaTroll(p));
            InvCreator.troll.setItem(3, Items.SlownessTroll(p));
            InvCreator.troll.setItem(0, Items.CowTroll(p));
            InvCreator.troll.setItem(1, Items.LightningTroll(p));
            InvCreator.troll.setItem(2, Items.BlindnessTroll(p));
            InvCreator.troll.setItem(5, Items.JumpTroll(p));
            InvCreator.troll.setItem(6, Items.WeaknessTroll(p));
            InvCreator.troll.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.troll.getItem(i) == null) {
                    InvCreator.troll.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.troll);
        }
      }
        if (e.getCurrentItem().equals((Object)Items.MobManagerMenu(p))) {
            InvCreator.mobmanager.setItem(4, Items.MobClear(p));
            InvCreator.mobmanager.setItem(8, Items.BACK(p));
            for (int i = 0; i < 9; ++i) {
                if (InvCreator.mobmanager.getItem(i) == null) {
                    InvCreator.mobmanager.setItem(i, Items.Glass(p));
                }
            p.openInventory(InvCreator.mobmanager);
        }
      }
        
        
    }
}
