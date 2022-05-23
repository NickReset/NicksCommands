package me.nickrest.command.commands;

import me.nickrest.command.Command;
import me.nickrest.command.info.CommandInfo;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "ban", permission = "nickrest.ban", console = true)
public class BanCommand extends Command {

    public boolean execute(CommandSender sender, String label, String[] args) {
        return false;
    }
}
