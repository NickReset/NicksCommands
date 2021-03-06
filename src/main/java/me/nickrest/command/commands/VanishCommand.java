package me.nickrest.command.commands;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.command.Command;
import me.nickrest.command.info.CommandInfo;
import me.nickrest.event.Event;
import me.nickrest.event.events.EventJoin;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@CommandInfo(name = "vanish", permission = "nick.vanish")
@Getter @Setter
public class VanishCommand extends Command {

    private List<Player> vanishedPlayers = new ArrayList<>();

    public boolean execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        if(args.length == 0 && !vanishedPlayers.contains(player)) {

            if(!vanishedPlayers.contains(player)) {
                Bukkit.getOnlinePlayers().forEach(p -> {
                    if(!p.hasPermission("nick.vanish.see")) {
                        p.hidePlayer(player);
                    }
                    player.setPlayerListName("§8[§cVanished§8] §7" + player.getName());
                });
                vanishedPlayers.add(player);
                player.sendMessage("§aYou are now visible.");
                return true;
            }

            Bukkit.getOnlinePlayers().forEach(p -> {
                p.showPlayer(player);
                player.setPlayerListName(player.getDisplayName());
            });
            vanishedPlayers.remove(player);
            player.sendMessage("§aYou are no longer invisible.");

            return true;
        }
        return false;
    }

    /**
     * Called when a player joins the server
     * Hides every vanished players
     * */
    private void hideAllVanished(Player player) {
        Bukkit.getOnlinePlayers().forEach(p -> {
            if(vanishedPlayers.contains(p)) {
                player.hidePlayer(p);
            }
        });
        player.setPlayerListName(player.getDisplayName());
    }

    public void onEvent(Event event) {
        if(event instanceof EventJoin) {
            EventJoin e = (EventJoin) event;
            Player player = e.getPlayer();
            hideAllVanished(player);
        }
    }
}
