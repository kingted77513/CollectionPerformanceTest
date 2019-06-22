package data;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
	private SetOperations hashSetOperations;
	private SetOperations linkedHashSetOperations;
	private SetOperations treeSetOperations;
	
	public Sets(int size) {
		Set<String> hashSet = new HashSet<String>(size);
		Set<String> linkedHashSet = new LinkedHashSet<String>(size);
		Set<String> treeSet = new TreeSet<String>();
		for (int i = 0 ; i < size ; i++) {
			String element = String.format("a%d", i);
			hashSet.add(element);
			linkedHashSet.add(element);
			treeSet.add(element);
		}
		String probe = String.format("a%d", size / 2);
		hashSetOperations = new SetOperations(hashSet, probe);
		linkedHashSetOperations = new SetOperations(linkedHashSet, probe);
		treeSetOperations = new SetOperations(treeSet, probe);
	}
	
	private class SetOperations {
		private Set<String> set;
		String probe;
		
		private SetOperations(Set<String> set, String probe) {
			this.set = set;
			this.probe = probe;
		}
		
		private void contains() {
			set.contains(probe);
		}
		
		private void modification() {
			set.add("b");
			set.remove("b");
		}
	}
	
	public void hashSetContains() {
		hashSetOperations.contains();
	}
	
	public void linkedHashSetContains() {
		linkedHashSetOperations.contains();
	}
	
	public void treeSetContains() {
		treeSetOperations.contains();
	}
	
	public void hashSetModification() {
		hashSetOperations.modification();
	}
	
	public void linkedHashSetModification() {
		linkedHashSetOperations.modification();
	}
	
	public void treeSetModification() {
		treeSetOperations.modification();
	}
	
	
}
