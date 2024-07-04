package com.nawab.parkinglot.model;

public class Slot {
    private Integer slotNumber;
    private Car car;
    public Integer getSlotNumber() {
        return slotNumber;
    }

    public Car getCar() {
        return car;
    }

    public Slot(Integer slotNumber){
        this.slotNumber = slotNumber;
    }

    public void allocateSlot(Car car){
        this.car = car;
    }

    public void freeSlot(){
        this.car = null;
    }

    public boolean isFreeSlot(){
        return car==null;
    }

}
