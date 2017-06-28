package me.cadox8.LoM.managers;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.utils.TeamData;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameManager {

    private LoM plugin;

    @Getter private HashMap<LoMPlayer, Champion> champions;
    @Getter private ArrayList<LoMPlayer> playersInGame;

    public GameManager(LoM instance){
        this.plugin = instance;

        champions = new HashMap<>();
        playersInGame = new ArrayList<>();
    }

    public void addPlayer(LoMPlayer p){
        if (!playersInGame.contains(p)) {
            playersInGame.add(p);
            p.getUserData().setMoney(400);
            p.save();
        } else {
            p.sendMessage("&cYou're playing!");
        }
    }

    public void quitPlayer(LoMPlayer p){
        if (!playersInGame.contains(p)) return;
        playersInGame.remove(p);
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

    public Player[] playersInGame(){
        List<Player> players = new ArrayList<>();

        for (LoMPlayer p : getPlayersInGame()) players.add(p.getPlayer());

        return players.toArray(new Player[players.size()]);
    }
}
