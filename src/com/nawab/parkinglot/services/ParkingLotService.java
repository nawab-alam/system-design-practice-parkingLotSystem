package com.nawab.parkinglot.services;

import com.nawab.parkinglot.model.Car;
import com.nawab.parkinglot.model.ParkingLot;
import com.nawab.parkinglot.model.Slot;
import com.nawab.parkinglot.strategy.Strategy;

import java.util.List;
import java.util.TreeSet;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private Strategy strategy;

    public ParkingLotService(ParkingLot parkingLot, Strategy strategy) {
        this.parkingLot = parkingLot;
        this.strategy = strategy;
    }

    public void createParkingLot(Integer capacity) {
        parkingLot.createParingLot(capacity);
        TreeSet<Integer> slotNumbers = new TreeSet<>();
        for(int slotNumber = 1; slotNumber <= capacity; slotNumber++) {
            slotNumbers.add(slotNumber);
        }
        strategy.initialize(slotNumbers);
    }

    public Integer parkACar(Car car) {
        Integer freeSlotNumber = strategy.getNextFreeSlot();
        parkingLot.parkACar(freeSlotNumber, car);
        strategy.removeFreeslot(freeSlotNumber);
        return freeSlotNumber;
    }

    public Integer makeSlotFree(Integer slotNumber) {
        parkingLot.freeSlot(slotNumber);
        strategy.addNewFreeSlot(slotNumber);
        return slotNumber;
    }

    public List<Slot> getAllSlots(){
        return parkingLot.getSlots();
    }
}
