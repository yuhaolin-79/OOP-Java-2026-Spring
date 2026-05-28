import java.io.*;
import java.util.StringTokenizer;

/**
 * This class implements the interface CatalogLoader and loads
 * the product catalog from a file.
 *
 * @author author name
 * @version 1.1.0
 * @see CatalogLoader
 */
public class FileCatalogLoader implements CatalogLoader {

	/**
	 * Reads a line of coffee-accessory data and returns a Product object.
	 *
	 * @param line  a line of coffee-accessory data
	 * @return a Product object
	 * @throws DataFormatException if the line is malformed
	 */
	private Product readProduct(String line)
			throws DataFormatException {

		StringTokenizer tokenizer = new StringTokenizer(line, "_");
		int tokenCount = tokenizer.countTokens();

		if (tokenCount != 4) {
			throw new DataFormatException(line);
		}

		tokenizer.nextToken();  // skip "Product" prefix
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
	 * Reads a line of coffee data and returns a Coffee object.
	 *
	 * @param line  a line of coffee data
	 * @return a Coffee object
	 * @throws DataFormatException if the line is malformed
	 */
	private Coffee readCoffee(String line)
			throws DataFormatException {

		StringTokenizer tokenizer = new StringTokenizer(line, "_");
		int tokenCount = tokenizer.countTokens();

		if (tokenCount != 10) {
			throw new DataFormatException(line);
		}

		tokenizer.nextToken();  // skip "Coffee" prefix
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
	 * Reads a line of coffee-brewer data and returns a CoffeeBrewer object.
	 *
	 * @param line  a line of coffee-brewer data
	 * @return a CoffeeBrewer object
	 * @throws DataFormatException if the line is malformed
	 */
	private CoffeeBrewer readCoffeeBrewer(String line)
			throws DataFormatException {

		StringTokenizer tokenizer = new StringTokenizer(line, "_");
		int tokenCount = tokenizer.countTokens();

		if (tokenCount != 7) {
			throw new DataFormatException(line);
		}

		tokenizer.nextToken();  // skip "Brewer" prefix
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

		return new CoffeeBrewer(code, description, price, model,
				waterSupply, numberOfCups);
	}

	/**
	 * Loads the information in the specified file into a product
	 * catalog and returns the catalog.
	 *
	 * @param filename  the name of a file that contains catalog information
	 * @return a product catalog
	 * @throws FileNotFoundException  if the specified file does not exist
	 * @throws IOException  if there is an error reading the file
	 * @throws DataFormatException  if the file contains badly-formed data
	 */
	public Catalog loadCatalog(String fileName)
			throws FileNotFoundException, IOException, DataFormatException {

		Catalog catalog = new Catalog();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		try {
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
		} finally {
			reader.close();
		}

		return catalog;
	}
}
