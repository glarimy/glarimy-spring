package com.glarimy.directory.data;

import java.util.Map;

import com.glarimy.directory.exceptions.InvalidEntryException;

public class InMemoryCRUDRepository<K, V> implements CRUDRepository<K, V> {
	private Map<K, V> entries;

	public InMemoryCRUDRepository(Map<K, V> entries) {
		this.entries = entries;
	}

	public void save(K key, V value) {
		if (key == null)
			throw new InvalidEntryException();
		entries.put(key, value);
	}

	public V find(K key) {
		return entries.get(key);
	}
}
