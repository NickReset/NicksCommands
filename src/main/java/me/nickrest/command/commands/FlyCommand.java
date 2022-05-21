package me.nickrest.command.commands;

import me.nickrest.command.Command;
import me.nickrest.command.info.CommandInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@CommandInfo(name = "fly", permission = "nick.fly")
public class FlyCommand extends Command {

    public boolean execute(Player player, String label, String[] args) {
        player.setAllowFlight(!player.getAllowFlight());
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You have " + (player.getAllowFlight() ? "&aenabled" : "&cdisabled") + " flight!"));
        return false;
    }
}
