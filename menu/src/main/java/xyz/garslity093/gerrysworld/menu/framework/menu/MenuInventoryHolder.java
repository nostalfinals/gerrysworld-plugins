package xyz.garslity093.gerrysworld.menu.framework.menu;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.UUID;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: MenuInventoryHolder
 * @author: GerryYuu
 * @date: 7/12/2022 6:04 PM
 */

public class MenuInventoryHolder implements InventoryHolder {
    private final UUID MENU_UUID = UUID.randomUUID();

    @Override
    public Inventory getInventory() {
        return null;
    }
}
