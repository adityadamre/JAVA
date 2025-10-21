package Heaps;
import java.util.*;

public class N_Ropes {
    public static int ropes(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i: arr) {
            pq.offer(i);
        }
        int ans = 0;

        while(pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            pq.offer(temp);
            ans += temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};

        System.out.println(ropes(arr));
    }
}
