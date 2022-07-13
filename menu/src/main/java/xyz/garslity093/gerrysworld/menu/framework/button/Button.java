package xyz.garslity093.gerrysworld.menu.framework.button;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.menu.framework.MenuFramework;
import xyz.garslity093.gerrysworld.menu.framework.action.Action;
import xyz.garslity093.gerrysworld.menu.framework.utils.ButtonUtils;

import java.util.HashSet;
import java.util.UUID;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Button
 * @author: GerryYuu
 * @date: 7/12/2022 4:51 PM
 */

public class Button {
    private final UUID uuid;
    private final HashSet<Action> ACTIONS = new HashSet<>();
    private ItemStack itemStack;

    public Button() {
        uuid = UUID.randomUUID();
        itemStack = new ItemStack(Material.STONE, 1);
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setUUID("buttonUUID", uuid);
    }

    public Button addAction(Action action) {
        ACTIONS.add(action);
        MenuFramework.getButtonActionMap().put(itemStack, ACTIONS);
        return this;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Button setItemStack(ItemStack itemStack) {
        this.itemStack = ButtonUtils.addUuid(ButtonUtils.convertToButtonItem(itemStack), uuid);
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }
}