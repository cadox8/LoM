package me.cadox8.LoM.managers;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.tower.Tower;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public class ArenaManager {

    private LoM plugin;

    @Getter public HashMap<Tower, Location> towers = new HashMap<>();
    @Getter public HashMap<Team, Location> teamLocs = new HashMap<>();

    public ArenaManager(LoM Main){
        this.plugin = Main;

        initArena();
    }

    private void initArena(){

    }
}
