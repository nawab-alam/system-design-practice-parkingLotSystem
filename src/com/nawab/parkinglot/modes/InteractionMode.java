package com.nawab.parkinglot.modes;

import com.nawab.parkinglot.command.executors.CommandExecutorFactory;
import com.nawab.parkinglot.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractionMode extends Mode{
    public InteractionMode(CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void process() throws IOException {
        System.out.println("Welcome to Interaction mode!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String inputData = reader.readLine();
            Command command = new Command(inputData);
            processCommand(command);
        }
//        reader.close();
    }
}
