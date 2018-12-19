package me.cadox8.LoM.champions.list;

import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.champions.ChampionStats;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.skills.pasives.GuerrillaWarfare;
import me.cadox8.LoM.utils.Roles;

import java.util.Arrays;
import java.util.List;

public class Teemo extends Champion {

    public Teemo(){
        super(1, "Teemo", "The Swift Scout", Arrays.asList(Roles.MAGE, Roles.SUPPORT));

        //Champion Stats
        championStats = new ChampionStats();

        championStats.setMaxHealth(547.48);
    }

    @Override
    public List<Skill> championSkills(){
        return Arrays.asList(new GuerrillaWarfare());
    }

    @Override
    public void giveItems(LoMPlayer player) {

    }
}
