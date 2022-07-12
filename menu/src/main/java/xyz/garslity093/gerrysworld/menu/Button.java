package xyz.garslity093.gerrysworld.menu;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Button
 * @author: GerryYuu
 * @date: 7/12/2022 4:51 PM
 */

public class Button {
    private final List<Action> ACTIONS = new ArrayList<>();
    private ItemStack itemStack;

    public Button() {
        itemStack = new ItemStack(Material.AIR, 1);
    }

    public static ItemStack convertToButtonItem(ItemStack itemStack) {
        NBTItem nbtItem = new NBTItem(itemStack);
        NBTCompound nbtCompound = nbtItem.addCompound("menu");
        nbtCompound.setBoolean("isMenuItem", true);
        return nbtItem.getItem();
    }

    public static boolean isMenuButtonItem(ItemStack itemStack) {
        NBTItem nbtItem = new NBTItem(itemStack);
        if (nbtItem.getCompound("menu") != null) {
            return nbtItem.getCompound("menu").getBoolean("isMenuItem");
        }
        return false;
    }

    public Button addAction(Action action) {
        ACTIONS.add(action);
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.getCompound("menu").setObject("actions", ACTIONS);
        itemStack = nbtItem.getItem();
        return this;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Button setItemStack(ItemStack itemStack) {
        this.itemStack = convertToButtonItem(itemStack);
        return this;
    }
}