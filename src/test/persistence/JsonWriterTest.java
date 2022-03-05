package persistence;

import static org.junit.jupiter.api.Assertions.*;

// References: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import exception.InvalidConditionException;
import model.Clothing;
import model.Shoes;
import model.StreetWearCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            StreetWearCollection sc = new StreetWearCollection("My StreetWear Collection");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyStreetWearCollection() {
        try {
            StreetWearCollection sc = new StreetWearCollection("My StreetWear Collection");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyStreetWearCollection.json");
            writer.open();
            writer.write(sc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyStreetWearCollection.json");
            sc = reader.read();
            assertEquals("My StreetWear Collection", sc.getName());
            assertEquals(0, sc.getNumberOfClothing());
            assertEquals(0, sc.getNumberOfShoes());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralStreetWearCollection() {
        try {
            StreetWearCollection sc = new StreetWearCollection("My StreetWear Collection");
            try {
                sc.addClothing(new Clothing("Travis Scott x Nike", "NRG AG Utility Hoodie",
                        "NWT", "M", "150", "250"));
                sc.addClothing(new Clothing("Travis Scott x Nike", "NRG AG Utility Sweatpants",
                        "NWOT", "M", "125", "350"));
                sc.addShoes(new Shoes("Nike", "Air Force 1 Low Travis Scott Sail",
                        "DS", "10", "150", "1500"));
                sc.addShoes(new Shoes("Nike", "Air Force 1 Low Travis Scott Cactus Jack",
                        "DSWT", "10", "160", "500"));
            } catch (InvalidConditionException e) {
                fail("Caught InvalidConditionException!");
            }
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralStreetWearCollection.json");
            writer.open();
            writer.write(sc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralStreetWearCollection.json");
            sc = reader.read();
            assertEquals("My StreetWear Collection", sc.getName());
            List<Clothing> clothing = sc.getClothingCollection();
            List<Shoes> shoes = sc.getShoesCollection();
            assertEquals(2, sc.getNumberOfClothing());
            assertEquals(2, sc.getNumberOfShoes());
            assertEquals(4, sc.getNumberOfStreetWearItems());
            checkClothing("Travis Scott x Nike", "NRG AG Utility Hoodie",
                    "NWT", "M", "150","250", clothing.get(0));
            checkClothing("Travis Scott x Nike", "NRG AG Utility Sweatpants",
                    "NWOT", "M", "125","350", clothing.get(1));
            checkShoes("Nike", "Air Force 1 Low Travis Scott Sail",
                    "DS","10","150","1500", shoes.get(0));
            checkShoes("Nike", "Air Force 1 Low Travis Scott Cactus Jack",
                    "DSWT","10","160","500", shoes.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
