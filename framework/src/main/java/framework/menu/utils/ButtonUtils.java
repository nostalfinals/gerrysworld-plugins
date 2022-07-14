package framework.menu.utils;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.utils
 * @className: ButtonUtils
 * @author: GerryYuu
 * @date: 7/12/2022 9:06 PM
 */

public final class ButtonUtils {
    public ButtonUtils() {
    }

    public static ItemStack convertToButtonItem(ItemStack itemStack) {
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setBoolean("isMenuItem", true);
        return nbtItem.getItem();
    }

    public static boolean isMenuButtonItem(ItemStack itemStack) {
        NBTItem nbtItem = new NBTItem(itemStack);
        return nbtItem.getBoolean("isMenuItem");
    }

    public static ItemStack addUuid(ItemStack itemStack, UUID uuid) {
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setUUID("buttonUUID", uuid);
        return nbtItem.getItem();
    }

    public static UUID getUUID(ItemStack itemStack) {
        return new NBTItem(itemStack).getUUID("buttonUUID");
    }
}
