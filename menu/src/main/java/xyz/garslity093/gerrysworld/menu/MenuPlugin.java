package xyz.garslity093.gerrysworld.menu;

import org.bukkit.plugin.java.JavaPlugin;

public final class MenuPlugin extends JavaPlugin {


    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(MenuPlugin.class);
    }

    @Override
    public void onEnable() {
        getServer().getPluginCommand("menu").setExecutor(new MenuCommand());
    }
}
