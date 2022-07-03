package xyz.garslity093.gerrysworld.ecoadditions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.garslity093.gerrysworld.ecoadditions.commands.EcoAdditionsCommand;

import java.util.ArrayList;
import java.util.List;

public final class EcoAdditionsPlugin extends JavaPlugin{

    private static ItemStack coinItemStack;

    /*获取插件主类实例*/
    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(EcoAdditionsPlugin.class);
    }

    /*初始化货币物品堆*/
    private void initCoinItemStack() {
        coinItemStack = new ItemStack(Material.SUNFLOWER, 1);
        ItemMeta coinItemMeta = coinItemStack.getItemMeta();
        coinItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l货币"));
        coinItemMeta.setUnbreakable(true);
        coinItemMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        coinItemStack.setItemMeta(coinItemMeta);
    }

    /*货币物品堆 Getter*/
    public static ItemStack getCoinItemStack(double amount) {
        ItemMeta coinItemMeta = coinItemStack.getItemMeta();
        List<String> loreList = new ArrayList<>();
        loreList.add(ChatColor.translateAlternateColorCodes('&', "&fx " + amount));
        coinItemMeta.setLore(loreList);
        ItemStack patchedCoinItemMeta = coinItemStack.clone();
        patchedCoinItemMeta.setItemMeta(coinItemMeta);
        return patchedCoinItemMeta;
    }

    public static double getCoinAmountFromItemStack(ItemStack coinItemStack) {
        ItemMeta meta = coinItemStack.getItemMeta();
        if (meta.getLore() != null) {
            ArrayList<String> lore = (ArrayList<String>) meta.getLore();
            if (lore.size() == 1 && meta.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&e货币"))) {
                String amountLine = lore.get(0);
                if (amountLine.contains(" ") && amountLine.contains("x")) {
                    double amount = Double.parseDouble(amountLine.substring(amountLine.indexOf(" ") + 1, amountLine.length() - 1));
                }
            }
        }
        return 0;
    }

    /*插件启动方法*/
    @Override
    public void onEnable() {
        saveDefaultConfig();
        initCoinItemStack();
        /*注册指令*/
        Bukkit.getPluginCommand("ecoadditions").setExecutor(new EcoAdditionsCommand());
        Bukkit.getPluginCommand("ecoadditions").setTabCompleter(new EcoAdditionsCommand());
    }
}
