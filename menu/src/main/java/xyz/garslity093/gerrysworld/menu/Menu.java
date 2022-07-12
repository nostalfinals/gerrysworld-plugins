package xyz.garslity093.gerrysworld.menu;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Menu
 * @author: GerryYuu
 * @date: 7/12/2022 5:07 PM
 */

public abstract class Menu {
    private Inventory bukkitInventory;

    private InventoryType bukkitInventoryType;

    public Menu(Inventory bukkitInventory, InventoryType bukkitInventoryType) {
        this.bukkitInventory = bukkitInventory;
        this.bukkitInventoryType = bukkitInventoryType;
    }
}
