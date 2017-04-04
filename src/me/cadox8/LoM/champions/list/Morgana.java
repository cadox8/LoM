package me.cadox8.LoM.champions.list;

import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.champions.ChampionStats;
import me.cadox8.LoM.utils.Roles;

import java.util.Arrays;

public class Morgana extends Champion{

    public Morgana(){
        super(0, "Morgana", Arrays.asList(Roles.MAGE, Roles.SUPPORT));

        //Champion Stats
        ChampionStats cs = new ChampionStats();

        cs.setMaxHealth(547.48);

        setChampionStats(cs);
    }
}
