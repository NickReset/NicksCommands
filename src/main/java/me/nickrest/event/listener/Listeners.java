package me.nickrest.event.listener;

import me.nickrest.Plugin;
import me.nickrest.event.events.EventJoin;
import me.nickrest.event.events.EventQuit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Plugin.getInstance().onEvent(new EventJoin(event, event.getPlayer()));
    }

    @EventHandler
    public void onJoin(PlayerQuitEvent event) {
        Plugin.getInstance().onEvent(new EventQuit(event, event.getPlayer()));
    }
}
