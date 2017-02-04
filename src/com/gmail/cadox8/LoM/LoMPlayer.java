package com.gmail.cadox8.LoM;

import com.gmail.cadox8.LoM.utils.TeamData;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LoMPlayer {

    private LoM plugin = LoM.getInstance();

    @Getter private UUID uuid;

    public LoMPlayer(UUID uuid){
        this.uuid = uuid;
    }

    public void addTeam(TeamData team){
        plugin.getTeams().addPlayerToTeam(getPlayer(), team.getTeam());
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(uuid);
    }
}
