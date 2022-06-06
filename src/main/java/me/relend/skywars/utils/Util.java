package me.relend.skywars.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Util {

    public static String color(String m) {
        return ChatColor.translateAlternateColorCodes('&', m);
    }

    public static String locationToString(Location loc) {
        return loc.getBlockX() + ";" + loc.getBlockY() + ";" + loc.getBlockZ() + ";" + loc.getWorld().getName();
    }

    public static Location stringToLocation(String s) {
        String[] parts = s.split(";");
        return new Location(Bukkit.getWorld(parts[3]), Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
    }

    public static Vector faceLoc(Location location, Location face) {
        return face.getBlock().getLocation().subtract(location.getBlock().getLocation()).toVector();
    }

    public static void spawnCage(Location location, Material mat) {
        // below layer
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() - 1, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX() - 1, location.getBlockY() - 1, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX() + 1, location.getBlockY() - 1, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() - 1, location.getBlockZ() - 1).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() - 1, location.getBlockZ() + 1).getBlock().setType(mat);
        // up 1 layer
        new Location(location.getWorld(), location.getBlockX() - 1, location.getBlockY(), location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX() + 1, location.getBlockY(), location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ() - 1).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ() + 1).getBlock().setType(mat);
        // up 2 layers
        new Location(location.getWorld(), location.getBlockX() - 1, location.getBlockY() + 1, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX() + 1, location.getBlockY() + 1, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 1, location.getBlockZ() - 1).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 1, location.getBlockZ() + 1).getBlock().setType(mat);
        // up 3 layers
        new Location(location.getWorld(), location.getBlockX() - 1, location.getBlockY() + 2, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX() + 1, location.getBlockY() + 2, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 2, location.getBlockZ() - 1).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 2, location.getBlockZ() + 1).getBlock().setType(mat);
        // top layer
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 3, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX() - 1, location.getBlockY() + 3, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX() + 1, location.getBlockY() + 3, location.getBlockZ()).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 3, location.getBlockZ() - 1).getBlock().setType(mat);
        new Location(location.getWorld(), location.getBlockX(), location.getBlockY() + 3, location.getBlockZ() + 1).getBlock().setType(mat);
    }

    public static void resetPlayer(Player player) {
        player.setHealth(20.0);
        player.setFoodLevel(20);
        player.setExp(0);
        player.getActivePotionEffects().clear();
        player.getInventory().clear();
        player.setAbsorptionAmount(0);
    }

}
