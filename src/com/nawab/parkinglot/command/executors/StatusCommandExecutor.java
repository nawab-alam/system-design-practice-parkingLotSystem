package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.model.Slot;
import com.nawab.parkinglot.services.ParkingLotService;

import java.util.List;

public class StatusCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "status";
    public StatusCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getCommandName().equals(COMMAND_NAME) && command.getParams().isEmpty();
    }

    @Override
    public void executeCommand(Command command) {
        List<Slot> availableSlots = parkingLotService.getAllSlots();
        for(Slot slot:availableSlots){
            if(!slot.isFreeSlot()) {
                System.out.println(slot.getSlotNumber() + " " + slot.getCar().getRegistrationNumber() + " " + slot.getCar().getColor());
            }
        }
    }
}
