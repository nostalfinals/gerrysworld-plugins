package xyz.garslity093.gerrysworld.wbadditions;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class WbExtendRunnable extends BukkitRunnable {
    @Override
    public void run() {
        for (World world : WbAdditionsPlugin.getWorlds()) {
            world.getWorldBorder().setSize(world.getWorldBorder().getSize() + WbAdditionsPlugin.getPerSecExtend());
        }
    }

    public WbExtendRunnable(JavaPlugin javaPlugin) {
        runTaskTimer(javaPlugin, 0L, WbAdditionsPlugin.getWbExtendCycle()* 60L * 20L);
    }
}