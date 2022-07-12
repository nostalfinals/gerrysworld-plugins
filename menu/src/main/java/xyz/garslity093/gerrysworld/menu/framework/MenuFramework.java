package xyz.garslity093.gerrysworld.menu.framework;

import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.garslity093.gerrysworld.menu.framework.menu.MenuInventoryListener;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.framework
 * @className: MenuFramework
 * @author: GerryYuu
 * @date: 7/12/2022 9:08 PM
 */

public class MenuFramework {
    private static final Gson GSON = new Gson();
    private final JavaPlugin plugin;


    public MenuFramework(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(new MenuInventoryListener(), plugin);
    }

    public static Gson getGson() {
        return GSON;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}
