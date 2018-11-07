package me.cadox8.LoM.shop;

import me.cadox8.LoM.shop.item.ShopItem;
import me.cadox8.LoM.utils.Log;

import java.util.Arrays;

public class ShopManager {

    private Shop shop;

    public ShopManager() {
        shop = new Shop();
    }

    public void registerItems(ShopItem... items) {
        Arrays.asList(items).forEach(i -> {
            if (!shop.addItem(i)) Log.log(Log.Logs.ERROR, "Item duplicated in shop: " + i.getName());
        });
    }
}
