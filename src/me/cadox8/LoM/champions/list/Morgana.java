package me.cadox8.LoM.champions.list;

import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.champions.ChampionStats;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.skills.champs.morgana.DarkBinding;
import me.cadox8.LoM.skills.champs.morgana.TormentedSoil;
import me.cadox8.LoM.skills.pasives.SoulSiphon;
import me.cadox8.LoM.utils.Roles;

import java.util.Arrays;
import java.util.List;

public class Morgana extends Champion {

    public Morgana(){
        super(0, "Morgana", "Fallen Angel", Arrays.asList(Roles.MAGE, Roles.SUPPORT));

        //Champion Stats
        ChampionStats cs = new ChampionStats();

        cs.setRange(450);

        cs.setMaxHealth(547.48);
        cs.setHealth(cs.getMaxHealth());
        cs.setHealthPerLevel(86);
        cs.setHealthRegen(5.705);
        cs.setHealthPerLevel(0.6);

        cs.setArmor(25.384);
        cs.setArmorPerLevel(3.8);

        cs.setMagicResistance(30);
        cs.setMagicResistancePerLevel(0);

        cs.setAd(55.46);
        cs.setAdPerLevel(3.5);

        cs.setSpeed(335);

        setChampionStats(cs);
    }

    @Override
    public List<Skill> championSkills(){
        return Arrays.asList(new SoulSiphon(), new DarkBinding(), new TormentedSoil());
    }
}
