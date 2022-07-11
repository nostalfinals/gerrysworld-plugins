package xyz.garslity093.gerrysworld.wbadditions;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public final class WbAdditionsPlugin extends JavaPlugin {

    private static int wbExtendCycle;

    private static int wbExtendSize;

    private static List<World> worlds;

    private static double perSecExtend;

    private static BukkitTask task;

    /*获取插件主类实例*/
    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(WbAdditionsPlugin.class);
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
    public static double getPerSecExtend() {
        return perSecExtend;
    }

    /*设置每秒钟扩展量*/
    private static void setPerSecExtend(double d) {
        perSecExtend = d;
    }

    /*需要处理的世界列表 Getter*/
    public static List<World> getWorlds() {
        return worlds;
    }

    /*重载插件*/
    public static void load() {
        WbAdditionsPlugin.getInstance().getServer().getScheduler().cancelTasks(WbAdditionsPlugin.getInstance());
        /*读取配置*/
        wbExtendCycle = WbAdditionsPlugin.getInstance().getConfig().getInt("settings.cycle");
        wbExtendSize = WbAdditionsPlugin.getInstance().getConfig().getInt("settings.extendSize");

        for (String s : WbAdditionsPlugin.getInstance().getConfig().getStringList("settings.worlds")) {
            if (Bukkit.getWorld(s) != null) {
                worlds.add(Bukkit.getWorld(s));
            } else {
                WbAdditionsPlugin.getInstance().getLogger().severe(s + " 不是一个有效的世界名称！");
            }
        }

        /*计算每秒需要扩展的大小*/
        setPerSecExtend((double) wbExtendSize / wbExtendCycle / 60 / 20);

        /*开启计划任务*/
        task = new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() > 0) {
                    for (World world : getWorlds()) {
                        world.getWorldBorder().setSize(world.getWorldBorder().getSize() + perSecExtend);
                    }
                }
            }
        }.runTaskTimer(WbAdditionsPlugin.getInstance(), 0L, 1L);
    }

    /*Bukkit任务 Getter*/
    public static BukkitTask getTask() {
        return task;
    }

    /*插件启动方法*/
    @Override
    public void onEnable() {
        worlds = new ArrayList<>();
        saveDefaultConfig();
        getServer().getPluginCommand("wbadditions").setExecutor(new Command());
        getServer().getPluginCommand("wbadditions").setTabCompleter(new Command());

        /*加载计划任务*/
        load();
    }
}