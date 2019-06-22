package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class SetVsArrayList {
	private CollectionOperations setOperation;
	private CollectionOperations arrayListOperation;
	
	public SetVsArrayList(int size) {
		Collection<String> set = new HashSet<String>(size);
		Collection<String> arrayList = new ArrayList<String>(size);
		for (int i = 0 ; i < size ; i++) {
			String element = String.format("a%d", i);
			set.add(element);
			arrayList.add(element);
		}
		
		String probe = String.format("a%d", size / 2);
		setOperation = new CollectionOperations(set, probe);
		arrayListOperation = new CollectionOperations(arrayList, probe);
	}
	
	private class CollectionOperations {
		private Collection<String> collection;
		private String probe;
		
		private CollectionOperations(Collection<String> collection
				, String probe) {
			this.collection = collection;
			this.probe = probe;
		}
		
		private void membership() {
			collection.contains(probe);
		}
		
		private void iteration() {
			Iterator<String> all = collection.iterator();
			while (all.hasNext()) {
				all.next();
			}
		}
		
		private void modification() {
			collection.add("b");
			collection.remove("b");
		}
	}

	public void setMembership() {
		setOperation.membership();
	}
	
	public void arrayListMembership() {
		arrayListOperation.membership();
	}
	
	public void setIteration() {
		setOperation.iteration();
	}
	
	public void arrayListIteration() {
		arrayListOperation.iteration();
	}
	
	public void setModification() {
		setOperation.modification();
	}
	
	public void arrayListModification() {
		arrayListOperation.modification();
	}
}
