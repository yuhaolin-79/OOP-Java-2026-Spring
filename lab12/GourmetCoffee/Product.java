import javax.swing.*;
import java.awt.*;

/**
 * Base product in the gourmet coffee catalog.
 */
public class Product {

    private String code;
    private String description;
    private double price;

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Product && code.equals(((Product) obj).code);
    }

    @Override
    public String toString() {
        return code + "_" + description + "_" + price;
    }

    /**
     * Returns a JPanel displaying the product attributes.
     */
    public JPanel getPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3, 5, 3, 5);
        c.anchor = GridBagConstraints.WEST;

        JTextField codeField = new JTextField(code, 20);
        codeField.setEditable(false);
        JTextField descField = new JTextField(description, 20);
        descField.setEditable(false);
        JTextField priceField = new JTextField(String.format("%.2f", price), 20);
        priceField.setEditable(false);

        c.gridx = 0; c.gridy = 0;
        panel.add(new JLabel("Code:"), c);
        c.gridx = 1;
        panel.add(codeField, c);

        c.gridx = 0; c.gridy = 1;
        panel.add(new JLabel("Description:"), c);
        c.gridx = 1;
        panel.add(descField, c);

        c.gridx = 0; c.gridy = 2;
        panel.add(new JLabel("Price:"), c);
        c.gridx = 1;
        panel.add(priceField, c);

        return panel;
    }
}
