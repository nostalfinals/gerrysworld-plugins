package xyz.garslity093.gerrysworld.wbadditions;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class WbAdditionsPlugin extends JavaPlugin{

    private static int wbExtendCycle;

    private static int wbExtendSize;

    private static List<World> worlds;

    private static double perMinExtend;

    /*获取插件主类实例*/
    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(WbAdditionsPlugin.class);
    }

    /*插件启动方法*/
    @Override
    public void onEnable() {
        saveDefaultConfig();

        /*读取配置*/
        wbExtendCycle = getConfig().getInt("settings.cycle");
        wbExtendSize = getConfig().getInt("settings.extendSize");
        for (String s : getConfig().getStringList("settings.worlds")) {
            if (Bukkit.getWorld(s) != null) {
                worlds.add(Bukkit.getWorld("s"));
            }else {
                getLogger().severe(s + " 不是一个有效的世界名称！");
            }
        }

        /*计算每分钟需要扩展的大小*/
        perMinExtend = (double) wbExtendCycle/wbExtendSize;

        /*开启扩展任务*/
        new WbExtendRunnable(this);
    }

    /*一周期时间 Getter*/
    public static int getWbExtendCycle() {
        return wbExtendCycle;
    }

    /*一周期扩展量 Getter*/
    public static int getWbExtendSize() {
        return wbExtendSize;
    }

    /*每分钟扩展量 Getter*/
    public static double getPerMinExtend() {
        return perMinExtend;
    }

    /*需要处理的世界列表 Getter*/
    public static List<World> getWorlds() {
        return worlds;
    }

    /*重载插件*/
    public static void reload() {
        wbExtendCycle = WbAdditionsPlugin.getInstance().getConfig().getInt("settings.cycle");
        wbExtendSize = WbAdditionsPlugin.getInstance().getConfig().getInt("settings.extendSize");
        for (String s : WbAdditionsPlugin.getInstance().getConfig().getStringList("settings.worlds")) {
            if (Bukkit.getWorld(s) != null) {
                worlds.add(Bukkit.getWorld("s"));
            }else {
                WbAdditionsPlugin.getInstance().getLogger().severe(s + " 不是一个有效的世界名称！");
            }
        }
        perMinExtend = (double) wbExtendCycle/wbExtendSize;
    }
}