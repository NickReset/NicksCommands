package me.nickrest.command.commands;

import me.nickrest.command.Command;
import me.nickrest.command.info.CommandInfo;
import me.nickrest.util.BanUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "ban", permission = "nickrest.ban", console = true)
public class BanCommand extends Command {

    public boolean execute(CommandSender sender, String label, String[] args) {
        String banner = sender instanceof Player ? sender.getName() : "Console";
        if(args.length == 0) {
            sender.sendMessage("§cUsage: /ban <player> <reason>");
            return true;
        }
        if(args.length == 1) {
            sender.sendMessage("§cUsage: /ban <player> <reason>");
            return true;
        }

        StringBuilder reason = new StringBuilder();
        for(int i = 1; i < args.length; i++) {
            reason.append(args[i]).append(" ");
        }
        String reasonStr = reason.toString().trim();

        BanUtils.banPlayer(args[0], reasonStr, banner);
        sender.sendMessage("§aPlayer §7" + args[0] + " §ahas been banned.");
        return false;
    }
}
