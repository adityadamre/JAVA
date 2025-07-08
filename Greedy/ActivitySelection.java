package Greedy;
import java.util.*;

public class ActivitySelection {
    public static void maxActivity(int[] start, int[] end) {
        int[][] arr = new int[start.length][3];
        for(int i = 0; i < start.length; i++) {
            arr[i][1] = start[i];
            arr[i][2] = end[i];
            arr[i][0] = i;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));
        int maxAct = 1, lastEnd = arr[0][2];
        ans.add(arr[0][0]);

        for(int i = 1; i < start.length; i++) {
            if(arr[i][1] >= lastEnd) {
                maxAct++;
                ans.add(arr[i][0]);
                lastEnd = arr[i][2];
            }
        }

        System.out.println("Maximum Activities : " + maxAct);
        for(int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }


    public static void main(String[] args) {
        int start[] = {1, 5, 3, 5, 0, 8};
        int end[] = {2, 7, 4, 9, 6, 9};

        maxActivity(start, end);

        // WHEN end[] IS SORTED

        // ArrayList<Integer> ans = new ArrayList<>();
        // int maxAct = 1;
        // ans.add(0);
        // int lastEnd = end[0];

        // for(int i = 1; i < start.length; i++) {
        //     if(start[i] >= lastEnd) {
        //         maxAct++;
        //         ans.add(i);
        //         lastEnd = end[i];
        //     }
        // }

        // System.out.println("Maximum Activities : " + maxAct);
        // for(int i = 0; i < ans.size(); i++) {
        //     System.out.print("A" + ans.get(i) + " ");
        // }
    }
}