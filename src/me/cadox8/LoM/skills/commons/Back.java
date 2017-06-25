package me.cadox8.LoM.skills.commons;

import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.utils.ItemMaker;
import org.bukkit.Material;

public class Back extends Skill {

    public Back(){
        super("Back", new ItemMaker(Material.BED).setName("Back").build());

        setLevel(1);
    }

    public void use(LoMPlayer p){
        plugin.getGameManager().getChampions().get(p).back(p);
    }
}
