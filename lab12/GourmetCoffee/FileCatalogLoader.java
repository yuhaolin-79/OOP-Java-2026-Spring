import java.io.*;
import java.util.StringTokenizer;

/**
 * Implements CatalogLoader to load product catalog from a file.
 */
public class FileCatalogLoader implements CatalogLoader {

    private static final int PRODUCT_FIELDS = 4;
    private static final int COFFEE_FIELDS = 10;
    private static final int BREWER_FIELDS = 7;

    /**
     * Parses a line of coffee-accessory data.
     */
    private Product readProduct(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        if (tokenizer.countTokens() != PRODUCT_FIELDS) {
            throw new DataFormatException(line);
        }

        tokenizer.nextToken(); // skip "Product" prefix
        String code = tokenizer.nextToken();
        String description = tokenizer.nextToken();

        double price;
        try {
            price = Double.parseDouble(tokenizer.nextToken());
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }

        return new Product(code, description, price);
    }

    /**
     * Parses a line of coffee data.
     */
    private Coffee readCoffee(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        if (tokenizer.countTokens() != COFFEE_FIELDS) {
            throw new DataFormatException(line);
        }

        tokenizer.nextToken(); // skip "Coffee" prefix
        String code = tokenizer.nextToken();
        String description = tokenizer.nextToken();

        double price;
        try {
            price = Double.parseDouble(tokenizer.nextToken());
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }

        String origin = tokenizer.nextToken();
        String roast = tokenizer.nextToken();
        String flavor = tokenizer.nextToken();
        String aroma = tokenizer.nextToken();
        String acidity = tokenizer.nextToken();
        String body = tokenizer.nextToken();

        return new Coffee(code, description, price, origin, roast,
                flavor, aroma, acidity, body);
    }

    /**
     * Parses a line of coffee-brewer data.
     */
    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        if (tokenizer.countTokens() != BREWER_FIELDS) {
            throw new DataFormatException(line);
        }

        tokenizer.nextToken(); // skip "Brewer" prefix
        String code = tokenizer.nextToken();
        String description = tokenizer.nextToken();

        double price;
        try {
            price = Double.parseDouble(tokenizer.nextToken());
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }

        String model = tokenizer.nextToken();
        String waterSupply = tokenizer.nextToken();

        int numberOfCups;
        try {
            numberOfCups = Integer.parseInt(tokenizer.nextToken());
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }

        return new CoffeeBrewer(code, description, price, model, waterSupply, numberOfCups);
    }

    @Override
    public Catalog loadCatalog(String fileName)
            throws FileNotFoundException, IOException, DataFormatException {

        Catalog catalog = new Catalog();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            while (line != null) {
                if (line.startsWith("Coffee")) {
                    catalog.addProduct(readCoffee(line));
                } else if (line.startsWith("Brewer")) {
                    catalog.addProduct(readCoffeeBrewer(line));
                } else if (line.startsWith("Product")) {
                    catalog.addProduct(readProduct(line));
                }
                line = reader.readLine();
            }
        }

        return catalog;
    }
}
