package me.cadox8.LoM.shop.item;

import lombok.Data;

@Data
public class ItemEffects {

    private int health = 0;
    private int healthRegen = 0, healthTime = 0;

    private int mana = 0;
    private int manaRegen = 0, manaTime = 0;

    private int armor = 0;
    private int magic_resistance = 0;

    private int damage = 0;
    private int critic = 0;
    private int magic = 0;
}
