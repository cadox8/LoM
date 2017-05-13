package me.cadox8.LoM.managers;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.utils.TeamData;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameManager {

    private LoM plugin;

    @Getter private HashMap<LoMPlayer, Champion> champions = new HashMap<>();
    @Getter private ArrayList<LoMPlayer> playersInGame = new ArrayList<>();

    public GameManager(LoM Main){
        this.plugin = Main;
    }

    public void addPlayer(LoMPlayer p){
        if (!playersInGame.contains(p)) {
            playersInGame.add(p);
        } else {
            p.sendMessage("&cYou're playing!");
        }
    }

    public void mixTeams() throws NullPointerException {
        int i = 0;

        for (LoMPlayer p : playersInGame){
            champSelect(p);
            switch (i){
                case 0:
                    p.addTeam(TeamData.RED);
                    i++;
                    break;
                case 1:
                    p.addTeam(TeamData.BLUE);
                    i = 0;
                    break;
                default:
                    throw new NullPointerException("Inserting player to a null team");
            }
            p.sendMessage("&bAssigned to Team: " + p.getTeam().getPrefix() + p.getTeam().getDisplayName());
        }
    }

    private void champSelect(LoMPlayer p){
        if (champions.get(p) == null) {
            Champion c = plugin.getChampionManager().getChampions().get(new Random().nextInt(plugin.getChampionManager().getRegisteredChamps()));
            champions.put(p, c);
            p.sendMessage("&bAssigned Champion: " + c.getName());
        }
    }
}
