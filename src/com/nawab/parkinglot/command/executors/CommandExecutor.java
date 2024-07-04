package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.services.ParkingLotService;

public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;

    public CommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public abstract boolean validate(Command command);
    public abstract void executeCommand(Command command);

}
