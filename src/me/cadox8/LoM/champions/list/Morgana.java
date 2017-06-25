package me.cadox8.LoM.champions.list;

import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.champions.ChampionStats;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.skills.champs.morgana.DarkBinding;
import me.cadox8.LoM.skills.pasives.SoulSiphon;
import me.cadox8.LoM.utils.Roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Morgana extends Champion {

    public Morgana(){
        super(0, "Morgana", "Fallen Angel", Arrays.asList(Roles.MAGE, Roles.SUPPORT));

        //Champion Stats
        ChampionStats cs = new ChampionStats();

        cs.setMaxHealth(547.48);

        setChampionStats(cs);
    }

    @Override
    public List<Skill> championSkills(){
        List<Skill> skills = new ArrayList<>();

        skills.add(new SoulSiphon()); //Pasive
        skills.add(new DarkBinding());

        return skills;
    }
}
