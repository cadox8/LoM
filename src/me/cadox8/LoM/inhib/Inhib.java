package me.cadox8.LoM.inhib;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.task.InhibTask;
import me.cadox8.LoM.utils.CuboidZone;
import me.cadox8.LoM.utils.TeamData;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.Location;

import java.util.Random;

public class Inhib {

    private LoM plugin = LoM.getInstance();

    @Getter @Setter private InhibType inhibType;
    @Getter @Setter private Location location;

    @Getter @Setter private CuboidZone area;
    @Getter @Setter private TeamData teamData;
    @Getter @Setter private double health;
    @Getter @Setter private int gold_reward;

    @Getter @Setter private boolean destroyed;

    public Inhib(InhibType inhibType, Location location, TeamData teamData){
        this.inhibType = inhibType;
        this.location = location;

        setHealth(inhibType.getHealth());
        setGold_reward(inhibType.getGold());

        setTeamData(teamData);

        setDestroyed(false);
    }

    public void damage(double damage){
        damage = damage * 0.85; //Real damage
        if (getHealth() - damage <= 0){
            destroy();
            return;
        }
        setHealth(getHealth() - damage);
    }

    public void regen(){
        new InhibTask(plugin, this).runTaskLater(plugin, 5 * 60 * 20); //5 minutes delay
    }

    public void destroy(){
        setDestroyed(true);

        for (int x = 0; x < area.toArray().size() / 4; x++){
            area.removeBlock(area.toArray().get(new Random().nextInt(area.toArray().size())));
        }

        Utils.giveMoney(getTeamData(), getGold_reward());
        regen();
    }

    public void loadAnimation(){
        ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(0, 50, 255), location, 50);
    }
}
