package com.gmail.cadox8.LoM.champions.list;

import com.gmail.cadox8.LoM.champions.Champion;
import com.gmail.cadox8.LoM.utils.Roles;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Morgana extends Champion{

    public Morgana(){
        super(0, "Morgana", Arrays.asList(Roles.MAGE, Roles.SUPPORT));
    }

    public List<ItemStack> habiItems(){
        List<ItemStack> items = new ArrayList<>();

        return items;
    }
}
