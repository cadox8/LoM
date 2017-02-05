package com.gmail.cadox8.LoM;

import com.gmail.cadox8.LoM.managers.ArenaManager;
import com.gmail.cadox8.LoM.managers.GameManager;
import com.gmail.cadox8.LoM.managers.Teams;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class LoM extends JavaPlugin{

    @Getter private static LoM instance;

    @Getter private Teams teams;
    @Getter private ArenaManager arenaManager;
    @Getter private GameManager gameManager;

    public void onEnable(){
        instance = this;

        loadManagers();
    }

    private void loadManagers(){
        teams = new Teams(this);
        arenaManager = new ArenaManager(this);
        gameManager = new GameManager(this);
    }
}
