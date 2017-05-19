package me.cadox8.LoM.task;

import me.cadox8.LoM.LoM;
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
            case 1:
                plugin.getArenaManager().getTowers().forEach(t -> {
                    t.loadAnimation();
                    t.setEnabled(true);
                });
                break;
            case minionsSpawn:

                break;
            case jungleStarts:

                break;
            case baronSpawn:

                break;
        }

        //ToDo: Check if Nexus is broken
        //plugin.getState().setState(State.States.FINISHED);
    }
}
