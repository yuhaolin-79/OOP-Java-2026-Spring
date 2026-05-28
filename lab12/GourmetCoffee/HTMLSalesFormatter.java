import java.util.Iterator;

/**
 * Sales formatter that produces HTML output.
 */
public class HTMLSalesFormatter implements SalesFormatter {

    private static final String NEW_LINE = System.lineSeparator();
    private static HTMLSalesFormatter singletonInstance;

    public static HTMLSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new HTMLSalesFormatter();
        }
        return singletonInstance;
    }

    private HTMLSalesFormatter() {
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder sb = new StringBuilder();

        sb.append("<html>").append(NEW_LINE);
        sb.append("  <body>").append(NEW_LINE);
        sb.append("    <center><h2>Orders</h2></center>").append(NEW_LINE);

        for (Iterator<Order> i = sales.getOrdersIterator(); i.hasNext(); ) {
            Order order = i.next();

            sb.append("    <hr>").append(NEW_LINE);
            sb.append("    <h4>Total = ").append(order.getTotalCost())
              .append("</h4>").append(NEW_LINE);

            for (Iterator<OrderItem> j = order.getItemsIterator(); j.hasNext(); ) {
                OrderItem item = j.next();

                sb.append("      <p>").append(NEW_LINE);
                sb.append("        <b>code:</b> ")
                  .append(item.getProduct().getCode()).append("<br>").append(NEW_LINE);
                sb.append("        <b>quantity:</b> ")
                  .append(item.getQuantity()).append("<br>").append(NEW_LINE);
                sb.append("        <b>price:</b> ")
                  .append(item.getProduct().getPrice()).append(NEW_LINE);
                sb.append("      </p>").append(NEW_LINE);
            }
        }

        sb.append("  </body>").append(NEW_LINE).append("</html>");
        return sb.toString();
    }
}
