package ui;

import exception.InvalidConditionException;
import model.Clothing;
import model.Event;
import model.EventLog;
import model.Shoes;
import model.StreetWearCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

// References: https://www.youtube.com/watch?v=22MBsRYuM4Q
//             https://stackoverflow.com/questions/21415182/populating-a-jtable-with-parsed-information
//             https://examples.javacodegeeks.com/desktop-java/swing/jbutton/set-action-command-for-jbutton/
//             https://stackoverflow.com/questions/4577792/how-to-clear-jtable
//             https://stackoverflow.com/questions/8689122/joptionpane-yes-no-options-confirm-dialog-box-issue
//             https://stackoverflow.com/questions/60516720/java-how-to-print-message-when-a-jframe-is-closed

// HypeBeast Application GUI
public class HypeBeastGUI implements ActionListener {

    private static final String JSON_STORE = "./data/streetWearCollection.json";
    private StreetWearCollection streetWearCollection;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private String iconName = "./data/HypeBeast.png";
    private String addName = "./data/Add.png";
    private String deleteName = "./data/Delete.png";
    private String saveName = "./data/Save.png";
    private String loadName = "./data/Load.png";

    private ImageIcon iconImage;
    private ImageIcon addImage;
    private ImageIcon deleteImage;
    private ImageIcon saveImage;
    private ImageIcon loadImage;

    private Object[] columnNames = {"Category", "Brand", "Model",
            "Condition", "Size", "Bought Price ($)", "Market Price ($)"};
    private Object[] categoryNames = {"...", "Clothing", "Shoes"};

    private DefaultTableModel clothingTableModel;
    private DefaultTableModel shoesTableModel;

    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton loadButton;

    private JComboBox categoryComboBox;

    private JFrame frame;

    private JPanel clothingPanel;
    private JPanel shoesPanel;

    private JLabel categoryLabel;
    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel sizeLabel;
    private JLabel conditionLabel;
    private JLabel boughtPriceLabel;
    private JLabel marketPriceLabel;
    private JLabel iconLabel;

    private JLabel collectionLabel;
    private JLabel clothingLabel;
    private JLabel shoesLabel;

    private JScrollPane clothingScrollPane;
    private JScrollPane shoesScrollPane;

    private JTable clothingTable;
    private JTable shoesTable;

    private JTextField brandTextField;
    private JTextField conditionTextField;
    private JTextField boughtPriceTextField;
    private JTextField modelTextField;
    private JTextField sizeTextField;
    private JTextField marketPriceTextField;

    /*
     * EFFECTS: runs the HypeBeast Application GUI
     */
    public HypeBeastGUI() {
        frame = new JFrame();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        streetWearCollection = new StreetWearCollection("User's StreetWear Collection");
        runHypeBeastGUI();
    }

    /*
     * MODIFIES: this
     * EFFECTS: processes user inputs
     */
    private void runHypeBeastGUI() {
        processComboBox();
        processStreetWearCollection();
        processLabel();
        processTextField();
        processImage();
        processButton();
        processClothingTable();
        processShoesTable();
        processActionListener();
        processActionCommand();
        processFrame();
        processEventLog();
    }

