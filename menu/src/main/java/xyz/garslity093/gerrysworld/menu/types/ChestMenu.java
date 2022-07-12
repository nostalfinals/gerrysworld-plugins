package xyz.garslity093.gerrysworld.menu.types;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import xyz.garslity093.gerrysworld.menu.Menu;
import xyz.garslity093.gerrysworld.menu.MenuInventoryHolder;
import xyz.garslity093.gerrysworld.menu.utils.PatternUtils;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.types
 * @className: ChestMenu
 * @author: GerryYuu
 * @date: 7/12/2022 6:00 PM
 */

public class ChestMenu extends Menu {
    public ChestMenu(String title) {
        super(Bukkit.createInventory(new MenuInventoryHolder(), InventoryType.CHEST, title), InventoryType.CHEST, title);
    }

    @Override
    public int[] processPattern(char patternSymbol) {
        return PatternUtils.process(getPattern(),
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8},
                new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17},
                new int[]{18, 19, 20, 21, 22, 23, 24, 25, 26});
    }
}
