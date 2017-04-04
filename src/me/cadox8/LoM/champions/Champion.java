package me.cadox8.LoM.champions;

import me.cadox8.LoM.LoMPlayer;
import me.cadox8.LoM.utils.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class Champion {

    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private List<Roles> roles;
    @Getter @Setter private ChampionStats championStats;

    public Champion(int id, String name, Roles role){
        this(id, name, Arrays.asList(role));
    }

    public Champion(int id, String name, List<Roles> roles){
        this.id = id;
        this.name = name;
        this.roles = roles;
    }


    public void giveItems(LoMPlayer player){
        int s = 0;
    }
}
