import java.util.Iterator;

public class XMLSalesFormatter implements SalesFormatter {

    private static final String NEW_LINE = System.lineSeparator();
    private static XMLSalesFormatter singletonInstance;

    public static XMLSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new XMLSalesFormatter();
        }
        return singletonInstance;
    }

    private XMLSalesFormatter() {
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder sb = new StringBuilder();
        sb.append("<Sales>").append(NEW_LINE);

        for (Iterator<Order> i = sales.getOrdersIterator(); i.hasNext(); ) {
            Order order = i.next();
            sb.append("  <Order total=\"").append(order.getTotalCost())
              .append("\">").append(NEW_LINE);

            for (Iterator<OrderItem> j = order.getItemsIterator(); j.hasNext(); ) {
                OrderItem item = j.next();
                sb.append("    <OrderItem quantity=\"").append(item.getQuantity())
                  .append("\" price=\"").append(item.getProduct().getPrice())
                  .append("\">").append(item.getProduct().getCode())
                  .append("</OrderItem>").append(NEW_LINE);
            }

            sb.append("  </Order>").append(NEW_LINE);
        }

        sb.append("</Sales>");
        return sb.toString();
    }
}
