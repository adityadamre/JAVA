package Hashing;
import java.util.*;

public class HashMapImplementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K k, V v) {
                key = k;
                value = v;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.n = 0;
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            
            for(int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBucks = buckets;
            N = 2*N;
            buckets = new LinkedList[N];
            for(int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for(int i = 0; i < oldBucks.length; i++) {
                LinkedList<Node> ll = oldBucks[i];
                for(int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {  // O(lambda) ---> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {  // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {  // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {  // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        @SuppressWarnings("unchecked")
        public void clear() {
            this.n = 0;
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node: ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 130);
        hm.put("US", 80);
        hm.put("Nepal", 30);

        ArrayList<String> keys = hm.keySet();
        for(String key: keys) {
            System.out.println(key);
        }

        System.out.println(hm.get("China"));
        System.out.println(hm.remove("China"));
        System.out.println(hm.get("China"));

        hm.clear();
        System.out.println(hm.isEmpty());
    }
}
