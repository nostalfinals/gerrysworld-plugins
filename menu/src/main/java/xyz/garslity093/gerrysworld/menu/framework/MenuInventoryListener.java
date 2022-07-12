package xyz.garslity093.gerrysworld.menu.framework;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
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
        /*确保点击者是玩家*/
        if (event.getWhoClicked() instanceof Player) {
            Player player = ((Player) event.getWhoClicked());
            /*确保点击的物品栏不是null*/
            if (event.getClickedInventory() != null) {
                /*确保点击的是插件创建的物品栏*/
                if (event.getClickedInventory().getHolder() instanceof MenuInventoryHolder) {
                    /*确保点击的是按钮物品*/
                    if (ButtonUtils.isMenuButtonItem(event.getCurrentItem())) {

                    }
                }
            }
        }
    }
}