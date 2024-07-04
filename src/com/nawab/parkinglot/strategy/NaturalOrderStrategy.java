package com.nawab.parkinglot.strategy;

import java.util.TreeSet;

public class NaturalOrderStrategy implements Strategy{
    TreeSet<Integer> freeSlots;
    public NaturalOrderStrategy(){
        this.freeSlots = new TreeSet<>();
    }
    @Override
    public void initialize(TreeSet<Integer> slots) {
        if(!freeSlots.isEmpty()) {
            throw new RuntimeException("Can not initialize freeSlots as it is not empty!");
        }
        this.freeSlots = slots;
    }

    @Override
    public void addNewFreeSlot(Integer slotNumber) {
        if(freeSlots.contains(slotNumber)) {
            throw new RuntimeException("Slot is already free!");
        }
        this.freeSlots.add(slotNumber);
    }

    @Override
    public void removeFreeslot(Integer slotNumber) {
        if (!this.freeSlots.contains(slotNumber)) {
            throw new RuntimeException("Free slot can't be remove as it doesn't exist");
        }
        this.freeSlots.remove(slotNumber);
    }

    @Override
    public Integer getNextFreeSlot() {
        if(freeSlots.isEmpty()) {
            throw new RuntimeException("Sorry, parking lot is full");
        }
        return freeSlots.first();
    }
}
