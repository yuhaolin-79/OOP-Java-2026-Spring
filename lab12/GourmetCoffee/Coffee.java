import javax.swing.*;
import java.awt.*;

/**
 * Represents a coffee product.
 */
public class Coffee extends Product {

    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    public Coffee(String code, String description, double price,
                  String origin, String roast, String flavor,
                  String aroma, String acidity, String body) {
        super(code, description, price);
        this.origin = origin;
        this.roast = roast;
        this.flavor = flavor;
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;
    }

    public String getOrigin() {
        return origin;
    }

    public String getRoast() {
        return roast;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getAroma() {
        return aroma;
    }

    public String getAcidity() {
        return acidity;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + origin + "_" + roast + "_"
                + flavor + "_" + aroma + "_" + acidity + "_" + body;
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
        JTextField originField = new JTextField(origin, 20);
        originField.setEditable(false);
        JTextField roastField = new JTextField(roast, 20);
        roastField.setEditable(false);
        JTextField flavorField = new JTextField(flavor, 20);
        flavorField.setEditable(false);
        JTextField aromaField = new JTextField(aroma, 20);
        aromaField.setEditable(false);
        JTextField acidityField = new JTextField(acidity, 20);
        acidityField.setEditable(false);
        JTextField bodyField = new JTextField(body, 20);
        bodyField.setEditable(false);

        String[] labels = {"Code:", "Description:", "Price:", "Origin:",
                "Roast:", "Flavor:", "Aroma:", "Acidity:", "Body:"};
        JTextField[] fields = {codeField, descField, priceField, originField,
                roastField, flavorField, aromaField, acidityField, bodyField};

        for (int i = 0; i < labels.length; i++) {
            c.gridx = 0; c.gridy = i;
            panel.add(new JLabel(labels[i]), c);
            c.gridx = 1;
            panel.add(fields[i], c);
        }

        return panel;
    }
}
