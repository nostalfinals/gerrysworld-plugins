package xyz.garslity093.gerrysworld.menu;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.garslity093.gerrysworld.menu.menus.MenuManager;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu
 * @className: Command
 * @author: GerryYuu
 * @date: 7/12/2022 7:56 PM
 */

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            //player.playSound(player, Sound.BLOCK_IRON_DOOR_OPEN, 1F, 2F);
            MenuManager.getMainMenu().openForPlayer(player);
        }
        return true;
    }
}