package com.openplugins.tntrun;

import com.openplugins.tntrun.utils.State;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTRun extends JavaPlugin {

    private State state;
    private static TNTRun game;

    @Override
    public void onEnable() {
        game=this;
        state=State.LOBBY;
    }

    public static TNTRun getGame() {
        return game;
    }

    @Override
    public void onDisable() {
    }
}
