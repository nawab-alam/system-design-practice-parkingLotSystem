package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.services.ParkingLotService;

public class LeaveCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "leave";
    public LeaveCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        //TO-DO add integer validation
        return command.getCommandName().equals(COMMAND_NAME) && command.getParams().size() == 1;
    }

    @Override
    public void executeCommand(Command command) {
        Integer slotToBeFree = Integer.parseInt(command.getParams().get(0));
        try {
            Integer freedSlot = parkingLotService.makeSlotFree(slotToBeFree);
            System.out.println("Slot number " + freedSlot + " is free");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
