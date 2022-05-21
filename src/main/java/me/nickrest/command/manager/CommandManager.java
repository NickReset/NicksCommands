package me.nickrest.command.manager;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.Plugin;
import me.nickrest.command.Command;
import me.nickrest.command.commands.FlyCommand;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CommandManager {

    private List<Command> commands = new ArrayList<>();

    public CommandManager() {
        registerCommand(new FlyCommand());
        commands.forEach(Command::register);
    }

    public void registerCommand(Command command) {
        commands.add(command);
    }
}
