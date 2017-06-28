package me.cadox8.LoM.champions.list;

import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.champions.ChampionStats;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.skills.pasives.GuerrillaWarfare;
import me.cadox8.LoM.utils.Roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teemo extends Champion {

    public Teemo(){
        super(1, "Teemo", "The Swift Scout", Arrays.asList(Roles.MAGE, Roles.SUPPORT, Roles.ADC));

        //Champion Stats
        ChampionStats cs = new ChampionStats();

        cs.setMaxHealth(547.48);

        setChampionStats(cs);
    }

    @Override
    public List<Skill> championSkills(){
        List<Skill> skills = new ArrayList<>();

        skills.add(new GuerrillaWarfare()); //Pasive

        return skills;
    }
}
