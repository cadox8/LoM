package me.cadox8.LoM.task;

import me.cadox8.LoM.LoM;
import me.cadox8.LoM.states.State;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyTask extends BukkitRunnable{

    private LoM plugin;

    private int count = 120;

    public LobbyTask(LoM Main){
        this.plugin = Main;
    }

    public void run(){
        if (!(plugin.getGameManager().getPlayersInGame().size() >= 2)) return;

        plugin.getGameManager().getPlayersInGame().forEach(p -> p.getPlayer().setLevel(count));

        switch (count){
            case 60:
            case 30:
            case 20:
                Utils.broadcast("&aTime left: &c" + count);
                break;

            case 10:
                plugin.getGameManager().mixTeams();
                break;

            case 5:
                plugin.getGameManager().getPlayersInGame().forEach(p -> {
                    p.getPlayer().teleport(plugin.getArenaManager().getTeamLocs().get(p.getTeam()));
                    p.paralyze();
                });
                break;

            case 0:
                plugin.getGameManager().getPlayersInGame().forEach(p -> {
                    plugin.getGameManager().getChampions().get(p).giveItems(p);
                    p.paralyze();
                    Utils.broadcast("&2&lThe game has begun");
                    Utils.sound(Sound.ENTITY_GENERIC_EXPLODE);
                });
                new GameTask(plugin).runTaskTimer(plugin, 0, 20);
                plugin.getState().setState(State.States.GAME);

                cancel();
                break;
        }
        count--;
    }
}
