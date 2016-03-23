package problem2;

public class DictHashSet<K> {
	private K key;
	private K value;

	public DictHashSet(K key, K value) {
		this.key = key;
		this.value = value;
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
