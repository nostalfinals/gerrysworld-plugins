package framework.hologram;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @packageName: framework.hologram
 * @className: HologramFramework
 * @author: GerryYuu
 * @date: 7/15/2022 12:55 AM
 */

public class HologramFramework {
    private static JavaPlugin plugin;

    public HologramFramework(JavaPlugin plugin) {
        HologramFramework.plugin = plugin;
    }
}
