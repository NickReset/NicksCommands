package me.nickrest.command.manager;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.Plugin;
import me.nickrest.command.Command;
import me.nickrest.command.commands.FlyCommand;
import me.nickrest.command.commands.VanishCommand;
import me.nickrest.event.Event;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CommandManager {

    private List<Command> commands = new ArrayList<>();

    /* Commands that might use events */
    private VanishCommand vanishCommand;

    public CommandManager() {
        registerCommand(new FlyCommand());
        registerCommand(vanishCommand = new VanishCommand());
        commands.forEach(Command::register);
    }

    public void onEvent(Event event) {
        vanishCommand.onEvent(event);
    }

    public void registerCommand(Command command) {
        commands.add(command);
    }
}
