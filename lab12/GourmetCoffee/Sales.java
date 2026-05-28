import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sales {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Iterator<Order> getOrdersIterator() {
        return orders.iterator();
    }

    public int getNumberOfOrders() {
        return orders.size();
    }
}
