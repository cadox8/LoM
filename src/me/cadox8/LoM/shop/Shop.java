package me.cadox8.LoM.shop;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import org.bukkit.inventory.Inventory;

public class Shop {

    private LoM plugin = LoM.getInstance();

    private LoMPlayer player;
    private Inventory inv;

    public void Shop(LoMPlayer player){
        Inventory inv = plugin.getServer().createInventory(null, 9, "Shop");
    }
}
