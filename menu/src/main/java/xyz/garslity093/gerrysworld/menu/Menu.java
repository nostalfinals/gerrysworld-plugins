package xyz.garslity093.gerrysworld.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Menu
 * @author: GerryYuu
 * @date: 7/12/2022 5:07 PM
 */

public abstract class Menu {
    private final Inventory bukkitInventory;
    private final InventoryType bukkitInventoryType;
    private final String title;
    private int size;
    private String[] pattern;

    public Menu(Inventory bukkitInventory, InventoryType bukkitInventoryType, String title) {
        this.bukkitInventory = bukkitInventory;
        this.bukkitInventoryType = bukkitInventoryType;
        this.title = title;
        size = bukkitInventoryType.getDefaultSize();
    }

    /*获取图案*/
    public String[] getPattern() {
        return pattern;
    }

    public void setPattern(String... pattern) {
        this.pattern = pattern;
    }

    public Inventory getBukkitInventory() {
        return bukkitInventory;
    }

    public InventoryType getBukkitInventoryType() {
        return bukkitInventoryType;
    }

    public void addButton(char pattern, Button button) {
        for (int i : processPattern(pattern)) {
            bukkitInventory.setItem(i, button.getItemStack());
        }
    }

    public void openForPlayer(Player player) {
        player.openInventory(bukkitInventory);
    }

    /*处理图案，返回这个字符的位置用于添加按钮*/
    public abstract int[] processPattern(char patternSymbol);

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
