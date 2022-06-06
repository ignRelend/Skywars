package me.relend.skywars.listeners;

import me.relend.skywars.Skywars;
import me.relend.skywars.utils.Util;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (Skywars.getInstance().getGameManager().addPlayer(event.getPlayer())) {
            event.setJoinMessage(event.getPlayer().getName() + " has joined the game (" + Skywars.getInstance().getGameManager().getAlive().size() + "/" + Skywars.getInstance().getArenaConfig().getStringList("arena.spawnpoints").size() + ")");
            event.getPlayer().teleport(Util.stringToLocation(Skywars.getInstance().getArenaConfig().getStringList("arena.spawnpoints").get(Skywars.getInstance().getGameManager().getAlive().size() - 1)));
            event.getPlayer().teleport(event.getPlayer().getLocation().setDirection(Util.faceLoc(event.getPlayer().getLocation(), new Location(event.getPlayer().getWorld(), 0, event.getPlayer().getLocation().getBlockY(), 0))));
            Util.spawnCage(event.getPlayer().getLocation(), Material.GLASS);
            Util.resetPlayer(event.getPlayer());
            event.getPlayer().setGameMode(GameMode.SURVIVAL);
        } else {
            event.setJoinMessage(null);
            event.getPlayer().sendMessage("hey you, we are full, and you are now a spectator nerd.");
        }
    }
}
