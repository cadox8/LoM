package com.gmail.cadox8.LoM.managers;

import com.gmail.cadox8.LoM.LoM;
import com.gmail.cadox8.LoM.LoMPlayer;
import com.gmail.cadox8.LoM.champions.Champion;
import lombok.Getter;

import java.util.HashMap;

public class GameManager {

    private LoM plugin;

    @Getter public HashMap<LoMPlayer, Champion> champions = new HashMap<>();

    public GameManager(LoM Main){
        this.plugin = Main;
    }
}
