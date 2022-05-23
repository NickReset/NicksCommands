package me.nickrest.command.commands;

import me.nickrest.command.Command;
import me.nickrest.command.info.CommandInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@CommandInfo(name = "fly", permission = "nick.fly")
public class FlyCommand extends Command {

    public boolean execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        if(args.length == 0) {
            player.setAllowFlight(!player.getAllowFlight());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You have " + (player.getAllowFlight() ? "&aenabled" : "&cdisabled") + "&7 flight!"));
            return false;
        }
        Player argPlayer = Bukkit.getPlayer(args[0]);
        if(argPlayer == null) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer not found!"));
            return false;
        }
        argPlayer.setAllowFlight(!argPlayer.getAllowFlight());
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You have " + (argPlayer.getAllowFlight() ? "&aenabled" : "&cdisabled") + "&7 flight for " + argPlayer.getName() + "&7!"));

        return false;
    }
}
