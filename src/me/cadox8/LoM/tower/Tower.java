package me.cadox8.LoM.tower;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.utils.CuboidZone;
import me.cadox8.LoM.utils.TeamData;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Random;

public class Tower {

    private LoM plugin = LoM.getInstance();

    @Getter @Setter private TowerType towerType;
    @Getter @Setter private Location location;

    @Getter @Setter private CuboidZone area;
    @Getter @Setter private TeamData teamData;
    @Getter @Setter private int ad;
    @Getter @Setter private int adPlus;
    @Getter @Setter private double healt;

    @Getter @Setter private int range;

    @Getter @Setter private boolean enabled;
    @Getter @Setter private boolean destroyed;

    public Tower(TowerType towerType, Location location, TeamData teamData){
        this.towerType = towerType;
        this.location = location;

        setAd(100);
        setAdPlus(0);
        setHealt(towerType.getHealth());

        setTeamData(teamData);

        setEnabled(false);
        setDestroyed(false);
        setRange(500);
    }

    public void attack(){
        if (isDestroyed()) return;
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

    public void damage(double damage){
        if (getHealt() - damage <= 0){
            destroy();
            return;
        }
        setHealt(getHealt() - damage);
    }

    public void regen(){
        if (getHealt() + towerType.getRegeneration() >= towerType.getHealth()){
            setHealt(towerType.getHealth());
            return;
        }
        setHealt(getHealt() + towerType.getRegeneration());
    }

    public void destroy(){
        setDestroyed(true);
        setEnabled(false);
        for (int x = 0; x < area.toArray().size() / 4; x++){
            area.removeBlock(area.toArray().get(new Random().nextInt(area.toArray().size())));
        }
    }

    public void loadAnimation(){
        ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(0, 50, 255), location, 50);
        setEnabled(true);
    }
}