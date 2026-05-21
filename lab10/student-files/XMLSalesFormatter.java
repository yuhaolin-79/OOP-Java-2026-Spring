import java.util.Iterator;

/**
 * This class implements the interface SalesFormatter.
 * It produces an XML representation of the sales information.
 * This class is implemented as a singleton.
 *
 * @author author name
 * @version 1.1.0
 * @see SalesFormatter
 * @see Sales
 */
public class XMLSalesFormatter implements SalesFormatter {

	private static final String LINE_SEPARATOR = System.lineSeparator();

	private static XMLSalesFormatter singletonInstance;

	/**
	 * Constructs an XMLSalesFormatter object.
	 * Declared private so it is inaccessible to other classes.
	 */
	private XMLSalesFormatter() {
	}

	/**
	 * Obtains the single instance of class XMLSalesFormatter.
	 *
	 * @return the single instance of XMLSalesFormatter
	 */
	public static XMLSalesFormatter getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new XMLSalesFormatter();
		}
		return singletonInstance;
	}

	/**
	 * Produces a string that contains the specified sales information
	 * in an XML format.
	 *
	 * @param sales the sales information
	 * @return a string representation of the sales information in XML
	 */
	@Override
	public String formatSales(Sales sales) {
		StringBuilder sb = new StringBuilder();

		sb.append("<Sales>").append(LINE_SEPARATOR);

		Iterator<Order> orders = sales.getOrdersIterator();
		while (orders.hasNext()) {
			Order order = orders.next();

			sb.append("  <Order total=\"")
			  .append(order.getTotalCost()).append("\">")
			  .append(LINE_SEPARATOR);

			Iterator<OrderItem> items = order.getItemsIterator();
			while (items.hasNext()) {
				OrderItem item = items.next();

				sb.append("    <OrderItem quantity=\"")
				  .append(item.getQuantity())
				  .append("\" price=\"")
				  .append(item.getProduct().getPrice())
				  .append("\">")
				  .append(item.getProduct().getCode())
				  .append("</OrderItem>")
				  .append(LINE_SEPARATOR);
			}

			sb.append("  </Order>").append(LINE_SEPARATOR);
		}

		sb.append("</Sales>");

		return sb.toString();
	}
}
