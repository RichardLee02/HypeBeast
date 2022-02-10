package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClothingTest {

    private Clothing clothingInvalid;
    private Clothing clothingValid;

    @BeforeEach
    public void setUp() {
        clothingInvalid = new Clothing("", "", "", "", 0,0);
        clothingValid = new Clothing("", "", "NWT", "", 0,0);
    }

    @Test
    public void testConstructorInvalid() {
        assertEquals("", clothingInvalid.getBrand());
        assertEquals("", clothingInvalid.getModel());
        assertEquals("[INVALID CONDITION]", clothingInvalid.getCondition());
        assertEquals("", clothingInvalid.getSize());
        assertEquals(0 , clothingInvalid.getBoughtPrice());
        assertEquals(0 , clothingInvalid.getMarketPrice());
    }

    @Test
    public void testConstructorValid() {
        assertEquals("", clothingValid.getBrand());
        assertEquals("", clothingValid.getModel());
        assertEquals("NWT", clothingValid.getCondition());
        assertEquals("", clothingValid.getSize());
        assertEquals(0 , clothingValid.getBoughtPrice());
        assertEquals(0 , clothingValid.getMarketPrice());
    }

}
