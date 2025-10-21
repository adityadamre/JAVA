package Heaps;
import java.util.*;

public class Heaps {
    static class MinHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {   // O(logn)
            arr.add(data);

            int x = arr.size() - 1;
            int parent = (x - 1) / 2;

            while(arr.get(x) < arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x - 1) / 2;
            }
        }

        public int peek() {   // O(1)
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            
            if(minIdx != i) {
                int temp = arr.get(minIdx);
                arr.set(minIdx, arr.get(i));
                arr.set(i, temp);

                heapify(minIdx);
            }
        }

        public int remove() {   // O(logn)
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);

            heapify(0);
            return data;
        }

        public boolean isEmpty() {   // O(1)
            return arr.size() == 0;
        }
    }

    static class MaxHeap {  // Implementation same as MinHeap just some operators will get reversed
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1;
            int parent = (x - 1) / 2;

            while(arr.get(x) > arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int maxIdx = i;

            if(left < arr.size() && arr.get(maxIdx) < arr.get(left)) {
                maxIdx = left;
            }

            if(right < arr.size() && arr.get(maxIdx) < arr.get(right)) {
                maxIdx = right;
            }
            
            if(maxIdx != i) {
                int temp = arr.get(maxIdx);
                arr.set(maxIdx, arr.get(i));
                arr.set(i, temp);

                heapify(maxIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);

            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        MinHeap pq = new MinHeap();

        pq.add(7);
        pq.add(2);
        pq.add(5);
        pq.add(9);
        pq.add(3);

        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
