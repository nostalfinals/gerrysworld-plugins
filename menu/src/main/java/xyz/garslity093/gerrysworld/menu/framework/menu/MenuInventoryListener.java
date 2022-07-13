package xyz.garslity093.gerrysworld.menu.framework.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.menu.framework.MenuFramework;
import xyz.garslity093.gerrysworld.menu.framework.action.Action;
import xyz.garslity093.gerrysworld.menu.framework.action.ButtonAction;
import xyz.garslity093.gerrysworld.menu.framework.action.MenuAction;
import xyz.garslity093.gerrysworld.menu.framework.action.MenuActionType;
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

        if (event.getClickedInventory().getHolder() instanceof Player) {
            if (event.getView().getTopInventory().getHolder() instanceof MenuInventoryHolder) {
                event.setCancelled(true);
            }
        }

        if (!(event.getClickedInventory().getHolder() instanceof MenuInventoryHolder)) return;
        if (event.getCurrentItem() == null) return;
        if (!ButtonUtils.isMenuButtonItem(event.getCurrentItem())) return;

        event.setCancelled(true);

        ItemStack itemStack = event.getCurrentItem();

        for (Action action : MenuFramework.getButtonActionMap().get(itemStack)) {
            if (action instanceof ButtonAction) {
                ButtonAction buttonAction = (ButtonAction) action;
                if (buttonAction.getClickTypes().contains(event.getClick())) {
                    buttonAction.on(player);
                }
            }
        }
    }

    @EventHandler
    public void inventoryOpenEvent(InventoryOpenEvent event) {
        if (!(event.getPlayer() instanceof Player)) return;
        ;

        Player player = (Player) event.getPlayer();

        if (event.getInventory().getHolder() == null) return;

        InventoryHolder inventoryHolder = event.getInventory().getHolder();

        if (!MenuFramework.getMenuActionMap().containsKey(inventoryHolder)) return;

        for (Action action : MenuFramework.getMenuActionMap().get(inventoryHolder)) {
            if (action instanceof MenuAction) {
                MenuAction menuAction = (MenuAction) action;
                if (menuAction.getMenuActionTypes().contains(MenuActionType.OPEN)) {
                    action.on(player);
                }
            }
        }
    }

    @EventHandler
    public void inventoryCloseEvent(InventoryCloseEvent event) {
        if (!(event.getPlayer() instanceof Player)) return;
        ;

        Player player = (Player) event.getPlayer();

        if (event.getInventory().getHolder() == null) return;

        InventoryHolder inventoryHolder = event.getInventory().getHolder();

        if (!MenuFramework.getMenuActionMap().containsKey(inventoryHolder)) return;

        for (Action action : MenuFramework.getMenuActionMap().get(inventoryHolder)) {
            if (action instanceof MenuAction) {
                MenuAction menuAction = (MenuAction) action;
                if (menuAction.getMenuActionTypes().contains(MenuActionType.CLOSE)) {
                    action.on(player);
                }
            }
        }
    }
}