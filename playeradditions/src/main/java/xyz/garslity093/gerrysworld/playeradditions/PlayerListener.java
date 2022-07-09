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
            CommandSender consoleSender = PlayerAdditionsPlugin.INSTANCE.getServer().getConsoleSender();
            String unlockAllRecipeCmd = "/recipe give " + player.getName() + " *";
            String giveMoneyCmd = "/eco give " + player.getName() + " 500";
            PlayerAdditionsPlugin.INSTANCE.getServer().dispatchCommand(consoleSender, unlockAllRecipeCmd);
            PlayerAdditionsPlugin.INSTANCE.getServer().dispatchCommand(consoleSender, giveMoneyCmd);
        }
    }
}
