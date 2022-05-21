package me.nickrest;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.command.manager.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter @Setter
public final class Plugin extends JavaPlugin {

    /* instance */
    @Getter
    private static Plugin instance;

    /* managers */
    private CommandManager commandManager;

    public void onEnable() {
        instance = this;
        commandManager = new CommandManager();
    }

}
