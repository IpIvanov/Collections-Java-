package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HashDictionary<K> implements Dictionary<K> {
	private static final int DEFAULT_CAPACITY = 2;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private List<DictHashSet<K>>[] table;
	private float loadFactor;
	private int threshold;
	private int size;

	public HashDictionary() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	@SuppressWarnings("unchecked")
	private HashDictionary(int capacity, float loadFactor) {
		this.table = new List[capacity];
		this.loadFactor = loadFactor;
		this.threshold = (int) (this.table.length * this.loadFactor);
	}

	@Override
	public void clear() {
		Arrays.fill(this.table, null);
		this.size = 0;
	}

	private List<DictHashSet<K>> findChain(K key, boolean createIfMissing) {
		int index = key.hashCode();
		index = index % this.table.length;
		if (table[index] == null && createIfMissing) {
			table[index] = new ArrayList<DictHashSet<K>>();
		}
		return table[index];
	}

	@Override
	public K get(K key) {
		List<DictHashSet<K>> chain = findChain(key, false);
		if (chain != null) {
			for (DictHashSet<K> dictionaryEntry : chain) {
				if (dictionaryEntry.getKey().equals(key)) {
					return dictionaryEntry.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public K put(K key) {
		List<DictHashSet<K>> chain = findChain(key, true);
		for (int i = 0; i < chain.size(); i++) {
			DictHashSet<K> entry = chain.get(i);
			if (entry.getKey().equals(key)) {
				// Key found -> replace its value with the new value
				DictHashSet<K> newEntry = new DictHashSet<K>(key, key);
				chain.set(i, newEntry);
				return entry.getValue();
			}
		}
		chain.add(new DictHashSet<K>(key, key));
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
		List<DictHashSet<K>>[] oldTable = this.table;
		this.table = new List[newCapacity];
		this.threshold = (int) (newCapacity * this.loadFactor);
		for (List<DictHashSet<K>> oldChain : oldTable) {
			if (oldChain != null) {
				for (DictHashSet<K> dictionaryEntry : oldChain) {
					List<DictHashSet<K>> chain = findChain(dictionaryEntry.getKey(), true);
					chain.add(dictionaryEntry);
				}
			}
		}
	}

	@Override
	public boolean remove(K key) {
		List<DictHashSet<K>> chain = findChain(key, false);
		if (chain != null) {
			for (int i = 0; i < chain.size(); i++) {
				DictHashSet<K> entry = chain.get(i);
				if (entry.getKey().equals(key)) {
					// Key found -> remove it
					chain.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Iterator<DictHashSet<K>> iterator() {
		List<DictHashSet<K>> entries = new ArrayList<DictHashSet<K>>(this.table.length);
		for (List<DictHashSet<K>> chain : this.table) {
			if (chain != null) {
				entries.addAll(chain);
			}
		}
		return entries.iterator();
	}
}