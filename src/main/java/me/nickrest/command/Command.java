package me.nickrest.command;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.Plugin;
import me.nickrest.command.info.CommandInfo;
import me.nickrest.command.manager.CommandManager;
import me.nickrest.event.Event;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter @Setter
public abstract class Command  implements CommandExecutor{

    /* info */
    private CommandInfo info = this.getClass().getAnnotation(CommandInfo.class);

    /* command stuff */
    private String name, permission;

    public Command() {
        if(info == null) {
            throw new IllegalArgumentException("Command class must have a CommandInfo annotation!");
        }
        this.name = info.name();
        this.permission = info.permission();
    }

    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission(permission) && !permission.equalsIgnoreCase("")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have permission to use this command!"));
            return true;
        }
        if(!(sender instanceof Player) && !info.console()) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou must be a player to use this command!"));
            return true;
        }
        assert sender instanceof Player;
        return execute(sender, label, args);
    }

    public void register() {
        Objects.requireNonNull(Plugin.getInstance().getCommand(name)).setExecutor(this);
    }

    public abstract boolean execute(CommandSender sender, String label, String[] args);

    /* Command Events */
    public void onEvent(Event event) {}

}
