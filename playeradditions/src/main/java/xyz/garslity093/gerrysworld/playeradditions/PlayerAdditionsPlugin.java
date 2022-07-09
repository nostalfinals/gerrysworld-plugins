package xyz.garslity093.gerrysworld.playeradditions;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerAdditionsPlugin extends JavaPlugin {

    /*主类实例*/
    public static final JavaPlugin INSTANCE = JavaPlugin.getPlugin(PlayerAdditionsPlugin.class);

    /*插件启动方法*/
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

}
