package me.cadox8.LoM.champions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//All stats are from http://gameinfo.euw.leagueoflegends.com/en/game-info/champions/

@Data
public class ChampionStats{
    //Range
    @Getter @Setter private double range;

    //Health
    @Getter @Setter private double maxHealth;
    @Getter @Setter private double healthPerLevel;
    @Getter @Setter private double healthRegen;
    @Getter @Setter private double healthRegenPerLevel;
    @Getter @Setter private double health;

    //Armor
    @Getter @Setter private double armor;
    @Getter @Setter private double armorPerLevel;

    //Mana
    @Getter @Setter private double maxMana;
    @Getter @Setter private double manaPerLevel;
    @Getter @Setter private double manaRegen;
    @Getter @Setter private double manaRegenPerLevel;
    @Getter @Setter private double mana;

    //Ap
    @Getter @Setter private double ap;
    @Getter @Setter private double apPerLevel;

    //Ad
    @Getter @Setter private double ad;
    @Getter @Setter private double adPerLevel;

    //Speed
    @Getter @Setter private double speed;

    //Attack Speed
    @Getter @Setter private double attackSpeed;
    @Getter @Setter private double attackSpeedPerLevel; // %

    //Magic Resistance
    @Getter @Setter private double magicResistance;
    @Getter @Setter private double magicResistancePerLevel;
}
