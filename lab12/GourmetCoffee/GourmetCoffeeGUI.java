import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.text.*;

/**
 * Gourmet Coffee System — Graphical User Interface.
 * <p>
 * Displays the product catalog, manages orders, and handles sales
 * with Plain Text / HTML / XML output formats.
 *
 * @see Product
 * @see Coffee
 * @see CoffeeBrewer
 * @see Catalog
 * @see OrderItem
 * @see Order
 * @see Sales
 * @see CatalogLoader
 * @see FileCatalogLoader
 * @see DataFormatException
 * @see SalesFormatter
 * @see PlainTextSalesFormatter
 * @see HTMLSalesFormatter
 * @see XMLSalesFormatter
 */
public class GourmetCoffeeGUI extends JPanel {

    private static final PrintWriter STD_ERR = new PrintWriter(System.err, true);

    private static final int WIDTH = 600;
    private static final int HEIGHT = 530;
    private static final int CATALOG_CELL_SIZE = 50;
    private static final int CATALOG_LIST_ROWS = 14;
    private static final int ORDER_CELL_SIZE = 100;
    private static final int ORDER_LIST_ROWS = 6;
    private static final int QUANTITY_TEXTFIELD_SIZE = 5;
    private static final int TOTAL_TEXTFIELD_SIZE = 8;
    private static final int STATUS_ROWS = 10;
    private static final int STATUS_COLS = 40;

    private JList<String> catalogList;
    private JList<OrderItem> orderList;
    private JButton addModifyButton;
    private JButton removeButton;
    private JButton registerSaleButton;
    private JButton displaySalesButton;
    private JButton saveSalesButton;
    private JPanel productPanel;
    private JTextField quantityTextField;
    private JTextField totalTextField;
    private JTextArea statusTextArea;
    private JRadioButton plainRadioButton;
    private JRadioButton HTMLRadioButton;
    private JRadioButton XMLRadioButton;

    private JFileChooser fileChooser;

    private Catalog catalog;
    private Order currentOrder;
    private Sales sales;
    private SalesFormatter salesFormatter;
    private NumberFormat dollarFormatter;

    // ──────────────────────────────────────────────────────────────
    //  main
    // ──────────────────────────────────────────────────────────────

