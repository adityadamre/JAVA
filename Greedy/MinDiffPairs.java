package Greedy;
import java.util.*;

public class MinDiffPairs {
    public static int minDiff(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int mini = 0;

        for(int i = 0; i < arr1.length; i++) {
            mini += Math.abs(arr1[i] - arr2[i]);
        }

        return mini;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 7, 8};
        int arr2[] = {5, 4, 2, 6};

        System.out.println(minDiff(arr1, arr2));
    }
}