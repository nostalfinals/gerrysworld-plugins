package xyz.garslity093.gerrysworld.ecoadditions;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.garslity093.gerrysworld.ecoadditions.commands.EcoAdditionsCommand;
import xyz.garslity093.gerrysworld.ecoadditions.listeners.PlayerListener;

import java.util.ArrayList;
import java.util.List;

public final class EcoAdditionsPlugin extends JavaPlugin{

    private static ItemStack coinItemStack;

    private static Economy eco;

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

    /*货币物品堆 Getter*/
    public static ItemStack getCoinItemStack(double amount) {
        ItemStack itemStackCopy = coinItemStack.clone();
        ItemMeta coinItemMeta = coinItemStack.getItemMeta();
        List<String> loreList = new ArrayList<>();
        loreList.add(ChatColor.translateAlternateColorCodes('&', "&fx " + amount));
        coinItemMeta.setLore(loreList);
        itemStackCopy.setItemMeta(coinItemMeta);
        NBTItem nbtItem = new NBTItem(itemStackCopy);
        NBTCompound nbtCompound = nbtItem.addCompound("value");
        nbtCompound.setDouble("amount", amount);
        return nbtItem.getItem();
    }

    /*Vault API 经济API实例 Getter*/
    public static Economy getEco() {
        return eco;
    }

    public static double getCoinAmountFromItemStack(ItemStack coinItemStack) {
        ItemMeta meta = coinItemStack.getItemMeta();
        if (meta.getLore() != null) {
            ArrayList<String> lore = (ArrayList<String>) meta.getLore();
            if (lore.size() == 1 && meta.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&e&l货币"))) {
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
        initEconomy();

        /*注册指令*/
        Bukkit.getPluginCommand("ecoadditions").setExecutor(new EcoAdditionsCommand());
        Bukkit.getPluginCommand("ecoadditions").setTabCompleter(new EcoAdditionsCommand());

        /*注册事件*/
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }
}