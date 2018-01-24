package com.openplugins.tntrun.arena;

import com.openplugins.tntrun.TNTRun;
import org.bukkit.Location;

public class Arena {

    private String name;
    private Location lobby;
    private Location spawn;

    public Arena() {
        this.name= TNTRun.getGame().getConfig().getString("arena.name");
        lobby=getLocation("arena.lobby");
        spawn=getLocation("arena.spawn");

    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location location) {

        TNTRun.getGame().getConfig().set("arena.spawn.x",location.getX());
        TNTRun.getGame().getConfig().set("arena.spawn.y",location.getY());
        TNTRun.getGame().getConfig().set("arena.spawn.z",location.getZ());
        TNTRun.getGame().getConfig().set("arena.spawn.world",location.getWorld().getName());
        TNTRun.getGame().saveConfig();

        this.spawn=location;

    }

    public void setLobby(Location location) {

        TNTRun.getGame().getConfig().set("arena.lobby.x",location.getX());
        TNTRun.getGame().getConfig().set("arena.lobby.y",location.getY());
        TNTRun.getGame().getConfig().set("arena.lobby.z",location.getZ());
        TNTRun.getGame().getConfig().set("arena.lobby.world",location.getWorld().getName());
        TNTRun.getGame().saveConfig();

        this.lobby=location;

    }

    public Location getLobby() {
        return lobby;
    }

    private Location getLocation(String location) {

        Location l = null;

        double x = TNTRun.getGame().getConfig().getDouble(location + ".x");
        double y = TNTRun.getGame().getConfig().getDouble(location + ".y");
        double z = TNTRun.getGame().getConfig().getDouble(location + ".z");
        String world = TNTRun.getGame().getConfig().getString(location + ".world");

        return l;
    }
}
