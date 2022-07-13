package xyz.garslity093.gerrysworld.menu.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import xyz.garslity093.gerrysworld.menu.framework.action.ButtonAction;
import xyz.garslity093.gerrysworld.menu.framework.action.MenuAction;
import xyz.garslity093.gerrysworld.menu.framework.action.MenuActionType;
import xyz.garslity093.gerrysworld.menu.framework.button.Button;
import xyz.garslity093.gerrysworld.menu.framework.button.ItemStackBuilder;
import xyz.garslity093.gerrysworld.menu.framework.menu.types.LargeChestMenu;
import xyz.garslity093.gerrysworld.menu.utils.ColorUtils;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.menus
 * @className: MainMenu
 * @author: GerryYuu
 * @date: 7/13/2022 3:45 PM
 */

public class MainMenu extends LargeChestMenu {
    public MainMenu() {
        super(ColorUtils.parseColor("服务器菜单 &l(正在开发中)"));
        this.addAction(
                        new MenuAction() {
                            @Override
                            public void on(Player player) {
                                player.playSound(player, Sound.BLOCK_IRON_DOOR_OPEN, 1F, 2F);
                            }
                        }.addMenuActionType(MenuActionType.OPEN)
                )
                .setPattern("         ", "         ", "  AB     ", "         ", "         ", "        X")
                .addButton('X', new Button()
                        .setItemStack(
                                new ItemStackBuilder()
                                        .setMaterial(Material.RED_STAINED_GLASS_PANE)
                                        .setName(ColorUtils.parseColor("&c关闭"))
                                        .addLore(ColorUtils.parseColor("&7下次再见哦！"))
                                        .addLore(" ")
                                        .addLore(ColorUtils.parseColor("&e左键点击。"))
                                        .build()
                        )
                        .addAction(
                                new ButtonAction() {
                                    @Override
                                    public void on(Player player) {
                                        player.closeInventory();
                                        player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                    }
                                }.addClickType(ClickType.LEFT)
                        )
                )
                .addButton('A', new Button()
                        .setItemStack(
                                new ItemStackBuilder()
                                        .setMaterial(Material.ENDER_PEARL)
                                        .setName(ColorUtils.parseColor("&e传送"))
                                        .addLore(ColorUtils.parseColor("&7传送到其他玩家，家，亦或是领地。"))
                                        .addLore(" ")
                                        .addLore(ColorUtils.parseColor("&e左键点击。"))
                                        .build()
                        )
                        .addAction(
                                new ButtonAction() {
                                    @Override
                                    public void on(Player player) {
                                        player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                    }
                                }.addClickType(ClickType.LEFT)
                        )
                )
                .addButton('B', new Button()
                        .setItemStack(
                                new ItemStackBuilder()
                                        .setMaterial(Material.CHEST)
                                        .setName(ColorUtils.parseColor("&6商店"))
                                        .addLore(ColorUtils.parseColor("&7打开服务器商店。"))
                                        .addLore(" ")
                                        .addLore(ColorUtils.parseColor("&e左键点击。"))
                                        .build()
                        )
                        .addAction(
                                new ButtonAction() {
                                    @Override
                                    public void on(Player player) {
                                        player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                    }
                                }.addClickType(ClickType.LEFT)
                        )
                );
    }
}