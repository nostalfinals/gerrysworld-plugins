package xyz.garslity093.gerrysworld.ecoadditions.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import xyz.garslity093.gerrysworld.ecoadditions.utils.CoinUtils;
import xyz.garslity093.gerrysworld.ecoadditions.utils.ConfigUtils;
import xyz.garslity093.gerrysworld.ecoadditions.utils.DropChance;
import xyz.garslity093.gerrysworld.ecoadditions.utils.MathUtils;

public class EntityListener implements Listener {
    /*实体死亡监听器*/
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        /*处理实体随机掉落货币*/
        if (event.getEntity() instanceof Mob) {
            Entity entity = event.getEntity();
            DropChance dropChance = ConfigUtils.getEntityDropChance(entity.getType());
            if (dropChance.willThisTimeDrop()) {
                ItemStack itemStack = CoinUtils.getCoinItemStack(MathUtils.halfUpTwoDecimal(dropChance.randomDropAmount()));
                event.getDrops().add(itemStack);
            }
        }
    }
}