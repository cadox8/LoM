package me.cadox8.LoM.champions;

import lombok.Getter;
import lombok.NonNull;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.champions.list.Morgana;
import me.cadox8.LoM.champions.list.Teemo;
import me.cadox8.LoM.exceptions.RegisteredChampionException;

import java.util.ArrayList;
import java.util.List;

public class ChampionManager {

    private LoM plugin;
    @Getter private List<Champion> champions;

    public ChampionManager(LoM instance){
        this.plugin = instance;
        champions = new ArrayList<>();
        registerAllChamps(); //Register plugin's champs
    }

    public void registerChampions(@NonNull Champion... champion) throws RegisteredChampionException {
        for (Champion c : champion){
            champions.forEach(champ -> {
                if (champ.getId() == c.getId()) throw new RegisteredChampionException("Champion with id " + c.getId() + " is already registered");
                champions.add(c);
            });
        }
    }

    public int getRegisteredChamps(){
        return champions.size();
    }

    private void registerAllChamps(){
        try {
            registerChampions(new Morgana(), new Teemo());
        } catch (RegisteredChampionException e){
            System.err.println(e.getMessage());
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        }
    }
}
