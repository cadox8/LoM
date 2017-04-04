package me.cadox8.LoM.utils;

import me.cadox8.LoM.LoM;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.scoreboard.Team;

@AllArgsConstructor
public enum TeamData {

    BLUE(LoM.getInstance().getTeams().getBlue()),
    RED(LoM.getInstance().getTeams().getRed());

    @Getter private Team team;
}
