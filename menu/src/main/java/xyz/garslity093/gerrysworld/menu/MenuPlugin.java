package xyz.garslity093.gerrysworld.menu;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.garslity093.gerrysworld.menu.framework.MenuFramework;
import xyz.garslity093.gerrysworld.menu.framework.menu.MenuInventoryListener;

public final class MenuPlugin extends JavaPlugin {


    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(MenuPlugin.class);
    }


    @Override
    public void onEnable() {
        new MenuFramework(this);
        getServer().getPluginManager().registerEvents(new MenuInventoryListener(), this);
        getServer().getPluginCommand("menuplugin").setExecutor(new Command());
    }
}
