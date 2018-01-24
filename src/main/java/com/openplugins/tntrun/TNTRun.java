package com.openplugins.tntrun;

import com.openplugins.tntrun.command.GameCommands;
import com.openplugins.tntrun.utils.State;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTRun extends JavaPlugin {

    private State state;
    private String version;
    private GameCommands gameCommands;

    private static TNTRun game;

    @Override
    public void onEnable() {
        game=this;
        state=State.LOBBY;
        version="1.0.0";

        gameCommands = new GameCommands();

        getCommand("start").setExecutor(gameCommands);
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
