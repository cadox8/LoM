package me.cadox8.LoM.utils;

import lombok.Getter;
import me.cadox8.LoM.LoM;

import java.io.File;
import java.util.List;

public class FileUtils {

    private LoM plugin;

    @Getter private static File fConf;

    public FileUtils(LoM instance){
        this.plugin = instance;
        setupFiles();
    }

    private void setupFiles(){
        fConf = new File(plugin.getDataFolder(), "config.yml");
        if (!fConf.exists()) {
            try {
                plugin.getConfig().options().copyDefaults(true);
                plugin.saveConfig();
                Log.log(Log.Logs.SUCCESS, "Created config file");
            } catch (Exception e) {
                Log.log(Log.Logs.ERROR, "Failed to create config file");
            }
        }
    }

    public String getString(String team, String search){
        return plugin.getConfig().getString("arena." + team + "." + search);
    }
    public List<String> getStringList(String team, String search){
        return plugin.getConfig().getStringList("arena." + team + "." + search);
    }
}
