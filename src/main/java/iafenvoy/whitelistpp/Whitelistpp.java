package iafenvoy.whitelistpp;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class Whitelistpp extends Plugin {
    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new WhiteListCommand());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new PlayerJoinListener());
        WhiteListManager.INSTANCE.load();
    }

    @Override
    public void onDisable() {
        WhiteListManager.INSTANCE.save();
        ProxyServer.getInstance().getPluginManager().unregisterCommands(this);
        ProxyServer.getInstance().getPluginManager().unregisterListeners(this);
    }
}
