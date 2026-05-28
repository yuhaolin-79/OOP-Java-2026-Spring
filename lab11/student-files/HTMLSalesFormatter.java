import java.util.Iterator;

/**
 * This class implements a sales formatter that produces HTML output.
 *
 * @author author name
 * @version 1.1.0
 * @see SalesFormatter
 */
public class HTMLSalesFormatter implements SalesFormatter {

	private static final String NEW_LINE =
		System.getProperty("line.separator");

	private static HTMLSalesFormatter singletonInstance = null;

	/**
	 * Returns the singleton instance of HTMLSalesFormatter.
	 *
	 * @return the singleton instance
	 */
	public static HTMLSalesFormatter getSingletonInstance() {

		if (singletonInstance == null) {
			singletonInstance = new HTMLSalesFormatter();
		}

		return singletonInstance;
	}

	/**
	 * Constructs a HTMLSalesFormatter object.
	 */
	private HTMLSalesFormatter() {
	}

	/**
	 * Formats the sales information as HTML.
	 *
	 * @param sales  the sales to format
	 * @return a string containing the HTML-formatted sales
	 */
	public String formatSales(Sales sales) {

		String result = "<html>" + NEW_LINE
			+ "  <body>" + NEW_LINE
			+ "    <center><h2>Orders</h2></center>" + NEW_LINE;

		for (Iterator i = sales.getOrdersIterator(); i.hasNext();) {

			Order order = (Order) i.next();

			result += "    <hr>" + NEW_LINE
				+ "    <h4>Total = " + order.getTotalCost()
				+ "</h4>" + NEW_LINE;

			for (Iterator j = order.getItemsIterator(); j.hasNext();) {

				OrderItem item = (OrderItem) j.next();

				result += "      <p>" + NEW_LINE
					+ "        <b>code:</b> "
					+ item.getProduct().getCode() + "<br>" + NEW_LINE
					+ "        <b>quantity:</b> "
					+ item.getQuantity() + "<br>" + NEW_LINE
					+ "        <b>price:</b> "
					+ item.getProduct().getPrice() + NEW_LINE
					+ "      </p>" + NEW_LINE;
			}
		}

		result += "  </body>" + NEW_LINE + "</html>";

		return result;
	}
}
