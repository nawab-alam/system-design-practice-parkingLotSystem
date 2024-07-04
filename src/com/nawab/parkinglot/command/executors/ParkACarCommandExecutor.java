package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Car;
import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.services.ParkingLotService;

public class ParkACarCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "park";
    public ParkACarCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getCommandName().equals(COMMAND_NAME) && command.getParams().size() == 2;
    }

    @Override
    public void executeCommand(Command command) {
        Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        try {
            Integer allocatedSlotNumber = parkingLotService.parkACar(car);
            System.out.println("Allocated slot number:" + allocatedSlotNumber);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
