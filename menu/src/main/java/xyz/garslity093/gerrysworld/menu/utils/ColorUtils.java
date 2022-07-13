package xyz.garslity093.gerrysworld.menu.utils;

import org.bukkit.ChatColor;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.utils
 * @className: ColorUtils
 * @author: GerryYuu
 * @date: 7/13/2022 3:49 PM
 */

public class ColorUtils {
    private ColorUtils() {
    }

    public static String parseColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
