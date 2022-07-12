package xyz.garslity093.gerrysworld.menu.framework.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.menu.framework.MenuFramework;
import xyz.garslity093.gerrysworld.menu.framework.action.Action;
import xyz.garslity093.gerrysworld.menu.framework.action.ButtonAction;
import xyz.garslity093.gerrysworld.menu.framework.utils.ButtonUtils;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: PlayerListener
 * @author: GerryYuu
 * @date: 7/12/2022 5:56 PM
 */

public final class MenuInventoryListener implements Listener {
    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent event) {

        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory() == null) return;

        if (!(event.getClickedInventory().getHolder() instanceof MenuInventoryHolder)) return;
        if (event.getCurrentItem() == null) return;
        if (!ButtonUtils.isMenuButtonItem(event.getCurrentItem())) return;

        event.setCancelled(true);

        ItemStack itemStack = event.getCurrentItem();

        for (Action action : MenuFramework.getActionsMap().get(itemStack)) {
            if (action instanceof ButtonAction) {
                ButtonAction buttonAction = (ButtonAction) action;
                if (buttonAction.getClickTypes().contains(event.getClick())) {
                    buttonAction.on(player);
                    return;
                }
            }
        }
    }
}