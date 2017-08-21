package me.cadox8.LoM;

import me.cadox8.LoM.api.LoMServer;
import me.cadox8.LoM.champions.ChampionManager;
import me.cadox8.LoM.managers.ArenaManager;
import me.cadox8.LoM.managers.GameManager;
import me.cadox8.LoM.managers.Teams;
import lombok.Getter;
import me.cadox8.LoM.states.State;
import me.cadox8.LoM.task.LobbyTask;
import me.cadox8.LoM.utils.FileUtils;
import me.cadox8.LoM.utils.Log;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LoM extends JavaPlugin {

    @Getter private static String prefix = ChatColor.GRAY + " || " + ChatColor.RED + "LoM" + ChatColor.GRAY + " || ";

    @Getter private static LoM instance;

    @Getter private FileUtils fileUtils;
    @Getter private Teams teams;
    @Getter private ArenaManager arenaManager;
    @Getter private GameManager gameManager;
    @Getter private ChampionManager championManager;
    @Getter private State state;
    @Getter private LoMServer loMServer;

    public void onEnable(){
        instance = this;

        loadManagers();
        new LobbyTask(instance);

        Log.log(Log.Logs.SUCCESS, "League Of Minecraft has been enabled, v" + getDescription().getVersion());
    }

    public void onDisable(){
        getServer().getScheduler().cancelTasks(instance);

        Log.log(Log.Logs.SUCCESS, "League Of Minecraft has been disabled");
    }

    private void loadManagers(){
        try {
            fileUtils = new FileUtils(instance);
            teams = new Teams(instance);
            arenaManager = new ArenaManager(instance);
            gameManager = new GameManager(instance);
            championManager = new ChampionManager(instance);
            state = new State();
            loMServer = new LoMServer();
        } catch (Exception e){
            Log.log(Log.Logs.ERROR, "Error while loading classes, disabling...");
            getServer().getPluginManager().disablePlugin(instance);
        }
    }
}
