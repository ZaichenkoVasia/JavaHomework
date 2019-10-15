package ua.mycompany.map;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {

    private Node<K, V>[] buckets;
    private int size = 0;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int MAX_COLLISION_SIZE = 8;

    HashMap() {
        this.buckets = new Node[10];
    }

    @Override
    public V put(K key, V value) {
        if (DEFAULT_LOAD_FACTOR * buckets.length <= size+1) {
            growSize();
        }
        int counterCollision =0;
        int bucketIndex = Math.abs(key.hashCode() % buckets.length);
        Node<K, V> node = getNodeKeyByHashcode(key);
        if (node != null) {
            boolean done = false;
            while (!done && node != null) {
                if(++counterCollision >= MAX_COLLISION_SIZE){
                    growSize();
                }
                if (key.equals(node.getKey())) {
                    node.setValue(value);
                } else if (node.getNext() == null) {
                    node.setNext(new Node<>(key, value));
                    done = true;
                }
                node = node.getNext();
            }

        } else {
            buckets[bucketIndex] = new Node<>(key, value);
            size++;
        }
        return node != null ? node.getValue() : null;
    }

    private void growSize() {
        int newSize = buckets.length * 2;
        buckets = Arrays.copyOf(buckets, newSize);
        transferNodes();
    }

    private void transferNodes() {
        for (Node<K, V> bucket : buckets) {
            if(bucket != null) {
                while (bucket.getNext() != null) {
                    bucket = bucket.getNext();
                    put(bucket.getKey(), bucket.getValue());
                }
            }
        }
    }

    @Override
    public V getByKey(K key) {
        Node<K, V> node = getNodeKeyByHashcode(key);

        while (node != null && !key.equals(node.getKey())) {
            node = node.getNext();
        }
        return node != null ? node.getValue() : null;
    }

    private Node<K, V> getNodeKeyByHashcode(K key) {
        int bucketIndex = Math.abs(key.hashCode() % buckets.length);
        return buckets[bucketIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<V>();
        for (Node<K, V> bucket : buckets) {
            if (bucket != null) {
                values.add(bucket.getValue());
                Node<K, V> bucketCollision = bucket.getNext();
                while (bucketCollision != null) {
                    values.add(bucketCollision.getValue());
                    bucketCollision = bucketCollision.getNext();
                }
            }
        }
        return values;
    }

    @Override
    public Set<K> keys() {
        Set<K> keys = new HashSet<K>();
        for (Node<K, V> bucket : buckets) {
            if (bucket != null) {
                keys.add(bucket.getKey());
            }
        }
        return keys;
    }

    private class Node<K, V> {
        private Node<K, V> next;
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return this.key;
        }

        void setValue(V value) {
            this.value = value;
        }

        V getValue() {
            return this.value;
        }

        void setNext(Node<K, V> next) {
            this.next = next;
        }

        Node<K, V> getNext() {
            return this.next;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
