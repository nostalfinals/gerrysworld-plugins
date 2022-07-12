package xyz.garslity093.gerrysworld.menu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: PlayerListener
 * @author: GerryYuu
 * @date: 7/12/2022 5:56 PM
 */

public final class PlayerListener implements Listener {
    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent event) {
        if (Button.isMenuButtonItem(event.getCurrentItem())) {
            event.setCancelled(true);
        }
    }
}
