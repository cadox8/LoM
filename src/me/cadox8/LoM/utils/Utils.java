package me.cadox8.LoM.utils;

import lombok.NonNull;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
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

    public static String locationToString(@NonNull Location loc) {
        return loc.getWorld().getName() + "%" + loc.getX() + "%" + loc.getY() + "%" + loc.getZ() + "%" + loc.getYaw() + "%" + loc.getPitch();
    }

    public static Location stringToLocation(@NonNull String string) {
        if (string == null) return null;
        String[] s = string.split("%");
        Location loc = new Location(plugin.getServer().getWorld(s[0]), Double.parseDouble(s[1]), Double.parseDouble(s[2]), Double.parseDouble(s[3]), Float.parseFloat(s[4]), Float.parseFloat(s[5]));
        return loc;
    }

    public static Location add(double a, Location l) {
        switch (getFacing(l)) {
            case 0:
                l.add(a, 0, 0);
                break;
            case 1:
                l.add(0, 0, a);
                break;
            case 2:
                l.add(-a, 0, 0);
                break;
            case 3:
                l.add(0, 0, -a);
                break;
        }
        return l;
    }

    public static int getFacing(Player player) {
        return getFacing(player.getLocation());
    }
    //So... not diagonals, TODO!
    public static int getFacing(Location l) {
        double d = (l.getYaw() * 4.0F / 360.0F) + 0.5D;
        int i = (int) d;
        return d < i ? i - 1 : i;
        /*
        * 0 = South
        * 1 = West
        * 2 = North
        * 3 = East
        * */
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

    public static void giveMoney(TeamData td, int gold) {
        switch (td){
            case RED:
                plugin.getGameManager().getPlayersInGame().forEach(p -> {
                    if (p.getTeam().equals(TeamData.BLUE.getTeam())) p.getUserData().setMoney(p.getUserData().getMoney() + gold);
                });
                break;
            case BLUE:
                plugin.getGameManager().getPlayersInGame().forEach(p -> {
                    if (p.getTeam().equals(TeamData.RED.getTeam())) p.getUserData().setMoney(p.getUserData().getMoney() + gold);
                });
                break;
        }
    }

    public static LoMPlayer getPlayer(Player p) {
        for (LoMPlayer u : plugin.getGameManager().getPlayersInGame()) {
            if (u.getName().equalsIgnoreCase(p.getName())) return u;
        }
        return null;
    }
}
