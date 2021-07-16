package com.zcash;

import java.util.List;

public class ConfigManager {
    public static boolean getBoolean(String nome){
        return zCash.getPlugin(zCash.class).getConfig().getBoolean(nome);
    }
    public static String getString(String nome){
        return zCash.getPlugin(zCash.class).getConfig().getString(nome);
    }
    public static List<String> getStringList(String nome){return zCash.getPlugin(zCash.class).getConfig().getStringList(nome); }
    public static double getDouble(String nome){ return zCash.getPlugin(zCash.class).getConfig().getDouble(nome); }
    public static void setDouble(String nome,Double valor){ zCash.getPlugin(zCash.class).getConfig().set(nome,valor); zCash.getPlugin(zCash.class).saveConfig(); }
    public static int getInt(String nome){ return zCash.getPlugin(zCash.class).getConfig().getInt(nome); }
}
