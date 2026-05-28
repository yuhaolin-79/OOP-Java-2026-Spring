import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Product catalog containing all products in the gourmet coffee store.
 */
public class Catalog {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Iterator<Product> getProductsIterator() {
        return products.iterator();
    }

    public Product getProduct(String code) {
        for (Product product : products) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    /**
     * Returns an array of all product codes.
     * Used by the GUI to populate the catalog JList.
     */
    public String[] getCodes() {
        String[] codes = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            codes[i] = products.get(i).getCode();
        }
        return codes;
    }
}
