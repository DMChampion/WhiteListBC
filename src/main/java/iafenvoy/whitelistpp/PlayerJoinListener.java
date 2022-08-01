package iafenvoy.whitelistpp;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.PlayerHandshakeEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onHandShake(PlayerHandshakeEvent e) {
        if (!WhiteListManager.INSTANCE.isInWhiteList(e.getConnection().getName()))
            e.getConnection().disconnect(new ComponentBuilder("You are not in the white list").color(ChatColor.RED).create());
    }
}
