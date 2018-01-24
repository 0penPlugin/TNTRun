package com.openplugins.tntrun;

import com.openplugins.tntrun.command.GameCommands;
import com.openplugins.tntrun.utils.State;
import com.openplugins.utils.web.Request;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTRun extends JavaPlugin {

    private State state;
    private String version;
    private GameCommands gameCommands;
    private Request request;
    private String requestResult;

    private static TNTRun game;

    @Override
    public void onEnable() {
        game=this;
        state=State.LOBBY;
        version="1.0.0";

        request = new Request("http://openplugins.atspace.cc/","tntrun.php");

        if (!request.request("version").contains(version)) {
            requestResult= ChatColor.RED + "Update required!";
        }

        gameCommands = new GameCommands();

        getCommand("start").setExecutor(gameCommands);
        getCommand("tntrun").setExecutor(gameCommands);
    }

    public String getRequestResult() {
        return requestResult;
    }

    public static TNTRun getGame() {
        return game;
    }

    @Override
    public void onDisable() {
    }

    public String getVersion() {
        return version;
    }
}
