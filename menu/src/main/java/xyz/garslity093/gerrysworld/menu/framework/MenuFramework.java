package xyz.garslity093.gerrysworld.menu.framework;

import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.framework
 * @className: MenuFramework
 * @author: GerryYuu
 * @date: 7/12/2022 9:08 PM
 */

public record MenuFramework(JavaPlugin plugin) {
    private static final Gson GSON = new Gson();


    public static Gson getGson() {
        return GSON;
    }
}
