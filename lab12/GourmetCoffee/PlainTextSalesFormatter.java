import java.util.Iterator;

public class PlainTextSalesFormatter implements SalesFormatter {

    private static final String NEW_LINE = System.lineSeparator();
    private static PlainTextSalesFormatter singletonInstance;

    public static PlainTextSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new PlainTextSalesFormatter();
        }
        return singletonInstance;
    }

    private PlainTextSalesFormatter() {
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder sb = new StringBuilder();
        int orderNum = 0;

        for (Iterator<Order> i = sales.getOrdersIterator(); i.hasNext(); ) {
            Order order = i.next();
            orderNum++;

            sb.append("------------------------").append(NEW_LINE);
            sb.append("Order ").append(orderNum).append(NEW_LINE);
            sb.append(NEW_LINE);

            for (Iterator<OrderItem> j = order.getItemsIterator(); j.hasNext(); ) {
                OrderItem item = j.next();
                sb.append(item.getQuantity()).append(" ")
                  .append(item.getProduct().getCode()).append(" ")
                  .append(item.getProduct().getPrice()).append(NEW_LINE);
            }

            sb.append(NEW_LINE);
            sb.append("Total = ").append(order.getTotalCost()).append(NEW_LINE);
        }

        return sb.toString();
    }
}
