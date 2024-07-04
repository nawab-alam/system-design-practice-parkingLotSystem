package com.nawab.parkinglot.modes;

import com.nawab.parkinglot.command.executors.CommandExecutor;
import com.nawab.parkinglot.command.executors.CommandExecutorFactory;
import com.nawab.parkinglot.model.Command;

import java.io.IOException;

public abstract class Mode {
    private CommandExecutorFactory commandExecutorFactory;

    public Mode(CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
    }

    void processCommand(Command command) {
        CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if(commandExecutor.validate(command)){
            commandExecutor.executeCommand(command);
        }else {
            throw new RuntimeException("Invalid command exception!");
        }
    }

    public abstract void process() throws IOException;
}
