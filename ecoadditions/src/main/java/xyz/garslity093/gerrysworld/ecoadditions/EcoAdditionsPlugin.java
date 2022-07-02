package xyz.garslity093.gerrysworld.ecoadditions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class EcoAdditionsPlugin extends JavaPlugin{

    private static ItemStack coinItemStack;

    /*获取插件主类实例*/
    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(EcoAdditionsPlugin.class);
    }

    /*初始化货币物品堆*/
    public void initCoinItemStack() {
        coinItemStack = new ItemStack(Material.SUNFLOWER, 1);
        ItemMeta coinItemMeta = coinItemStack.getItemMeta();
        coinItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l货币"));
        coinItemMeta.setUnbreakable(true);
        coinItemMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        coinItemStack.setItemMeta(coinItemMeta);
    }

    /*货币物品堆 Getter*/
    public static ItemStack getCoinItemStack() {
        return coinItemStack;
    }

    /*插件启动方法*/
    @Override
    public void onEnable() {
        saveDefaultConfig();
        initCoinItemStack();
    }

}
