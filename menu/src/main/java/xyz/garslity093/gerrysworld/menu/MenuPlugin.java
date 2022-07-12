package xyz.garslity093.gerrysworld.menu;

import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

public final class MenuPlugin extends JavaPlugin {

    private static final Gson GSON = new Gson();

    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(MenuPlugin.class);
    }

    public static Gson getGson() {
        return GSON;
    }

    @Override
    public void onEnable() {

    }
}
