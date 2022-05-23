package me.nickrest.command.commands;

import me.nickrest.command.Command;
import me.nickrest.command.info.CommandInfo;
import org.bukkit.entity.Player;

@CommandInfo(name = "ban", permission = "nickrest.ban", console = true)
public class BanCommand extends Command {

    public boolean execute(Player player, String label, String[] args) {
        return false;
    }

}
