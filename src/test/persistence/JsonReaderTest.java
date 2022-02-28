package persistence;

// References: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import model.Clothing;
import model.Shoes;
import model.StreetWearCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            StreetWearCollection sc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyStreetWearCollection() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyStreetWearCollection.json");
        try {
            StreetWearCollection sc = reader.read();
            assertEquals("My StreetWear Collection", sc.getName());
            assertEquals(0, sc.getNumberOfClothing());
            assertEquals(0, sc.getNumberOfShoes());
            assertEquals(0, sc.getNumberOfStreetWearItems());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralStreetWearCollection() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralStreetWearCollection.json");
        try {
            StreetWearCollection sc = reader.read();
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
            fail("Couldn't read from file");
        }
    }

}