    /**
     * Loads the product catalog and launches the GUI.
     */
    public static void main(String[] args) throws IOException {
        String filename = args.length == 1 ? args[0] : "catalog.dat";

        try {
            Catalog catalog = new FileCatalogLoader().loadCatalog(filename);

            JFrame frame = new JFrame("Gourmet Coffee");
            frame.setContentPane(new GourmetCoffeeGUI(catalog));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.setResizable(true);
            frame.setVisible(true);

        } catch (FileNotFoundException e) {
            STD_ERR.println("The file does not exist");
            System.exit(1);
        } catch (DataFormatException e) {
            STD_ERR.println("The file contains malformed data: " + e.getMessage());
            System.exit(1);
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  constructor — layout the UI
    // ──────────────────────────────────────────────────────────────

    public GourmetCoffeeGUI(Catalog initialCatalog) {
        // --- components ---
        catalogList = new JList<>();
        orderList = new JList<>();
        catalogList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        catalogList.setVisibleRowCount(CATALOG_LIST_ROWS);
        catalogList.setFixedCellWidth(CATALOG_CELL_SIZE);
        orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orderList.setVisibleRowCount(ORDER_LIST_ROWS);
        orderList.setFixedCellWidth(ORDER_CELL_SIZE);

        addModifyButton = new JButton("Add|Modify Order Item");
        removeButton = new JButton("Remove Order Item");
        registerSaleButton = new JButton("Register Sale of Current Order");
        displaySalesButton = new JButton("Display Sales");
        saveSalesButton = new JButton("Save Sales");

        quantityTextField = new JTextField("", QUANTITY_TEXTFIELD_SIZE);
        totalTextField = new JTextField("$0.00", TOTAL_TEXTFIELD_SIZE);
        totalTextField.setEditable(false);

        statusTextArea = new JTextArea(STATUS_ROWS, STATUS_COLS);
        statusTextArea.setEditable(false);

        // radio buttons
        plainRadioButton = new JRadioButton("Plain", true);
        HTMLRadioButton = new JRadioButton("HTML");
        XMLRadioButton = new JRadioButton("XML");
        ButtonGroup group = new ButtonGroup();
        group.add(plainRadioButton);
        group.add(HTMLRadioButton);
        group.add(XMLRadioButton);

        // --- panels ---

        // Product Information
        productPanel = new JPanel();
        productPanel.setBorder(BorderFactory.createTitledBorder("Product Information"));

        // Catalog
        JPanel catalogPanel = new JPanel();
        catalogPanel.setBorder(BorderFactory.createTitledBorder("Catalog"));
        catalogPanel.add(new JScrollPane(catalogList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        // Add|Modify area
        JPanel centralPanel = new JPanel(new BorderLayout());
        JPanel addModifyPanel = new JPanel(new GridLayout(2, 1));
        JPanel quantityPanel = new JPanel();
        quantityPanel.add(new JLabel("Quantity:"));
        quantityPanel.add(quantityTextField);
        addModifyPanel.add(quantityPanel);
        addModifyPanel.add(addModifyButton);
        centralPanel.add(productPanel, BorderLayout.CENTER);
        centralPanel.add(addModifyPanel, BorderLayout.SOUTH);

        // Order
        JPanel orderPanel = new JPanel(new BorderLayout());
        orderPanel.setBorder(BorderFactory.createTitledBorder("Order"));
        JPanel totalPanel = new JPanel();
        totalPanel.add(new JLabel("Total:"));
        totalPanel.add(totalTextField);
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        buttonsPanel.add(removeButton);
        buttonsPanel.add(registerSaleButton);
        orderPanel.add(totalPanel, BorderLayout.NORTH);
        orderPanel.add(new JScrollPane(orderList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        orderPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Status / bottom
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Status"));
        JPanel salesButtonsPanel = new JPanel(new GridLayout(1, 5));
        salesButtonsPanel.add(plainRadioButton);
        salesButtonsPanel.add(HTMLRadioButton);
        salesButtonsPanel.add(XMLRadioButton);
        salesButtonsPanel.add(displaySalesButton);
        salesButtonsPanel.add(saveSalesButton);
        bottomPanel.add(new JScrollPane(statusTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        bottomPanel.add(salesButtonsPanel, BorderLayout.SOUTH);

        // assemble top-level
        setLayout(new BorderLayout());
        add(catalogPanel, BorderLayout.WEST);
        add(centralPanel, BorderLayout.CENTER);
        add(orderPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        // --- event wiring ---
        catalogList.addListSelectionListener(new DisplayProductListener());
        addModifyButton.addActionListener(new AddModifyListener());
        removeButton.addActionListener(new RemoveListener());
        registerSaleButton.addActionListener(new RegisterSaleListener());
        displaySalesButton.addActionListener(new DisplaySalesListener());
        saveSalesButton.addActionListener(new SaveSalesListener());
        plainRadioButton.addActionListener(new PlainListener());
        HTMLRadioButton.addActionListener(new HTMLListener());
        XMLRadioButton.addActionListener(new XMLListener());

        // --- data ---
        catalog = initialCatalog;
        catalogList.setListData(catalog.getCodes());

        currentOrder = new Order();
        sales = new Sales();
        salesFormatter = PlainTextSalesFormatter.getSingletonInstance();
        fileChooser = new JFileChooser();
        dollarFormatter = NumberFormat.getCurrencyInstance();
    }

    // ──────────────────────────────────────────────────────────────
    //  helper — refresh order display
    // ──────────────────────────────────────────────────────────────

    private void updateOrderDisplay() {
        orderList.setListData(currentOrder.getItems());
        totalTextField.setText(dollarFormatter.format(currentOrder.getTotalCost()));
    }

    // ──────────────────────────────────────────────────────────────
    //  Inner Classes — Listeners
    // ──────────────────────────────────────────────────────────────

    /**
     * Displays product details when a catalog item is selected.
     */
    class DisplayProductListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (catalogList.getValueIsAdjusting()) return;

            String code = catalogList.getSelectedValue();
            if (code == null) return;

            Product product = catalog.getProduct(code);

            productPanel.removeAll();
            productPanel.setVisible(false);
            productPanel.add(product.getPanel());
            productPanel.setVisible(true);

            statusTextArea.setText("Product " + code + " has been displayed");
        }
    }

    /**
     * Adds or modifies an order item.
     */
    class AddModifyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String code = catalogList.getSelectedValue();
            if (code == null) {
                statusTextArea.setText("No product is selected.");
                return;
            }

            String quantityText = quantityTextField.getText().trim();
            if (quantityText.isEmpty()) {
                statusTextArea.setText("Enter a quantity.");
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityText);
            } catch (NumberFormatException e) {
                statusTextArea.setText("The quantity must be an integer.");
                return;
            }

            if (quantity <= 0) {
                statusTextArea.setText("The quantity must be positive.");
                return;
            }

            Product product = catalog.getProduct(code);
            OrderItem existing = currentOrder.getItem(product);

            if (existing != null) {
                existing.setQuantity(quantity);
                statusTextArea.setText("The quantity of " + code + " has been modified.");
            } else {
                currentOrder.addItem(new OrderItem(product, quantity));
                statusTextArea.setText("The product " + code + " has been added.");
            }

            updateOrderDisplay();
        }
    }

    /**
     * Removes the selected item from the current order.
     */
    class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (currentOrder.getNumberOfItems() == 0) {
                statusTextArea.setText("The order is empty.");
                return;
            }

            OrderItem selected = orderList.getSelectedValue();
            if (selected == null) {
                statusTextArea.setText("No item is selected in the order.");
                return;
            }

            currentOrder.removeItem(selected);
            statusTextArea.setText("The item " + selected.getProduct().getCode()
                    + " has been removed.");
            updateOrderDisplay();
        }
    }

    /**
     * Registers the current order as a sale.
     */
    class RegisterSaleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (currentOrder.getNumberOfItems() == 0) {
                statusTextArea.setText("The order is empty.");
                return;
            }

            sales.addOrder(currentOrder);
            currentOrder = new Order();
            updateOrderDisplay();
            statusTextArea.setText("The sale has been registered.");
        }
    }

