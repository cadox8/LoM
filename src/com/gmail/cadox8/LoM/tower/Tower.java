package com.gmail.cadox8.LoM.tower;

import com.gmail.cadox8.LoM.utils.CuboidZone;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.scoreboard.Team;

import java.util.Random;

public class Tower {

    @Getter @Setter private TowerType towerType;
    @Getter @Setter private Location location;

    @Getter @Setter private CuboidZone area;
    @Getter @Setter private Team team;
    @Getter @Setter private int adPlus;
    @Getter @Setter private double healt;

    @Getter @Setter private int range;

    @Getter @Setter private boolean enabled;

    public Tower(TowerType towerType, Location location){
        this.towerType = towerType;
        this.location = location;

        setAdPlus(0);
        setHealt(towerType.getHealth());

        setRange(500);
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
        for (int x = 0; x < area.toArray().size() / 4; x++){
            area.removeBlock(area.toArray().get(new Random().nextInt(area.toArray().size())));
        }
    }
}
