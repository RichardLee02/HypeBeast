package model;

import exception.InvalidConditionException;
import org.json.JSONObject;
import persistence.Writable;

// References: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a pair of shoes having a brand, a model, a condition, a size, a bought price ($), and a market price ($)
public class Shoes implements Writable {

    private String brand;
    private String model;
    private String condition;
    private String size;
    private String boughtPrice;
    private String marketPrice;

    /*
     * EFFECTS: constructs a pair of shoes with a brand, model, condition, size, bought price, and market price
     *
     *          if the condition is one of: Deadstock (DS)
     *                                      Deadstock With Tags (DSWT)
     *                                      Very Near Deadstock (VNDS)
     *                                      Near Deadstock (NDS)
     *                                      Pass As Deadstock (PADS)
     *                                      Beaters (BS)
     *         then the condition is set as the given, otherwise the condition is set to [INVALID CONDITION]
     */
    public Shoes(String brand, String model, String condition, String size, String boughtPrice, String marketPrice)
            throws InvalidConditionException {

        this.brand = brand;
        this.model = model;

        if (condition.equals("DS") || condition.equals("DSWT") || condition.equals("VNDS")
                || condition.equals("NDS") || condition.equals("PADS") || condition.equals("BS")) {
            this.condition = condition;
        } else {
            throw new InvalidConditionException();
        }

        this.size = size;
        this.boughtPrice = boughtPrice;
        this.marketPrice = marketPrice;
    }

    /*
     * EFFECTS: returns the shoe brand
     */
    public String getBrand() {
        return brand;
    }

    /*
     * EFFECTS: returns the shoe model
     */
    public String getModel() {
        return model;
    }

    /*
     * EFFECTS: returns the shoe condition
     */
    public String getCondition() {
        return condition;
    }

    /*
     * EFFECTS: returns the shoe size
     */
    public String getSize() {
        return size;
    }

    /*
     * EFFECTS: returns the shoe bought price
     */
    public String getBoughtPrice() {
        return boughtPrice;
    }

    /*
     * EFFECTS: returns the shoe market price
     */
    public String getMarketPrice() {
        return marketPrice;
    }

    /*
     * EFFECTS: returns the shoes in string format
     */
    @Override
    public String toString() {
        return "[Brand = '" + brand + '\'' + ", Model = '" + model + '\'' + ", Condition = '" + condition
                + '\'' + ", Size = '" + size + '\'' + ", Bought Price = '" + boughtPrice + '\'' + ", Market Price = '"
                + marketPrice + '\'' + ']';
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("ShoeBrand", brand);
        json.put("ShoeModel", model);
        json.put("ShoeCondition", condition);
        json.put("ShoeSize", size);
        json.put("ShoeBoughtPrice", boughtPrice);
        json.put("ShoeMarketPrice", marketPrice);
        return json;
    }

}
