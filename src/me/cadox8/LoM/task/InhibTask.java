package me.cadox8.LoM.task;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.states.State;
import me.cadox8.LoM.structures.Structure;
import org.bukkit.scheduler.BukkitRunnable;

public class InhibTask extends BukkitRunnable {

    private LoM plugin;
    private Structure structure;

    public InhibTask(LoM instance, Structure structure){
        this.plugin = instance;
        this.structure = structure;
    }

    public void run() {
        if (plugin.getState().getState() != State.States.GAME) return;

        structure.setDestroyed(false);
        structure.loadAnimation();
    }
}
