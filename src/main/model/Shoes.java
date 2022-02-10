package model;

public class Shoes {

    private String brand;
    private String model;
    private String condition;
    private double size;
    private double boughtPrice;
    private double marketPrice;

    /*
     * EFFECTS: this.brand is set to brand
     *          this.model is set to model
     *
     *          if condition is one of: Deadstock (DS)
     *                                  Deadstock With Tags (DSWT)
     *                                  Very Near Deadstock (VNDS)
     *                                  Near Deadstock (NDS)
     *                                  Pass As Deadstock (PADS)
     *                                  Beaters (BS)
     *         then this.condition is set to condition, otherwise this.condition is set to [INVALID CONDITION]
     *
     *         this.size is set to size
     *         this.boughtPrice is set to boughtPrice
     *         this.marketPrice is set to marketPrice
     */
    public Shoes(String brand, String model, String condition, double size,
                 double boughtPrice, double marketPrice) {

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

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCondition() {
        return condition;
    }

    public double getSize() {
        return size;
    }

    public double getBoughtPrice() {
        return boughtPrice;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

}
