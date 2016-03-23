package problem2;

public class HashDictionaryExample {

	public static void main(String[] args) {
		HashDictionary<String> names = new HashDictionary<String>();
		System.out.println("Is dictionary empyt? -> " + names.isEmpty());
		names.put("Pepi");
		names.put("Kiro");
		names.put("Mimi");
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
