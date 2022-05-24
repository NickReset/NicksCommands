package me.nickrest.command.commands;

import me.nickrest.command.Command;
import me.nickrest.command.info.CommandInfo;
import me.nickrest.util.BanUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@CommandInfo(name = "tempban", permission = "nickreset.ban", console = true)
public class TempBan extends Command {

    public boolean execute(CommandSender sender, String label, String[] args) {
        String banner = sender instanceof Player ? sender.getName() : "Console";
        if(args.length == 0) {
            sender.sendMessage("§cUsage: /tempban <player> <timespan> <reason>");
            return true;
        }
        if(args.length == 1) {
            sender.sendMessage("§cUsage: /tempban <player> <timespan> <reason>");
            return true;
        }
        StringBuilder reason = new StringBuilder();
        for (int i = 2; i < args.length; i++) {
            reason.append(args[i]).append(" ");
        }
        String reasonStr = reason.toString().trim();


        BanUtils.tempBanPlayer(args[0], reasonStr, banner, args[2]);
        sender.sendMessage("§aPlayer §7" + args[0] + " §ahas been banned.");
        return true;
    }
}
