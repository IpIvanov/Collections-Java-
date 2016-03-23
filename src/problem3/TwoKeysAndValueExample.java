package problem3;

public class TwoKeysAndValueExample {

	public static void main(String[] args) {
		DictionaryTable<String, String, Integer> table = new DictionaryTable<String, String, Integer>();
		System.out.println("Is dictionary empty? -> " + table.isEmpty());
		table.putByThreeValues("A", "A1", 1);
		table.putByThreeValues("B", "B1", 2);
		table.putByThreeValues("C", "C1", 3);
		table.putByThreeValues("C", "C1", 4);

		for (HashTable<String, String, Integer> entry : table) {
			System.out.println(entry + " ");
		}

		System.out.println("Is dictionary empty? -> " + table.isEmpty());
		System.out.println("This is the value by two keys \"C\" and \"C1\" : " + table.getByTwoKeys("C", "C1"));
	}

}
