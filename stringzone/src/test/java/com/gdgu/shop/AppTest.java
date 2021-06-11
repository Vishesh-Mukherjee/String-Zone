package com.gdgu.shop;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    public Inventory inventory;

    @BeforeEach 
    public void setup() {
        inventory = new Inventory();
        Map<String, Object> p1 = new HashMap<>();        
        Map<String, Object> p2 = new HashMap<>();        
        Map<String, Object> p3 = new HashMap<>();        
        Map<String, Object> p4 = new HashMap<>();        

        p1.put("InstrumentType", InstrumentType.GUITAR);
        p1.put("Builder", Builder.GIBSON);
        p1.put("Model", "Les Paul");
        p1.put("NumStr", 6);
        p1.put("Type", Type.ELECTRIC);
        p1.put("BackWood", Wood.MAPLE);
        p1.put("TopWood", Wood.BRAZILIAN_ROSEWOOD);

        p2.put("InstrumentType", InstrumentType.MANDOLIN);
        p2.put("Builder", Builder.OLSON);
        p2.put("Model", "VX-6778");
        p2.put("Style", Style.NEPOLITAN);
        p2.put("Type", Type.ACOUSTIC);
        p2.put("BackWood", Wood.CEDAR);
        p2.put("TopWood", Wood.INDIAN_ROSEWOOD);

        p3.put("InstrumentType", InstrumentType.GUITAR);
        p3.put("Builder", Builder.FENDER);
        p3.put("Model", "Stratocaster");
        p3.put("NumStr", 12);
        p3.put("Type", Type.ACOUSTIC);
        p3.put("BackWood", Wood.ALDER);
        p3.put("TopWood", Wood.COCOBOLO);

        p4.put("InstrumentType", InstrumentType.GUITAR);
        p4.put("Builder", Builder.GIBSON);
        p4.put("Model", "Les Paul");
        p4.put("NumStr", 6);
        p4.put("Type", Type.ELECTRIC);
        p4.put("BackWood", Wood.MAPLE);
        p4.put("TopWood", Wood.BRAZILIAN_ROSEWOOD);

        inventory.addInstrument("V1432", 5999.00, p1);
        inventory.addInstrument("X5432", 8599.00, p2);
        inventory.addInstrument("AA345", 5999.00, p3);
        inventory.addInstrument("GT543", 6999.00, p4);
    }

    @Test
    public void addInstrumentTest() {

        Assertions.assertEquals(4, inventory.getInventory().size());

        Map<String, Object> p = new HashMap<>();
        p.put("InstrumentType", InstrumentType.MANDOLIN);
        p.put("Builder", Builder.ANY);
        p.put("Model", "Elegent");
        p.put("Style", Style.ARCHTOP);
        p.put("Type", Type.ELECTRO_ACOUSTIC);
        p.put("BackWood", Wood.MAPLE);
        p.put("TopWood", Wood.MAHOGANY);
        inventory.addInstrument("QE353", 5999.00, p);

        Assertions.assertEquals(5, inventory.getInventory().size());
    }

    @Test
    public void getInstrumentTest() { 
        Assertions.assertTrue(inventory.getInstrument("GH324").isEmpty());
        Assertions.assertEquals("V1432", inventory.getInstrument("V1432").get().getSerialNumber());
    }

    @Test
    public void searchInstrumentTest() {
        Map<String, Object> p = new HashMap<>();        
        p.put("InstrumentType", InstrumentType.GUITAR);
        p.put("Builder", Builder.GIBSON);
        p.put("Model", "Les Paul");
        p.put("NumStr", 6);
        p.put("Type", Type.ELECTRIC);
        p.put("BackWood", Wood.MAPLE);
        p.put("TopWood", Wood.BRAZILIAN_ROSEWOOD);        
        
        Assertions.assertEquals(2, inventory.searchInstrument(p).size());
    }
}
