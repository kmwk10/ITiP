import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class HashTable<K, V> {
    private static final int INITIAL_CAPACITY = 11;
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size;

    public HashTable() {
        table = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table.add(null);
        }
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.size();
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table.get(index) == null) {
            table.set(index, new LinkedList<>());
        }
        for (Entry<K, V> entry : table.get(index)) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table.get(index).add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table.get(index) != null) {
            for (Entry<K, V> entry : table.get(index)) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table.get(index) != null) {
            ListIterator<Entry<K, V>> iterator = table.get(index).listIterator();
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if (entry.getKey().equals(key)) {
                    iterator.remove();
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
