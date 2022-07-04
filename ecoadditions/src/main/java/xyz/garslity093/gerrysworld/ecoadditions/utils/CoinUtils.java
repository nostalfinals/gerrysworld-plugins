package xyz.garslity093.gerrysworld.ecoadditions.utils;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/*游戏内货币相关工具类*/
public final class CoinUtils {
    /*私有修饰 防止被实例化*/
    private CoinUtils() {
    }

    /*从货币物品堆获取货币数量*/
    public static double getCoinAmountFromItemStack(ItemStack coinItemStack) {
        ItemMeta meta = coinItemStack.getItemMeta();
        if (meta.getLore() != null) {
            ArrayList<String> lore = (ArrayList<String>) meta.getLore();
            if (lore.size() == 1 && meta.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&e&l货币"))) {
                NBTItem nbtapi = new NBTItem(coinItemStack);
                NBTCompound nbtCompound = nbtapi.getCompound("value");
                return nbtCompound.getDouble("amount");
            }
        }
        return 0;
    }

    /*生成指定金额的货币物品堆*/
    public static ItemStack getCoinItemStack(double amount) {
        ItemStack coinItemStack = new ItemStack(Material.SUNFLOWER, 1);
        ItemMeta coinItemMeta = coinItemStack.getItemMeta();
        coinItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l货币"));
        coinItemMeta.setUnbreakable(true);
        coinItemMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        coinItemStack.setItemMeta(coinItemMeta);
        List<String> loreList = new ArrayList<>();
        loreList.add(ChatColor.translateAlternateColorCodes('&', "&fx " + amount));
        coinItemMeta.setLore(loreList);
        coinItemStack.setItemMeta(coinItemMeta);
        NBTItem nbtItem = new NBTItem(coinItemStack);
        NBTCompound nbtCompound = nbtItem.addCompound("value");
        nbtCompound.setDouble("amount", amount);
        return nbtItem.getItem();
    }
}
