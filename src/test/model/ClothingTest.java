package model;

import exception.InvalidConditionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClothingTest {

    private Clothing clothingInvalid;
    private Clothing clothingNWT;
    private Clothing clothingNWOT;
    private Clothing clothingVEUC;
    private Clothing clothingEUC;
    private Clothing clothingVGUC;
    private Clothing clothingGUC;

    @Test
    public void testConstructorInvalid() {
        try {
            clothingInvalid = new Clothing("", "", "", "", "","");
            fail("InvalidConditionException Was Not Thrown!");
        } catch (InvalidConditionException e) {
            // pass
        }
    }

    @Test
    public void testConstructorNWT() {
        try {
            clothingNWT = new Clothing("", "", "NWT", "", "","");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", clothingNWT.getBrand());
        assertEquals("", clothingNWT.getModel());
        assertEquals("NWT", clothingNWT.getCondition());
        assertEquals("", clothingNWT.getSize());
        assertEquals("" , clothingNWT.getBoughtPrice());
        assertEquals("" , clothingNWT.getMarketPrice());
    }

    @Test
    public void testConstructorNWOT() {
        try {
            clothingNWOT = new Clothing("", "", "NWOT", "", "","");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", clothingNWOT.getBrand());
        assertEquals("", clothingNWOT.getModel());
        assertEquals("NWOT", clothingNWOT.getCondition());
        assertEquals("", clothingNWOT.getSize());
        assertEquals("" , clothingNWOT.getBoughtPrice());
        assertEquals("" , clothingNWOT.getMarketPrice());
    }

    @Test
    public void testConstructorVEUC() {
        try {
            clothingVEUC = new Clothing("", "", "VEUC", "", "","");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", clothingVEUC.getBrand());
        assertEquals("", clothingVEUC.getModel());
        assertEquals("VEUC", clothingVEUC.getCondition());
        assertEquals("", clothingVEUC.getSize());
        assertEquals("" , clothingVEUC.getBoughtPrice());
        assertEquals("" , clothingVEUC.getMarketPrice());
    }

    @Test
    public void testConstructorEUC() {
        try {
            clothingEUC = new Clothing("", "", "EUC", "", "","");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", clothingEUC.getBrand());
        assertEquals("", clothingEUC.getModel());
        assertEquals("EUC", clothingEUC.getCondition());
        assertEquals("", clothingEUC.getSize());
        assertEquals("" , clothingEUC.getBoughtPrice());
        assertEquals("" , clothingEUC.getMarketPrice());
    }

    @Test
    public void testConstructorVGUC() {
        try {
            clothingVGUC = new Clothing("", "", "VGUC", "", "","");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", clothingVGUC.getBrand());
        assertEquals("", clothingVGUC.getModel());
        assertEquals("VGUC", clothingVGUC.getCondition());
        assertEquals("", clothingVGUC.getSize());
        assertEquals("" , clothingVGUC.getBoughtPrice());
        assertEquals("" , clothingVGUC.getMarketPrice());
    }

    @Test
    public void testConstructorGUC() {
        try {
            clothingGUC = new Clothing("", "", "GUC", "", "","");
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals("", clothingGUC.getBrand());
        assertEquals("", clothingGUC.getModel());
        assertEquals("GUC", clothingGUC.getCondition());
        assertEquals("", clothingGUC.getSize());
        assertEquals("" , clothingGUC.getBoughtPrice());
        assertEquals("" , clothingGUC.getMarketPrice());
    }

}
