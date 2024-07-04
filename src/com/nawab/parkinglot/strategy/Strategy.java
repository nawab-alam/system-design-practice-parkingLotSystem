package com.nawab.parkinglot.strategy;

import java.util.TreeSet;

public interface Strategy {
    void initialize(TreeSet<Integer> slots);
    void addNewFreeSlot(Integer slotNumber);
    void removeFreeslot(Integer slotNumber);
    Integer getNextFreeSlot();

}
