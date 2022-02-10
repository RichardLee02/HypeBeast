package model;

import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() {
        clothingInvalid = new Clothing("", "", "", "", 0,0);
        clothingNWT = new Clothing("", "", "NWT", "", 0,0);
        clothingNWOT = new Clothing("", "", "NWOT", "", 0,0);
        clothingVEUC = new Clothing("", "", "VEUC", "", 0,0);
        clothingEUC = new Clothing("", "", "EUC", "", 0,0);
        clothingVGUC = new Clothing("", "", "VGUC", "", 0,0);
        clothingGUC = new Clothing("", "", "GUC", "", 0,0);
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
    public void testConstructorNWT() {
        assertEquals("", clothingNWT.getBrand());
        assertEquals("", clothingNWT.getModel());
        assertEquals("NWT", clothingNWT.getCondition());
        assertEquals("", clothingNWT.getSize());
        assertEquals(0 , clothingNWT.getBoughtPrice());
        assertEquals(0 , clothingNWT.getMarketPrice());
    }

    @Test
    public void testConstructorNWOT() {
        assertEquals("", clothingNWOT.getBrand());
        assertEquals("", clothingNWOT.getModel());
        assertEquals("NWOT", clothingNWOT.getCondition());
        assertEquals("", clothingNWOT.getSize());
        assertEquals(0 , clothingNWOT.getBoughtPrice());
        assertEquals(0 , clothingNWOT.getMarketPrice());
    }

    @Test
    public void testConstructorVEUC() {
        assertEquals("", clothingVEUC.getBrand());
        assertEquals("", clothingVEUC.getModel());
        assertEquals("VEUC", clothingVEUC.getCondition());
        assertEquals("", clothingVEUC.getSize());
        assertEquals(0 , clothingVEUC.getBoughtPrice());
        assertEquals(0 , clothingVEUC.getMarketPrice());
    }

    @Test
    public void testConstructorEUC() {
        assertEquals("", clothingEUC.getBrand());
        assertEquals("", clothingEUC.getModel());
        assertEquals("EUC", clothingEUC.getCondition());
        assertEquals("", clothingEUC.getSize());
        assertEquals(0 , clothingEUC.getBoughtPrice());
        assertEquals(0 , clothingEUC.getMarketPrice());
    }

    @Test
    public void testConstructorVGUC() {
        assertEquals("", clothingVGUC.getBrand());
        assertEquals("", clothingVGUC.getModel());
        assertEquals("VGUC", clothingVGUC.getCondition());
        assertEquals("", clothingVGUC.getSize());
        assertEquals(0 , clothingVGUC.getBoughtPrice());
        assertEquals(0 , clothingVGUC.getMarketPrice());
    }

    @Test
    public void testConstructorGUC() {
        assertEquals("", clothingGUC.getBrand());
        assertEquals("", clothingGUC.getModel());
        assertEquals("GUC", clothingGUC.getCondition());
        assertEquals("", clothingGUC.getSize());
        assertEquals(0 , clothingGUC.getBoughtPrice());
        assertEquals(0 , clothingGUC.getMarketPrice());
    }

}
