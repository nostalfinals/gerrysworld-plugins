package xyz.garslity093.gerrysworld.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.action
 * @className: WindowAction
 * @author: GerryYuu
 * @date: 7/12/2022 5:33 PM
 */

public abstract class Action {
    private ClickType clickType;

    public ClickType getClickType() {
        return clickType;
    }

    public Action setClickType(ClickType clickType) {
        this.clickType = clickType;
        return this;
    }

    abstract void on(Player player);
}
