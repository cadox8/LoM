package me.cadox8.LoM.champions;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.task.BackTask;
import me.cadox8.LoM.utils.Roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Champion {

    private LoM plugin = LoM.getInstance();

    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private List<Roles> roles;
    @Getter @Setter private ChampionStats championStats;

    public Champion(int id, String name, Roles role){
        this(id, name, Arrays.asList(role));
    }

    public Champion(int id, String name, List<Roles> roles){
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public List<Skill> championSkills(){
        return new ArrayList<>();
    }

    public void giveItems(LoMPlayer player){}


    public void damage(double damage){

    }

    public void back(LoMPlayer p){
        new BackTask(LoM.getInstance(), p);
    }
}
