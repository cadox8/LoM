package me.cadox8.LoM.task;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.inhib.Inhib;
import me.cadox8.LoM.states.State;
import org.bukkit.scheduler.BukkitRunnable;

public class InhibTask extends BukkitRunnable {

    private LoM plugin;
    private Inhib inhib;

    public InhibTask(LoM instance, Inhib inhib){
        this.plugin = instance;
        this.inhib = inhib;
    }

    public void run() {
        if (plugin.getState().getState() != State.States.GAME) return;

        inhib.setDestroyed(false);
        inhib.loadAnimation();
    }
}
