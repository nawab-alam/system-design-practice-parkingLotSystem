package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.model.Slot;
import com.nawab.parkinglot.services.ParkingLotService;

import java.util.List;

public class SlotNumberForRegistrationNumberCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "slot_number_for_registration_number";
    public SlotNumberForRegistrationNumberCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getCommandName().equals(COMMAND_NAME) && command.getParams().size() == 1;
    }

    @Override
    public void executeCommand(Command command) {
        List<Slot> availableSlots = parkingLotService.getAllSlots();
        boolean slotFound = false;
        for(Slot slot:availableSlots){
            if(!slot.isFreeSlot() && slot.getCar().getRegistrationNumber().equals(command.getParams().get(0))) {
                System.out.print(slot.getSlotNumber() + ", " );
                slotFound = true;
            }
        }
        if(slotFound) {
            System.out.println();
            return;
        }
        System.out.println("Not found");
    }
}
