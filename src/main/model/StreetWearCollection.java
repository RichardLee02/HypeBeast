package model;

import java.util.ArrayList;
import java.util.List;

// Represents a streetwear collection containing of clothing and shoes
public class StreetWearCollection {

    private List<Clothing> clothingCollection;
    private List<Shoes> shoesCollection;

    public StreetWearCollection() {
        clothingCollection = new ArrayList<Clothing>();
        shoesCollection = new ArrayList<Shoes>();
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
     * EFFECTS: returns the number of streetwear items (clothing and shoes) in the street wear collection
     */
    public int getNumberOfStreetWearItems() {
        int numberOfStreetWearItems = clothingCollection.size() + shoesCollection.size();
        return numberOfStreetWearItems;
    }

}
