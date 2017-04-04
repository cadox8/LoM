package me.cadox8.LoM;

import me.cadox8.LoM.managers.ArenaManager;
import me.cadox8.LoM.managers.GameManager;
import me.cadox8.LoM.managers.Teams;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LoM extends JavaPlugin{

    @Getter private String prefix = ChatColor.GRAY + " || " + ChatColor.RED + "LoM" + ChatColor.GRAY + " || ";

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
