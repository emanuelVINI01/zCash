package com.zcash;


import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CashManager {
    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();
    static {
        suffixes.put(1_000L, "K");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "B");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "Q");
        suffixes.put(1_000_000_000_000_000_000L, "QQ");
    }
    public static String format(long value) {
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return String.valueOf((int) value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }
    public static double getCash(String nick){
        if(playerInConfig(nick)){
            return ConfigManager.getDouble(String.format("data.%s.cash", nick));
        }else{
            return 0.0F;
        }
    }
    public static void setCash(String nick,double valor){
        ConfigManager.setDouble(String.format("data.%s.cash", nick),valor);
    }
    public static void resetCash(String nick){
        ConfigManager.setDouble(String.format("data.%s.cash", nick),0.0D);
    }
    public static String getCashFormated(String nick){
        if(playerInConfig(nick)){
            return format(new Double(ConfigManager.getDouble(String.format("data.%s.cash", nick))).longValue());
        }else{
            return "0";
        }
    }
    public static boolean playerInConfig(String nick){
        return zCash.getPlugin(zCash.class).getConfig().contains(String.format("data.%s.cash", nick));
    }
}
