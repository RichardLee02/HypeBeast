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
        shoesInvalid = new Shoes("", "", "", "", "", "");
        shoesDS = new Shoes("", "", "DS", "", "", "");
        shoesDSWT = new Shoes("", "", "DSWT", "", "", "");
        shoesVNDS = new Shoes("", "", "VNDS", "", "", "");
        shoesNDS = new Shoes("", "", "NDS", "", "", "");
        shoesPADS = new Shoes("", "", "PADS", "", "", "");
        shoesBS = new Shoes("", "", "BS", "", "", "");

    }

    @Test
    public void testConstructorInvalid() {
        assertEquals("", shoesInvalid.getBrand());
        assertEquals("", shoesInvalid.getModel());
        assertEquals("[INVALID CONDITION]", shoesInvalid.getCondition());
        assertEquals("", shoesInvalid.getSize());
        assertEquals("", shoesInvalid.getBoughtPrice());
        assertEquals("", shoesInvalid.getMarketPrice());
    }

    @Test
    public void testConstructorDS() {
        assertEquals("", shoesDS.getBrand());
        assertEquals("", shoesDS.getModel());
        assertEquals("DS", shoesDS.getCondition());
        assertEquals("", shoesDS.getSize());
        assertEquals("", shoesDS.getBoughtPrice());
        assertEquals("", shoesDS.getMarketPrice());
    }

    @Test
    public void testConstructorDSWT() {
        assertEquals("", shoesDSWT.getBrand());
        assertEquals("", shoesDSWT.getModel());
        assertEquals("DSWT", shoesDSWT.getCondition());
        assertEquals("", shoesDSWT.getSize());
        assertEquals("", shoesDSWT.getBoughtPrice());
        assertEquals("", shoesDSWT.getMarketPrice());
    }

    @Test
    public void testConstructorVNDS() {
        assertEquals("", shoesVNDS.getBrand());
        assertEquals("", shoesVNDS.getModel());
        assertEquals("VNDS", shoesVNDS.getCondition());
        assertEquals("", shoesVNDS.getSize());
        assertEquals("", shoesVNDS.getBoughtPrice());
        assertEquals("", shoesVNDS.getMarketPrice());
    }

    @Test
    public void testConstructorNDS() {
        assertEquals("", shoesNDS.getBrand());
        assertEquals("", shoesNDS.getModel());
        assertEquals("NDS", shoesNDS.getCondition());
        assertEquals("", shoesNDS.getSize());
        assertEquals("", shoesNDS.getBoughtPrice());
        assertEquals("", shoesNDS.getMarketPrice());
    }

    @Test
    public void testConstructorPADS() {
        assertEquals("", shoesPADS.getBrand());
        assertEquals("", shoesPADS.getModel());
        assertEquals("PADS", shoesPADS.getCondition());
        assertEquals("", shoesPADS.getSize());
        assertEquals("", shoesPADS.getBoughtPrice());
        assertEquals("", shoesPADS.getMarketPrice());
    }

    @Test
    public void testConstructorBS() {
        assertEquals("", shoesBS.getBrand());
        assertEquals("", shoesBS.getModel());
        assertEquals("BS", shoesBS.getCondition());
        assertEquals("", shoesBS.getSize());
        assertEquals("", shoesBS.getBoughtPrice());
        assertEquals("", shoesBS.getMarketPrice());
    }

}
