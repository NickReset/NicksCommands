package me.nickrest.event.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.nickrest.event.Event;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

@Getter @Setter
@AllArgsConstructor
public class EventQuit extends Event {
    private PlayerQuitEvent parentEvent;
    private Player player;
}
