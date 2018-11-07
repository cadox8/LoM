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

    public ItemMaker(Material type, int data) {
        itemStack = new ItemStack(type, 1, (short)data);
    }

    public ItemMaker setType(Material type) {
        itemStack.setType(type);
        return this;
    }

    public ItemMaker setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemMaker setData(int data) {
        this.itemStack.setDurability((short)data);
        return this;
    }

    public ItemMaker setName(String displayName) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setDisplayName(Utils.colorize(displayName));
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

    public ItemMaker noInfo() {
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        this.itemStack.setItemMeta(meta);
        setUnbreakable();
        return this;
    }

    public ItemStack build() {
        noInfo();
        return this.itemStack;
    }
}
