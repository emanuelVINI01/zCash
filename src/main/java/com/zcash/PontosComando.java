package com.zcash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PontosComando implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ConfigManager.getString("console"));
            return true;
        }
        if(!commandSender.hasPermission("pontoscomando")){
            commandSender.sendMessage(ConfigManager.getString("semperm"));
            return true;
        }
        if(strings.length == 0){
            for(String i : ConfigManager.getStringList("pontosajuda")) {
                commandSender.sendMessage(i);
            }
            return true;
        }
        if(strings.length == 1){
                for(String i : ConfigManager.getStringList("pontosajuda")) {
                    commandSender.sendMessage(i);
                }
                return true;
        }
        if(strings.length == 2){
            String comando = strings[0];
            String argumento = strings[1];
            if(comando.equalsIgnoreCase("ver")){
                if(!commandSender.hasPermission(ConfigManager.getString("vercash"))){
                    commandSender.sendMessage(ConfigManager.getString("semperm"));
                    return true;
                }
                if(!argumento.isEmpty() || !comando.isEmpty()){
                    commandSender.sendMessage(ConfigManager.getString("vercashoutromsg").replace("%player%",argumento).replace("%cash%",String.valueOf(new Double(CashManager.getCash(argumento)).intValue())));
                    return true;
                }else{
                    for(String i : ConfigManager.getStringList("pontosajuda")) {
                        commandSender.sendMessage(i);
                    }
                    return true;
                }
            }
            if(comando.equalsIgnoreCase("resetar")){
                if(!commandSender.hasPermission(ConfigManager.getString("resetcash"))){
                    commandSender.sendMessage(ConfigManager.getString("semperm"));
                    return true;
                }
                if(!argumento.isEmpty() || !comando.isEmpty()){
                    CashManager.resetCash(argumento);
                    commandSender.sendMessage(ConfigManager.getString("resetcashoutromsg").replace("%player%",argumento));
                }
                }else{
                    for(String i : ConfigManager.getStringList("pontosajuda")) {
                        commandSender.sendMessage(i);
                    }
                    return true;
                }
            }
        if(strings.length == 3){
            String comando = strings[0];
            String argumento = strings[1];
            String argumento2 = strings[2];
            if(comando.equalsIgnoreCase("setar")){
                if(!commandSender.hasPermission(ConfigManager.getString("setcash"))){
                    commandSender.sendMessage(ConfigManager.getString("semperm"));
                    return true;
                }
                if(!argumento.isEmpty() || !comando.isEmpty() || !argumento2.isEmpty()){
                    if(!isNumeric(argumento2)){
                        commandSender.sendMessage(ConfigManager.getString("falhaset").replace("%argumento%",argumento2));
                        return true;
                    }
                    CashManager.setCash(argumento,Double.parseDouble(argumento2));
                    commandSender.sendMessage(ConfigManager.getString("setcashoutromsg").replace("%player%",argumento).replace("%cash%",argumento2));
                    return true;
                }else{
                    for(String i : ConfigManager.getStringList("pontosajuda")) {
                        commandSender.sendMessage(i);
                    }
                    return true;
                }
            }
            if(comando.equalsIgnoreCase("adicionar")){
                if(!commandSender.hasPermission(ConfigManager.getString("givecash"))){
                    commandSender.sendMessage(ConfigManager.getString("semperm"));
                    return true;
                }
                if(!argumento.isEmpty() || !comando.isEmpty() || !argumento2.isEmpty()){
                    if(!isNumeric(argumento2)){
                        commandSender.sendMessage(ConfigManager.getString("falhaset").replace("%argumento%",argumento2));
                        return true;
                    }
                    Double total = CashManager.getCash(argumento) + Double.parseDouble(argumento2);
                    CashManager.setCash(argumento,total);
                    commandSender.sendMessage(ConfigManager.getString("addcashoutromsg").replace("%player%",argumento).replace("%cash%",argumento2));
                    return true;
                }else{
                    for(String i : ConfigManager.getStringList("pontosajuda")) {
                        commandSender.sendMessage(i);
                    }
                    return true;
                }
            }
            if(comando.equalsIgnoreCase("remover")){
                if(!commandSender.hasPermission(ConfigManager.getString("takecash"))){
                    commandSender.sendMessage(ConfigManager.getString("semperm"));
                    return true;
                }
                if(!argumento.isEmpty() || !comando.isEmpty() || !argumento2.isEmpty()){
                    if(!isNumeric(argumento2)){
                        commandSender.sendMessage(ConfigManager.getString("falhaset").replace("%argumento%",argumento2));
                        return true;
                    }
                    Double total = CashManager.getCash(argumento) - Double.parseDouble(argumento2);
                    CashManager.setCash(argumento,total);
                    commandSender.sendMessage(ConfigManager.getString("takecashoutromsg").replace("%player%",argumento).replace("%cash%",argumento2));
                    return true;
                }else{
                    for(String i : ConfigManager.getStringList("pontosajuda")) {
                        commandSender.sendMessage(i);
                    }
                    return true;
                }
            }
        }
        for(String i : ConfigManager.getStringList("pontosajuda")) {
            commandSender.sendMessage(i);
        }
            return true;
        }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    }
