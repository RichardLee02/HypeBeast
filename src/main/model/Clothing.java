package model;

public class Clothing {

    private String brand;
    private String model;
    private String condition;
    private String size;
    private double boughtPrice;
    private double marketPrice;

    /*
     * EFFECTS: this.brand is set to brand
     *          this.model is set to model
     *
     *          if condition is one of: New With Tags (NWT)
     *                                  New Without Tags (NWOT)
     *                                  Very Excellent Used Condition (VEUC)
     *                                  Excellent Used Condition (EUC)
     *                                  Very Good Used Condition (VGUC)
     *                                  Good Used Condition (GUC)
     *
     *         then this.condition is set to condition, otherwise this.condition is set to [INVALID CONDITION]
     *
     *         this.size is set to size
     *         this.boughtPrice is set to boughtPrice
     *         this.marketPrice is set to marketPrice
     */
    public Clothing(String brand, String model, String condition, String size,
                    double boughtPrice, double marketPrice) {

        this.brand = brand;
        this.model = model;

        if (condition.equals("NWT") || condition.equals("NWOT") || condition.equals("VEUC")
                || condition.equals("EUC") || condition.equals("VGUC") || condition.equals("GUC")) {
            this.condition = condition;
        } else {
            this.condition = "[INVALID CONDITION]";
        }

        this.size = size;
        this.boughtPrice = boughtPrice;
        this.marketPrice = marketPrice;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCondition() {
        return condition;
    }

    public String getSize() {
        return size;
    }

    public double getBoughtPrice() {
        return boughtPrice;
    }

    public double getMarketPrice() {
        return marketPrice;
    }
}
