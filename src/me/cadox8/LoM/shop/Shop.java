package me.cadox8.LoM.shop;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.shop.item.ShopItem;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private LoM plugin = LoM.getInstance();

    private List<ShopItem> items;

    public Shop() {
        items = new ArrayList<>();
    }

    public boolean addItem(ShopItem item) {
        if (items.contains(item)) return false;
        return items.add(item);
    }

    public void createShop(LoMPlayer player) {
        final Inventory inv = plugin.getServer().createInventory(null, 63, "Shop");

        items.forEach(i -> inv.setItem(i.getId(), i.getItem()));

        player.getPlayer().closeInventory();
        player.getPlayer().openInventory(inv);
    }

    public void updateShop(LoMPlayer player) {
        player.getPlayer().closeInventory();
        createShop(player);
    }
}
