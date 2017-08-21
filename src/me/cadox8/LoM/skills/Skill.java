package me.cadox8.LoM.skills;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Skill {

    //ToDo: + x%

    protected LoM plugin = LoM.getInstance();

    @Getter @Setter private String name;
    @Getter @Setter private ItemStack item;

    @Getter @Setter private int level = 0;

    @Getter @Setter private List<Double> manaCost;
    @Getter @Setter private List<Double> adDamage;
    @Getter @Setter private List<Double> apDamage;

    @Getter private double range;
    @Getter @Setter private double time;
    @Getter @Setter private double cooldown;

    public Skill(String name, ItemStack item){
        this.name = name;
        this.item = item;
    }

    public boolean useSkill(){
        if (!enabled()) return false;
        if (getLevel() == 0) return false;

        use();
        return true;
    }

    protected void use(){}
    protected void use(LoMPlayer p){}



    public boolean enabled(){
        return true;
    }




    //Utils
    public List<Double> toList(double... args){
        List<Double> doubles = new ArrayList<>();

        for (double d : args) doubles.add(d);
        return doubles;
    }

    public void setRange(double d){
        d = d / 25; //LoL -> Minecraft
        this.range = d;
    }

    private double isNull(List<Double> list, int index){
        if (list.get(index) == null) return 0;
        return list.get(index);
    }
}
