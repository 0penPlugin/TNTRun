package com.openplugins.tntrun.utils;

import com.openplugins.tntrun.TNTRun;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class MovementThread extends BukkitRunnable {

    private int id;

    public MovementThread() {

        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(TNTRun.getGame(),this,10L,10L);

    }

    @Override
    public void run() {

        if (TNTRun.getGame().getState() != State.INGAME) {
            Bukkit.getScheduler().cancelTask(id);
            return;
        }

        for (UUID uuid : TNTRun.getGame().getPlayers()) {
            Player player = Bukkit.getPlayer(uuid);

            if (player == null) {
                TNTRun.getGame().getPlayers().remove(uuid);
                return;
            }

            Location location = player.getLocation().clone().subtract(0,1,0);

            if (location.getBlock().getType() != Material.TNT) {
                return;
            }

            new BukkitRunnable() {

                public void run() {
                    location.getBlock().setType(Material.AIR);
                    StorageAPI.getRemovedBlocks().add(location);
                }

            }.runTaskLater(TNTRun.getGame(),30L);
        }
    }
}
