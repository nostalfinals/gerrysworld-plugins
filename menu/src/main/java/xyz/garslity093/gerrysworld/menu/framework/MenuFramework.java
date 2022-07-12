package xyz.garslity093.gerrysworld.menu.framework;

import com.google.gson.Gson;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.garslity093.gerrysworld.menu.framework.action.Action;
import xyz.garslity093.gerrysworld.menu.framework.menu.MenuInventoryListener;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.framework
 * @className: MenuFramework
 * @author: GerryYuu
 * @date: 7/12/2022 9:08 PM
 */

public class MenuFramework {
    private static final Gson GSON = new Gson();
    private static final HashMap<ItemStack, HashSet<Action>> ACTIONS_MAP = new HashMap<>();
    private static JavaPlugin plugin;

    private static boolean called = false;

    public MenuFramework(JavaPlugin plugin) {
        MenuFramework.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(new MenuInventoryListener(), plugin);
    }

    public static Gson getGson() {
        return GSON;
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static HashMap<ItemStack, HashSet<Action>> getActionsMap() {
        return ACTIONS_MAP;
    }

    public static boolean isCalled() {
        return called;
    }

    public static void setCalled(boolean called) {
        MenuFramework.called = called;
    }
}
