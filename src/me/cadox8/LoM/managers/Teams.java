package me.cadox8.LoM.managers;

import me.cadox8.LoM.LoM;
import lombok.Getter;
import me.cadox8.LoM.api.LoMPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public class Teams {

    private final LoM plugin;

    public Teams(LoM Main) {
        plugin = Main;
        initTeams();
    }

    public Scoreboard board;
    @Getter private Team red;
    @Getter private Team blue;

    @Getter public HashMap<Team, Location> locs = new HashMap<>();

    private void initTeams() {
        board = plugin.getServer().getScoreboardManager().getMainScoreboard();
        cleanTeams();

        red = board.getTeam("lom_red") == null ? board.registerNewTeam("lom_red") : board.getTeam("lom_red");
        blue = board.getTeam("lom_blue") == null ? board.registerNewTeam("lom_blue") : board.getTeam("lom_blue");

        red.setPrefix("§c");
        blue.setPrefix("§3");

        red.setDisplayName("Red");
        blue.setDisplayName("Blue");

        red.setAllowFriendlyFire(false);
        blue.setAllowFriendlyFire(false);
    }

    public Team getTeam(LoMPlayer p){
        return getTeam(p.getPlayer());
    }

    public Team getTeam(Player p){
        if (red.getEntries().contains(p.getName())) return red;
        if (blue.getEntries().contains(p.getName())) return blue;
        return null;
    }

    public void addPlayerToTeam(Player p, Team team){
        if (getTeam(p) != null) return;
        team.addEntry(p.getName());
    }

    public void removePlayerFromTeam(Player p, Team team){
        if (getTeam(p) == null) return;
        team.removeEntry(p.getName());
    }

    public void cleanTeams() {
        red.getEntries().clear();
        blue.getEntries().clear();
    }
}
