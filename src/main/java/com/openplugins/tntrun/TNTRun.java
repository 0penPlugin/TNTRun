package com.openplugins.tntrun;

import com.openplugins.tntrun.arena.Arena;
import com.openplugins.tntrun.command.GameCommands;
import com.openplugins.tntrun.events.PlayerJoin;
import com.openplugins.tntrun.utils.State;
import com.openplugins.tntrun.utils.StorageAPI;
import com.openplugins.utils.web.Request;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TNTRun extends JavaPlugin {

    private State state;
    private String version;
    private GameCommands gameCommands;
    private Request request;
    private String requestResult;
    private Arena arena;
    private PluginManager pluginManager;
    private List<UUID> players;

    private static TNTRun game;

    @Override
    public void onEnable() {

        if (Bukkit.getPluginManager().getPlugin("SpigotUtils") == null) {
            this.setEnabled(false);
            return;
        }

        this.saveDefaultConfig();
        game=this;
        state=State.LOBBY;
        version="1.0.0";

        players = new ArrayList<>();

        arena=new Arena();

        pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoin(),this);

        request = new Request("http://openplugins.atspace.cc/","tntrun.php");

        if (!request.request("version").contains(version)) {
            requestResult= ChatColor.RED + "Update required! " + ChatColor.GOLD + "Type /update to update the plugin";
        }

        gameCommands = new GameCommands();

        getCommand("start").setExecutor(gameCommands);
        getCommand("tntrun").setExecutor(gameCommands);
        getCommand("setlobby").setExecutor(gameCommands);
        getCommand("setspawn").setExecutor(gameCommands);

        StorageAPI.init();
    }

    public String getRequestResult() {
        return requestResult;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public Arena getArena() {
        return arena;
    }

    public static TNTRun getGame() {
        return game;
    }

    @Override
    public void onDisable() {
        this.saveConfig();

        for (Location location : StorageAPI.getRemovedBlocks()) {
            location.getBlock().setType(Material.TNT);
        }
    }

    public String getVersion() {
        return version;
    }
}
