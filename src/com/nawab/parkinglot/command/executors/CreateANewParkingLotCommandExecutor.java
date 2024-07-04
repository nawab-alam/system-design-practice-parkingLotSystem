package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.services.ParkingLotService;

public class CreateANewParkingLotCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateANewParkingLotCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        //TO-DO add integer validation
        return command.getCommandName().equals(COMMAND_NAME) && command.getParams().size() == 1;
    }

    @Override
    public void executeCommand(Command command) {
        Integer capacity = Integer.parseInt(command.getParams().getFirst());
        try {
            parkingLotService.createParkingLot(capacity);
            System.out.println("Created a parking lot with " + capacity + " slots");
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
