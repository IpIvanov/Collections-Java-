package problem3;

public class DictHashSet<K> {
	private K key;
	private K value;

	public DictHashSet(K key) {
		this.key = key;
		this.value = key;
	}

	public K getKey() {
		return this.key;
	}

	public K getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format("[Key: %s, Value: %s]", key, value);
	}

}
