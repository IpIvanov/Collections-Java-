package problem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapArrayDemo {

	public static void main(String[] args) {
		HashMap<Integer, ArrayList<String>> hashmap = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> arraylist1 = new ArrayList<String>();
		arraylist1.add("First");
		arraylist1.add("Second");
		arraylist1.add("Third");
		hashmap.put(1, arraylist1);
		ArrayList<String> arraylist2 = new ArrayList<String>();
		arraylist2.add("A");
		arraylist2.add("B");
		arraylist2.add("C");
		hashmap.put(2, arraylist2);

		arraylist1 = hashmap.get(1);
		arraylist2 = hashmap.get(2);
		System.out.println("Keys: " + hashmap.keySet());
		System.out.println("ArrayListValues: " + arraylist1 + arraylist2);

		for (Map.Entry<Integer, ArrayList<String>> entry : hashmap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
