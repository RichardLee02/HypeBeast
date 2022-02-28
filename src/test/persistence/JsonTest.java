package persistence;

import model.Clothing;
import model.Shoes;

import static org.junit.jupiter.api.Assertions.*;

// References: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonTest {

    protected void checkClothing(String brand, String model, String condition, String size,
                                 String boughtPrice, String marketPrice, Clothing clothing) {
        assertEquals(brand, clothing.getBrand());
        assertEquals(model, clothing.getModel());
        assertEquals(condition, clothing.getCondition());
        assertEquals(size, clothing.getSize());
        assertEquals(boughtPrice, clothing.getBoughtPrice());
        assertEquals(marketPrice, clothing.getMarketPrice());
    }

    protected void checkShoes(String brand, String model, String condition, String size,
                              String boughtPrice, String marketPrice, Shoes shoes) {
        assertEquals(brand, shoes.getBrand());
        assertEquals(model, shoes.getModel());
        assertEquals(condition, shoes.getCondition());
        assertEquals(size, shoes.getSize());
        assertEquals(boughtPrice, shoes.getBoughtPrice());
        assertEquals(marketPrice, shoes.getMarketPrice());
    }

}
