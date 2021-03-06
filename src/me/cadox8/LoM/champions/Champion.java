package me.cadox8.LoM.champions;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.task.BackTask;
import me.cadox8.LoM.utils.Roles;

import java.util.Arrays;
import java.util.List;

public abstract class Champion {

    protected LoM plugin = LoM.getInstance();

    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private List<Roles> roles;
    @Getter @Setter protected ChampionStats championStats;

    public Champion(int id, String name, String description, Roles role){
        this(id, name, description, Arrays.asList(role));
    }

    public Champion(int id, String name, String description, List<Roles> roles){
        this.id = id;
        this.name = name;
        this.description = description;
        this.roles = roles;
    }

    public abstract List<Skill> championSkills();
    public abstract void giveItems(LoMPlayer player);

    public void back(LoMPlayer p){
        int time = 7;
        if (p.getUserData().isHasBaron()) time = 5;
        new BackTask(LoM.getInstance(), p, time);
    }

    public void damage(int damage) {
        final double health = championStats.getHealth() - (damage - (championStats.getArmor() * 0.25));

        if (health <= 0) {
            die();
            return;
        }
        championStats.setHealth(health);
    }

    private void die() {

    }
}
