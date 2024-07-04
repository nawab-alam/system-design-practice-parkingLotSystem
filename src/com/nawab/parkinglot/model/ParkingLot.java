package com.nawab.parkinglot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private Integer capacity;
    private HashMap<Integer,Slot> slots;

    public void createParingLot(Integer capacity){
        this.capacity = capacity;
        slots = new HashMap<>();
        for(int slotNumber = 1; slotNumber <= capacity; slotNumber++){
            slots.put(slotNumber, new Slot(slotNumber));
        }
    }

    public void parkACar(Integer slotNumber, Car car){
        slots.get(slotNumber).allocateSlot(car);
    }

    public void freeSlot(Integer slotNumber){
        slots.get(slotNumber).freeSlot();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<Slot> getSlots() {
        return new ArrayList<>(slots.values());
    }

    public void printAll(){
        for(Slot slot:slots.values()){
            System.out.println(slot.getSlotNumber() + " " + (slot.isFreeSlot()?"Empty slot":slot.getCar().getRegistrationNumber()));
        }
    }

}
