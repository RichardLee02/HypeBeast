package model;

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
        clothing = new Clothing("", "", "", "", "","");
        clothingX = new Clothing("", "", "NWT", "", "","");
        clothingY = new Clothing("", "", "NWOT", "", "","");
        clothingZ = new Clothing("", "", "VEUC", "", "","");
        shoes = new Shoes("", "", "", "", "", "");
        shoesX = new Shoes("", "", "DS", "", "", "");
        shoesY = new Shoes("", "", "DSWT", "", "", "");
        shoesZ = new Shoes("", "", "VNDS", "", "", "");
        streetWearCollection = new StreetWearCollection();
    }

    @Test
    public void testAddClothing() {
        // Single
        streetWearCollection.addClothing(clothing);
        assertEquals(1, streetWearCollection.getNumberOfClothing());
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        // Multiple
        streetWearCollection.addClothing(clothingX);
        streetWearCollection.addClothing(clothingY);
        streetWearCollection.addClothing(clothingZ);
        assertEquals(4, streetWearCollection.getNumberOfClothing());
        assertEquals(clothingX, streetWearCollection.getClothingCollection().get(1));
        assertEquals(clothingY, streetWearCollection.getClothingCollection().get(2));
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(3));
    }

    @Test
    public void testAddShoes() {
        // Single
        streetWearCollection.addShoes(shoes);
        assertEquals(1, streetWearCollection.getNumberOfShoes());
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        // Multiple
        streetWearCollection.addShoes(shoesX);
        streetWearCollection.addShoes(shoesY);
        streetWearCollection.addShoes(shoesZ);
        assertEquals(4, streetWearCollection.getNumberOfShoes());
        assertEquals(shoesX, streetWearCollection.getShoesCollection().get(1));
        assertEquals(shoesY, streetWearCollection.getShoesCollection().get(2));
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(3));
    }

    @Test
    public void testRemoveClothing() {
        // Single
        streetWearCollection.addClothing(clothing);
        assertEquals(1, streetWearCollection.getNumberOfClothing());
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        streetWearCollection.removeClothing(clothing);
        assertEquals(0, streetWearCollection.getNumberOfClothing());
        // Multiple
        streetWearCollection.addClothing(clothing);
        streetWearCollection.addClothing(clothingX);
        streetWearCollection.addClothing(clothingY);
        streetWearCollection.addClothing(clothingZ);
        assertEquals(4, streetWearCollection.getNumberOfClothing());
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        assertEquals(clothingX, streetWearCollection.getClothingCollection().get(1));
        assertEquals(clothingY, streetWearCollection.getClothingCollection().get(2));
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(3));
        streetWearCollection.removeClothing(clothingX);
        streetWearCollection.removeClothing(clothingY);
        assertEquals(2, streetWearCollection.getNumberOfClothing());
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(1));
        streetWearCollection.removeClothing(clothing);
        assertEquals(1, streetWearCollection.getNumberOfClothing());
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(0));
        streetWearCollection.removeClothing(clothingZ);
        assertEquals(0, streetWearCollection.getNumberOfClothing());
    }

    @Test
    public void testRemoveShoes() {
        // Single
        streetWearCollection.addShoes(shoes);
        assertEquals(1, streetWearCollection.getNumberOfShoes());
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        streetWearCollection.removeShoes(shoes);
        assertEquals(0, streetWearCollection.getNumberOfShoes());
        // Multiple
        streetWearCollection.addShoes(shoes);
        streetWearCollection.addShoes(shoesX);
        streetWearCollection.addShoes(shoesY);
        streetWearCollection.addShoes(shoesZ);
        assertEquals(4, streetWearCollection.getNumberOfShoes());
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        assertEquals(shoesX, streetWearCollection.getShoesCollection().get(1));
        assertEquals(shoesY, streetWearCollection.getShoesCollection().get(2));
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(3));
        streetWearCollection.removeShoes(shoesX);
        streetWearCollection.removeShoes(shoesY);
        assertEquals(2, streetWearCollection.getNumberOfShoes());
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(1));
        streetWearCollection.removeShoes(shoes);
        assertEquals(1, streetWearCollection.getNumberOfShoes());
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(0));
        streetWearCollection.removeShoes(shoesZ);
        assertEquals(0, streetWearCollection.getNumberOfShoes());
    }

    @Test
    public void testNumberOfStreetWearItems() {
        // Single
        streetWearCollection.addClothing(clothing);
        streetWearCollection.addShoes(shoes);
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        assertEquals(1, streetWearCollection.getNumberOfClothing());
        assertEquals(1, streetWearCollection.getNumberOfShoes());
        assertEquals(2, streetWearCollection.getNumberOfStreetWearItems());
        // Multiple
        streetWearCollection.addClothing(clothing);
        streetWearCollection.addClothing(clothingX);
        streetWearCollection.addClothing(clothingY);
        streetWearCollection.addClothing(clothingZ);
        streetWearCollection.addShoes(shoes);
        streetWearCollection.addShoes(shoesX);
        streetWearCollection.addShoes(shoesY);
        streetWearCollection.addShoes(shoesZ);
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(1));
        assertEquals(clothingX, streetWearCollection.getClothingCollection().get(2));
        assertEquals(clothingY, streetWearCollection.getClothingCollection().get(3));
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(4));
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(1));
        assertEquals(shoesX, streetWearCollection.getShoesCollection().get(2));
        assertEquals(shoesY, streetWearCollection.getShoesCollection().get(3));
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(4));
        assertEquals(5, streetWearCollection.getNumberOfClothing());
        assertEquals(5, streetWearCollection.getNumberOfShoes());
        assertEquals(10, streetWearCollection.getNumberOfStreetWearItems());
        // Single
        streetWearCollection.removeClothing(clothing);
        streetWearCollection.removeShoes(shoes);
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        assertEquals(clothingX, streetWearCollection.getClothingCollection().get(1));
        assertEquals(clothingY, streetWearCollection.getClothingCollection().get(2));
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(3));
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        assertEquals(shoesX, streetWearCollection.getShoesCollection().get(1));
        assertEquals(shoesY, streetWearCollection.getShoesCollection().get(2));
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(3));
        assertEquals(4, streetWearCollection.getNumberOfClothing());
        assertEquals(4, streetWearCollection.getNumberOfShoes());
        assertEquals(8, streetWearCollection.getNumberOfStreetWearItems());
        // Multiple
        streetWearCollection.removeClothing(clothing);
        streetWearCollection.removeClothing(clothingX);
        streetWearCollection.removeShoes(shoes);
        streetWearCollection.removeShoes(shoesX);
        assertEquals(clothingY, streetWearCollection.getClothingCollection().get(0));
        assertEquals(clothingZ, streetWearCollection.getClothingCollection().get(1));
        assertEquals(shoesY, streetWearCollection.getShoesCollection().get(0));
        assertEquals(shoesZ, streetWearCollection.getShoesCollection().get(1));
        assertEquals(2, streetWearCollection.getNumberOfClothing());
        assertEquals(2, streetWearCollection.getNumberOfShoes());
        assertEquals(4, streetWearCollection.getNumberOfStreetWearItems());
    }

}
