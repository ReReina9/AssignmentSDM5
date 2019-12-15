package HashMap;

import java.util.HashMap;
import java.util.Set;
import java.util.function.BiFunction;


public class HashMapContracts<K,V> extends HashMap<K,V> implements MapContracts<K,V> {

    @Override
    public int size() { return super.size(); }

    @Override
    public boolean isEmpty() { return super.isEmpty(); }

    @Override
    public boolean containsKey(Object o) { return super.containsKey(o); }

    @Override
    public boolean containsValue(Object o) { return super.containsValue(o); }

    @Override
    public V put(K key, V value) { return super.put(key, value); }

    @Override
    public V putIfAbsent(K key, V value) { return super.putIfAbsent(key, value); }

    @Override
    public V remove(Object key) { return super.remove(key); }

    @Override
    public void clear() { super.clear(); }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) { super.replaceAll(function); }

    @Override
    public Set<K> keySet() { return super.keySet(); }
}