package xyz.garslity093.gerrysworld.ecoadditions.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import xyz.garslity093.gerrysworld.ecoadditions.EcoAdditionsPlugin;

import java.io.File;

/*配置文件相关工具类*/
public final class ConfigUtils {

    private static FileConfiguration defaultConfig = EcoAdditionsPlugin.getInstance().getConfig();

    /*私有修饰 防止被实例化*/
    private ConfigUtils() {
    }

    /*获取配置文件里有没有自定义一种生物的掉落机会*/
    public static boolean containsCustomMobSetting(EntityType entityType) {
        return defaultConfig().getConfigurationSection("mobCoinDropping.settingsForPerMob").getKeys(false).contains(entityType.name().toLowerCase());
    }

    /*获取默认掉落机会*/
    public static DropChance getDefaultDropChance() {
        return new DropChance(defaultConfig.getDouble("mobCoinDropping.defaultCoinDrops.chance"),
                defaultConfig.getDouble("mobCoinDropping.defaultCoinDrops.min"),
                defaultConfig.getDouble("mobCoinDropping.defaultCoinDrops.max"));
    }

    /*获取一种生物的自定义掉落机会*/
    public static DropChance getEntityDropChance(EntityType entityType) {
        if (containsCustomMobSetting(entityType)) {
            return new DropChance(defaultConfig.getDouble("mobCoinDropping.settingsForPerMob." + entityType.name().toLowerCase() + ".chance"),
                    defaultConfig.getDouble("mobCoinDropping.settingsForPerMob." + entityType.name().toLowerCase() + ".min"),
                    defaultConfig.getDouble("mobCoinDropping.settingsForPerMob." + entityType.name().toLowerCase() + ".max"));
        }
        return getDefaultDropChance();
    }

    /*获取默认配置文件实例*/
    public static FileConfiguration defaultConfig() {
        return defaultConfig;
    }

    public static void reloadConfig() {
        defaultConfig = YamlConfiguration.loadConfiguration(new File(EcoAdditionsPlugin.getInstance().getDataFolder(), "config.yml"));
    }
}