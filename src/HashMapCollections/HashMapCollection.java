package HashMapCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 4, 2, 2, 5, 2, 3, 2, 3, 1, 5, 2, 6, 6, 6 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(list.size());
		int occurrences = 0;
		for (Integer number : numbers) {
			list.add(number);
			occurrences = hashMap.containsKey(number) ? hashMap.get(number) : 0;
			hashMap.put(number, occurrences + 1);
		}

		System.out.println("Currently the array list has following elements:" + list);
		System.out.println(hashMap);
		for (Integer key : hashMap.keySet()) {
			// System.out.print(key + ",");
		}

		for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() % 2 == 0) {

			}
		}

	}

}