    /*
     * MODIFIES: this
     * EFFECTS: sets up frame
     */
    private void processFrame() {
        frame.setTitle("HypeBeast");
        frame.setIconImage(new ImageIcon(iconName).getImage());
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /*
     * MODIFIES: this
     * EFFECTS: instantiates and sets up categoryComboBox to frame
     */
    private void processComboBox() {
        categoryComboBox = new JComboBox(categoryNames);
        categoryComboBox.setSelectedIndex(0);
        categoryComboBox.setBounds(30, 45, 225, 30);
        frame.add(categoryComboBox);
    }

    /*
     * MODIFIES: this
     * EFFECTS: instantiates and sets up iconLabel, collectionLabel, clothingLabel, shoesLabel to frame
     */
    private void processStreetWearCollection() {
        iconImage = new ImageIcon(iconName);
        iconLabel = new JLabel();
        collectionLabel = new JLabel("Total Number of StreetWear Items: 0");
        clothingLabel = new JLabel("Total Number of Clothing: 0");
        shoesLabel = new JLabel("Total Number of Shoes: 0");

        iconLabel.setIcon(iconImage);
        iconLabel.setBounds(500, 25, 200, 25);
        collectionLabel.setBounds(283, 506, 250, 51);
        clothingLabel.setBounds(655, 506, 250, 51);
        shoesLabel.setBounds(998, 506, 250, 51);

        frame.add(iconLabel);
        frame.add(collectionLabel);
        frame.add(clothingLabel);
        frame.add(shoesLabel);
    }

    /*
     * MODIFIES: this
     * EFFECTS: instantiates and sets up categoryLabel, brandLabel, modelLabel, conditionLabel, sizeLabel,
     *          boughtPriceLabel, marketPriceLabel to frame
     */
    private void processLabel() {
        categoryLabel = new JLabel("Category");
        brandLabel = new JLabel("Brand");
        modelLabel = new JLabel("Model");
        conditionLabel = new JLabel("Condition");
        sizeLabel = new JLabel("Size");
        boughtPriceLabel = new JLabel("Bought Price");
        marketPriceLabel = new JLabel("Market Price");

        categoryLabel.setBounds(35, 12, 100, 51);
        brandLabel.setBounds(35, 60, 100, 51);
        modelLabel.setBounds(35, 110, 100, 51);
        conditionLabel.setBounds(35, 160, 100, 51);
        sizeLabel.setBounds(35, 210, 100, 51);
        boughtPriceLabel.setBounds(35, 260, 100, 51);
        marketPriceLabel.setBounds(35, 310, 100, 51);

        frame.add(categoryLabel);
        frame.add(brandLabel);
        frame.add(modelLabel);
        frame.add(conditionLabel);
        frame.add(sizeLabel);
        frame.add(boughtPriceLabel);
        frame.add(marketPriceLabel);
    }

    /*
     * MODIFIES: this
     * EFFECTS: initializes and sets up brandTextField, modelTextField, conditionTextField, sizeTextField,
     *          boughtPriceTextField, and marketPriceTextField to frame
     */
    private void processTextField() {
        brandTextField = new JTextField();
        modelTextField = new JTextField();
        conditionTextField = new JTextField();
        sizeTextField = new JTextField();
        boughtPriceTextField = new JTextField();
        marketPriceTextField = new JTextField();

        brandTextField.setBounds(32, 90, 220, 30);
        modelTextField.setBounds(32, 140, 220, 30);
        conditionTextField.setBounds(32, 190, 220, 30);
        sizeTextField.setBounds(32, 240, 220, 30);
        boughtPriceTextField.setBounds(32, 290, 220, 30);
        marketPriceTextField.setBounds(32, 340, 220, 30);

        frame.add(brandTextField);
        frame.add(modelTextField);
        frame.add(conditionTextField);
        frame.add(sizeTextField);
        frame.add(boughtPriceTextField);
        frame.add(marketPriceTextField);
    }

    /*
     * MODIFIES: this
     * EFFECTS: instantiates and sets up addImage, deleteImage, saveImage, and loadImage
     */
    private void processImage() {
        addImage = new ImageIcon(addName);
        Image scaleAddImage = addImage.getImage();
        Image modifiedAddImage = scaleAddImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        addImage = new ImageIcon(modifiedAddImage);

        deleteImage = new ImageIcon(deleteName);
        Image scaleDeleteImage = deleteImage.getImage();
        Image modifiedDeleteImage = scaleDeleteImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        deleteImage = new ImageIcon(modifiedDeleteImage);

        saveImage = new ImageIcon(saveName);
        Image scaleSaveImage = saveImage.getImage();
        Image modifiedSaveImage = scaleSaveImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        saveImage = new ImageIcon(modifiedSaveImage);

        loadImage = new ImageIcon(loadName);
        Image scaleLoadImage = loadImage.getImage();
        Image modifiedLoadImage = scaleLoadImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        loadImage = new ImageIcon(modifiedLoadImage);
    }

    /*
     * MODIFIES: this
     * EFFECTS: instantiates and sets up addButton, deleteButton, saveButton, and loadButton to frame, and instantiates
     *          and sets up addImage, deleteImage, saveImage, and loadImage to corresponding button
     */
    private void processButton() {
        addButton = new JButton("Add", addImage);
        deleteButton = new JButton("Delete", deleteImage);
        saveButton = new JButton("Save", saveImage);
        loadButton = new JButton("Load", loadImage);

        addButton.setBounds(33, 378, 219, 40);
        deleteButton.setBounds(33, 420, 219, 40);
        saveButton.setBounds(33, 462, 219, 40);
        loadButton.setBounds(33, 504, 219, 40);

        frame.add(addButton);
        frame.add(deleteButton);
        frame.add(saveButton);
        frame.add(loadButton);
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds action listener for addButton, deleteButton, saveButton, and loadButton to this
     */
    private void processActionListener() {
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
    }

    /*
     * MODIFIES: this
     * EFFECTS: sets action command for addButton, deleteButton, saveButton, and loadButton to "Add", "Delete", "Save"
     *          and "Load" respectively
     */
    private void processActionCommand() {
        addButton.setActionCommand("Add");
        deleteButton.setActionCommand("Delete");
        saveButton.setActionCommand("Save");
        loadButton.setActionCommand("Load");
    }

    /*
     * MODIFIES: this
     * EFFECTS: processes user commands
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Add")) {
            doAdd();
            doEmptyTextField();
            doViewStreetWearCollection();
        } else if (actionCommand.equals("Delete")) {
            doDelete();
            doViewStreetWearCollection();
        } else if (actionCommand.equals("Save")) {
            doSave();
        } else if (actionCommand.equals("Load")) {
            doLoad();
            doViewStreetWearCollection();
        }
    }

    /*
     * EFFECTS: if brandLength, modelLength, conditionLength, sizeLength, boughtPriceLength, and marketPriceLength
     *          is greater than or equal to 1 and clothingCondition is met, return true, otherwise false
     */
    private boolean addClothingCondition() {
        boolean brandLength = brandTextField.getText().length() >= 1;
        boolean modelLength = modelTextField.getText().length() >= 1;
        boolean conditionLength = conditionTextField.getText().length() >= 1;
        boolean sizeLength = sizeTextField.getText().length() >= 1;
        boolean boughtPriceLength = boughtPriceTextField.getText().length() >= 1;
        boolean marketPriceLength = marketPriceTextField.getText().length() >= 1;

        boolean clothingCondition = conditionTextField.getText().equals("NWT")
                || conditionTextField.getText().equals("NWOT") || conditionTextField.getText().equals("VEUC")
                || conditionTextField.getText().equals("EUC") || conditionTextField.getText().equals("VGUC")
                || conditionTextField.getText().equals("GUC");

        return brandLength && modelLength && conditionLength && sizeLength
                && boughtPriceLength && marketPriceLength && clothingCondition;
    }

    /*
     * EFFECTS: if brandLength, modelLength, conditionLength, sizeLength, boughtPriceLength, and marketPriceLength
     *          is greater than or equal to 1 and shoesCondition is met, return true, otherwise false
     */
    private boolean addShoesCondition() {
        boolean brandLength = brandTextField.getText().length() >= 1;
        boolean modelLength = modelTextField.getText().length() >= 1;
        boolean conditionLength = conditionTextField.getText().length() >= 1;
        boolean sizeLength = sizeTextField.getText().length() >= 1;
        boolean boughtPriceLength = boughtPriceTextField.getText().length() >= 1;
        boolean marketPriceLength = marketPriceTextField.getText().length() >= 1;

        boolean shoesCondition = conditionTextField.getText().equals("DS")
                || conditionTextField.getText().equals("DSWT") || conditionTextField.getText().equals("VNDS")
                || conditionTextField.getText().equals("NDS") || conditionTextField.getText().equals("PADS")
                || conditionTextField.getText().equals("BS");

        return brandLength && modelLength && conditionLength && sizeLength
                && boughtPriceLength && marketPriceLength && shoesCondition;
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds clothing/shoes into clothingTableModel/shoesTableModel and streetWear collection respectively
     */
    private void doAdd() {
        doAddClothing();
        doAddShoes();
    }

    /*
     * MODIFIES: this
     * EFFECTS: if the addClothingCondition is met and the selected categoryComboBox is equal to "Clothing", it adds
     *          clothing into clothingTableModel and streetWear collection
     */
    private void doAddClothing() {
        if (addClothingCondition() && categoryComboBox.getSelectedItem().toString().equals("Clothing")) {

            Object[] row = new Object[7];
            row[0] = categoryComboBox.getSelectedItem().toString();
            row[1] = brandTextField.getText();
            row[2] = modelTextField.getText();
            row[3] = conditionTextField.getText();
            row[4] = sizeTextField.getText();
            row[5] = boughtPriceTextField.getText();
            row[6] = marketPriceTextField.getText();

            clothingTableModel.addRow(row);

            if (categoryComboBox.getSelectedItem().toString().equals("Clothing")) {
                try {
                    Clothing clothing = new Clothing(brandTextField.getText(), modelTextField.getText(),
                            conditionTextField.getText(), sizeTextField.getText(),
                            boughtPriceTextField.getText(), marketPriceTextField.getText());
                    streetWearCollection.addClothing(clothing);
                } catch (InvalidConditionException ex) {
                    System.out.println("Invalid Condition! Please Try Again!");
                }
            }
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: if the addShoesCondition is met and the selected categoryComboBox is equal to "Shoes", it adds shoes
     *          into shoesTableModel and streetWear collection
     */
    private void doAddShoes() {
        if (addShoesCondition() && categoryComboBox.getSelectedItem().toString().equals("Shoes")) {

            Object[] row = new Object[7];
            row[0] = categoryComboBox.getSelectedItem().toString();
            row[1] = brandTextField.getText();
            row[2] = modelTextField.getText();
            row[3] = conditionTextField.getText();
            row[4] = sizeTextField.getText();
            row[5] = boughtPriceTextField.getText();
            row[6] = marketPriceTextField.getText();

            shoesTableModel.addRow(row);

            if (categoryComboBox.getSelectedItem().toString().equals("Shoes")) {
                try {
                    Shoes shoes = new Shoes(brandTextField.getText(), modelTextField.getText(),
                            conditionTextField.getText(), sizeTextField.getText(),
                            boughtPriceTextField.getText(), marketPriceTextField.getText());
                    streetWearCollection.addShoes(shoes);
                } catch (InvalidConditionException ex) {
                    System.out.println("Invalid Condition! Please Try Again!");
                }
            }
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: if the selected clothingTable/shoesTable row is not equal to -1, it removes the selected row from
     *          clothingTableModel/shoesTableModel and streetWear collection
     */
    private void doDelete() {
        if (clothingTable.getSelectedRow() != -1) {
            int i = clothingTable.getSelectedRow();
            Clothing clothing = streetWearCollection.getClothingCollection().get(i);
            streetWearCollection.removeClothing(clothing);
            clothingTableModel.removeRow(clothingTable.getSelectedRow());
        }

        if (shoesTable.getSelectedRow() != -1) {
            int i = shoesTable.getSelectedRow();
            Shoes shoes = streetWearCollection.getShoesCollection().get(i);
            streetWearCollection.removeShoes(shoes);
            shoesTableModel.removeRow(shoesTable.getSelectedRow());
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: if confirmDialog is equal to 0, it saves streetWear collection to file, otherwise it prints message
     */
    private void doSave() {
        int confirmDialog = JOptionPane.showConfirmDialog(null,
                "Save Data?", "Save Option", JOptionPane.YES_NO_OPTION);
        if (confirmDialog == 0) {
            try {
                jsonWriter.open();
                jsonWriter.write(streetWearCollection);
                jsonWriter.close();
                System.out.println("Saved " + streetWearCollection.getName() + " to " + JSON_STORE);
            } catch (FileNotFoundException exception) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: if the confirmDialog is equal to 0, it empties the clothingTableModel/shoesTableModel, and it loads
     *          streetWear collection from file into clothingTableModel/shoesTableModel, otherwise it prints message
     */
    private void doLoad() {
        int confirmDialog = JOptionPane.showConfirmDialog(null,
                "Load Data?", "Load Option", JOptionPane.YES_NO_OPTION);
        if (confirmDialog == 0) {
            try {
                doEmptyTable();
                streetWearCollection = jsonReader.read();
                doLoadStreetWearCollection();

                System.out.println("Loaded " + streetWearCollection.getName() + " from " + JSON_STORE);
            } catch (IOException exception) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds clothing/shoes from streetWear collection to clothingTableModel/shoesTableModel respectively
     */
    private void doLoadStreetWearCollection() {
        for (Clothing clothing : streetWearCollection.getClothingCollection()) {
            String brand = clothing.getBrand();
            String model = clothing.getModel();
            String condition = clothing.getCondition();
            String size = clothing.getSize();
            String boughtPrice = clothing.getBoughtPrice();
            String marketPrice = clothing.getMarketPrice();
            clothingTableModel.addRow(new Object[]{"Clothing", brand, model,
                    condition, size, boughtPrice, marketPrice});
        }

        for (Shoes shoes : streetWearCollection.getShoesCollection()) {
            String brand = shoes.getBrand();
            String model = shoes.getModel();
            String condition = shoes.getCondition();
            String size = shoes.getSize();
            String boughtPrice = shoes.getBoughtPrice();
            String marketPrice = shoes.getMarketPrice();
            shoesTableModel.addRow(new Object[]{"Shoes", brand, model,
                    condition, size, boughtPrice, marketPrice});
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: instantiates and sets up clothingPanel, clothingTableModel, clothingTable, and clothingScrollPane in
     *          frame
     */
    private void processClothingTable() {
        clothingPanel = new JPanel();
        clothingTableModel = new DefaultTableModel();
        clothingTable = new JTable();
        clothingScrollPane = new JScrollPane(clothingTable);

        clothingPanel.setBounds(280, 65, 885, 220);
        clothingPanel.setBackground(Color.black);
        clothingTableModel.setColumnIdentifiers(columnNames);
        clothingTable.setModel(clothingTableModel);
        clothingTable.setBackground(Color.lightGray);
        clothingTable.setRowHeight(30);
        clothingTable.setFillsViewportHeight(true);
        clothingTable.setPreferredScrollableViewportSize(new Dimension(875, 200));

        clothingPanel.add(clothingScrollPane);
        frame.add(clothingPanel);
    }

    /*
     * MODIFIES: this
     * EFFECTS: instantiates and sets up shoesPanel, shoesTableModel, shoesTable, and shoesScrollPane in frame
     */
    private void processShoesTable() {
        shoesPanel = new JPanel();
        shoesTableModel = new DefaultTableModel();
        shoesTable = new JTable();
        shoesScrollPane = new JScrollPane(shoesTable);

        shoesPanel.setBounds(280, 293, 885, 220);
        shoesPanel.setBackground(Color.black);
        shoesTableModel.setColumnIdentifiers(columnNames);
        shoesTable.setModel(shoesTableModel);
        shoesTable.setBackground(Color.lightGray);
        shoesTable.setRowHeight(30);
        shoesTable.setFillsViewportHeight(true);
        shoesTable.setPreferredScrollableViewportSize(new Dimension(875, 200));

        shoesPanel.add(shoesScrollPane);
        frame.add(shoesPanel);
    }

    /*
     * MODIFIES: this
     * EFFECTS: sets categoryComboBox as default (...), and brandTextField, modelTextField, conditionTextField,
     *          sizeTextField, boughtPriceTextField, and marketPriceTextField as empty string ("")
     */
    private void doEmptyTextField() {
        categoryComboBox.setSelectedIndex(0);
        brandTextField.setText("");
        modelTextField.setText("");
        conditionTextField.setText("");
        sizeTextField.setText("");
        boughtPriceTextField.setText("");
        marketPriceTextField.setText("");
    }

    /*
     * MODIFIES: this
     * EFFECTS: sets clothingTableModel and shoesTableModel as 0 (empties clothingTableModel and shoesTableModel data)
     */
    private void doEmptyTable() {
        clothingTableModel.setRowCount(0);
        shoesTableModel.setRowCount(0);
    }

    /*
     * MODIFIES: this
     * EFFECTS: displays number of streetWear items, number of clothing, and number of shoes in collectionLabel,
     *          clothingLabel and shoesLabel respectively
     */
    private void doViewStreetWearCollection() {
        collectionLabel.setText("Total Number of StreetWear Items: "
                + streetWearCollection.getNumberOfStreetWearItems());
        clothingLabel.setText("Total Number of Clothing: "
                + streetWearCollection.getNumberOfClothing());
        shoesLabel.setText("Total Number of Shoes: "
                + streetWearCollection.getNumberOfShoes());
    }

    /*
     * EFFECTS: print to the console all the events that have been logged since the application started
     */
    private void processEventLog() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.toString());
                }
            }
        });
    }

}
