package me.cadox8.LoM.tower;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TowerType {

    NEXUS_TOP("nexus_top", 3300, 150, 40, 40, 4.0, 5),
    NEXUS_BOT("nexus_bot", 3300, 150, 40, 40, 4.0, 5),

    INHIB_TOP("inhib_top", 3300, 170, 40, 40, 4.0, 5),
    INHIB_MID("inhib_mid", 3300, 170, 40, 40, 4.0, 5),
    INHIB_BOT("inhib_bot", 3300, 170, 40, 40, 4.0, 5),

    INNER_TOP("inner_top", 3300, 170, 40, 40, 0.83, 5),
    INNER_MID("inner_mid", 3300, 170, 40, 40, 0.83, 5),
    INNER_BOT("inner_bot", 3300, 170, 40, 40, 0.83, 5),

    OUTER_TOP("outer_top", 3500, 152, 40, 40, 0.83, 5),
    OUTER_MID("outer_mid", 3500, 152, 40, 40, 0.83, 5),
    OUTER_BOT("outer_bot", 3500, 152, 40, 40, 0.83, 5);

    @Getter private String name;
    @Getter private int health;
    @Getter private int ad;
    @Getter private int armor;
    @Getter private int mr;
    @Getter private double attackSpeed;
    @Getter private int regeneration;
}
