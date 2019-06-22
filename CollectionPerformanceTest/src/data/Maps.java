package data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
	private MapOperations hashMapOperations;
	private MapOperations linkedHashMapOperations;
	private MapOperations treeMapOperations;
	
	public Maps(int size) {
		Map<String, String> hashMap = new HashMap<String, String>(size);
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>(size);
		Map<String, String> treeMap = new TreeMap<String, String>();
		for (int i = 0 ; i < size ; i++) {
			String element = String.format("a%d", i);
			hashMap.put(element, element);
			linkedHashMap.put(element, element);
			treeMap.put(element, element);
		}
		String probe = String.format("a%d", size / 2);
		hashMapOperations = new MapOperations(hashMap, probe);
		linkedHashMapOperations = new MapOperations(linkedHashMap, probe);
		treeMapOperations = new MapOperations(treeMap, probe);
	}
	
	private class MapOperations {
		private Map<String, String> map;
		String probe;
		
		private MapOperations(Map<String, String> map, String probe) {
			this.map = map;
			this.probe = probe;
		}
		
		private void contains() {
			map.containsKey(probe);
		}
		
		private void modification() {
			map.put("b", "b");
			map.remove("b");
		}
	}
	
	public void arrayListContains() {
		hashMapOperations.contains();
	}
	
	public void linkedHashMapContains() {
		linkedHashMapOperations.contains();
	}
	
	public void treeMapContains() {
		treeMapOperations.contains();
	}
	
	public void arrayListModification() {
		hashMapOperations.modification();
	}
	
	public void linkedHashMapModification() {
		linkedHashMapOperations.modification();
	}
	
	public void treeMapModification() {
		treeMapOperations.modification();
	}
	
	
}
