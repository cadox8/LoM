package com.gmail.cadox8.LoM.task;

import com.gmail.cadox8.LoM.LoM;
import org.bukkit.scheduler.BukkitRunnable;

public class GameTask extends BukkitRunnable {

    private LoM plugin;

    private int count = 0;

    //
    private final int minionsSpawn = 30;
    private final int jungleStarts = 90;
    private final int baronSpawn = 1200;
    //

    public GameTask(LoM Main){
        this.plugin = Main;
    }

    @Override
    public void run(){
        count++;

        switch (count){
            case minionsSpawn:

                break;
            case jungleStarts:

                break;
            case baronSpawn:

                break;
        }
    }
}