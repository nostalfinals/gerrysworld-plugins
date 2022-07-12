package xyz.garslity093.gerrysworld.menu;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.menu.framework.Button;
import xyz.garslity093.gerrysworld.menu.framework.ButtonAction;
import xyz.garslity093.gerrysworld.menu.framework.Menu;
import xyz.garslity093.gerrysworld.menu.types.ChestMenu;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Command
 * @author: GerryYuu
 * @date: 7/12/2022 7:56 PM
 */

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        return true;
    }
}
