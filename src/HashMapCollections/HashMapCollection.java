package HashMapCollections;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapCollection {

	public static void main(String[] args) {

		int[] numbers = { 4, 2, 2, 5, 2, 3, 2, 3, 1, 5, 2, 6, 6, 6, 77 };
		ArrayList<Integer> list = null, finalList = null;
		list = createArraylist(numbers, list);
		System.out.println("Input data: " + list);

		HashMap<Integer, Integer> hashMap = null;
		hashMap = checkNumbersOfOccurrences(list, hashMap);
		System.out.println("Created HashMap: " + hashMap);

		finalList = createFinalList(hashMap, list);
		System.out.println("Final extracted list with odd numbers: " + finalList);
	}

	private static ArrayList<Integer> createArraylist(int[] numbers, ArrayList<Integer> arrayList) {
		arrayList = new ArrayList<Integer>(numbers.length);
		for (Integer number : numbers) {
			arrayList.add(number);
		}
		return arrayList;
	}

	private static HashMap<Integer, Integer> checkNumbersOfOccurrences(ArrayList<Integer> arrayList,
			HashMap<Integer, Integer> hashMap) {
		hashMap = new HashMap<Integer, Integer>(arrayList.size());
		int occurrences = 0;
		for (Integer number : arrayList) {
			occurrences = hashMap.containsKey(number) ? hashMap.get(number) : 0;
			hashMap.put(number, occurrences + 1);
		}

		return hashMap;
	}

	private static ArrayList<Integer> createFinalList(HashMap<Integer, Integer> hashMap, ArrayList<Integer> list) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		Integer key, value;
		for (HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			if (value % 2 != 0) {
				tempList.add(key);
			}
		}
		list.removeAll(tempList);
		return list;
	}

}
