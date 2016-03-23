package problem3;

public class HashTable<K, K2, V> {
	private K key;
	private K2 key2;
	private V value;

	public HashTable(K key, K2 key2, V value) {
		this.key = key;
		this.key2 = key2;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public K2 getKey2() {
		return this.key2;
	}

	public V getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format("[Key1: %s, Key2: %s, Value: %s]", key, key2, value);
	}
}
