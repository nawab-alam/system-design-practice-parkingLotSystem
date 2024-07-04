package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.services.ParkingLotService;

import java.util.HashMap;


public class CommandExecutorFactory {
    HashMap<String, CommandExecutor> commandExecutorMap;
    private ParkingLotService parkingLotService;

    public CommandExecutorFactory(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
        commandExecutorMap = new HashMap<>();
        commandExecutorMap.put(CreateANewParkingLotCommandExecutor.COMMAND_NAME,
                new CreateANewParkingLotCommandExecutor(parkingLotService));
        commandExecutorMap.put(ExitCommandExecutor.COMMAND_NAME,
                new ExitCommandExecutor(parkingLotService));
        commandExecutorMap.put(LeaveCommandExecutor.COMMAND_NAME,
                new LeaveCommandExecutor(parkingLotService));
        commandExecutorMap.put(ParkACarCommandExecutor.COMMAND_NAME,
                new ParkACarCommandExecutor(parkingLotService));
        commandExecutorMap.put(RegistrationNumbersForCarsWithColorCommandExecutor.COMMAND_NAME,
                new RegistrationNumbersForCarsWithColorCommandExecutor(parkingLotService));
        commandExecutorMap.put(SlotNumberForRegistrationNumberCommandExecutor.COMMAND_NAME,
                new SlotNumberForRegistrationNumberCommandExecutor(parkingLotService));
        commandExecutorMap.put(SlotNumbersForCarsWithColorCommandExecutor.COMMAND_NAME,
                new SlotNumbersForCarsWithColorCommandExecutor(parkingLotService));
        commandExecutorMap.put(StatusCommandExecutor.COMMAND_NAME,
                new StatusCommandExecutor(parkingLotService));
    }

    public CommandExecutor getCommandExecutor(Command command) {
        CommandExecutor commandExecutor = commandExecutorMap.get(command.getCommandName());
        if(commandExecutor==null) {
            throw new RuntimeException("Command is not supported");
        }
        return commandExecutor;
    }
}
