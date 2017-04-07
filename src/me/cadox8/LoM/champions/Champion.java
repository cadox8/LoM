package me.cadox8.LoM.champions;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.utils.Roles;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

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

    private int count = 7;
    private BukkitTask bt;
    public void back(LoMPlayer player){
        count = 7;
        List<Player> players = new ArrayList<>();

        plugin.getGameManager().getPlayersInGame().forEach(p -> players.add(p.getPlayer()));

        plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
            player.getPlayer().teleport(plugin.getArenaManager().getTeamLocs().get(plugin.getTeams().getTeam(player)));
        }, 20 * 7);

        bt = plugin.getServer().getScheduler().runTaskTimer(plugin, ()-> {
            ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(0, 50, 255), player.getPlayer().getEyeLocation(), players);
            if (count <= 0) bt.cancel();
            count--;
        }, 0, 20);
    }
}
