package xyz.garslity093.gerrysworld.motd;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.Random;

/**
 * @packageName: xyz.garslity093.gerrysworld.motd
 * @className: PlayerListener
 * @author: GerryYuu
 * @date: 7/11/2022 8:30 PM
 */

public class PlayerListener implements Listener {
    @EventHandler
    public void serverListPingEvent(ServerListPingEvent event) {
        int randomInt = new Random().nextInt(0, MotdPlugin.getHitokotos().size());
        String randomHitokoto = MotdPlugin.getHitokotos().get(randomInt);
        event.setMotd(ChatColor.translateAlternateColorCodes('&', MotdPlugin.getInstance().getConfig().getString("line1").replace("{hitokoto}", randomHitokoto) + "\n" + MotdPlugin.getInstance().getConfig().getString("line2").replace("{hitokoto}", randomHitokoto)));
    }
}
