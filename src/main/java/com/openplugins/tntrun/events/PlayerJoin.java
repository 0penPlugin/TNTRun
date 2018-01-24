package com.openplugins.tntrun.events;

import com.openplugins.tntrun.TNTRun;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(event.getPlayer().getName() + " has joined TNTRun");

        event.getPlayer().teleport(TNTRun.getGame().getArena().getLobby());
    }
}
