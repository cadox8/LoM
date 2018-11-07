package me.cadox8.LoM.shop.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.cadox8.LoM.utils.ItemMaker;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public enum ShopItemType {

    HEALTH(new ItemMaker(Material.PAPER).setName("&cHealth").build()),
    DAMAGE(new ItemMaker(Material.GOLDEN_SWORD).setName("&cDamage").build()),
    MAGIC_RESISTANCE(new ItemMaker(Material.ENCHANTED_BOOK).setName("&cMagic Resistance").build()),
    ARMOR(new ItemMaker(Material.IRON_CHESTPLATE).setName("&cArmor").build()),
    MANA(new ItemMaker(Material.POTION).setName("&cMana").build()),
    ABILITY_POWER(new ItemMaker(Material.ENCHANTING_TABLE).setName("&cAbility Power").build());

    @Getter private ItemStack itemStack;

    public String getEffect(){
        return this.toString();
    }
    public String getName(){
        return this.toString();
    }
}
