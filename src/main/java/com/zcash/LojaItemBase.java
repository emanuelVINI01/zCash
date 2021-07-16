package com.zcash;

import org.bukkit.inventory.ItemStack;

public class LojaItemBase {
    String comando;
    int custo;
    boolean daritem;
    boolean comandohabilitado;
    ItemStack item;
    public LojaItemBase(ItemStack item, int custo,String comando, boolean daritem, boolean comandohabilitado){
        this.item = item;
        this.custo = custo;
        this.comando = comando;
        this.comandohabilitado = comandohabilitado;
        this.daritem = daritem;
    }
}
