package com.openplugins.tntrun;

import com.openplugins.tntrun.arena.Arena;
import com.openplugins.tntrun.command.GameCommands;
import com.openplugins.tntrun.events.PlayerJoin;
import com.openplugins.tntrun.utils.State;
import com.openplugins.utils.web.Request;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTRun extends JavaPlugin {

    private State state;
    private String version;
    private GameCommands gameCommands;
    private Request request;
    private String requestResult;
    private Arena arena;
    private PluginManager pluginManager;

    private static TNTRun game;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        game=this;
        state=State.LOBBY;
        version="1.0.0";

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
    }

    public String getRequestResult() {
        return requestResult;
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
    }

    public String getVersion() {
        return version;
    }
}
