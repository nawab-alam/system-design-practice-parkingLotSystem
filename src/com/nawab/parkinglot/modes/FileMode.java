package com.nawab.parkinglot.modes;

import com.nawab.parkinglot.command.executors.CommandExecutorFactory;
import com.nawab.parkinglot.model.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileMode extends Mode{
    private String fileName;
    public FileMode(CommandExecutorFactory commandExecutorFactory, String fileName) {
        super(commandExecutorFactory);
        this.fileName = fileName;
    }

    @Override
    public void process() throws IOException {
        System.out.println("Welcome to Interaction mode!");
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("CustomeError");
            return;
        }

        String inputData = reader.readLine();
        while (inputData != null) {
            Command command = new Command(inputData);
            processCommand(command);
            inputData = reader.readLine();
        }
    }
}
