package me.cadox8.LoM.skills.champs.morgana;

import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.utils.ItemMaker;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class DarkBinding extends Skill {

    public DarkBinding(){
        super("Dark Binding", new ItemMaker(Material.ENCHANTED_BOOK).setDisplayName("Dark Binding").build());

        setLevel(0);

        setAdDamage(toList(0));
        setApDamage(toList(80, 135, 190, 245, 300));
        setManaCost(toList(50, 55, 60, 65, 70));
        setRange(1175);
    }

    public void use(LoMPlayer p){
        Location l = p.getLoc();
        for (double x = 0.0; x < getRange(); x += 0.5){
            ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(102, 0, 102), l.add(x, 2, 0), plugin.getGameManager().playersInGame());

            if (getRange() == x) {
                l.getWorld().getNearbyEntities(l.add(x, 0, 0), 0, 0, 0).forEach(e -> {
                    if (e instanceof Player) {
                        Player target = (Player) e;

                        if (plugin.getTeams().getTeam(target).equals(p.getTeam())) return;

                        new LoMPlayer(target.getUniqueId()).paralize();

                        plugin.getServer().getScheduler().runTaskLater(plugin, () -> new LoMPlayer(target.getUniqueId()).paralize(), (long)(getLevel() * 1.2) * 20);
                    }
                });
            }
        }
    }
}
