package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StreetWearCollectionTest {

    private Clothing clothing;
    private Shoes shoes;
    private StreetWearCollection streetWearCollection;

    @BeforeEach
    public void setUp() {
        clothing = new Clothing("", "", "", "", 0,0);
        shoes = new Shoes("", "", "", 0, 0, 0);
        streetWearCollection = new StreetWearCollection();
    }

    @Test
    public void testAddClothing() {
        // Single
        streetWearCollection.addClothing(clothing);
        assertEquals(1, streetWearCollection.getNumberOfClothing());
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        // Multiple
        streetWearCollection.addClothing(clothing);
        streetWearCollection.addClothing(clothing);
        assertEquals(3, streetWearCollection.getNumberOfClothing());
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(1));
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(2));
    }

    @Test
    public void testAddShoes() {
        // Single
        streetWearCollection.addShoes(shoes);
        assertEquals(1, streetWearCollection.getNumberOfShoes());
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        // Multiple
        streetWearCollection.addShoes(shoes);
        streetWearCollection.addShoes(shoes);
        assertEquals(3, streetWearCollection.getNumberOfShoes());
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(1));
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(2));
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
        streetWearCollection.addClothing(clothing);
        assertEquals(2, streetWearCollection.getNumberOfClothing());
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(1));
        streetWearCollection.removeClothing(clothing);
        assertEquals(1, streetWearCollection.getNumberOfClothing());
        assertEquals(clothing, streetWearCollection.getClothingCollection().get(0));
        streetWearCollection.removeClothing(clothing);
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
        streetWearCollection.addShoes(shoes);
        assertEquals(2, streetWearCollection.getNumberOfShoes());
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(1));
        streetWearCollection.removeShoes(shoes);
        assertEquals(1, streetWearCollection.getNumberOfShoes());
        assertEquals(shoes, streetWearCollection.getShoesCollection().get(0));
        streetWearCollection.removeShoes(shoes);
        assertEquals(0, streetWearCollection.getNumberOfShoes());
    }

    @Test
    public void testNumberOfStreetWearItems() {
        // Single
        streetWearCollection.addClothing(clothing);
        streetWearCollection.addShoes(shoes);
        assertEquals(1, streetWearCollection.getNumberOfClothing());
        assertEquals(1, streetWearCollection.getNumberOfShoes());
        assertEquals(2, streetWearCollection.getNumberOfStreetWearItems());
        // Multiple
        streetWearCollection.addClothing(clothing);
        streetWearCollection.addClothing(clothing);
        streetWearCollection.addShoes(shoes);
        streetWearCollection.addShoes(shoes);
        assertEquals(3, streetWearCollection.getNumberOfClothing());
        assertEquals(3, streetWearCollection.getNumberOfShoes());
        assertEquals(6, streetWearCollection.getNumberOfStreetWearItems());
        // Single
        streetWearCollection.removeClothing(clothing);
        streetWearCollection.removeShoes(shoes);
        assertEquals(2, streetWearCollection.getNumberOfClothing());
        assertEquals(2, streetWearCollection.getNumberOfShoes());
        assertEquals(4, streetWearCollection.getNumberOfStreetWearItems());
        // Multiple
        streetWearCollection.removeClothing(clothing);
        streetWearCollection.removeClothing(clothing);
        streetWearCollection.removeShoes(shoes);
        streetWearCollection.removeShoes(shoes);
        assertEquals(0, streetWearCollection.getNumberOfClothing());
        assertEquals(0, streetWearCollection.getNumberOfShoes());
        assertEquals(0, streetWearCollection.getNumberOfStreetWearItems());
    }

}
