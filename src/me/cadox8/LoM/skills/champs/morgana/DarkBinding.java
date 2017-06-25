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
                Location rangeLoc = l;
                rangeLoc.getWorld().getNearbyEntities(Utils.add(x, rangeLoc), 0, 0, 0).forEach(e -> {
                    if (e instanceof Player) {
                        Player target = (Player) e;

                        if (plugin.getTeams().getTeam(target).equals(p.getTeam())) return;

                        new LoMPlayer(target.getUniqueId()).paralize();

                        plugin.getServer().getScheduler().runTaskLater(plugin, () -> new LoMPlayer(target.getUniqueId()).paralize(), 0);
                    }
                });
            }
        }
    }
}
