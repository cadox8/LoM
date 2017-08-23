package me.cadox8.LoM.structures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.task.InhibTask;
import me.cadox8.LoM.utils.TeamData;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public class Structure {

    protected LoM plugin = LoM.getInstance();

    @Getter @Setter private StructureType structureType;
    @Getter @Setter private InhibType inhibType;
    @Getter @Setter private TowerType towerType;

    @Getter @Setter private Location location;

    @Getter @Setter private int ad;
    @Getter @Setter private int adPlus;
    @Getter @Setter private int range;

    @Getter @Setter private List<Location> area; //TODO: Areas with ArmorStands

    @Getter @Setter private TeamData teamData;

    @Getter @Setter private double health;
    @Getter @Setter private int gold_reward;

    @Getter @Setter private boolean destroyed;

    public Structure(StructureType structureType, Location l, TeamData teamData) {
        setLocation(l);
        setStructureType(structureType);
        setTeamData(teamData);
        setDestroyed(false);
    }

    public void setStructure(InhibType inhibType, TowerType towerType, Nexus nexus) {
        switch (getStructureType()) {
            case INHIB:
                setHealth(inhibType.getHealth());
                setGold_reward(inhibType.getGold());
                break;
            case TOWER:
                setAd(100);
                setAdPlus(0);
                setHealth(towerType.getHealth());
                setGold_reward(towerType.getGold());
                break;
            case NEXUS:
                setHealth(nexus.getHealth());
                setGold_reward(nexus.getGold_reward());
                break;
        }
    }


    public void damage(double damage){
        if (getStructureType() == StructureType.INHIB) damage = damage * 0.85; //Real damage
        if (getHealth() - damage <= 0){
            destroy();
            return;
        }
        setHealth(getHealth() - damage);
    }

    public void attack(){
        if (isDestroyed() || getStructureType() != StructureType.TOWER) return;
        int damage = towerType.getAd() + adPlus;

        Utils.getCircle(location, range).forEach(l -> {
            if (Utils.canAttackPlayer(l, teamData)){
                for (Entity e : l.getWorld().getNearbyEntities(l, 0, 0, 0)){
                    if (e instanceof Player){
                        LoMPlayer p = new LoMPlayer((Player) e);
                        Champion c = plugin.getGameManager().getChampions().get(p);

                        c.damage(getAd());
                    }
                }
                return;
            }

            if (Utils.canAttackBlueMinion(l, teamData)){

                return;
            }

            if (Utils.canAttackRedMinion(l, teamData)){

                return;
            }
        });

    }

    public void destroy(){
        setDestroyed(true);


        Utils.giveMoney(getTeamData(), getGold_reward());
        regen();
    }

    public void regen(){
        switch (getStructureType()) {
            case INHIB:
                if (isDestroyed()) new InhibTask(plugin, this).runTaskLater(plugin, 5 * 60 * 20); //5 minutes delay
                break;
            case TOWER:

                break;
            case NEXUS:
                if (isDestroyed()) return;
                if (getHealth() == 5500) return;
                if (getHealth() + 25 >= 5500) {
                    setHealth(5500);
                    return;
                }
                setHealth(getHealth() + 25);
                break;
        }
    }

    public void loadAnimation(){
        ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(0, 50, 255), location, 50);
    }


    public enum StructureType {
        NEXUS, TOWER, INHIB
    }

    @AllArgsConstructor
    public enum Nexus {
        NEXUS(5500, 50);

        @Getter private int health;
        @Getter private int gold_reward;
    }
}
