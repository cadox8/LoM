package me.cadox8.LoM.champions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//All stats are from http://gameinfo.euw.leagueoflegends.com/en/game-info/champions/

@Data
public class ChampionStats{

    //Range
    @Getter @Setter private double range = 0;

    //Health
    @Getter @Setter private double maxHealth = 0;
    @Getter @Setter private double healthPerLevel = 0;
    @Getter @Setter private double healthRegen = 0;
    @Getter @Setter private double healthRegenPerLevel = 0;
    @Getter @Setter private double health = 0;

    //Armor
    @Getter @Setter private double armor = 0;
    @Getter @Setter private double armorPerLevel = 0;

    //Mana
    @Getter @Setter private double maxMana = 0;
    @Getter @Setter private double manaPerLevel = 0;
    @Getter @Setter private double manaRegen = 0;
    @Getter @Setter private double manaRegenPerLevel = 0;
    @Getter @Setter private double mana = 0;

    //Ap
    @Getter @Setter private double ap = 0;
    @Getter @Setter private double apPerLevel = 0;

    //Ad
    @Getter @Setter private double ad = 0;
    @Getter @Setter private double adPerLevel = 0;

    //Speed
    @Getter @Setter private double speed = 0;

    //Attack Speed
    @Getter @Setter private double attackSpeed = 0;
    @Getter @Setter private double attackSpeedPerLevel = 0; // %

    //Magic Resistance
    @Getter @Setter private double magicResistance = 0;
    @Getter @Setter private double magicResistancePerLevel = 0;
}
