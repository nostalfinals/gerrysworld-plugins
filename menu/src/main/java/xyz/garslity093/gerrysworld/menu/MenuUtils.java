package xyz.garslity093.gerrysworld.menu;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: MenuUtils
 * @author: GerryYuu
 * @date: 7/12/2022 4:54 PM
 */

public class MenuUtils {
    public MenuUtils() {
    }

    public static ItemStack convertToButtonItem(ItemStack stack) {
        NBTItem nbtItem = new NBTItem(stack);
        nbtItem.setBoolean("isMenuButtonItem", true);
        return nbtItem.getItem();
    }
}
