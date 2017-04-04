package me.cadox8.LoM.skills;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Skill {

    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private ItemStack item;

    @Getter @Setter private int level;

    @Getter @Setter private List<Double> manaCost;
    @Getter @Setter private List<Double> adDamage;
    @Getter @Setter private List<Double> apDamage;
    @Getter private double range;
    @Getter @Setter private double time;

    public Skill(int id, String name, ItemStack item){
        this.id = id;
        this.name = name;
        this.item = item;
    }

    public boolean useSkill(){
        if (!enabled()) return false;
        if (getLevel() == 0) return false;

        use();
        return true;
    }

    private void use(){

    }



    public boolean enabled(){
        return true;
    }




    //Utils
    public List<Double> toList(double... args){
        List<Double> doubles = new ArrayList<>();

        for (double d : args){
            doubles.add(d);
        }
        return doubles;
    }

    public void setRange(double d){
        d = d / 25; //LoL -> Minecraft
        this.range = d;
    }
}
