package me.cadox8.LoM;

import me.cadox8.LoM.champions.ChampionManager;
import me.cadox8.LoM.managers.ArenaManager;
import me.cadox8.LoM.managers.GameManager;
import me.cadox8.LoM.managers.Teams;
import lombok.Getter;
import me.cadox8.LoM.task.LobbyTask;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LoM extends JavaPlugin{

    @Getter private String prefix = ChatColor.GRAY + " || " + ChatColor.RED + "LoM" + ChatColor.GRAY + " || ";

    @Getter private static LoM instance;

    @Getter private Teams teams;
    @Getter private ArenaManager arenaManager;
    @Getter private GameManager gameManager;
    @Getter private ChampionManager championManager;

    public void onEnable(){
        instance = this;

        loadManagers();
        new LobbyTask(instance);
    }

    private void loadManagers(){
        teams = new Teams(instance);
        arenaManager = new ArenaManager(instance);
        gameManager = new GameManager(instance);
        championManager = new ChampionManager(instance);
    }

    public void onDisable(){
        getServer().getScheduler().cancelTasks(instance);
    }
}
