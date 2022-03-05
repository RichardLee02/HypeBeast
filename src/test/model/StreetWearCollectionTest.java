package model;

import exception.InvalidConditionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StreetWearCollectionTest {

    private Clothing clothing;
    private Clothing clothingX;
    private Clothing clothingY;
    private Clothing clothingZ;
    private Shoes shoes;
    private Shoes shoesX;
    private Shoes shoesY;
    private Shoes shoesZ;
    private StreetWearCollection streetWearCollection;

    @BeforeEach
    public void setUp() {
        streetWearCollection = new StreetWearCollection("User's StreetWear Collection");
    }

    @Test
    public void testConstructor() {
        assertEquals("User's StreetWear Collection", streetWearCollection.getName());
    }

    @Test
    public void testAddClothingExpectException() {
        try {
            clothing = new Clothing("", "", "", "", "", "");
            streetWearCollection.addClothing(clothing);
            fail("InvalidConditionException Was Not Thrown!");
        } catch (InvalidConditionException e) {
            // pass
        }
    }

    @Test
    public void testAddClothingNoException() {
        try {
            clothingX = new Clothing("", "", "NWT", "", "", "");
            clothingY = new Clothing("", "", "NWOT", "", "", "");
            clothingZ = new Clothing("", "", "VEUC", "", "", "");
            streetWearCollection.addClothing(clothingX);
            streetWearCollection.addClothing(clothingY);
            streetWearCollection.addClothing(clothingZ);
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals(clothingX, streetWearCollection.getClothingCollection().get(0));
        assertEquals(clothingY, streetWearCollection.getClothingCollection().get(1));
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(2));
        assertEquals(3, streetWearCollection.getNumberOfClothing());
        assertEquals(3, streetWearCollection.getNumberOfStreetWearItems());
    }

    @Test
    public void testAddShoesExpectException() {
        try {
            shoes = new Shoes("", "", "", "", "", "");
            fail("InvalidConditionException Was Not Thrown!");
        } catch (InvalidConditionException e) {
            // pass
        }
    }

    @Test
    public void testAddShoesNoException() {
        try {
            shoesX = new Shoes("", "", "DS", "", "", "");
            shoesY = new Shoes("", "", "DSWT", "", "", "");
            shoesZ = new Shoes("", "", "VNDS", "", "", "");
            streetWearCollection.addShoes(shoesX);
            streetWearCollection.addShoes(shoesY);
            streetWearCollection.addShoes(shoesZ);
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals(shoesX, streetWearCollection.getShoesCollection().get(0));
        assertEquals(shoesY, streetWearCollection.getShoesCollection().get(1));
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(2));
        assertEquals(3, streetWearCollection.getNumberOfShoes());
        assertEquals(3, streetWearCollection.getNumberOfStreetWearItems());
    }

    @Test
    public void testRemoveClothingSingle() {
        try {
            clothingX = new Clothing("", "", "NWT", "", "","");
            clothingY = new Clothing("", "", "NWOT", "", "","");
            clothingZ = new Clothing("", "", "VEUC", "", "","");
            streetWearCollection.addClothing(clothingX);
            streetWearCollection.addClothing(clothingY);
            streetWearCollection.addClothing(clothingZ);
            streetWearCollection.removeClothing(clothingX);
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals(clothingY, streetWearCollection.getClothingCollection().get(0));
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(1));
        assertEquals(2, streetWearCollection.getNumberOfClothing());
        assertEquals(2, streetWearCollection.getNumberOfStreetWearItems());
    }

    @Test
    public void testRemoveClothingMultiple() {
        try {
            clothingX = new Clothing("", "", "NWT", "", "","");
            clothingY = new Clothing("", "", "NWOT", "", "","");
            clothingZ = new Clothing("", "", "VEUC", "", "","");
            streetWearCollection.addClothing(clothingX);
            streetWearCollection.addClothing(clothingY);
            streetWearCollection.addClothing(clothingZ);
            streetWearCollection.removeClothing(clothingX);
            streetWearCollection.removeClothing(clothingY);
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(0));
        assertEquals(1, streetWearCollection.getNumberOfClothing());
        assertEquals(1, streetWearCollection.getNumberOfStreetWearItems());
    }

    @Test
    public void testRemoveShoesSingle() {
        try {
            shoesX = new Shoes("", "", "DS", "", "", "");
            shoesY = new Shoes("", "", "DSWT", "", "", "");
            shoesZ = new Shoes("", "", "VNDS", "", "", "");
            streetWearCollection.addShoes(shoesX);
            streetWearCollection.addShoes(shoesY);
            streetWearCollection.addShoes(shoesZ);
            streetWearCollection.removeShoes(shoesX);
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals(shoesY, streetWearCollection.getShoesCollection().get(0));
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(1));
        assertEquals(2, streetWearCollection.getNumberOfShoes());
        assertEquals(2, streetWearCollection.getNumberOfStreetWearItems());
    }

    @Test
    public void testRemoveShoesMultiple() {
        try {
            shoesX = new Shoes("", "", "DS", "", "", "");
            shoesY = new Shoes("", "", "DSWT", "", "", "");
            shoesZ = new Shoes("", "", "VNDS", "", "", "");
            streetWearCollection.addShoes(shoesX);
            streetWearCollection.addShoes(shoesY);
            streetWearCollection.addShoes(shoesZ);
            streetWearCollection.removeShoes(shoesX);
            streetWearCollection.removeShoes(shoesY);
        } catch (InvalidConditionException e) {
            fail("Caught InvalidConditionException!");
        }
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(0));
        assertEquals(1, streetWearCollection.getNumberOfShoes());
        assertEquals(1, streetWearCollection.getNumberOfStreetWearItems());
    }

}
