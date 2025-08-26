package Greedy;
import java.util.*;

public class SJF {  // Shortest Job First
    public static int compute(int[] arr) {
        Arrays.sort(arr);
        int time = 0, waitTime = 0;

        for(int i = 0; i < arr.length; i++) {
            waitTime += time;
            time += arr[i];
        }

        return waitTime;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 1, 2};

        System.out.println("Waiting Time : " + compute(arr));
    }
}
