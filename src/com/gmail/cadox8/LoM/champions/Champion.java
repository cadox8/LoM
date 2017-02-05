package com.gmail.cadox8.LoM.champions;

import com.gmail.cadox8.LoM.utils.Roles;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public abstract class Champion {

    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private List<Roles> roles;

    public Champion(int id, String name, Roles role){
        this(id, name, Arrays.asList(role));
    }

    public Champion(int id, String name, List<Roles> roles){
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public abstract List<ItemStack> habiItems();
}
