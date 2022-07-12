package xyz.garslity093.gerrysworld.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.menu.framework.action.ButtonAction;
import xyz.garslity093.gerrysworld.menu.framework.button.Button;
import xyz.garslity093.gerrysworld.menu.framework.button.ItemStackBuilder;
import xyz.garslity093.gerrysworld.menu.framework.menu.Menu;
import xyz.garslity093.gerrysworld.menu.framework.menu.types.ChestMenu;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Command
 * @author: GerryYuu
 * @date: 7/12/2022 7:56 PM
 */

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Menu menu = new ChestMenu(">>> 测试");
        menu.setPattern("#########", "#A#B#C#D#", "#######TX")
                .addButton('T',
                        new Button()
                                .setItemStack(new ItemStack(Material.RED_STAINED_GLASS_PANE, 1))
                                .addAction(
                                        new ButtonAction() {
                                            @Override
                                            public void on(Player player) {
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c222。"));
                                                player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                            }
                                        }.addClickType(ClickType.LEFT)
                                ))
                .addButton('X',
                        new Button()
                                .setItemStack(new ItemStack(Material.RED_STAINED_GLASS_PANE, 1))
                                .addAction(
                                        new ButtonAction() {
                                            @Override
                                            public void on(Player player) {
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c你关闭了菜单。"));
                                                player.closeInventory();
                                                player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                            }
                                        }.addClickType(ClickType.LEFT)
                                ))
                .addButton('D',
                        new Button()
                                .setItemStack(
                                        new ItemStackBuilder()
                                                .setMaterial(Material.PLAYER_HEAD)
                                                .setName(ChatColor.translateAlternateColorCodes('&', "&e啦啦啦！"))
                                                .setSkullValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTdjZTA3OWY3NjQ0Y2NkOTMwODYyMTQ3NjI0N2IzOTAwNWJiOWQ0ODZiMTM5MzE2MjNkNTA4YzNkNzFkMjQ4YSJ9fX0=")
                                                .build()
                                )
                                .addAction(
                                        new ButtonAction() {
                                            @Override
                                            public void on(Player player) {
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bMade By GerryYuu with &cLove."));
                                                player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                            }
                                        }.addClickType(ClickType.LEFT)
                                ))
                .addButton('C',
                        new Button()
                                .setItemStack(new ItemStack(Material.IRON_SWORD, 1))
                                .addAction(
                                        new ButtonAction() {
                                            @Override
                                            public void on(Player player) {
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e我也好！"));
                                                player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                            }
                                        }.addClickType(ClickType.LEFT)
                                ))
                .addButton('B',
                        new Button()
                                .setItemStack(new ItemStack(Material.IRON_PICKAXE, 1))
                                .addAction(
                                        new ButtonAction() {
                                            @Override
                                            public void on(Player player) {
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e你好！"));
                                                player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                            }
                                        }.addClickType(ClickType.LEFT)
                                ))
                .addButton('A',
                        new Button()
                                .setItemStack(
                                        new ItemStackBuilder()
                                                .setMaterial(Material.APPLE)
                                                .setName(ChatColor.translateAlternateColorCodes('&', "&b好耶！"))
                                                .addLore(" ")
                                                .addLore(ChatColor.translateAlternateColorCodes('&', "&e这是一行 Lore。"))
                                                .setAmount(2)
                                                .build()
                                )
                                .addAction(
                                        new ButtonAction() {
                                            @Override
                                            public void on(Player player) {
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e苹果！"));
                                                player.playSound(player, Sound.UI_BUTTON_CLICK, 1F, 2F);
                                            }
                                        }.addClickType(ClickType.LEFT)
                                )
                                .addAction(
                                        new ButtonAction() {
                                            @Override
                                            public void on(Player player) {
                                                player.sendMessage("111");
                                            }
                                        }.addClickType(ClickType.RIGHT)
                                ))
                .addButton('#',
                        new Button()
                                .setItemStack(new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1))
                                .addAction(
                                        new ButtonAction() {
                                            @Override
                                            public void on(Player player) {
                                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c这个不可以点击哦。"));
                                                player.playSound(player, Sound.ENTITY_VILLAGER_NO, 0F, 1F);
                                            }
                                        }.addClickType(ClickType.LEFT)
                                )
                ).openForPlayer((Player) sender);
        return true;
    }
}