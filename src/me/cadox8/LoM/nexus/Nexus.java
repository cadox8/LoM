package me.cadox8.LoM.nexus;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.states.State;
import me.cadox8.LoM.utils.CuboidZone;
import me.cadox8.LoM.utils.TeamData;
import org.bukkit.Location;

public class Nexus {

    private LoM plugin = LoM.getInstance();

    @Getter @Setter private Location location;

    @Getter @Setter private CuboidZone area;
    @Getter @Setter private TeamData teamData;
    @Getter @Setter private double health;
    @Getter @Setter private int gold_reward;

    @Getter @Setter private boolean enabled;
    @Getter @Setter private boolean destroyed;

    public Nexus(Location location, TeamData teamData){
        this.location = location;

        setHealth(5500);
        setGold_reward(50); //We need to destroy the nexus to get that money, m8

        setTeamData(teamData);

        setEnabled(false);
        setDestroyed(false);
    }

    public void damage(double damage){
        if (getHealth() - damage <= 0){
            destroy();
            return;
        }
        setHealth(getHealth() - damage);
    }

    public void regen(){
        if (isDestroyed() || !isEnabled()) return;
        if (getHealth() == 5500) return;
        if (getHealth() + 25 >= 5500) {
            setHealth(5500);
            return;
        }
        setHealth(getHealth() + 25);
    }

    public void destroy(){
        setDestroyed(true);
        setEnabled(false);

        area.removeAll();

        switch (getTeamData()){
            case RED:
                plugin.getGameManager().getPlayersInGame().forEach(p -> {
                    if (p.getTeam().equals(TeamData.BLUE.getTeam())) {
                        plugin.getGameManager().getMoney().put(p, plugin.getGameManager().getMoney().get(p) + getGold_reward());
                        p.sendTitle("&3Victory", "You won!", 0, 5, 0);
                    } else {
                        p.sendTitle("&cDefeat", "You lost!", 0, 5, 0);
                    }
                });
                break;
            case BLUE:
                plugin.getGameManager().getPlayersInGame().forEach(p -> {
                    if (p.getTeam().equals(TeamData.RED.getTeam())) {
                        plugin.getGameManager().getMoney().put(p, plugin.getGameManager().getMoney().get(p) + getGold_reward());
                        p.sendTitle("&3Victory", "You won!", 0, 5, 0);
                    } else {
                        p.sendTitle("&cDefeat", "You lost!", 0, 5, 0);
                    }
                });
                break;
        }

        plugin.getState().setState(State.States.FINISHED);
    }

    public void loadAnimation(){
        ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(0, 50, 255), location, 50);
        setEnabled(true);
    }
}
