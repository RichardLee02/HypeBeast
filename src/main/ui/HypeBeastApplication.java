package ui;

import model.Clothing;
import model.Shoes;
import model.StreetWearCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Sources: Professors & TAs
// References: https://github.students.cs.ubc.ca/CPSC210/TellerApp

// HypeBeast Application
public class HypeBeastApplication {

    private StreetWearCollection streetWearCollection;
    private Scanner input;

    private List<Clothing> removeClothing;
    private List<Shoes> removeShoes;

    /*
     * EFFECTS: runs the HypeBeast Application
     */
    public HypeBeastApplication() {

        removeClothing = new ArrayList<>();
        removeShoes = new ArrayList<>();

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

        System.out.println("\nWelcome To HypeBeast!" + "\n");

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

        System.out.println("\nThank You For Using HypeBeast!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        switch (command) {
            case "AC":
                doAddClothing();
                break;
            case "AS":
                doAddShoes();
                break;
            case "RC":
                doRemoveClothing();
                break;
            case "RS":
                doRemoveShoes();
                break;
            case "VS":
                doViewStreetWearCollection();
                break;
            case "VT":
                doViewTotalAmountOfItems();
                break;
            default:
                System.out.println("Selection Not Valid...");
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes streetwear collection
    private void init() {
        streetWearCollection = new StreetWearCollection();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("--------------------- HypeBeast ---------------------" + "\n");
        System.out.println("Select From:" + "\n");
        System.out.println("\tAC -> Add Clothing");
        System.out.println("\tAS -> Add Shoes");
        System.out.println("\tRC -> Remove Clothing");
        System.out.println("\tRS -> Remove Shoes");
        System.out.println("\tVS -> View StreetWear Collection");
        System.out.println("\tVT -> View Total Amount Of Items");
        System.out.println("\tQH -> Quit HypeBeast" + "\n");
        System.out.println("-----------------------------------------------------" + "\n");
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds the clothing to the clothing collection
     */
    public void doAddClothing() {
        System.out.print("Enter Clothing Brand: ");
        String brand = input.next();
        System.out.print("Enter Clothing Model: ");
        String model = input.next();
        System.out.print("Enter Clothing Condition: ");
        String condition = input.next();
        System.out.print("Enter Clothing Size: ");
        String size = input.next();
        System.out.print("Enter Clothing Bought Price: ");
        String boughtPrice = input.next();
        System.out.print("Enter Clothing Market Price: ");
        String marketPrice = input.next();
        Clothing clothing = new Clothing(brand, model, condition, size, boughtPrice, marketPrice);
        streetWearCollection.addClothing(clothing);
        System.out.print("\n");
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds the pair of shoes to the shoes collection
     */
    public void doAddShoes() {
        System.out.print("Enter Shoe Brand: ");
        String brand = input.next();
        System.out.print("Enter Shoe Model: ");
        String model = input.next();
        System.out.print("Enter Shoe Condition: ");
        String condition = input.next();
        System.out.print("Enter Shoe Size: ");
        String size = input.next();
        System.out.print("Enter Shoe Bought Price: ");
        String boughtPrice = input.next();
        System.out.print("Enter Shoe Market Price: ");
        String marketPrice = input.next();
        Shoes shoes = new Shoes(brand, model, condition, size, boughtPrice, marketPrice);
        streetWearCollection.addShoes(shoes);
        System.out.print("\n");
    }

    /*
     * MODIFIES: this, removeClothing
     * EFFECTS: if the clothing is contained in the clothing collection and the given prompts (brand, model, condition,
     *          size, bought, price) matches accordingly, it removes the clothing from the clothing collection
     */
    public void doRemoveClothing() {
        System.out.print("Enter Clothing Brand: ");
        String brand = input.next();
        System.out.print("Enter Clothing Model: ");
        String model = input.next();
        System.out.print("Enter Clothing Condition: ");
        String condition = input.next();
        System.out.print("Enter Clothing Size: ");
        String size = input.next();
        System.out.print("Enter Clothing Bought Price: ");
        String boughtPrice = input.next();
        System.out.print("Enter Clothing Market Price: ");
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
        System.out.print("Enter Shoe Brand: ");
        String brand = input.next();
        System.out.print("Enter Shoe Model: ");
        String model = input.next();
        System.out.print("Enter Shoe Condition: ");
        String condition = input.next();
        System.out.print("Enter Shoe Size: ");
        String size = input.next();
        System.out.print("Enter Shoe Bought Price: ");
        String boughtPrice = input.next();
        System.out.print("Enter Shoe Market Price: ");
        String marketPrice = input.next();
        for (Shoes shoes : streetWearCollection.getShoesCollection()) {
            if (shoes.getBrand().equals(brand) && shoes.getModel().equals(model)
                    && shoes.getCondition().equals(condition) && shoes.getSize().equals(size)
                    && shoes.getBoughtPrice().equals(boughtPrice) && shoes.getMarketPrice().equals(marketPrice)) {
                removeShoes.add(shoes);
            }
        }
        streetWearCollection.getShoesCollection().removeAll(removeShoes);
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
     * EFFECTS: prints the total amount of items (clothing, shoes, and streetwear)
     */
    public void doViewTotalAmountOfItems() {
        System.out.println("Total Amount Of Items " + "\n");
        System.out.println("Total Amount Of Clothing: " + streetWearCollection.getNumberOfClothing());
        System.out.println("Total Amount Of Shoes: " + streetWearCollection.getNumberOfShoes());
        System.out.println("Total Amount Of StreetWear Items: "
                + streetWearCollection.getNumberOfStreetWearItems() + "\n");
    }

}
