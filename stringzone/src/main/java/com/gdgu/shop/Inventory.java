package com.gdgu.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventory {
    private List<Instrument> inventory = new ArrayList<>();

    public List<Instrument> getInventory() {
        return inventory;
    }

    public void addInstrument(String serialNumber, double price, Map<String, Object> properties) {
       inventory.add(new Instrument(serialNumber, price, properties));
    }

    public Optional<Instrument> getInstrument(String serialNumber) {
        return inventory.stream()
                        .filter(instrument -> instrument.getSerialNumber() == serialNumber) 
                        .findAny();
    }

    public List<Instrument> searchInstrument(Map<String, Object> properties) {
        return inventory.stream()
                        .filter(instrument -> instrument.matches(properties))
                        .collect(Collectors.toList());
    }
}
