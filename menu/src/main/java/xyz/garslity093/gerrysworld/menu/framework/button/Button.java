package xyz.garslity093.gerrysworld.menu.framework.button;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.menu.framework.MenuFramework;
import xyz.garslity093.gerrysworld.menu.framework.action.Action;
import xyz.garslity093.gerrysworld.menu.framework.action.ButtonAction;
import xyz.garslity093.gerrysworld.menu.framework.utils.ButtonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Button
 * @author: GerryYuu
 * @date: 7/12/2022 4:51 PM
 */

public class Button {
    private final List<Action> actions;
    private ItemStack itemStack;

    public Button() {
        actions = new ArrayList<>();
        itemStack = new ItemStack(Material.AIR, 1);
    }

    public Button addAction(ButtonAction action) {
        actions.add(action);
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.getCompound("menu").setString("actions", MenuFramework.getGson().toJson(actions));
        itemStack = nbtItem.getItem();
        return this;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Button setItemStack(ItemStack itemStack) {
        this.itemStack = ButtonUtils.convertToButtonItem(itemStack);
        return this;
    }
}