package me.cadox8.LoM.skills.champs.morgana;

import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.particles.ParticleEffect;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.utils.ItemMaker;
import me.cadox8.LoM.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class TormentedSoil extends Skill {

    public TormentedSoil() {
        super("Tormented Soil", new ItemMaker(Material.INK_SACK, 5).setName("Tormented Soil").build());

        setAdDamage(toList(0));
        setApDamage(toList(8, 16, 24, 32, 40));
        setManaCost(toList(70, 85, 100, 115, 130));
        setRange(900);
        setCooldown(10);
    }

    public void use(LoMPlayer p) {
        Location l = p.getLoc().toVector().add(p.getLoc().getDirection().multiply(10)).toLocation(p.getLoc().getWorld());
        Block b = getSafeBlock(l);
        l = b.getLocation();

        Utils.getCircle(l, 10).forEach(loc -> {
            ParticleEffect.REDSTONE.display(new ParticleEffect.OrdinaryColor(153, 0, 153), loc, plugin.getGameManager().playersInGame());

            loc.getWorld().getNearbyEntities(loc, 0, 3, 0).forEach(e -> {
                if (e instanceof Player) {
                    LoMPlayer u = Utils.getPlayer((Player) e);
                    if (u == null) return;

                    if (plugin.getTeams().getTeam(u.getPlayer()).equals(p.getTeam())) return;
                    u.damage(this);
                }
            });
        });
    }

    private Block getSafeBlock(Location l) {
        Block b = l.getBlock();

        if (b.getType() == Material.AIR) {
            for (int x = 0; x <= 10; x++) {
                Block tempBlock = b.getLocation().add(0, -x, 0).getBlock();
                if (tempBlock.getType() != Material.AIR) return tempBlock;
            }
        }
        return b;
    }
}
