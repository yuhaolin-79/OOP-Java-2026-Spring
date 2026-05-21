import java.util.Iterator;

/**
 * This class implements the interface SalesFormatter.
 * It produces an HTML representation of the sales information.
 * This class is implemented as a singleton.
 *
 * @author author name
 * @version 1.1.0
 * @see SalesFormatter
 * @see Sales
 */
public class HTMLSalesFormatter implements SalesFormatter {

	private static final String LINE_SEPARATOR = System.lineSeparator();

	private static HTMLSalesFormatter singletonInstance;

	/**
	 * Constructs an HTMLSalesFormatter object.
	 * Declared private so it is inaccessible to other classes.
	 */
	private HTMLSalesFormatter() {
	}

	/**
	 * Obtains the single instance of class HTMLSalesFormatter.
	 *
	 * @return the single instance of HTMLSalesFormatter
	 */
	public static HTMLSalesFormatter getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new HTMLSalesFormatter();
		}
		return singletonInstance;
	}

	/**
	 * Produces a string that contains the specified sales information
	 * in an HTML format.
	 *
	 * @param sales the sales information
	 * @return a string representation of the sales information in HTML
	 */
	public String formatSales(Sales sales) {
		StringBuilder sb = new StringBuilder();

		sb.append("<html>").append(LINE_SEPARATOR);
		sb.append("  <body>").append(LINE_SEPARATOR);
		sb.append("    <center><h2>Orders</h2></center>").append(LINE_SEPARATOR);

		Iterator<Order> orders = sales.getOrdersIterator();
		while (orders.hasNext()) {
			Order order = orders.next();

			sb.append("    <hr>").append(LINE_SEPARATOR);
			sb.append("    <h4>Total = ").append(order.getTotalCost())
			  .append("</h4>").append(LINE_SEPARATOR);

			Iterator<OrderItem> items = order.getItemsIterator();
			while (items.hasNext()) {
				OrderItem item = items.next();

				sb.append("      <p>").append(LINE_SEPARATOR);
				sb.append("        <b>code:</b> ")
				  .append(item.getProduct().getCode()).append("<br>")
				  .append(LINE_SEPARATOR);
				sb.append("        <b>quantity:</b> ")
				  .append(item.getQuantity()).append("<br>")
				  .append(LINE_SEPARATOR);
				sb.append("        <b>price:</b> ")
				  .append(item.getProduct().getPrice())
				  .append(LINE_SEPARATOR);
				sb.append("      </p>").append(LINE_SEPARATOR);
			}
		}

		sb.append("  </body>").append(LINE_SEPARATOR);
		sb.append("</html>");

		return sb.toString();
	}
}
