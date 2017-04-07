package me.cadox8.LoM.champions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ChampionStats{

    @Getter @Setter private double maxHealth;
    @Getter @Setter private double maxMana;

    @Getter @Setter private double health;
    @Getter @Setter private double mana;

    @Getter @Setter private double ap;
    @Getter @Setter private double ad;

    @Getter @Setter private double healthRegen;
    @Getter @Setter private double manaRegen;
}
