package me.cadox8.LoM.skills.champs.morgana;

import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.utils.ItemMaker;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class DarkBinding extends Skill {

    public DarkBinding(){
        super("Dark Binding", new ItemMaker(Material.ENCHANTED_BOOK).setName("Dark Binding").build());

        setAdDamage(toList(0));
        setApDamage(toList(80, 135, 190, 245, 300));
        setManaCost(toList(50, 55, 60, 65, 70));
        setRange(1175);
        setCooldown(11);
    }

    public void use(LoMPlayer p){
        Location l = p.getLoc().toVector().add(p.getLoc().getDirection()).toLocation(p.getLoc().getWorld());
        for (double x = 0.0; x < getRange(); x += 0.5){
            Location particleLoc = l.add(0, 2, 0);
            ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(102, 0, 102), Utils.add(x, particleLoc), plugin.getGameManager().playersInGame());

            if (getRange() == x) {
                l.getWorld().getNearbyEntities(Utils.add(x, l), 0, 0, 0).forEach(e -> {
                    if (e instanceof Player) {
                        LoMPlayer u = Utils.getPlayer((Player) e);
                        if (u == null) return;

                        if (plugin.getTeams().getTeam(u.getPlayer()).equals(p.getTeam())) return;

                        u.paralize();
                        u.damage(this);

                        plugin.getServer().getScheduler().runTaskLater(plugin, () -> u.paralize(), 0);
                    }
                });
            }
        }
    }
}
