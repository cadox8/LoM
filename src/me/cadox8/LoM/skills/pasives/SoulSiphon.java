package me.cadox8.LoM.skills.pasives;

import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.skills.Pasive;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SoulSiphon extends Pasive {

    public SoulSiphon(){
        super("Soul Siphon", new ItemStack(Material.ACACIA_DOOR));

        setSpell_vamp(toList(0.1, 0.15, 0.2));
    }

    public void use(Champion c, double damage){
        spellVamp(c, damage);
    }

    public void spellVamp(Champion c, double damage){
        double heal = c.getChampionStats().getHealth();
        double regen = (spell_vamp.get(getLevel() - 1) * damage);

        c.getChampionStats().setHealth(regen + heal);
    }
}
