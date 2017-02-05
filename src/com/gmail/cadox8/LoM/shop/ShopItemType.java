package com.gmail.cadox8.LoM.shop;

import com.gmail.cadox8.LoM.utils.ItemMaker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public enum ShopItemType {

    HEALTH(new ItemMaker(Material.PAPER).setDisplayName("&cHealth").build()),
    DAMAGE(new ItemMaker(Material.GOLD_SWORD).setDisplayName("&cDamage").build()),
    MAGIC_RESISTANCE(new ItemMaker(Material.ENCHANTED_BOOK).setDisplayName("&cMagic Resistance").build()),
    ARMOR(new ItemMaker(Material.IRON_CHESTPLATE).setDisplayName("&cArmor").build()),
    MANA(new ItemMaker(Material.POTION).setDisplayName("&cMana").build()),
    ABILITY_POWER(new ItemMaker(Material.ENCHANTMENT_TABLE).setDisplayName("&cAbility Power").build());

    @Getter private ItemStack itemStack;

    public String getEffect(){
        return this.name();
    }
    public String getName(){
        return this.name().toString();
    }
}
