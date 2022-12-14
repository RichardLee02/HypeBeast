package ui;

import exception.InvalidConditionException;
import model.Clothing;
import model.Shoes;
import model.StreetWearCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// References: https://github.students.cs.ubc.ca/CPSC210/TellerApp
//             https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// HypeBeast Application
public class HypeBeastApplication {

    private static final String JSON_STORE = "./data/streetWearCollection.json";
    private StreetWearCollection streetWearCollection;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Scanner input;

    /*
     * EFFECTS: runs the HypeBeast Application
     */
    public HypeBeastApplication() throws FileNotFoundException {
        streetWearCollection = new StreetWearCollection("User's StreetWear Collection");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runHypeBeast();
    }

    /*
     * MODIFIES: this
     * EFFECTS: processes user input
     */
    private void runHypeBeast() {
        boolean keepGoing = true;
        String command = null;

        init();

        System.out.println("\n" + "=======================================================");
        System.out.println("|                Welcome To HypeBeast!                |");
        System.out.println("=======================================================" + "\n");

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toUpperCase();

            if (command.equals("QH")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\n" + "=======================================================");
        System.out.println("|            Thank You For Using HypeBeast!           |");
        System.out.println("=======================================================" + "\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("AC")) {
            doAddClothing();
        } else if (command.equals("AS")) {
            doAddShoes();
        } else if (command.equals("RC")) {
            doRemoveClothing();
        } else if (command.equals("RS")) {
            doRemoveShoes();
        } else if (command.equals("VS")) {
            doViewStreetWearCollection();
        } else if (command.equals("VT")) {
            doViewTotalAmountOfItems();
        } else if (command.equals("SS")) {
            doSaveStreetWearCollection();
        } else if (command.equals("LS")) {
            doLoadStreetWearCollection();
        } else {
            System.out.println("Selection Not Valid..." + "\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes streetWear collection
    private void init() {
        streetWearCollection = new StreetWearCollection("name");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("+--------------------- HypeBeast ---------------------+" + "\n");
        System.out.println("Select From:" + "\n");
        System.out.println("\tAC -> Add Clothing");
        System.out.println("\tAS -> Add Shoes");
        System.out.println("\tRC -> Remove Clothing");
        System.out.println("\tRS -> Remove Shoes");
        System.out.println("\tVS -> View StreetWear Collection");
        System.out.println("\tVT -> View Total Amount Of Items");
        System.out.println("\tSS -> Save StreetWear Collection");
        System.out.println("\tLS -> Load StreetWear Collection");
        System.out.println("\tQH -> Quit HypeBeast" + "\n");
        System.out.println("+-----------------------------------------------------+" + "\n");
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds the clothing to the clothing collection
     */
    public void doAddClothing() {
        System.out.print("Enter Clothing Brand: " + "\n");
        String brand = input.next();
        System.out.print("Enter Clothing Model: " + "\n");
        String model = input.next();
        System.out.print("Enter Clothing Condition: " + "\n");
        String condition = input.next();
        System.out.print("Enter Clothing Size: " + "\n");
        String size = input.next();
        System.out.print("Enter Clothing Bought Price: " + "\n");
        String boughtPrice = input.next();
        System.out.print("Enter Clothing Market Price: " + "\n");
        String marketPrice = input.next();
        Clothing clothing = null;
        try {
            clothing = new Clothing(brand, model, condition, size, boughtPrice, marketPrice);
            streetWearCollection.addClothing(clothing);
        } catch (InvalidConditionException e) {
            System.out.print("\nInvalid Condition! Try Again!" + "\n");
        }
        System.out.print("\n");
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds the pair of shoes to the shoes collection
     */
    public void doAddShoes() {
        System.out.print("Enter Shoe Brand: " + "\n");
        String brand = input.next();
        System.out.print("Enter Shoe Model: " + "\n");
        String model = input.next();
        System.out.print("Enter Shoe Condition: " + "\n");
        String condition = input.next();
        System.out.print("Enter Shoe Size: " + "\n");
        String size = input.next();
        System.out.print("Enter Shoe Bought Price: " + "\n");
        String boughtPrice = input.next();
        System.out.print("Enter Shoe Market Price: " + "\n");
        String marketPrice = input.next();
        Shoes shoes = null;
        try {
            shoes = new Shoes(brand, model, condition, size, boughtPrice, marketPrice);
            streetWearCollection.addShoes(shoes);
        } catch (InvalidConditionException e) {
            System.out.print("\nInvalid Condition! Try Again!" + "\n");
        }
        System.out.print("\n");
    }

    /*
     * MODIFIES: this, removeClothing
     * EFFECTS: if the clothing is contained in the clothing collection and the given prompts (brand, model, condition,
     *          size, bought, price) matches accordingly, it removes the clothing from the clothing collection
     */
    public void doRemoveClothing() {
        List<Clothing> removeClothing = new ArrayList<>();
        System.out.print("Enter Clothing Brand: " + "\n");
        String brand = input.next();
        System.out.print("Enter Clothing Model: " + "\n");
        String model = input.next();
        System.out.print("Enter Clothing Condition: " + "\n");
        String condition = input.next();
        System.out.print("Enter Clothing Size: ");
        String size = input.next();
        System.out.print("Enter Clothing Bought Price: " + "\n");
        String boughtPrice = input.next();
        System.out.print("Enter Clothing Market Price: " + "\n");
        String marketPrice = input.next();
        for (Clothing clothing : streetWearCollection.getClothingCollection()) {
            if (clothing.getBrand().equals(brand) && clothing.getModel().equals(model)
                    && clothing.getCondition().equals(condition) && clothing.getSize().equals(size)
                    && clothing.getBoughtPrice().equals(boughtPrice)
                    && clothing.getMarketPrice().equals(marketPrice)) {
                removeClothing.add(clothing);
            }
        }
        streetWearCollection.getClothingCollection().removeAll(removeClothing);
        System.out.print("\n");
    }

    /*
     * MODIFIES: this, removeShoes
     * EFFECTS: if the shoes is contained in the shoes collection and the given prompts (brand, model, condition,
     *          size, bought, price) matches accordingly, it removes the shoes from the shoes collection
     */
    public void doRemoveShoes() {
        List<Shoes> removeShoes = new ArrayList<>();
        System.out.print("Enter Shoe Brand: " + "\n");
        String brand = input.next();
        System.out.print("Enter Shoe Model: " + "\n");
        String model = input.next();
        System.out.print("Enter Shoe Condition: " + "\n");
        String condition = input.next();
        System.out.print("Enter Shoe Size: ");
        String size = input.next();
        System.out.print("Enter Shoe Bought Price: " + "\n");
        String boughtPrice = input.next();
        System.out.print("Enter Shoe Market Price: " + "\n");
        String marketPrice = input.next();
        for (Shoes shoes : streetWearCollection.getShoesCollection()) {
            if (shoes.getBrand().equals(brand) && shoes.getModel().equals(model)
                    && shoes.getCondition().equals(condition) && shoes.getSize().equals(size)
                    && shoes.getBoughtPrice().equals(boughtPrice) && shoes.getMarketPrice().equals(marketPrice)) {
                removeShoes.add(shoes);
            }
        }
        streetWearCollection.getShoesCollection().removeAll(removeShoes);
        System.out.print("\n");
    }

    /*
     * EFFECTS: if the clothing collection is empty, it prints "Clothing Collection Is Empty", otherwise it prints
     *          all the clothing contained in the clothing collection
     *
     *          if the shoes collection is empty, it prints "Shoes Collection Is Empty", otherwise it prints all the
     *          shoes contained in the shoes collection
     */
    public void doViewStreetWearCollection() {
        System.out.println("Items In StreetWear Collection " + "\n");
        System.out.println("Items In Clothing Collection: ");
        if (streetWearCollection.getClothingCollection().isEmpty()) {
            System.out.println("Clothing Collection Is Empty." + "\n");
        } else {
            for (Clothing clothing : streetWearCollection.getClothingCollection()) {
                System.out.println(clothing.getBrand() + " " + clothing.getModel() + " "
                        + clothing.getCondition() + " Size " + clothing.getSize());
                System.out.println("Bought Price: $" + clothing.getBoughtPrice());
                System.out.println("Market Price: $" + clothing.getMarketPrice() + "\n");
            }
        }

        System.out.println("Items In Shoes Collection: ");
        if (streetWearCollection.getShoesCollection().isEmpty()) {
            System.out.println("Shoes Collection Is Empty." + "\n");
        } else {
            for (Shoes shoes : streetWearCollection.getShoesCollection()) {
                System.out.println(shoes.getBrand() + " " + shoes.getModel() + " "
                        + shoes.getCondition() + " Size " + shoes.getSize());
                System.out.println("Bought Price: $" + shoes.getBoughtPrice());
                System.out.println("Market Price: $" + shoes.getMarketPrice() + "\n");
            }
        }
    }

    /*
     * EFFECTS: prints the total amount of items (clothing, shoes, and streetWear)
     */
    public void doViewTotalAmountOfItems() {
        System.out.println("Total Amount Of Items " + "\n");
        System.out.println("Total Amount Of Clothing: " + streetWearCollection.getNumberOfClothing());
        System.out.println("Total Amount Of Shoes: " + streetWearCollection.getNumberOfShoes());
        System.out.println("Total Amount Of StreetWear Items: "
                + streetWearCollection.getNumberOfStreetWearItems() + "\n");
    }

    // EFFECTS: saves the streetWearCollection to file
    private void doSaveStreetWearCollection() {
        try {
            jsonWriter.open();
            jsonWriter.write(streetWearCollection);
            jsonWriter.close();
            System.out.println("Saved " + streetWearCollection.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
        System.out.print("\n");
    }

    /*
     * MODIFIES: this
     * EFFECTS: loads streetWearCollection from file
     */
    private void doLoadStreetWearCollection() {
        try {
            streetWearCollection = jsonReader.read();
            System.out.println("Loaded " + streetWearCollection.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
        System.out.print("\n");
    }

}
