import java.util.*;

public class BorrowedItems implements Iterable<CatalogItem> {
	private ArrayList<CatalogItem> items = new ArrayList<CatalogItem>();
	
	public Iterator<CatalogItem> iterator() {
		return items.iterator();
	}
}
