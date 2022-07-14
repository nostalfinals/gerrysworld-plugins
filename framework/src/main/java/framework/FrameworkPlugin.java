package framework;

import framework.hologram.HologramFramework;
import framework.menu.MenuFramework;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @packageName: framework
 * @className: FrameworkPlugin
 * @author: GerryYuu
 * @date: 7/15/2022 12:58 AM
 */

public class FrameworkPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        new MenuFramework(this);
        new HologramFramework(this);
    }
}
