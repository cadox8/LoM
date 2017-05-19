package me.cadox8.LoM.task;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.states.State;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class BackTask extends BukkitRunnable {

    private LoM plugin;
    private LoMPlayer p;
    private int count;

    public BackTask(LoM instance, LoMPlayer p, int count){
        this.plugin = instance;
        this.p = p;
        this.count = count; //Default: 7 | Baron: 5
    }

    public void run() {
        if (plugin.getState().getState() != State.States.GAME) return;

        List<Player> players = new ArrayList<>();
        plugin.getGameManager().getPlayersInGame().forEach(p -> players.add(p.getPlayer()));

        Utils.getCircle(p.getPlayer().getLocation(), 5).forEach(l -> {
            ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(0, 50, 255), l, players);
            if (count <= 0) {
                p.getPlayer().teleport(plugin.getArenaManager().getTeamLocs().get(plugin.getTeams().getTeam(p)));
                cancel();
            }
        });
        count--;
    }
}
