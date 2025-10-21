package TwoPntr_SlidingWindow;
import java.util.*;

public class SumOfMode {
    static class Pair {
        int freq;
        int val;

        Pair(int f, int v) {
            freq = f;
            val = v;
        }
    }

    private static int getMode(Map<Integer,Integer> map, PriorityQueue<Pair> pq) {
        while(!pq.isEmpty()) {
            Pair temp = pq.peek();
            if(map.getOrDefault(temp.val, 0) == temp.freq) {
                return temp.val;
            } else pq.poll();
        }
        return 0; // Not Reachable
    }

    public static int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if(k > n) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.freq != b.freq ? b.freq - a.freq : a.val - b.val));
        
        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            pq.offer(new Pair(e.getValue(), e.getKey()));
        }
        
        int result = getMode(map, pq);
        
        for(int i = k; i < n; i++) {
            int out = arr[i - k];
            int in = arr[i];
            
            map.put(out, map.get(out) - 1);
            if(map.get(out) > 0) {
                pq.offer(new Pair(map.get(out), out));
            }
            
            map.put(in, map.getOrDefault(in, 0) + 1);
            pq.offer(new Pair(map.get(in), in));
            
            result += getMode(map, pq);
        }
        
        return result;
    }
}
