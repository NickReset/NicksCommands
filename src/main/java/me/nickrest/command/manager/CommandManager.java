package me.nickrest.command.manager;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.Plugin;
import me.nickrest.command.Command;
import me.nickrest.command.commands.BanCommand;
import me.nickrest.command.commands.FlyCommand;
import me.nickrest.command.commands.VanishCommand;
import me.nickrest.event.Event;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CommandManager {

    private List<Command> commands = new ArrayList<>();

    public CommandManager() {
        registerCommand(new FlyCommand());
        registerCommand(new VanishCommand());
        registerCommand(new BanCommand());
        commands.forEach(Command::register);
    }

    public void onEvent(Event event) {
        commands.forEach(command -> command.onEvent(event));
    }

    public void registerCommand(Command command) {
        commands.add(command);
    }
}
