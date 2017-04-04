package me.cadox8.LoM.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemMaker {

    private final ItemStack itemStack;

    public ItemMaker(Material type) {
        itemStack = new ItemStack(type);
    }

    public ItemMaker setType(Material type) {
        itemStack.setType(type);
        return this;
    }

    public ItemMaker setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemMaker setDisplayName(String displayName) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemMaker setDurability(short durability){
        this.itemStack.setDurability(durability);
        return this;
    }

    public ItemMaker setLores(String... lores) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        List<String> loresList = new ArrayList<>();
        for (String lore : lores) {
            loresList.add(lore);
        }
        itemMeta.setLore(loresList);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemMaker addItemFlag(ItemFlag itemFlag) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addItemFlags(itemFlag);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemMaker addItemFlag(ItemFlag... itemFlags) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addItemFlags(itemFlags);
        this.itemStack.setItemMeta(itemMeta);
        addItemFlag(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    public ItemMaker addUnsafeEnchant(Enchantment ench, int level) {
        this.itemStack.addUnsafeEnchantment(ench, level);
        return this;
    }

    public ItemMaker setUnbreakable(){
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.spigot().setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        this.itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return this.itemStack;
    }
}
