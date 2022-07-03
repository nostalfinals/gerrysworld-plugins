package xyz.garslity093.gerrysworld.ecoadditions.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import xyz.garslity093.gerrysworld.ecoadditions.EcoAdditionsPlugin;
import xyz.garslity093.gerrysworld.ecoadditions.Utils;

import java.util.Set;

public class EntityListener implements Listener {
    /*实体死亡事件*/
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        /*处理生物死亡掉货币*/
        if (event.getEntity() instanceof Mob) {
            Entity entity = event.getEntity();
            Set<String> entityTypesInConfig = EcoAdditionsPlugin.getInstance().getConfig().getConfigurationSection("mobCoinDropping.settingsForPerMob").getKeys(false);
            if (entityTypesInConfig.contains(entity.getType().name().toLowerCase())) {
                if (EcoAdditionsPlugin.getInstance().getConfig().getDouble("mobCoinDropping.settingsForPerMob." + entity.getType().name().toLowerCase()) > 0) {
                    event.getDrops().add(Utils.getCoinItemStack(EcoAdditionsPlugin.getInstance().getConfig().getDouble("mobCoinDropping.settingsForPerMob." + entity.getType().name().toLowerCase())));
                }
            }else {
                event.getDrops().add(Utils.getCoinItemStack(EcoAdditionsPlugin.getInstance().getConfig().getDouble("mobCoinDropping.defaultCoinDrops")));
            }
        }
    }
}
