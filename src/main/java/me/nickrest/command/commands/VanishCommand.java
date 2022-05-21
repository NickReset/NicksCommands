package me.nickrest.command.commands;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.command.Command;
import me.nickrest.command.info.CommandInfo;
import me.nickrest.event.Event;
import me.nickrest.event.events.EventJoin;
import me.nickrest.event.events.EventQuit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@CommandInfo(name = "vanish", permission = "nick.vanish")
@Getter @Setter
public class VanishCommand extends Command {

    private List<Player> vanishedPlayers = new ArrayList<>();

    public boolean execute(Player player, String label, String[] args) {
        if(args.length == 0) {
            if(vanishedPlayers.contains(player)) {
                hidePlayer(player);
                player.sendMessage("§aYou are now visible.");
                return true;
            }
            showPlayer(player);
            player.sendMessage("§aYou are now invisible.");
            return true;
        }
        return false;
    }

    private void hidePlayer(Player player) {
        Bukkit.getOnlinePlayers().forEach(player1 -> {
            if(!player1.hasPermission("nick.vanish.see")) {
                player1.hidePlayer(player);
            }
        });
        player.setPlayerListName("§7" + player.getDisplayName() + " §6[§7V§6]");
        vanishedPlayers.add(player);
    }

    private void showPlayer(Player player) {
        Bukkit.getOnlinePlayers().forEach(player1 -> player1.showPlayer(player));
        player.setPlayerListName(player.getDisplayName());
        vanishedPlayers.remove(player);
    }

    /**
     * Called when a player joins the server
     * Hides every vanished players
     * */
    private void hideAllVanished(Player player) {
        vanishedPlayers.forEach(player1 -> player1.hidePlayer(player));
    }

    /**
     * Update Vanish List
     * */
    private void updateVanished(Player player) {
        Bukkit.getOnlinePlayers().forEach(player1 -> vanishedPlayers.forEach(player2 -> {
            if(!player1.hasPermission("nick.vanish.see")) {
                player1.hidePlayer(player2);
            }
        }));
        vanishedPlayers.remove(player);
    }

    public void onEvent(Event event) {
        if(event instanceof EventJoin) {
            EventJoin e = (EventJoin) event;
            Player player = e.getPlayer();
            if(player.hasPermission("nick.vanish.see")) {
                return;
            }
            hideAllVanished(player);
            updateVanished(e.getPlayer());
        }
    }
}