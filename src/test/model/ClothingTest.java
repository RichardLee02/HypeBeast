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
        clothingInvalid = new Clothing("", "", "", "", "","");
        clothingNWT = new Clothing("", "", "NWT", "", "","");
        clothingNWOT = new Clothing("", "", "NWOT", "", "","");
        clothingVEUC = new Clothing("", "", "VEUC", "", "","");
        clothingEUC = new Clothing("", "", "EUC", "", "","");
        clothingVGUC = new Clothing("", "", "VGUC", "", "","");
        clothingGUC = new Clothing("", "", "GUC", "", "","");
    }

    @Test
    public void testConstructorInvalid() {
        assertEquals("", clothingInvalid.getBrand());
        assertEquals("", clothingInvalid.getModel());
        assertEquals("[INVALID CONDITION]", clothingInvalid.getCondition());
        assertEquals("", clothingInvalid.getSize());
        assertEquals("" , clothingInvalid.getBoughtPrice());
        assertEquals("" , clothingInvalid.getMarketPrice());
    }

    @Test
    public void testConstructorNWT() {
        assertEquals("", clothingNWT.getBrand());
        assertEquals("", clothingNWT.getModel());
        assertEquals("NWT", clothingNWT.getCondition());
        assertEquals("", clothingNWT.getSize());
        assertEquals("" , clothingNWT.getBoughtPrice());
        assertEquals("" , clothingNWT.getMarketPrice());
    }

    @Test
    public void testConstructorNWOT() {
        assertEquals("", clothingNWOT.getBrand());
        assertEquals("", clothingNWOT.getModel());
        assertEquals("NWOT", clothingNWOT.getCondition());
        assertEquals("", clothingNWOT.getSize());
        assertEquals("" , clothingNWOT.getBoughtPrice());
        assertEquals("" , clothingNWOT.getMarketPrice());
    }

    @Test
    public void testConstructorVEUC() {
        assertEquals("", clothingVEUC.getBrand());
        assertEquals("", clothingVEUC.getModel());
        assertEquals("VEUC", clothingVEUC.getCondition());
        assertEquals("", clothingVEUC.getSize());
        assertEquals("" , clothingVEUC.getBoughtPrice());
        assertEquals("" , clothingVEUC.getMarketPrice());
    }

    @Test
    public void testConstructorEUC() {
        assertEquals("", clothingEUC.getBrand());
        assertEquals("", clothingEUC.getModel());
        assertEquals("EUC", clothingEUC.getCondition());
        assertEquals("", clothingEUC.getSize());
        assertEquals("" , clothingEUC.getBoughtPrice());
        assertEquals("" , clothingEUC.getMarketPrice());
    }

    @Test
    public void testConstructorVGUC() {
        assertEquals("", clothingVGUC.getBrand());
        assertEquals("", clothingVGUC.getModel());
        assertEquals("VGUC", clothingVGUC.getCondition());
        assertEquals("", clothingVGUC.getSize());
        assertEquals("" , clothingVGUC.getBoughtPrice());
        assertEquals("" , clothingVGUC.getMarketPrice());
    }

    @Test
    public void testConstructorGUC() {
        assertEquals("", clothingGUC.getBrand());
        assertEquals("", clothingGUC.getModel());
        assertEquals("GUC", clothingGUC.getCondition());
        assertEquals("", clothingGUC.getSize());
        assertEquals("" , clothingGUC.getBoughtPrice());
        assertEquals("" , clothingGUC.getMarketPrice());
    }

}
