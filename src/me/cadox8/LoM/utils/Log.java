package me.cadox8.LoM.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.cadox8.LoM.LoM;

public class Log {

    @AllArgsConstructor
    public enum Logs {
        SUCCESS("&2Success"),
        INFO("&3Info"),
        WARNING("&6Warning"),
        ERROR("&4Error");

        @Getter private String prefix;
    }

    public static void log(String log){
        log(Logs.INFO, log);
    }

    public static void log(Logs logs, String log){
        String prefix = " &7[" + logs.getPrefix() + "&7]&r ";

        LoM.getInstance().getServer().getConsoleSender().sendMessage(LoM.getPrefix() + prefix + log);
    }
}
