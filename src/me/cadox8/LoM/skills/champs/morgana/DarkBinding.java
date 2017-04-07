package me.cadox8.LoM.skills.champs.morgana;

import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.utils.ItemMaker;
import org.bukkit.Material;

public class DarkBinding extends Skill {

    public DarkBinding(){
        super("Dark Binding", new ItemMaker(Material.ENCHANTED_BOOK).setDisplayName("Dark Binding").build());

        setLevel(0);

        setAdDamage(toList(0));
        setApDamage(toList(80, 135, 190, 245, 300));
        setManaCost(toList(50, 55, 60, 65, 70));
        setRange(1175);
    }

    public void use(){
        for (double x = 0.0; x < getRange(); x += 0.5){
            //TODO: Particles


        }
    }
}
