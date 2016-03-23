package problem3;

public interface TwoKeysAndValue<K2, V, K> extends Iterable<HashTable<K2, V, K>> {

	V putByThreeValues(K key, K2 key2, V value);

	V getByTwoKeys(K key, K2 key2);

	boolean isEmpty();
}
