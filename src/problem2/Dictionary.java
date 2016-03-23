package problem2;

public interface Dictionary<K> extends Iterable<DictHashSet<K>> {

	K put(K key);

	K get(K key);

	boolean remove(K key);

	boolean isEmpty();

	void clear();
}