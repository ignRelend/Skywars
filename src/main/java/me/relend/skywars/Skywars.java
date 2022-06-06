package me.relend.skywars;

import me.relend.skywars.listeners.BlockListener;
import me.relend.skywars.listeners.PlayerJoinListener;
import me.relend.skywars.manager.GameManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Skywars extends JavaPlugin {

    private static Skywars instance;
    private GameManager gameManager;
    private FileConfiguration arenaConfig;
    private FileConfiguration messagesConfig;

    @Override
    public void onEnable() {
        instance = this;
        gameManager = new GameManager();

        registerListeners();
        registerCommands();
        registerConfigs();
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

    private void registerCommands() {

    }

    private void registerConfigs() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        File arenaConfigFile = new File(getDataFolder(), "arena.yml");
        if (!arenaConfigFile.exists()) {
            arenaConfigFile.getParentFile().mkdirs();
            saveResource("arena.yml", false);
        }
        arenaConfig = new YamlConfiguration();
        try {
            arenaConfig.load(arenaConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        File messagesConfigFile = new File(getDataFolder(), "messages.yml");
        if (!messagesConfigFile.exists()) {
            messagesConfigFile.getParentFile().mkdirs();
            saveResource("messages.yml", false);
        }
        messagesConfig = new YamlConfiguration();
        try {
            messagesConfig.load(messagesConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static Skywars getInstance() {
        return instance;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public FileConfiguration getArenaConfig() {
        return arenaConfig;
    }

    public FileConfiguration getMessagesConfig() {
        return messagesConfig;
    }
}