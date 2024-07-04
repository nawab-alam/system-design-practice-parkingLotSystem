package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.model.Slot;
import com.nawab.parkinglot.services.ParkingLotService;

import java.util.List;

public class RegistrationNumbersForCarsWithColorCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "registration_numbers_for_cars_with_colour";
    public RegistrationNumbersForCarsWithColorCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getCommandName().equals(COMMAND_NAME) && command.getParams().size() == 1;
    }

    @Override
    public void executeCommand(Command command) {
        List<Slot> availableSlots = parkingLotService.getAllSlots();
        for(Slot slot:availableSlots){
            if(!slot.isFreeSlot() && slot.getCar().getColor().equals(command.getParams().get(0))) {
                System.out.print(slot.getCar().getRegistrationNumber() + ", " );
            }
        }
        System.out.println();
    }
}
