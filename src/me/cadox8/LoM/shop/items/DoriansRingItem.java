package me.cadox8.LoM.shop.items;

import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.shop.item.ItemEffects;
import me.cadox8.LoM.shop.item.ShopItem;
import me.cadox8.LoM.shop.item.ShopItemType;
import me.cadox8.LoM.utils.ItemMaker;
import org.bukkit.Material;

import java.util.Arrays;

public class DoriansRingItem extends ShopItem {

    public DoriansRingItem() {
        super(0, "Dorian's Ring", 400, Arrays.asList(ShopItemType.ABILITY_POWER, ShopItemType.HEALTH));

        item = new ItemMaker(Material.IRON_NUGGET).setName(getName()).build();

         effects = new ItemEffects();

         effects.setMagic(15);
         effects.setHealth(60);

         effects.setManaRegen(5);
         effects.setManaTime(5);
    }

    @Override
    public void onBought(LoMPlayer player) {
        iShopBought = () -> addEffects(player);
        iShopBought.bought();
    }

    @Override
    public void use(LoMPlayer player) {

    }
}
