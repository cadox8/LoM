package me.cadox8.LoM.inhib;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.cadox8.LoM.tower.TowerType;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public enum InhibType {

    INHIB_TOP("inhib_top", 4000, 50),
    INHIB_MID("inhib_mid", 4000, 50),
    INHIB_BOT("inhib_bot", 4000, 50);

    //NEXUS("inhib", 5500, 0); +25hp every 5 secs

    @Getter private String name;
    @Getter private double health;
    @Getter private int gold;

    public static List<TowerType> getList(){
        return Arrays.asList(TowerType.values());
    }
}
