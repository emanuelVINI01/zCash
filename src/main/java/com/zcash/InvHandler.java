package com.zcash;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvHandler implements Listener {
    @EventHandler
    public void onInvetoryClick(InventoryClickEvent e){
        if(e.getInventory().getName().equalsIgnoreCase(ConfigManager.getString("nomedomenu"))){
            for(LojaItemBase inte : zCash.items){
                if(inte.item.getItemMeta().getDisplayName().equalsIgnoreCase(e.getCurrentItem().getItemMeta().getDisplayName())){
                    if(CashManager.getCash(e.getWhoClicked().getName()) >= inte.custo){
                        if(inte.comandohabilitado) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), inte.comando.replace("%player%", e.getWhoClicked().getName()));
                        }
                        if(inte.daritem){
                            e.getWhoClicked().getInventory().addItem(inte.item);

                        }
                        e.getWhoClicked().sendMessage(ConfigManager.getString("comprou"));
                        CashManager.setCash(e.getWhoClicked().getName(),CashManager.getCash(e.getWhoClicked().getName())-inte.custo);
                    }else{
                        e.getWhoClicked().sendMessage(ConfigManager.getString("naotemcash"));
                    }
                }
            }
            e.setCancelled(true);
        }
    }
}
