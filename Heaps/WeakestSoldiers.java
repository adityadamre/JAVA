package Heaps;
import java.util.*;

public class WeakestSoldiers {
    static class Row implements Comparable<Row> {
        int soldiers;
        int index;

        public Row(int s, int i) {
            soldiers = s;
            index = i;
        }

        @Override
        public int compareTo(Row R2) {
            if(this.soldiers == R2.soldiers) {
                return this.index - R2.index;
            } else {
                return this.soldiers - R2.soldiers;
            }
        }
    }

    public static void weakest(int[][] arr, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            int count = 0;
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) count++;
            }
            pq.offer(new Row(count, i));
        }

        for(int i = 0; i < k; i++) {
            System.out.println("R" + pq.poll().index);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0},
                       {1, 1, 1, 1},
                       {1, 0, 0, 0},
                       {1, 0, 0, 0}};

        weakest(arr, 2);
    }
}
