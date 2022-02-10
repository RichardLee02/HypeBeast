package model;

import java.util.ArrayList;
import java.util.List;

public class StreetWearCollection {

    private List<Clothing> clothingCollection;
    private List<Shoes> shoesCollection;

    public StreetWearCollection() {
        clothingCollection = new ArrayList<Clothing>();
        shoesCollection = new ArrayList<Shoes>();
    }

    public void addClothing(Clothing clothing) {
        clothingCollection.add(clothing);
    }

    public void addShoes(Shoes shoes) {
        shoesCollection.add(shoes);
    }

    public void removeClothing(Clothing clothing) {
        for (int i = 0; i < clothingCollection.size(); i++) {
            if (clothing.equals(clothingCollection.get(i))) {
                clothingCollection.remove(clothing);
                break;
            }
        }
    }

    public void removeShoes(Shoes shoes) {
        for (int i = 0; i < shoesCollection.size(); i++) {
            if (shoes.equals(shoesCollection.get(i))) {
                shoesCollection.remove(shoes);
                break;
            }
        }
    }

    public List<Clothing> getClothingCollection() {
        return clothingCollection;
    }

    public List<Shoes> getShoesCollection() {
        return shoesCollection;
    }


    public int getNumberOfClothing() {
        return clothingCollection.size();
    }

    public int getNumberOfShoes() {
        return shoesCollection.size();
    }

    public int getNumberOfStreetWearItems() {
        int numberOfStreetWearItems = clothingCollection.size() + shoesCollection.size();
        return numberOfStreetWearItems;
    }

}
