package com.gdgu.shop;

import java.util.HashMap;
import java.util.Map;

public class Instrument {
    private String serialNumber;
    private double price;
    private Map<String, Object> properties;

    public Instrument(String serialNumber, double price, Map<String, Object> properties) {
        this.serialNumber = serialNumber;
        this.price = price;
        if (properties == null) 
            this.properties = new HashMap<>();
        else 
            this.properties = new HashMap<>(properties);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Map<String, Object> getInstrumentSpec() {
        return properties;
    }

    public boolean matches(Map<String, Object> properties) {
        if (this.properties.equals(properties))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "{" +
            " serialNumber='" + getSerialNumber() + "'" +
            ", price='" + getPrice() + "'" +
            ", properties='" + getProperties() + "'" +
            "}";
    }

}
