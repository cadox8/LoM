package me.cadox8.LoM.managers;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.inhib.Inhib;
import me.cadox8.LoM.nexus.Nexus;
import me.cadox8.LoM.tower.Tower;
import lombok.Getter;
import me.cadox8.LoM.tower.TowerType;
import me.cadox8.LoM.utils.TeamData;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.Location;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;

public class ArenaManager {

    //At the moment only one arena per server, sorry.

    private LoM plugin;

    @Getter private ArrayList<Tower> towers;
    @Getter private ArrayList<Inhib> inhibs;
    @Getter private ArrayList<Nexus> nexus;
    @Getter private HashMap<Team, Location> teamLocs;

    public ArenaManager(LoM Main){
        this.plugin = Main;

        towers = new ArrayList<>();
        inhibs = new ArrayList<>();
        nexus = new ArrayList<>();
        teamLocs = new HashMap<>(); //0 -> Red / 1 -> Blue

        initArena();
    }

    private void initArena() {
        teamLocs.put(TeamData.RED.getTeam(), Utils.stringToLocation(plugin.getFileUtils().getString("red", "spawn")));
        teamLocs.put(TeamData.RED.getTeam(), Utils.stringToLocation(plugin.getFileUtils().getString("blue", "spawn")));

        //RED
        for (int x = 0; x < TowerType.values().length; x++){
            Location loc = Utils.stringToLocation(plugin.getFileUtils().getStringList("red", "towers").get(x));
            towers.add(new Tower(TowerType.getList().get(x), loc, TeamData.RED));
        }
        //BLUE
        for (int x = 0; x < TowerType.values().length; x++){
            Location loc = Utils.stringToLocation(plugin.getFileUtils().getStringList("blue", "towers").get(x));
            towers.add(new Tower(TowerType.getList().get(x), loc, TeamData.BLUE));
        }
    }
}
