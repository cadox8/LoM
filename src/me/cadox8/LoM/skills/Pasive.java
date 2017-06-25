package me.cadox8.LoM.skills;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.api.LoMPlayer;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Pasive extends Skill {

    @Getter @Setter protected List<Double> spell_vamp; //Percent
    @Getter protected List<LoMPlayer> hide;

    public Pasive(String name, ItemStack item){
        super(name, item);

        setLevel(1);
    }
}
