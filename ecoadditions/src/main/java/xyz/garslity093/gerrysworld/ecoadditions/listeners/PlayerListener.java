package xyz.garslity093.gerrysworld.ecoadditions.listeners;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.garslity093.gerrysworld.ecoadditions.EcoAdditionsPlugin;

public final class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerPickItem(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = ((Player) event.getEntity());
            ItemStack item = event.getItem().getItemStack();
            ItemMeta meta = item.getItemMeta();
            /*判断是不是货币*/
            if (meta.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&e&l货币"))) {
                NBTItem nbtItem = new NBTItem(event.getItem().getItemStack());
                NBTCompound nbtCompound =  nbtItem.getCompound("value");
                double amount = nbtCompound.getDouble("amount");
                EcoAdditionsPlugin.getEco().depositPlayer(player, amount);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 0F);
                player.sendTitle(" ", "&e你拾取了 &f" + amount + "&e个货币。",0, 70, 0);
                event.setCancelled(true);
                event.getItem().remove();
            }
        }
    }
}
