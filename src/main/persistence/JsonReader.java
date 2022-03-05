package persistence;

import exception.InvalidConditionException;
import model.Clothing;
import model.Shoes;
import model.StreetWearCollection;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// References: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads streetWearCollection from JSON data stored in file
public class JsonReader {

    private String source;

    /*
     * EFFECTS: constructs reader to read from source file
     */
    public JsonReader(String source) {
        this.source = source;
    }

    /*
     * EFFECTS: reads streetWearCollection from file and returns it;
     *          throws IOException if an error occurs reading data from file
     */
    public StreetWearCollection read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseStreetWearCollection(jsonObject);
    }

    /*
     * EFFECTS: reads source file as string and returns it
     */
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    /*
     * EFFECTS: parses streetWearCollection from JSON object and returns it
     */
    private StreetWearCollection parseStreetWearCollection(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        StreetWearCollection sc = new StreetWearCollection(name);
        addClothingCollection(sc, jsonObject);
        addShoesCollection(sc, jsonObject);
        return sc;
    }

    /*
     * MODIFIES: sc
     * EFFECTS: parses clothingCollection from JSON object and adds them to streetWearCollection
     */
    private void addClothingCollection(StreetWearCollection sc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("clothingCollection");
        for (Object json : jsonArray) {
            JSONObject nextClothing = (JSONObject) json;
            addClothing(sc, nextClothing);
        }
    }

    /*
     * MODIFIES: sc
     * EFFECTS: parses clothingCollection from JSON object and adds them to streetWearCollection
     */
    private void addShoesCollection(StreetWearCollection sc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("shoesCollection");
        for (Object json : jsonArray) {
            JSONObject nextShoes = (JSONObject) json;
            addShoes(sc, nextShoes);
        }
    }

    /*
     * MODIFIES: sc
     * EFFECTS: parses clothing from JSON object and adds it to streetWearCollection
     */
    private void addClothing(StreetWearCollection sc, JSONObject jsonObject) {
        try {
            String brand = jsonObject.getString("clothingBrand");
            String model = jsonObject.getString("clothingModel");
            String condition = jsonObject.getString("clothingCondition");
            String size = jsonObject.getString("clothingSize");
            String boughtPrice = jsonObject.getString("clothingBoughtPrice");
            String marketPrice = jsonObject.getString("clothingMarketPrice");
            Clothing clothing = null;
            clothing = new Clothing(brand, model, condition, size, boughtPrice, marketPrice);
            sc.addClothing(clothing);
        } catch (InvalidConditionException e) {
            // expected
        }
    }

    /*
     * MODIFIES: sc
     * EFFECTS: parses shoes from JSON object and adds it to streetWearCollection
     */
    private void addShoes(StreetWearCollection sc, JSONObject jsonObject) {
        try {
            String brand = jsonObject.getString("ShoeBrand");
            String model = jsonObject.getString("ShoeModel");
            String condition = jsonObject.getString("ShoeCondition");
            String size = jsonObject.getString("ShoeSize");
            String boughtPrice = jsonObject.getString("ShoeBoughtPrice");
            String marketPrice = jsonObject.getString("ShoeMarketPrice");
            Shoes shoes = null;
            shoes = new Shoes(brand, model, condition, size, boughtPrice, marketPrice);
            sc.addShoes(shoes);
        } catch (InvalidConditionException e) {
            // expected
        }
    }

}
