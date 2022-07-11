package xyz.garslity093.gerrysworld.playeradditions;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class PlayerListener implements Listener {
    /*玩家加入监听*/
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            CommandSender consoleSender = PlayerAdditionsPlugin.getInstance().getServer().getConsoleSender();
            String unlockAllRecipeCmd = "/minecraft:recipe give " + player.getName() + " *";
            String giveMoneyCmd = "/eco give " + player.getName() + " 500";
            PlayerAdditionsPlugin.getInstance().getServer().dispatchCommand(consoleSender, unlockAllRecipeCmd);
            PlayerAdditionsPlugin.getInstance().getServer().dispatchCommand(consoleSender, giveMoneyCmd);
        }
    }
}
