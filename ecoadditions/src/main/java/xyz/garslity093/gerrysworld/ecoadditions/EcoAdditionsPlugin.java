package xyz.garslity093.gerrysworld.ecoadditions;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.garslity093.gerrysworld.ecoadditions.commands.EcoAdditionsCommand;
import xyz.garslity093.gerrysworld.ecoadditions.listeners.EntityListener;
import xyz.garslity093.gerrysworld.ecoadditions.listeners.PlayerListener;

public final class EcoAdditionsPlugin extends JavaPlugin {
    private static Economy eco;

    /*获取插件主类实例*/
    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(EcoAdditionsPlugin.class);
    }

    /*Vault API 经济API实例 Getter*/
    public static Economy getEco() {
        return eco;
    }

    /*设置经济接口  - Vault API*/
    private void initEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return;
        }
        eco = rsp.getProvider();
    }

    /*插件启动方法*/
    @Override
    public void onEnable() {
        saveDefaultConfig();
        initEconomy();

        /*注册指令*/
        Bukkit.getPluginCommand("ecoadditions").setExecutor(new EcoAdditionsCommand());
        Bukkit.getPluginCommand("ecoadditions").setTabCompleter(new EcoAdditionsCommand());

        /*注册事件*/
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
    }
}