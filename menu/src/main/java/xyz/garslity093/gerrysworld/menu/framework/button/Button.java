package xyz.garslity093.gerrysworld.menu.framework.button;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.menu.framework.MenuFramework;
import xyz.garslity093.gerrysworld.menu.framework.action.Action;
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
    public List<Action> actions = new ArrayList<>();
    public List<String> actionJsons = new ArrayList<>();
    public ItemStack itemStack;

    public Button() {
        System.out.println("new action jsons");
        itemStack = new ItemStack(Material.AIR, 1);
    }

    public Button addAction(Action action) {
        System.out.println(action);
        System.out.println(MenuFramework.getGson().toJson(action));
        actions.add(action);
        actionJsons.add(MenuFramework.getGson().toJson(action));
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setString("clickActions", MenuFramework.getGson().toJson(actionJsons));
        //System.out.println("add action: " + action);
        //.out.println("aj " + actionJsons);
        //System.out.println(MenuFramework.getGson().toJson(actions));
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