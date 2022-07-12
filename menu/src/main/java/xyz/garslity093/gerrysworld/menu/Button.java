package xyz.garslity093.gerrysworld.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Button
 * @author: GerryYuu
 * @date: 7/12/2022 4:51 PM
 */

public abstract class Button {
    abstract void onClick(Player player, ClickType clickType);
}
