package me.nickrest.event.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.nickrest.event.Event;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

@Getter @Setter
@AllArgsConstructor
public class EventJoin extends Event {
    private PlayerJoinEvent parentEvent;
    private Player player;
}
