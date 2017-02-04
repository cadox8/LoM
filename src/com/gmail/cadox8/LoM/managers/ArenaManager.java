package com.gmail.cadox8.LoM.managers;

import com.gmail.cadox8.LoM.LoM;
import com.gmail.cadox8.LoM.tower.Tower;
import lombok.Getter;

import java.util.ArrayList;

public class ArenaManager {

    private LoM plugin;

    @Getter public ArrayList<Tower> towers = new ArrayList<>();

    public ArenaManager(LoM Main){
        this.plugin = Main;
    }
}
