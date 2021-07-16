package com.zcash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LojaComando implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            return true;
        }
        if(!commandSender.hasPermission(ConfigManager.getString("lojacash"))){
            commandSender.sendMessage(ConfigManager.getString("semperm"));
            return true;
        }
        ((Player) commandSender).openInventory(zCash.lojainv);
        return false;
    }
}
