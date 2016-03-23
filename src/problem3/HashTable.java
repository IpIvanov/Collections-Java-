package problem3;

public class HashTable<K2, V, K> extends DictHashSet<K> {
	private K2 key2;
	private V value;

	public HashTable(K key, K2 key2, V value) {
		super(key);
		this.key2 = key2;
		this.value = value;
	}

	public K2 getKey2() {
		return this.key2;
	}

	public V getValueV() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format("[Key1: %s, Key2: %s, Value: %s]", getKey(), key2, value);
	}
}
