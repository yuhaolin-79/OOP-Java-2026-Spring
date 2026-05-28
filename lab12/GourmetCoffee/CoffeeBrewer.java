import javax.swing.*;
import java.awt.*;

/**
 * Represents a coffee brewer product.
 */
public class CoffeeBrewer extends Product {

    private String model;
    private String waterSupply;
    private int numberOfCups;

    public CoffeeBrewer(String code, String description, double price,
                        String model, String waterSupply, int numberOfCups) {
        super(code, description, price);
        this.model = model;
        this.waterSupply = waterSupply;
        this.numberOfCups = numberOfCups;
    }

    public String getModel() {
        return model;
    }

    public String getWaterSupply() {
        return waterSupply;
    }

    public int getNumberOfCups() {
        return numberOfCups;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + model + "_" + waterSupply + "_" + numberOfCups;
    }

    @Override
    public JPanel getPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 5, 2, 5);
        c.anchor = GridBagConstraints.WEST;

        JTextField codeField = new JTextField(getCode(), 20);
        codeField.setEditable(false);
        JTextField descField = new JTextField(getDescription(), 20);
        descField.setEditable(false);
        JTextField priceField = new JTextField(String.format("%.2f", getPrice()), 20);
        priceField.setEditable(false);
        JTextField modelField = new JTextField(model, 20);
        modelField.setEditable(false);
        JTextField waterField = new JTextField(waterSupply, 20);
        waterField.setEditable(false);
        JTextField cupsField = new JTextField(String.valueOf(numberOfCups), 20);
        cupsField.setEditable(false);

        String[] labels = {"Code:", "Description:", "Price:",
                "Model:", "Water Supply:", "Number of Cups:"};
        JTextField[] fields = {codeField, descField, priceField,
                modelField, waterField, cupsField};

        for (int i = 0; i < labels.length; i++) {
            c.gridx = 0; c.gridy = i;
            panel.add(new JLabel(labels[i]), c);
            c.gridx = 1;
            panel.add(fields[i], c);
        }

        return panel;
    }
}
