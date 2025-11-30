package Heaps;
import java.util.*;

public class SplitArraySubseq {
    static class Info implements Comparable<Info> {
        int lastEl, length;
        
        public Info(int last, int len) {
            lastEl = last;
            length = len;
        }
        
        @Override
        public int compareTo(Info I) {
            return this.lastEl == I.lastEl ?
                this.length - I.length : this.lastEl - I.lastEl;
        }
    }

    public static boolean isPossible(int[] arr, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int idx = 0;

        while(idx < arr.length) {
            if(pq.isEmpty()) {
                pq.offer(new Info(arr[idx++], 1));
            } else {
                Info temp = pq.peek();

                if(arr[idx] == temp.lastEl) {
                    pq.offer(new Info(arr[idx++], 1));
                } else if(arr[idx] == temp.lastEl + 1) {
                    pq.poll();
                    pq.offer(new Info(arr[idx++], temp.length+1));
                } else {
                    if(temp.length < k) return false;
                    pq.poll();
                }
            }
        }

        while(!pq.isEmpty()) {
            Info temp = pq.poll();
            if(temp.length < k) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        Arrays.sort(arr);

        if(isPossible(arr, k)) {
            System.out.println("It is possible to split array.");
        } else {
            System.out.println("It is not possible to split array.");
        }
    }
}
