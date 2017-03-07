package com.gmail.cadox8.LoM.tower;

import com.gmail.cadox8.LoM.utils.CuboidZone;
import com.gmail.cadox8.LoM.utils.TeamData;
import com.gmail.cadox8.LoM.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.util.Random;

public class Tower {

    @Getter @Setter private TowerType towerType;
    @Getter @Setter private Location location;

    @Getter @Setter private CuboidZone area;
    @Getter @Setter private TeamData teamData;
    @Getter @Setter private int adPlus;
    @Getter @Setter private double healt;

    @Getter @Setter private int range;

    @Getter @Setter private boolean destroyed;

    public Tower(TowerType towerType, Location location, TeamData teamData){
        this.towerType = towerType;
        this.location = location;

        setAdPlus(0);
        setHealt(towerType.getHealth());

        setTeamData(teamData);

        setDestroyed(false);
        setRange(500);
    }

    public void attack(){
        if (isDestroyed()) return;
        int damage = towerType.getAd() + adPlus;

        Utils.getCircle(location, range).forEach(l -> {
            if (Utils.canAttackPlayer(l, teamData)){

                return;
            }

            if (Utils.canAttackBlueMinion(l, teamData)){

                return;
            }

            if (Utils.canAttackRedMinion(l, teamData)){

                return;
            }
        });

    }

    public void damage(double damage){
        if (getHealt() - damage <= 0){
            destroy();
            return;
        }
        setHealt(getHealt() - damage);
    }

    public void regen(){
        if (getHealt() + towerType.getRegeneration() >= towerType.getHealth()){
            setHealt(towerType.getHealth());
            return;
        }
        setHealt(getHealt() + towerType.getRegeneration());
    }

    public void destroy(){
        setDestroyed(true);
        for (int x = 0; x < area.toArray().size() / 4; x++){
            area.removeBlock(area.toArray().get(new Random().nextInt(area.toArray().size())));
        }
    }
}
