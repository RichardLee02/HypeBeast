package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoesTest {

    private Shoes shoesInvalid;
    private Shoes shoesDS;
    private Shoes shoesDSWT;
    private Shoes shoesVNDS;
    private Shoes shoesNDS;
    private Shoes shoesPADS;
    private Shoes shoesBS;

    @BeforeEach
    public void setUp() {
        shoesInvalid = new Shoes("", "", "", 0, 0, 0);
        shoesDS = new Shoes("", "", "DS", 0, 0, 0);
        shoesDSWT = new Shoes("", "", "DSWT", 0, 0, 0);
        shoesVNDS = new Shoes("", "", "VNDS", 0, 0, 0);
        shoesNDS = new Shoes("", "", "NDS", 0, 0, 0);
        shoesPADS = new Shoes("", "", "PADS", 0, 0, 0);
        shoesBS = new Shoes("", "", "BS", 0, 0, 0);

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
    public void testConstructorDS() {
        assertEquals("", shoesDS.getBrand());
        assertEquals("", shoesDS.getModel());
        assertEquals("DS", shoesDS.getCondition());
        assertEquals(0, shoesDS.getSize());
        assertEquals(0 , shoesDS.getBoughtPrice());
        assertEquals(0 , shoesDS.getMarketPrice());
    }

    @Test
    public void testConstructorDSWT() {
        assertEquals("", shoesDSWT.getBrand());
        assertEquals("", shoesDSWT.getModel());
        assertEquals("DSWT", shoesDSWT.getCondition());
        assertEquals(0, shoesDSWT.getSize());
        assertEquals(0 , shoesDSWT.getBoughtPrice());
        assertEquals(0 , shoesDSWT.getMarketPrice());
    }

    @Test
    public void testConstructorVNDS() {
        assertEquals("", shoesVNDS.getBrand());
        assertEquals("", shoesVNDS.getModel());
        assertEquals("VNDS", shoesVNDS.getCondition());
        assertEquals(0, shoesVNDS.getSize());
        assertEquals(0 , shoesVNDS.getBoughtPrice());
        assertEquals(0 , shoesVNDS.getMarketPrice());
    }

    @Test
    public void testConstructorNDS() {
        assertEquals("", shoesNDS.getBrand());
        assertEquals("", shoesNDS.getModel());
        assertEquals("NDS", shoesNDS.getCondition());
        assertEquals(0, shoesNDS.getSize());
        assertEquals(0 , shoesNDS.getBoughtPrice());
        assertEquals(0 , shoesNDS.getMarketPrice());
    }

    @Test
    public void testConstructorPADS() {
        assertEquals("", shoesPADS.getBrand());
        assertEquals("", shoesPADS.getModel());
        assertEquals("PADS", shoesPADS.getCondition());
        assertEquals(0, shoesPADS.getSize());
        assertEquals(0 , shoesPADS.getBoughtPrice());
        assertEquals(0 , shoesPADS.getMarketPrice());
    }

    @Test
    public void testConstructorBS() {
        assertEquals("", shoesBS.getBrand());
        assertEquals("", shoesBS.getModel());
        assertEquals("BS", shoesBS.getCondition());
        assertEquals(0, shoesBS.getSize());
        assertEquals(0 , shoesBS.getBoughtPrice());
        assertEquals(0 , shoesBS.getMarketPrice());
    }

}
