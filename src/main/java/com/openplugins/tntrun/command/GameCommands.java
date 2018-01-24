package com.openplugins.tntrun.command;

import com.openplugins.tntrun.TNTRun;
import com.openplugins.utils.command.SpigotCommand;
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

            // todo start
        }

        if (command.getName().equalsIgnoreCase("tntrun")) {
            sender.sendMessage(ChatColor.GREEN + "TNTRun version " + TNTRun.getGame().getVersion());

            if (TNTRun.getGame().getRequestResult() != null) {
                sender.sendMessage(TNTRun.getGame().getRequestResult());
            }
        }

    }
}
