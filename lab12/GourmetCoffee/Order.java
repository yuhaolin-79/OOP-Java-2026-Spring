import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a single order containing multiple order items.
 */
public class Order {

    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Iterator<OrderItem> getItemsIterator() {
        return items.iterator();
    }

    public OrderItem getItem(Product product) {
        for (OrderItem item : items) {
            if (item.getProduct().equals(product)) {
                return item;
            }
        }
        return null;
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public double getTotalCost() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getValue();
        }
        return total;
    }

    /**
     * Returns an array of all order items.
     * Used by the GUI to populate the order JList.
     */
    public OrderItem[] getItems() {
        return items.toArray(new OrderItem[0]);
    }
}
