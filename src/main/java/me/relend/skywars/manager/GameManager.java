package me.relend.skywars.manager;

import me.relend.skywars.Skywars;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GameManager {

    private GameState gameState = GameState.WAITING;
    private ArrayList<Player> alive = new ArrayList<>();
    private ArrayList<Player> spectators = new ArrayList<>();

    public GameManager() {

    }

    public void setGameState(GameState gameState) {
        switch (gameState) {
            case WAITING:
                // not much all done in listeners

                break;
            case COUNTDOWN:
                // start countdown timer

                break;
            case IN_GAME:
                // give kits
                // remove kit selector item
                // add invincibility for 3 seconds
                // set chest contents

                break;
            case FINISH:
                // spawn fireworks
                // send winning messages / titles
                // send final kill amounts

                break;
            case RESETTING:
                // reset map
                // clear chest contents

                break;
        }
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public boolean addPlayer(Player player) {
        if (gameState == GameState.WAITING || gameState == GameState.COUNTDOWN) {
            if (Skywars.getInstance().getArenaConfig().getStringList("arena.spawnpoints").size() > alive.size()) {
                alive.add(player);
                return true;
            }
        }
        spectators.add(player);
        player.setGameMode(GameMode.SPECTATOR);
        return false;
    }

    public ArrayList<Player> getSpectators() {
        return spectators;
    }

    public ArrayList<Player> getAlive() {
        return alive;
    }
}
