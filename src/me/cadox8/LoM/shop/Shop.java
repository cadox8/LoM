package me.cadox8.LoM.shop;

import me.cadox8.LoM.LoMPlayer;
import me.cadox8.LoM.utils.CustomInventory;
import org.bukkit.inventory.Inventory;

public class Shop {

    private LoMPlayer player;
    private Inventory inv;

    public void Shop(LoMPlayer player){
        CustomInventory inv = new CustomInventory("Shop", 1);
    }
}
