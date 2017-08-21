package me.cadox8.LoM.api;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.champions.Champion;
import me.cadox8.LoM.skills.Skill;
import me.cadox8.LoM.utils.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class LoMPlayer {

    private LoM plugin = LoM.getInstance();

    @Getter private UUID uuid;
    @Getter @Setter private UserData userData;

    public LoMPlayer(OfflinePlayer p){
        this(p.getUniqueId());
    }
    public LoMPlayer(UUID uuid){
        this.uuid = uuid;

        setUserData(new UserData());
    }

    /**
     * LoMPlayer Class
     **/
    public void sendMessage(String msg){
        getPlayer().sendMessage(LoM.getPrefix() + Utils.colorize(msg));
    }

    public void paralize(){
        if (getPlayer().getWalkSpeed() <= 0){
            getPlayer().setWalkSpeed(0.1f);
            return;
        }
        getPlayer().setWalkSpeed(0);
    }

    public void addToGame(){
        getPlayer().getInventory().setItem(4, new ItemMaker(Material.NETHER_STAR).setName("&cChampion Selector").build());
        plugin.getGameManager().addPlayer(this);
    }

    public void save() {
        plugin.getGameManager().quitPlayer(this);
        plugin.getLoMServer().remPlayer(this);
        plugin.getLoMServer().addPlayer(this);
        plugin.getGameManager().addPlayer(this);
    }


    public void damage(Skill skill) {
        Champion c = plugin.getGameManager().getChampions().get(this);
        c.getChampionStats().setHealth(c.getChampionStats().getHealth() - skill.getApDamage().get(skill.getLevel()));
        plugin.getGameManager().getChampions().put(this, c);
    }

    /**
    * Teams
    **/
    public void addTeam(TeamData team){
        plugin.getTeams().addPlayerToTeam(getPlayer(), team.getTeam());
    }
    public void removeTeam(TeamData team){
        plugin.getTeams().removePlayerFromTeam(getPlayer(), team.getTeam());
    }
    public Team getTeam(){
        return plugin.getTeams().getTeam(getPlayer());
    }


    /**
     * Getters
     **/
    public Player getPlayer(){
        return plugin.getServer().getPlayer(uuid);
    }
    public Location getLoc() {
        return getPlayer().getLocation();
    }
    public String getName() {
        return getPlayer().getName();
    }


    /**
    * Fancy :D
    **/
    public void sendActionBar(Player p, String msg) {
        try {
            Constructor<?> constructor = ReflectionUtils.getNmsClass("PacketPlayOutChat").getConstructor(ReflectionUtils.getNmsClass("IChatBaseComponent"), byte.class);
            Object icbc = ReflectionUtils.getNmsClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + Utils.colorize(msg) + "\"}");
            Object packet = constructor.newInstance(icbc, (byte) 2);

            ReflectionUtils.sendPacket(p, packet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendHeaderAndFooter(Player p, String headerText, String footerText) {
        try {
            Class chatSerializer = ReflectionUtils.getNmsClass("IChatBaseComponent$ChatSerializer");

            Object tabHeader = chatSerializer.getMethod("a", String.class).invoke(chatSerializer, "{'text': '" + Utils.colorize(headerText) + "'}");
            Object tabFooter = chatSerializer.getMethod("a", String.class).invoke(chatSerializer, "{'text': '" + Utils.colorize(footerText) + "'}");
            Object tab = ReflectionUtils.getNmsClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[]{ReflectionUtils.getNmsClass("IChatBaseComponent")}).newInstance(new Object[]{tabHeader});

            Field f = tab.getClass().getDeclaredField("b");
            f.setAccessible(true);
            f.set(tab, tabFooter);

            ReflectionUtils.sendPacket(p, tab);
        } catch (IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void sendTitle(String title, String subtitle, int in, int stay, int out){
        Title t = new Title(getPlayer(), in, stay, out, title, subtitle);
        t.clearTitle();
        t.sendTitle();
    }


    @Data
    public class UserData {
        public boolean canMove = true;
        public boolean canAttack = true;

        public boolean hasBaron = false;

        public int money = 0;
    }
}
