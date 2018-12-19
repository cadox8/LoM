package me.cadox8.LoM.champions.list;

import me.cadox8.LoM.api.LoMPlayer;
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
        championStats = new ChampionStats();

        championStats.setRange(450);

        championStats.setMaxHealth(547.48);
        championStats.setHealth(championStats.getMaxHealth());
        championStats.setHealthPerLevel(86);
        championStats.setHealthRegen(5.705);
        championStats.setHealthPerLevel(0.6);

        championStats.setArmor(25.384);
        championStats.setArmorPerLevel(3.8);

        championStats.setMagicResistance(30);
        championStats.setMagicResistancePerLevel(0);

        championStats.setAd(55.46);
        championStats.setAdPerLevel(3.5);

        championStats.setSpeed(335);
    }

    @Override
    public List<Skill> championSkills(){
        return Arrays.asList(new SoulSiphon(), new DarkBinding(), new TormentedSoil());
    }

    @Override
    public void giveItems(LoMPlayer player) {

    }
}
