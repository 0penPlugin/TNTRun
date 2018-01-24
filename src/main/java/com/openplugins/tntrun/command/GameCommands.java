package com.openplugins.tntrun.command;

import com.openplugins.tntrun.TNTRun;
import com.openplugins.tntrun.utils.MovementThread;
import com.openplugins.tntrun.utils.State;
import com.openplugins.utils.command.SpigotCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class GameCommands extends SpigotCommand {

    @Override
    public void executeCommand(Player sender, Command command, String args[]) {

        if (command.getName().equalsIgnoreCase("start")) {
            if (!sender.hasPermission("tntrun.start") || !sender.hasPermission("openplugins.admin")) {
                sendPermission(sender);
                return;
            }


            for (Player player : Bukkit.getOnlinePlayers()) {
                TNTRun.getGame().getPlayers().add(player.getUniqueId());
                player.teleport(TNTRun.getGame().getArena().getSpawn());
            }

            TNTRun.getGame().setState(State.INGAME);
            new MovementThread();
        }

        if (command.getName().equalsIgnoreCase("setspawn")) {
            if (!sender.hasPermission("tntrun.set") || !sender.hasPermission("openplugins.admin")) {
                sendPermission(sender);
                return;
            }

            sender.sendMessage(ChatColor.GREEN + "Set spawn location");
            TNTRun.getGame().getArena().setSpawn(sender.getLocation());
        }

        if (command.getName().equalsIgnoreCase("setlobby")) {
            if (!sender.hasPermission("tntrun.set") || !sender.hasPermission("openplugins.admin")) {
                sendPermission(sender);
                return;
            }

            sender.sendMessage(ChatColor.GREEN + "Set lobby location");
            TNTRun.getGame().getArena().setLobby(sender.getLocation());
        }

        if (command.getName().equalsIgnoreCase("tntrun")) {
            sender.sendMessage(ChatColor.GREEN + "TNTRun version " + TNTRun.getGame().getVersion());

            if (TNTRun.getGame().getRequestResult() != null) {
                sender.sendMessage(TNTRun.getGame().getRequestResult());
            }
        }

    }
}
