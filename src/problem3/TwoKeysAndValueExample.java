package problem3;

import problem2.DictHashSet;

public class TwoKeysAndValueExample {

	public static void main(String[] args) {
		HashTable<String, String, Integer> table = new HashTable<String, String, Integer>(null, null, null);
		table.put("Pepi", "Pepi2", 3);
		table.put("Kiro");
		table.put("Mimi");
		for (DictHashSet<String> entry : names) {
			System.out.print(entry + " ");
		}
		System.out.println();
		System.out.println("Is dictionary empyt? -> " + names.isEmpty());
		// Use the iterator to traverse all entries
		System.out.println("Clearing the dictionary");
		names.clear();
		System.out.println("Is dictionary empyt? -> " + names.isEmpty());

	}

}
