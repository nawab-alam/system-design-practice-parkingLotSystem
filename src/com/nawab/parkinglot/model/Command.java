package com.nawab.parkinglot.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {
    private String commandName;
    private List<String> params;
    private final String SPACE = " ";
    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }

    public Command(String inputLine)  {
        List<String> tokens = new ArrayList<>(Arrays.asList(inputLine.split(SPACE)));
        if(tokens.isEmpty()){
            throw new RuntimeException("inputLine is empty");
        }
        this.commandName = tokens.get(0);
        tokens.remove(0);
        this.params = tokens;
    }
}
