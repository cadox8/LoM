package me.cadox8.LoM.task;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.states.State;
import me.cadox8.LoM.structures.Structure;
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

        if (count % 5 == 0) plugin.getArenaManager().getStructures().stream().filter(n -> n.getStructureType() == Structure.StructureType.NEXUS).forEach(n -> n.regen());

        switch (count){
            case 1:
                plugin.getArenaManager().getStructures().forEach(n -> n.loadAnimation());
                break;
            case minionsSpawn:

                break;
            case jungleStarts:

                break;
            case baronSpawn:

                break;
        }

        if (plugin.getState().getState() == State.States.FINISHED) cancel();
    }
}
