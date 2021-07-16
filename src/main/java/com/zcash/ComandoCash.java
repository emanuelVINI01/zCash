package com.zcash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoCash implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ConfigManager.getString("console"));
            return true;
        }
        if(commandSender.hasPermission(ConfigManager.getString("vercash"))){
            commandSender.sendMessage(ConfigManager.getString("vercashmsg").replace("%cash%",String.valueOf(new Double(CashManager.getCash(commandSender.getName())).intValue())));
        }else{
            commandSender.sendMessage(ConfigManager.getString("semperm"));
        }
        return false;
    }
}
