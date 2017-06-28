package me.cadox8.LoM.api;

import java.util.ArrayList;
import java.util.UUID;

public class LoMServer {

    private static ArrayList<LoMPlayer> players = new ArrayList<>();

    public void addPlayer(LoMPlayer p) {
        if (containsPlayer(p)) return;
        players.add(p);
    }

    public void remPlayer(LoMPlayer p) {
        if (!containsPlayer(p)) return;
        players.remove(p);
    }

    public boolean containsPlayer(LoMPlayer p) {
        return players.contains(p);
    }

    public LoMPlayer getPlayer(UUID uuid) {
        for (LoMPlayer p : players) if (p.getUuid().equals(uuid)) return p;
        addPlayer(new LoMPlayer(uuid));
        return getPlayer(uuid);
    }
}
