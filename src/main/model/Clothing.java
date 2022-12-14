package model;

import exception.InvalidConditionException;
import org.json.JSONObject;
import persistence.Writable;

// References: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a clothing having a brand, a model, a condition, a size, a bought price ($), and a market price ($)
public class Clothing implements Writable {

    private String brand;
    private String model;
    private String condition;
    private String size;
    private String boughtPrice;
    private String marketPrice;

    /*
     * EFFECTS: constructs a clothing with a brand, model, condition, size, bought price, and market price
     *
     *          if the condition is one of: New With Tags (NWT)
     *                                      New Without Tags (NWOT)
     *                                      Very Excellent Used Condition (VEUC)
     *                                      Excellent Used Condition (EUC)
     *                                      Very Good Used Condition (VGUC)
     *                                      Good Used Condition (GUC)
     *         then the condition is set as the given, otherwise the condition is set to [INVALID CONDITION]
     */
    public Clothing(String brand, String model, String condition, String size, String boughtPrice, String marketPrice)
            throws InvalidConditionException {

        this.brand = brand;
        this.model = model;

        if (condition.equals("NWT") || condition.equals("NWOT") || condition.equals("VEUC")
                || condition.equals("EUC") || condition.equals("VGUC") || condition.equals("GUC")) {
            this.condition = condition;
        } else {
            throw new InvalidConditionException();
        }

        this.size = size;
        this.boughtPrice = boughtPrice;
        this.marketPrice = marketPrice;
    }

    /*
     * EFFECTS: returns the clothing brand
     */
    public String getBrand() {
        return brand;
    }

    /*
     * EFFECTS: returns the clothing model
     */
    public String getModel() {
        return model;
    }

    /*
     * EFFECTS: returns the clothing condition
     */
    public String getCondition() {
        return condition;
    }

    /*
     * EFFECTS: returns the clothing size
     */
    public String getSize() {
        return size;
    }

    /*
     * EFFECTS: returns the clothing bought price
     */
    public String getBoughtPrice() {
        return boughtPrice;
    }

    /*
     * EFFECTS: returns the clothing market price
     */
    public String getMarketPrice() {
        return marketPrice;
    }

    /*
     * EFFECTS: returns the clothing in string format
     */
    @Override
    public String toString() {
        return "[Brand = '" + brand + '\'' + ", Model = '" + model + '\'' + ", Condition = '" + condition + '\''
                + ", Size = '" + size + '\'' + ", Bought Price = '" + boughtPrice + '\'' + ", Market Price = '"
                + marketPrice + '\'' + ']';
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("clothingBrand", brand);
        json.put("clothingModel", model);
        json.put("clothingCondition", condition);
        json.put("clothingSize", size);
        json.put("clothingBoughtPrice", boughtPrice);
        json.put("clothingMarketPrice", marketPrice);
        return json;
    }

}
