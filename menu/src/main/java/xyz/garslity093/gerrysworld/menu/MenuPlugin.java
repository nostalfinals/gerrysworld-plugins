package xyz.garslity093.gerrysworld.menu;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.garslity093.gerrysworld.menu.framework.MenuFramework;
import xyz.garslity093.gerrysworld.menu.menus.MenuManager;

public final class MenuPlugin extends JavaPlugin {


    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(MenuPlugin.class);
    }

    @Override
    public void onEnable() {
        new MenuFramework(this);
        new MenuManager();

        //getServer().getPluginCommand("menuplugin").setExecutor(new MenuCommand());
        getServer().getPluginCommand("menu").setExecutor(new MenuCommand());
        MenuFramework.printStats();
    }
}
