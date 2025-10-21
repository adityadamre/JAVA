package Queue;
import java.util.*;

public class SlidingWindowMax {
    static class Pair implements Comparable<Pair> {
        int element;
        int index;

        public Pair(int e, int i) {
            element = e;
            index = i;
        }

        @Override
        public int compareTo(Pair P2) {
            return P2.element - this.element;
        }
    }

    public static int[] findMax(int[] arr, int k) {  // O(NlogK)
        int n = arr.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < k - 1; i++) {
            pq.add(new Pair(arr[i], i));
        }

        int i = k - 1, idx = 0;

        while(i < n) {
            if(!pq.isEmpty() && pq.peek().index <= i - k) {
                pq.poll();
            }
            pq.offer(new Pair(arr[i], i));
            res[idx++] = pq.peek().element;
            i++;
        }

        return res;
    }

    public static int[] findMaxOpti(int[] arr, int k) {  // O(n)
        int n = arr.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < k; i++) {
            while(!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }

        res[0] = arr[q.peekFirst()];

        for(int i = k; i < n; i++) {
            while(!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }

            while(!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            res[i - k + 1] = arr[q.peekFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] res = findMaxOpti(arr, k);

        for(int i: res) {
            System.out.print(i + " ");
        }
    }
}
