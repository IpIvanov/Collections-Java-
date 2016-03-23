package problem3;

public interface TwoKeysAndValue<K, K2, V> extends Iterable<HashTable<K, K2, V>> {

	V putByThreeValues(K key, K2 key2, V value);

	V getByTwoKeys(K key, K2 key2);

	boolean isEmpty();
}
