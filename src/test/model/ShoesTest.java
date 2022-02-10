package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoesTest {

    private Shoes shoesInvalid;
    private Shoes shoesValid;

    @BeforeEach
    public void setUp() {
        shoesInvalid = new Shoes("", "", "", 0, 0, 0);
        shoesValid = new Shoes("", "", "DS", 0, 0, 0);
    }

    @Test
    public void testConstructorInvalid() {
        assertEquals("", shoesInvalid.getBrand());
        assertEquals("", shoesInvalid.getModel());
        assertEquals("[INVALID CONDITION]", shoesInvalid.getCondition());
        assertEquals(0, shoesInvalid.getSize());
        assertEquals(0 , shoesInvalid.getBoughtPrice());
        assertEquals(0 , shoesInvalid.getMarketPrice());
    }

    @Test
    public void testConstructorValid() {
        assertEquals("", shoesValid.getBrand());
        assertEquals("", shoesValid.getModel());
        assertEquals("DS", shoesValid.getCondition());
        assertEquals(0, shoesValid.getSize());
        assertEquals(0 , shoesValid.getBoughtPrice());
        assertEquals(0 , shoesValid.getMarketPrice());
    }

}
