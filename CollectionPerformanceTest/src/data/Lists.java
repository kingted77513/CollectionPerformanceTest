package data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
	private ListOperations arrayListOperations;
	private ListOperations linkedListOperations;
	
	public Lists(int size) {
		List<String> arrayList = new ArrayList<String>(size);
		List<String> linkedList = new LinkedList<String>();
		for (int i = 0 ; i < size ; i++) {
			String element = String.format("a%d", i);
			arrayList.add(element);
			linkedList.add(element);
		}
		arrayListOperations = new ListOperations(arrayList);
		linkedListOperations = new ListOperations(linkedList);
	}
	
	private class ListOperations {
		private List<String> list;
		private int centerIndex;
		
		private ListOperations(List<String> list) {
			this.list = list;
			this.centerIndex = list.size() / 2;
		}
		
		private void modification() {
			list.add(0, "b");
			list.remove(0);
		}
		
		private void access() {
			list.get(centerIndex);
		}
	}
	
	public void arrayListModification() {
		arrayListOperations.modification();
	}
	
	public void linkedListModification() {
		linkedListOperations.modification();
	}
	
	public void arrayListAccess() {
		arrayListOperations.access();
	}
	
	public void linkedListAccess() {
		linkedListOperations.access();
	}
}
