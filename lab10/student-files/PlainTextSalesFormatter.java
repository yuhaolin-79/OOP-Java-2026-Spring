import java.util.Iterator;

/**
 * This class implements the interface SalesFormatter.
 * It produces a plain-text representation of the sales information.
 * This class is implemented as a singleton.
 *
 * @author author name
 * @version 1.1.0
 * @see SalesFormatter
 * @see Sales
 */
public class PlainTextSalesFormatter implements SalesFormatter {

	private static final String LINE_SEPARATOR = System.lineSeparator();

	private static PlainTextSalesFormatter singletonInstance;

	/**
	 * Constructs a PlainTextSalesFormatter object.
	 * Declared private so it is inaccessible to other classes.
	 */
	private PlainTextSalesFormatter() {
	}

	/**
	 * Obtains the single instance of class PlainTextSalesFormatter.
	 *
	 * @return the single instance of PlainTextSalesFormatter
	 */
	public static PlainTextSalesFormatter getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new PlainTextSalesFormatter();
		}
		return singletonInstance;
	}

	/**
	 * Produces a string that contains the specified sales information
	 * in a plain-text format.
	 *
	 * @param sales the sales information
	 * @return a string representation of the sales information in plain-text
	 */
	public String formatSales(Sales sales) {
		StringBuilder sb = new StringBuilder();
		int orderNumber = 1;

		Iterator<Order> orders = sales.getOrdersIterator();
		while (orders.hasNext()) {
			Order order = orders.next();

			sb.append("------------------------");
			sb.append(LINE_SEPARATOR);
			sb.append("Order ").append(orderNumber);
			sb.append(LINE_SEPARATOR).append(LINE_SEPARATOR);

			Iterator<OrderItem> items = order.getItemsIterator();
			while (items.hasNext()) {
				OrderItem item = items.next();
				sb.append(item.getQuantity()).append(" ")
				  .append(item.getProduct().getCode()).append(" ")
				  .append(item.getProduct().getPrice());
				sb.append(LINE_SEPARATOR);
			}

			sb.append(LINE_SEPARATOR);
			sb.append("Total = ").append(order.getTotalCost());
			sb.append(LINE_SEPARATOR);

			orderNumber++;
		}

		return sb.toString();
	}
}
