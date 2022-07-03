package xyz.garslity093.gerrysworld.ecoadditions.listeners;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
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

public final class PlayerListener implements Listener {
    /*实体捡起物品监听器*/
    @EventHandler
    public void onPlayerPickItem(EntityPickupItemEvent event) {
        /*玩家捡起货币处理*/
        if (event.getEntity() instanceof Player) {
            Player player = ((Player) event.getEntity());
            ItemStack item = event.getItem().getItemStack();
            ItemMeta meta = item.getItemMeta();
            /*判断是不是货币*/
            if (meta.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&e&l货币"))) {
                NBTItem nbtItem = new NBTItem(event.getItem().getItemStack());
                NBTCompound nbtCompound =  nbtItem.getCompound("value");
                double amount = nbtCompound.getDouble("amount");
                /*给予货币 & 发送 subtitle*/
                EcoAdditionsPlugin.getEco().depositPlayer(player, amount);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 0F);
                player.sendTitle(" ", ChatColor.translateAlternateColorCodes('&', "&e你拾取了 " + amount + " 个货币。"),0, 70, 0);
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
        double percent = EcoAdditionsPlugin.getInstance().getConfig().getDouble("playerCoinDropping.saveCoinsPercent")/100;
        double originBalance = EcoAdditionsPlugin.getEco().getBalance(player);
        double balanceAfterLose = EcoAdditionsPlugin.getEco().getBalance(player)*percent;
        double withdraw = Math.round(originBalance-balanceAfterLose);
        /*判断玩家是否有货币*/
        if (withdraw > 0) {
            EcoAdditionsPlugin.getEco().withdrawPlayer(player, withdraw);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c啊哦... 你因为死亡丢失了 " + withdraw + " 个货币。"));
        }
    }
}