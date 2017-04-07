package me.cadox8.LoM.utils;

import me.cadox8.LoM.LoM;
import lombok.NonNull;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import java.util.ArrayList;

public class Utils {

    private static LoM plugin = LoM.getInstance();

    /**
     * Utils
     **/

    public static String colorize(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void broadcast(String msg){
        plugin.getGameManager().getPlayersInGame().forEach(p -> p.sendMessage(msg));
    }

    public static void sound(@NonNull Sound sound){
        plugin.getGameManager().getPlayersInGame().forEach(p -> p.getPlayer().playSound(p.getPlayer().getLocation(), sound, 1, 1));
    }




    /**
     * TIME
     * */

    public static ArrayList<Integer> parseTime(int seconds){
        ArrayList<Integer> time = new ArrayList<>();

        time.add(seconds / 3600); //Hours
        time.add((seconds % 3600) / 60); //Minutes
        time.add(seconds % 60); //Seconds

        return time;
    }


    /**
     * TOWERS
    **/

    public static ArrayList<Location> getCircle(Location center, double radius) {
        ArrayList<Location> locations = new ArrayList<>();

        for (double x = -radius; x <= radius; x++) {
            for (double y = center.getY(); y < 50; y++) {
                for (double z = -radius; z <= radius; z++) {
                    locations.add(new Location(center.getWorld(), center.getX() + x, center.getY() + y, center.getZ() + z));
                }
            }
        }
        return locations;
    }

    public static boolean canAttackPlayer(Location l, TeamData team){
        for (Entity e : l.getWorld().getNearbyEntities(l, 0, 0, 0)){
            if (e instanceof Player && !LoM.getInstance().getTeams().getTeam((Player)e).equals(team.getTeam())){
                return true;
            }
        }
        return false;
    }

    public static boolean canAttackBlueMinion(Location l, TeamData team){
        for (Entity e : l.getWorld().getNearbyEntities(l, 0, 0, 0)){
            if (e instanceof Zombie && !team.getTeam().equals(LoM.getInstance().getTeams().getBlue())){
                return true;
            }
        }
        return false;
    }

    public static boolean canAttackRedMinion(Location l, TeamData team){
        for (Entity e : l.getWorld().getNearbyEntities(l, 0, 0, 0)){
            if (e instanceof PigZombie && !team.getTeam().equals(LoM.getInstance().getTeams().getRed())){
                return true;
            }
        }
        return false;
    }
}
