package model;

import exception.InvalidConditionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShoesTest {

    private Shoes shoesInvalid;
    private Shoes shoesDS;
    private Shoes shoesDSWT;
    private Shoes shoesVNDS;
    private Shoes shoesNDS;
    private Shoes shoesPADS;
    private Shoes shoesBS;

    @Test
    public void testConstructorInvalid() {
        try {
            shoesInvalid = new Shoes("", "", "", "", "", "");
            fail("InvalidConditionException Was Not Thrown!");
        } catch (InvalidConditionException e) {
            // pass
        }
    }

    @Test
    public void testConstructorDS() {
        try {
            shoesDS = new Shoes("", "", "DS", "", "", "");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", shoesDS.getBrand());
        assertEquals("", shoesDS.getModel());
        assertEquals("DS", shoesDS.getCondition());
        assertEquals("", shoesDS.getSize());
        assertEquals("", shoesDS.getBoughtPrice());
        assertEquals("", shoesDS.getMarketPrice());
    }

    @Test
    public void testConstructorDSWT() {
        try {
            shoesDSWT = new Shoes("", "", "DSWT", "", "", "");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", shoesDSWT.getBrand());
        assertEquals("", shoesDSWT.getModel());
        assertEquals("DSWT", shoesDSWT.getCondition());
        assertEquals("", shoesDSWT.getSize());
        assertEquals("", shoesDSWT.getBoughtPrice());
        assertEquals("", shoesDSWT.getMarketPrice());
    }

    @Test
    public void testConstructorVNDS() {
        try {
            shoesVNDS = new Shoes("", "", "VNDS", "", "", "");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", shoesVNDS.getBrand());
        assertEquals("", shoesVNDS.getModel());
        assertEquals("VNDS", shoesVNDS.getCondition());
        assertEquals("", shoesVNDS.getSize());
        assertEquals("", shoesVNDS.getBoughtPrice());
        assertEquals("", shoesVNDS.getMarketPrice());
    }

    @Test
    public void testConstructorNDS() {
        try {
            shoesNDS = new Shoes("", "", "NDS", "", "", "");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", shoesNDS.getBrand());
        assertEquals("", shoesNDS.getModel());
        assertEquals("NDS", shoesNDS.getCondition());
        assertEquals("", shoesNDS.getSize());
        assertEquals("", shoesNDS.getBoughtPrice());
        assertEquals("", shoesNDS.getMarketPrice());
    }

    @Test
    public void testConstructorPADS() {
        try {
            shoesPADS = new Shoes("", "", "PADS", "", "", "");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", shoesPADS.getBrand());
        assertEquals("", shoesPADS.getModel());
        assertEquals("PADS", shoesPADS.getCondition());
        assertEquals("", shoesPADS.getSize());
        assertEquals("", shoesPADS.getBoughtPrice());
        assertEquals("", shoesPADS.getMarketPrice());
    }

    @Test
    public void testConstructorBS() {
        try {
            shoesBS = new Shoes("", "", "BS", "", "", "");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", shoesBS.getBrand());
        assertEquals("", shoesBS.getModel());
        assertEquals("BS", shoesBS.getCondition());
        assertEquals("", shoesBS.getSize());
        assertEquals("", shoesBS.getBoughtPrice());
        assertEquals("", shoesBS.getMarketPrice());
    }

}

