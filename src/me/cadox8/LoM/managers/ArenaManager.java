package me.cadox8.LoM.managers;

import lombok.Getter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.structures.Structure;
import me.cadox8.LoM.structures.TowerType;
import me.cadox8.LoM.utils.TeamData;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.Location;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;

public class ArenaManager {

    //At the moment only one arena per server, sorry.

    private LoM plugin;

    @Getter private ArrayList<Structure> structures;
    @Getter private HashMap<Team, Location> teamLocs;

    public ArenaManager(LoM Main){
        this.plugin = Main;

        structures = new ArrayList<>();
        teamLocs = new HashMap<>(); //0 -> Red / 1 -> Blue

        initArena();
    }

    private void initArena() {
        teamLocs.put(TeamData.RED.getTeam(), Utils.stringToLocation(plugin.getFileUtils().getString("red", "spawn")));
        teamLocs.put(TeamData.RED.getTeam(), Utils.stringToLocation(plugin.getFileUtils().getString("blue", "spawn")));

        //RED
        for (int x = 0; x < TowerType.values().length; x++){
            Location loc = Utils.stringToLocation(plugin.getFileUtils().getStringList("red", "towers").get(x));
            Structure s = new Structure(Structure.StructureType.TOWER, loc, TeamData.RED);
            s.setStructure(null, TowerType.getList().get(x), null);
            structures.add(s);
        }
        //BLUE
        for (int x = 0; x < TowerType.values().length; x++){
            Location loc = Utils.stringToLocation(plugin.getFileUtils().getStringList("blue", "towers").get(x));
            Structure s = new Structure(Structure.StructureType.TOWER, loc, TeamData.BLUE);
            s.setStructure(null, TowerType.getList().get(x), null);
            structures.add(s);
        }
    }
}
