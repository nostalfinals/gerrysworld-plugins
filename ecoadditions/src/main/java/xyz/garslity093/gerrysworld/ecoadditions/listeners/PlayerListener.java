package xyz.garslity093.gerrysworld.ecoadditions.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.garslity093.gerrysworld.ecoadditions.EcoAdditionsPlugin;
import xyz.garslity093.gerrysworld.ecoadditions.utils.CoinUtils;
import xyz.garslity093.gerrysworld.ecoadditions.utils.ConfigUtils;

public final class PlayerListener implements Listener {
    /*玩家捡起物品监听器*/
    @EventHandler
    public void onPlayerPickItem(EntityPickupItemEvent event) {
        /*玩家捡起货币处理*/
        if (event.getEntity() instanceof Player player) {
            ItemStack itemStack = event.getItem().getItemStack();
            ItemMeta itemMeta = itemStack.getItemMeta();
            /*判断是不是货币*/
            if (itemMeta.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&e&l货币"))) {
                /*给予货币 & 发送 subtitle*/
                double amount = CoinUtils.getCoinAmountFromItemStack(itemStack);
                EcoAdditionsPlugin.getEco().depositPlayer(player, amount);
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1F, 0F);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&e你拾取了 " + amount + " 个货币。")));
                event.setCancelled(true);
                event.getItem().remove();
            }
        }
    }

    /*玩家死亡监听器*/
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        /*玩家死亡丢失货币处理*/
        Player player = event.getEntity();
        double percent = ConfigUtils.defaultConfig().getDouble("playerCoinDropping.saveCoinsPercent") / 100;
        double originBalance = EcoAdditionsPlugin.getEco().getBalance(player);
        double balanceAfterLose = EcoAdditionsPlugin.getEco().getBalance(player) * percent;
        double withdraw = Math.round(originBalance - balanceAfterLose);
        /*判断玩家是否有货币*/
        if (withdraw > 0) {
            EcoAdditionsPlugin.getEco().withdrawPlayer(player, withdraw);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c啊哦... 你因为死亡丢失了 " + withdraw + " 个货币。"));
        }
    }
}