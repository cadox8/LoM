package me.cadox8.LoM.skills.pasives;

import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.skills.Pasive;
import me.cadox8.LoM.utils.TeamData;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

public class GuerrillaWarfare extends Pasive {

    public GuerrillaWarfare(){
        super("Guerrilla Warfare", new ItemStack(Material.POTION));
    }

    public void use(LoMPlayer p){
        hideOnBush(p);
    }

    private void hideOnBush(LoMPlayer p){ //FAKER!
        Team t = plugin.getTeams().getTeam(p.getPlayer());

        if (hide.contains(p)){
            if (TeamData.BLUE.getTeam().equals(t)){
                plugin.getTeams().getRed().getEntries().forEach(e -> {
                    plugin.getServer().getPlayer(e).showPlayer(p.getPlayer());
                });
            } else {
                plugin.getTeams().getBlue().getEntries().forEach(e -> {
                    plugin.getServer().getPlayer(e).showPlayer(p.getPlayer());
                });
            }
            hide.remove(p);
            return;
        }

        if (TeamData.BLUE.getTeam().equals(t)){
            plugin.getTeams().getRed().getEntries().forEach(e -> {
                plugin.getServer().getPlayer(e).hidePlayer(p.getPlayer());
            });
        } else {
            plugin.getTeams().getBlue().getEntries().forEach(e -> {
                plugin.getServer().getPlayer(e).hidePlayer(p.getPlayer());
            });
        }
        hide.add(p);
    }
}
