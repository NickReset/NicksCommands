package me.nickrest;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.command.commands.VanishCommand;
import me.nickrest.command.manager.CommandManager;
import me.nickrest.event.Event;
import me.nickrest.event.events.EventQuit;
import me.nickrest.event.listener.Listeners;
import org.bukkit.event.Listener;
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
        addListener(new Listeners());
    }

    public void onEvent(Event event) {
        commandManager.onEvent(event);
    }

    private void addListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

}
