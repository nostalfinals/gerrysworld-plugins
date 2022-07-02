package xyz.garslity093.gerrysworld.packethandler;

import org.bukkit.plugin.java.JavaPlugin;

public final class PacketHandlerPlugin extends JavaPlugin {
    public static JavaPlugin getInstance() {
        return JavaPlugin.getPlugin(PacketHandlerPlugin.class);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
