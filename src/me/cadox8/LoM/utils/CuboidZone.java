package me.cadox8.LoM.utils;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cadiducho base original, Cadox8 some changes
 */

public class CuboidZone {

    @Getter private Block corner1;
    @Getter private Block corner2;
    @Getter private World world;

    public CuboidZone(Block corner1, Block corner2) {
        if (corner1.getWorld().equals(corner2.getWorld())) {
            this.corner1 = corner1;
            this.corner2 = corner2;
            world = corner1.getWorld();
        } else {
            throw new IllegalArgumentException("Section must be in the same map");
        }
    }

    public void set(Material material) {
        toArray().forEach(b -> b.setType(material));
    }

    public void removeBlock(Block block){
        block.getWorld().getBlockAt(block.getLocation()).setType(Material.AIR);
    }

    public boolean contains(Block b) {
        return toArray().contains(b);
    }

    public List<Block> toArray() {
        List<Block> result = new ArrayList<>();

        int minX = Math.min(corner1.getX(), corner2.getX());
        int minY = Math.min(corner1.getY(), corner2.getY());
        int minZ = Math.min(corner1.getZ(), corner2.getZ());
        int maxX = Math.max(corner1.getX(), corner2.getX());
        int maxY = Math.max(corner1.getY(), corner2.getY());
        int maxZ = Math.max(corner1.getZ(), corner2.getZ());
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    result.add(world.getBlockAt(new Location(world, x, y, z)));
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        Location l = corner1.getLocation();
        String s = String.valueOf(new StringBuilder(String.valueOf(world.getName())).append(":").append(l.getBlockX()).toString()) + ":" + String.valueOf(l.getBlockY()) + ":" + String.valueOf(l.getBlockZ());
        Location l1 = corner2.getLocation();
        String s1 = String.valueOf(new StringBuilder(String.valueOf(world.getName())).append(":").append(l1.getBlockX()).toString()) + ":" + String.valueOf(l1.getBlockY()) + ":" + String.valueOf(l1.getBlockZ());
        return s + ";" + s1;
    }

    public Location getBottomCenter() {
        int minY = Math.min(corner1.getY(), corner2.getY());
        int minX = Math.min(corner1.getX(), corner2.getX());
        int minZ = Math.min(corner1.getZ(), corner2.getZ());
        int maxX = Math.max(corner1.getX(), corner2.getX());
        int maxZ = Math.max(corner1.getZ(), corner2.getZ());

        return new Location(world, minX + (maxX - minX) / 2, minY, minZ + (maxZ - minZ) / 2);
    }

    public void removeAll(){
        toArray().forEach(b -> removeBlock(b));
    }
}
