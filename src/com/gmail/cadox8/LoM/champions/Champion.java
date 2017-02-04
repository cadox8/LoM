package com.gmail.cadox8.LoM.champions;

import com.gmail.cadox8.LoM.utils.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public abstract class Champion {

    @Getter @Setter private String name;
    @Getter @Setter private List<Roles> roles;

    public Champion(String name, Roles role){
        this(name, Arrays.asList(role));
    }

    public Champion(String name, List<Roles> roles){
        this.name = name;
        this.roles = roles;
    }
}
