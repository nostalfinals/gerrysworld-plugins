package framework.menu;

import framework.menu.action.Action;
import framework.menu.menu.MenuInventoryListener;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.framework
 * @className: MenuFramework
 * @author: GerryYuu
 * @date: 7/12/2022 9:08 PM
 */

public class MenuFramework {
    private static final HashMap<ItemStack, HashSet<Action>> BUTTON_ACTION_MAP = new HashMap<>();
    private static final HashMap<InventoryHolder, HashSet<Action>> MENU_ACTION_MAP = new HashMap<>();
    private static JavaPlugin plugin;

    public MenuFramework(JavaPlugin plugin) {
        MenuFramework.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(new MenuInventoryListener(), plugin);
    }

    public static HashMap<ItemStack, HashSet<Action>> getButtonActionMap() {
        return BUTTON_ACTION_MAP;
    }

    public static HashMap<InventoryHolder, HashSet<Action>> getMenuActionMap() {
        return MENU_ACTION_MAP;
    }
}
