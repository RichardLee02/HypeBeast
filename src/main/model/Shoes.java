package model;

// Represents a pair of shoes having a brand, a model, a condition, a size, a bought price ($), and a market price ($)
public class Shoes {

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
     *
     *         this.size is set to size
     *         this.boughtPrice is set to boughtPrice
     *         this.marketPrice is set to marketPrice
     */
    public Shoes(String brand, String model, String condition, String size, String boughtPrice, String marketPrice) {

        this.brand = brand;
        this.model = model;

        if (condition.equals("DS") || condition.equals("DSWT") || condition.equals("VNDS")
                || condition.equals("NDS") || condition.equals("PADS") || condition.equals("BS")) {
            this.condition = condition;
        } else {
            this.condition = "[INVALID CONDITION]";
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

}
