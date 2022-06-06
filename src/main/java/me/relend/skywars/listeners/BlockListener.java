package me.relend.skywars.listeners;

import me.relend.skywars.Skywars;
import me.relend.skywars.manager.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (Skywars.getInstance().getGameManager().getGameState() != GameState.WAITING || Skywars.getInstance().getGameManager().getGameState() != GameState.COUNTDOWN) {
            event.setCancelled(true);
        }
    }

}
