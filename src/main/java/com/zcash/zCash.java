package com.zcash;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;


public class zCash extends JavaPlugin {
    public static boolean byLoader = false;
    public static Inventory lojainv;
    public static List<LojaItemBase> items = new ArrayList<>();
    @Override
    public void onEnable() {
        super.onEnable();

        saveDefaultConfig();
        lojainv = Bukkit.createInventory(null,ConfigManager.getInt("tamanho"),ConfigManager.getString("nomedomenu"));
        for (String key : getConfig().getConfigurationSection("loja").getKeys(false)) {
            ConfigurationSection block = getConfig().getConfigurationSection("loja." + key);
            ItemStack item = new ItemStack(Material.getMaterial(block.getString("item")),block.getInt("quantia"));
            ItemMeta meta = item.getItemMeta();
            meta.setLore(block.getStringList("lore"));
            meta.setDisplayName(block.getString("nome"));
            item.setItemMeta(meta);
            items.add(new LojaItemBase(item,block.getInt("custo"),block.getString("comando"),block.getBoolean("daritem"), block.getBoolean("comandohabilitado")));
            lojainv.setItem(block.getInt("slot"),item);
        }
        new CashPlaceHolder().register();
        getServer().getPluginManager().registerEvents(new InvHandler(), this);
        getCommand("cash").setExecutor(new ComandoCash());
        getCommand("pontos").setExecutor(new PontosComando());
        getCommand("lojacash").setExecutor(new LojaComando());
        getLogger().info("\nAutor: emanuel VINI\nVersão: 1.1\nSuporte: emanuel VINI#8000");
    }
    @Override
    public void onDisable() {
        super.onDisable();
        zCash.getPlugin(zCash.class).saveConfig();
    }
}
