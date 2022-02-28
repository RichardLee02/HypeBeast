package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// References: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a streetWear collection containing of clothing and shoes
public class StreetWearCollection implements Writable {

    private String name;
    private List<Clothing> clothingCollection;
    private List<Shoes> shoesCollection;

    public StreetWearCollection(String name) {
        this.name = name;
        clothingCollection = new ArrayList<>();
        shoesCollection = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: clothing is added to the clothing collection
     */
    public void addClothing(Clothing clothing) {
        clothingCollection.add(clothing);
    }

    /*
     * MODIFIES: this
     * EFFECTS: shoes are added to the shoes collection
     */
    public void addShoes(Shoes shoes) {
        shoesCollection.add(shoes);
    }

    /*
     * MODIFIES: this
     * EFFECTS: clothing is removed from the clothing collection
     */
    public void removeClothing(Clothing clothing) {
        clothingCollection.remove(clothing);
    }

    /*
     * MODIFIES: this
     * EFFECTS: shoes are removed from the shoes collection
     */
    public void removeShoes(Shoes shoes) {
        shoesCollection.remove(shoes);
    }

    public String getName() {
        return name;
    }

    /*
     * EFFECTS: returns the list of clothing in the clothing collection
     */
    public List<Clothing> getClothingCollection() {
        return clothingCollection;
    }

    /*
     * EFFECTS: returns the list of shoes in the shoes collection
     */
    public List<Shoes> getShoesCollection() {
        return shoesCollection;
    }

    /*
     * EFFECTS: returns the number of clothing in the clothing collection
     */
    public int getNumberOfClothing() {
        return clothingCollection.size();
    }

    /*
     * EFFECTS: returns the number of shoes in the shoes collection
     */
    public int getNumberOfShoes() {
        return shoesCollection.size();
    }

    /*
     * EFFECTS: returns the number of streetWear items (clothing and shoes) in the street wear collection
     */
    public int getNumberOfStreetWearItems() {
        return clothingCollection.size() + shoesCollection.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("clothingCollection", clothingCollectionToJson());
        json.put("shoesCollection", shoesCollectionToJson());
        return json;
    }

    /*
     * EFFECTS: returns clothingCollection as a JSON array
     */
    private JSONArray clothingCollectionToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Clothing c : clothingCollection) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }

    /*
     * EFFECTS: returns shoesCollection as a JSON array
     */
    private JSONArray shoesCollectionToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Shoes s : shoesCollection) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }

}
