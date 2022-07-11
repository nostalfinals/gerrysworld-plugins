package xyz.garslity093.gerrysworld.motd;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import xyz.yuu8583.hitokoto4j.Hitokoto;
import xyz.yuu8583.hitokoto4j.HitokotoBuilder;
import xyz.yuu8583.hitokoto4j.HitokotoResponse;
import xyz.yuu8583.hitokoto4j.HitokotoType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @packageName: xyz.garslity093.gerrysworld.motd
 * @className: MotdPlugin
 * @author: GerryYuu
 * @date: 7/11/2022 7:50 PM
 */

public class MotdPlugin extends JavaPlugin {

    /*插件主类实例*/
    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(MotdPlugin.class);
    }

    /*Hitokoto 请求任务*/
    private static BukkitTask hitokotoGettingTask;

    private static List<String> hitokotos;

    private static final Hitokoto HITOKOTO = new HitokotoBuilder().addType(HitokotoType.LITERATURE).addType(HitokotoType.POETRY).addType(HitokotoType.PHILOSOPHY).setMaxLength(20).build();

    /*插件启动方法*/
    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        hitokotos = new ArrayList<>();

        getLogger().info("获取完成。");

        hitokotoGettingTask = new BukkitRunnable() {
            @Override
            public void run() {
                get20HitokotosAndStoreThemIn(hitokotos);
            }
        }.runTaskTimerAsynchronously(this,0L, 20L * 60L * 20L);

    }

    public static void get20HitokotosAndStoreThemIn(List<String> targetList) {
        targetList.clear();
        for (int i = 0; i < 20; i++) {
            HitokotoResponse hitokotoResponse = HITOKOTO.request();
            if (hitokotoResponse.getFromWho() == null) {
                targetList.add(hitokotoResponse.getHitokoto() + "   ——未知");
            }else {
                targetList.add(hitokotoResponse.getHitokoto() + "   ——" + hitokotoResponse.getFromWho());
            }
            try {
                MotdPlugin.getInstance().getLogger().info("计划任务: 正在进行第 " + i + " 条 Hitokoto 的获取...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        MotdPlugin.getInstance().getLogger().info("获取完成。");
    }

    public static List<String> getHitokotos() {
        return hitokotos;
    }
}