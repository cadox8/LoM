package me.cadox8.LoM.skills.champs.morgana;

import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.utils.ItemMaker;
import org.bukkit.Location;
import org.bukkit.Material;

public class TormentedSoil extends Skill {

    public TormentedSoil() {
        super("Tormented Soil", new ItemMaker(Material.INK_SACK, 5).setName("Tormented Soil").build());

        setAdDamage(toList(0));
        setApDamage(toList(8, 16, 24, 32, 40));
        setManaCost(toList(70, 85, 100, 115, 130));
        setRange(900);
        setCooldown(10);
    }

    public void use(LoMPlayer p) {
        Location l = p.getLoc().toVector().add(p.getLoc().getDirection().multiply(10)).toLocation(p.getLoc().getWorld());
    }
}
