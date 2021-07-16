package com.zcash;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class CashPlaceHolder extends PlaceholderExpansion {
    @Override
    public String getIdentifier() {
        return "zcash";
    }

    @Override
    public String getAuthor() {
        return "emanuelVINI";
    }

    @Override
    public String getVersion() {
        return "1.1";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("bruto")){
            return String.valueOf(CashManager.getCash(player.getName()));
        }
        if(params.equalsIgnoreCase("formatado")){
            return CashManager.getCashFormated(player.getName());
        }
        return "";
    }
}
