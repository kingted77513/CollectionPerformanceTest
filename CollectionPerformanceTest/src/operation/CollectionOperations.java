package operation;

import java.util.Collection;
import java.util.Iterator;

public class CollectionOperations {
	Collection<String> collection;
	String probe;
	
	public void membership() {
		collection.contains(probe);
	}
	
	public void iteration() {
		Iterator<String> all = collection.iterator();
		while (all.hasNext()) {
			all.next();
		}
	}
	
	public void modification() {
		collection.add("b");
		collection.remove("b");
	}
}
