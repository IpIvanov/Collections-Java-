package problem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DictionaryTable<K2, V, K> implements TwoKeysAndValue<K2, V, K> {

	private static final int DEFAULT_CAPACITY = 2;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private List<HashTable<K2, V, K>>[] table;
	private float loadFactor;
	private int threshold;
	private int size;

	public DictionaryTable() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public DictionaryTable(int capacity, float loadFactor) {
		this.table = new List[capacity];
		this.loadFactor = loadFactor;
		this.threshold = (int) (this.table.length * this.loadFactor);
	}

	private List<HashTable<K2, V, K>> findChain(K key, K2 key2, boolean createIfMissing) {
		int index = key.hashCode();
		index = index % this.table.length;
		if (table[index] == null && createIfMissing) {
			table[index] = new ArrayList<HashTable<K2, V, K>>();
		}
		return table[index];
	}

	@Override
	public V getByTwoKeys(K key, K2 key2) {
		List<HashTable<K2, V, K>> chain = findChain(key, key2, false);
		if (chain != null) {
			for (HashTable<K2, V, K> dictionaryEntry : chain) {
				if (dictionaryEntry.getKey().equals(key) && dictionaryEntry.getKey2().equals(key2)) {
					return dictionaryEntry.getValueV();
				}
			}
		}
		return null;
	}

	@Override
	public V putByThreeValues(K key, K2 key2, V value) {
		List<HashTable<K2, V, K>> chain = findChain(key, key2, true);
		for (int i = 0; i < chain.size(); i++) {
			HashTable<K2, V, K> entry = chain.get(i);
			if (entry.getKey().equals(key) && entry.getKey2().equals(key2)) {
				// Key found -> replace its value with the new value
				HashTable<K2, V, K> newEntry = new HashTable<K2, V, K>(key, key2, value);
				chain.set(i, newEntry);
				return entry.getValueV();
			}
		}
		chain.add(new HashTable<K2, V, K>(key, key2, value));
		if (size++ >= threshold) {
			expand();
		}
		return null;
	}

	/**
	 * Expands the underling table
	 */
	@SuppressWarnings("unchecked")
	private void expand() {
		int newCapacity = 2 * this.table.length;
		List<HashTable<K2, V, K>>[] oldTable = this.table;
		this.table = new List[newCapacity];
		this.threshold = (int) (newCapacity * this.loadFactor);
		for (List<HashTable<K2, V, K>> oldChain : oldTable) {
			if (oldChain != null) {
				for (HashTable<K2, V, K> dictionaryEntry : oldChain) {
					List<HashTable<K2, V, K>> chain = findChain(dictionaryEntry.getKey(), dictionaryEntry.getKey2(),
							true);
					chain.add(dictionaryEntry);
				}
			}
		}
	}

	@Override
	public Iterator<HashTable<K2, V, K>> iterator() {
		List<HashTable<K2, V, K>> entries = new ArrayList<HashTable<K2, V, K>>(this.table.length);
		for (List<HashTable<K2, V, K>> chain : this.table) {
			if (chain != null) {
				entries.addAll(chain);
			}
		}
		return entries.iterator();
	}

}
