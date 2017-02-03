package com.gmail.cadox8.LoM.tower;

import com.gmail.cadox8.LoM.utils.CuboidZone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.scoreboard.Team;

public abstract class Tower {

    @Getter @Setter private TowerType towerType;

    @Getter @Setter private CuboidZone area;
    @Getter @Setter private Team team;
    @Getter @Setter private int adPlus;
    @Getter @Setter private double healt;

    public Tower(TowerType towerType){
        this.towerType = towerType;

        setAdPlus(0);
        setHealt(towerType.getHealth());
    }

    public void attack(){
        int damage = towerType.getAd() + adPlus;

    }

    public void regen(){
        if (getHealt() + towerType.getRegeneration() >= towerType.getHealth()){
            setHealt(towerType.getHealth());
            return;
        }
        setHealt(getHealt() + towerType.getRegeneration());
    }

    public void destroy(){
        area.destroy();
    }

    @AllArgsConstructor
    public enum TowerType {
        OUTER(3500, 152, 40, 40, 0.83, 5),
        INNER(3300,	170, 40, 40, 0.83, 5),
        INHIBITOR(3300,	170, 40, 40, 4.0, 5),
        NEXUS(3300,	150, 40, 40, 4.0, 5);

        @Getter private int health;
        @Getter private int ad;
        @Getter private int armor;
        @Getter private int mr;
        @Getter private double attackSpeed;
        @Getter private int regeneration;
    }
}
