package me.cadox8.LoM.managers;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.tower.Tower;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public class ArenaManager {

    private LoM plugin;

    @Getter private HashMap<Tower, Location> towers = new HashMap<>();
    @Getter private HashMap<Team, Location> teamLocs = new HashMap<>(); //0 -> Red / 1 -> Blue

    public ArenaManager(LoM Main){
        this.plugin = Main;

        initArena();
    }

    private void initArena(){

    }
}
