package com.glarimy.directory.data;

public interface CRUDRepository<K, V> {
	public void save(K key, V value);

	public V find(K key);
}
