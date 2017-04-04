package me.cadox8.LoM.managers;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.LoMPlayer;
import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.utils.TeamData;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {

    private LoM plugin;

    @Getter public HashMap<LoMPlayer, Champion> champions = new HashMap<>();
    @Getter public ArrayList<LoMPlayer> playersInGame = new ArrayList<>();

    public GameManager(LoM Main){
        this.plugin = Main;
    }


    public void mixTeams(){
        int i = 0;

        for (LoMPlayer p : playersInGame){
            switch (i){
                case 0:
                    p.addTeam(TeamData.RED);
                    break;
                case 1:
                    p.addTeam(TeamData.BLUE);
                    i = 0;
                    break;
                default:
                    throw new IndexOutOfBoundsException("Inserting player to a null team");
            }
            p.sendMessage("&bAsigned to Team: " + p.getTeam().getPrefix() + p.getTeam().getDisplayName());
        }
    }
}
