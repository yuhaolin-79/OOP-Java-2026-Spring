/**
 * This interface declares the method that every formatter class
 * will implement.
 *
 * @author author name
 * @version 1.1.0
 * @see Sales
 */
@FunctionalInterface
public interface SalesFormatter {

	/**
	 * Produces a string representation of the sales information.
	 *
	 * @param sales the sales information
	 * @return a string representation of the sales information
	 */
	String formatSales(Sales sales);
}