    /**
     * Displays all registered sales in the status area.
     */
    class DisplaySalesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (sales.getNumberOfOrders() == 0) {
                statusTextArea.setText("No orders have been sold.");
            } else {
                statusTextArea.setText(salesFormatter.formatSales(sales));
            }
        }
    }

    /**
     * Saves sales to a file chosen via JFileChooser.
     */
    class SaveSalesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (sales.getNumberOfOrders() == 0) {
                statusTextArea.setText("No orders have been sold.");
                return;
            }

            int result = fileChooser.showSaveDialog(GourmetCoffeeGUI.this);
            if (result != JFileChooser.APPROVE_OPTION) {
                statusTextArea.setText("Save cancelled.");
                return;
            }

            File file = fileChooser.getSelectedFile();

            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                writer.print(salesFormatter.formatSales(sales));
                statusTextArea.setText("Sales have been saved to " + file.getName());
            } catch (IOException e) {
                statusTextArea.setText("Error: could not save to " + file.getName());
            }
        }
    }

    /** Sets formatter to Plain Text. */
    class PlainListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            salesFormatter = PlainTextSalesFormatter.getSingletonInstance();
        }
    }

    /** Sets formatter to HTML. */
    class HTMLListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            salesFormatter = HTMLSalesFormatter.getSingletonInstance();
        }
    }

    /** Sets formatter to XML. */
    class XMLListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            salesFormatter = XMLSalesFormatter.getSingletonInstance();
        }
    }
}
