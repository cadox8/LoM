package com.gmail.cadox8.LoM.utils;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomInventory {

    public enum InventoryType{
        /*VILLAGER,*/ NORMAL
    }

    @Getter private InventoryType inventoryType;
    @Getter @Setter private String name;
    @Getter @Setter private int size;

    private Inventory inv;

    public CustomInventory(@NonNull String name){
        this(name, 9);
    }

    public CustomInventory(@NonNull String name, @NonNull int size){
        this(InventoryType.NORMAL, name, size);
    }

    public CustomInventory(@NonNull InventoryType inventoryType, @NonNull String name, @NonNull int size){
        if (size < 0) throw new IllegalArgumentException("Size must be positive");

        this.inventoryType = inventoryType;
        this.name = Utils.colorize(name);
        this.size = size;

        //Only Normal
        inv = Bukkit.createInventory(null, this.size * 9, this.name);
    }

    public void setItem(@NonNull int slot, @NonNull ItemStack itemStack){
        if (slot < 0) throw new IllegalArgumentException("Slot must be positive");
        inv.setItem(slot, itemStack);
    }

    public void addItem(ItemStack... itemStack){
        for (ItemStack i : itemStack){
            addItem(i);
        }
    }

    public void addItem(@NonNull ItemStack itemStack){
        inv.addItem(itemStack);
    }

    public Inventory getInv(){
        return inv;
    }
}
