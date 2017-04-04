package me.cadox8.LoM.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class Title {

    private Player player;
    private int fadeIn;
    private int stay;
    private int fadeOut;
    private String title;
    private String subtitle;

    public Title(Player player, int fadeIn, int stay, int fadeOut, String title, String subtitle){
        this.player = player;
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
        this.title = title;
        this.subtitle = subtitle;
    }

    public void sendTitle() {
        fadeIn = fadeIn * 20; //No more ticks, only seconds
        stay = stay * 20;
        fadeOut = fadeOut * 20;

        try {
            Object e;
            Object chatTitle;
            Object chatSubtitle;
            Constructor subtitleConstructor;
            Object titlePacket;
            Object subtitlePacket;

            if (title != null) {
                title = ChatColor.translateAlternateColorCodes('&', title);
                title = title.replaceAll("%player%", player.getDisplayName());
                // Times packets
                e = ReflectionUtils.getNmsClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get((Object) null);
                chatTitle = ReflectionUtils.getNmsClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[]{String.class}).invoke((Object) null, new Object[]{"{\"text\":\"" + title + "\"}"});
                subtitleConstructor = ReflectionUtils.getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{ReflectionUtils.getNmsClass("PacketPlayOutTitle").getDeclaredClasses()[0], ReflectionUtils.getNmsClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE});
                titlePacket = subtitleConstructor.newInstance(new Object[]{e, chatTitle, fadeIn, stay, fadeOut});
                ReflectionUtils.sendPacket(player, titlePacket);

                e = ReflectionUtils.getNmsClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get((Object) null);
                chatTitle = ReflectionUtils.getNmsClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[]{String.class}).invoke((Object) null, new Object[]{"{\"text\":\"" + title + "\"}"});
                subtitleConstructor = ReflectionUtils.getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{ReflectionUtils.getNmsClass("PacketPlayOutTitle").getDeclaredClasses()[0], ReflectionUtils.getNmsClass("IChatBaseComponent")});
                titlePacket = subtitleConstructor.newInstance(new Object[]{e, chatTitle});
                ReflectionUtils.sendPacket(player, titlePacket);
            }

            if (subtitle != null) {
                subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
                subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
                // Times packets
                e = ReflectionUtils.getNmsClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get((Object) null);
                chatSubtitle = ReflectionUtils.getNmsClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[]{String.class}).invoke((Object) null, new Object[]{"{\"text\":\"" + title + "\"}"});
                subtitleConstructor = ReflectionUtils.getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{ReflectionUtils.getNmsClass("PacketPlayOutTitle").getDeclaredClasses()[0], ReflectionUtils.getNmsClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE});
                subtitlePacket = subtitleConstructor.newInstance(new Object[]{e, chatSubtitle, fadeIn, stay, fadeOut});
                ReflectionUtils.sendPacket(player, subtitlePacket);

                e = ReflectionUtils.getNmsClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get((Object) null);
                chatSubtitle = ReflectionUtils.getNmsClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[]{String.class}).invoke((Object) null, new Object[]{"{\"text\":\"" + subtitle + "\"}"});
                subtitleConstructor = ReflectionUtils.getNmsClass("PacketPlayOutTitle").getConstructor(new Class[]{ReflectionUtils.getNmsClass("PacketPlayOutTitle").getDeclaredClasses()[0], ReflectionUtils.getNmsClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE});
                subtitlePacket = subtitleConstructor.newInstance(new Object[]{e, chatSubtitle, fadeIn, stay, fadeOut});
                ReflectionUtils.sendPacket(player, subtitlePacket);
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }
    }

    public void clearTitle() {
        new Title(player, 0, 0, 0, "", "").sendTitle();
    }
}
