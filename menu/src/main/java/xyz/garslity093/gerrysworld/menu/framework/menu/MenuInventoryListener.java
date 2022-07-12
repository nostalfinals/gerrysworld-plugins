package xyz.garslity093.gerrysworld.menu.framework.menu;

import com.google.common.reflect.TypeToken;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.menu.framework.MenuFramework;
import xyz.garslity093.gerrysworld.menu.framework.action.Action;
import xyz.garslity093.gerrysworld.menu.framework.action.ButtonAction;
import xyz.garslity093.gerrysworld.menu.framework.utils.ButtonUtils;
import xyz.garslity093.gerrysworld.menu.framework.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

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
                    /*确保点击的物品不是null*/
                    if (event.getCurrentItem() != null) {
                        /*确保点击的是按钮物品*/
                        if (ButtonUtils.isMenuButtonItem(event.getCurrentItem())) {
                            event.setCancelled(true);
                            //System.out.println(1);
                            ItemStack itemStack = event.getCurrentItem();
                            NBTItem nbtItem = new NBTItem(itemStack);
                            String jsonString = nbtItem.getString("clickActions");
                            System.out.println(jsonString);
                            List<String> actionJsons = JsonUtils.fromJsonToList(jsonString, String.class);
                            List<Action> actions = new ArrayList<>();
                            for (String s : actionJsons) {
                                System.out.println("s: " + s);
                                actions.add(MenuFramework.getGson().fromJson(s, Action.class));
                            }
                            //System.out.println(actions);
                            for (Action action : actions) {
                                //System.out.println(action);
                                if (action instanceof ButtonAction) {
                                    //System.out.println(1);
                                    ButtonAction buttonAction = (ButtonAction) action;
                                    if (buttonAction.getClickTypes().contains(event.getClick())) {
                                        buttonAction.on(player);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}