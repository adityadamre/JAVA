package BinarySearch;
import java.util.*;

public class BinarySearch {
    public static int lowerBound(int[] arr, int target) {
        int st = 0, end = arr.length - 1;
        int ans = arr.length;   // Virtual index in case no lowerBound found

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return ans;
    }

    public static int upperBound(int[] arr, int target) {
        int st = 0, end = arr.length - 1;
        int ans = arr.length;   // Virtual index in case no lowerBound found

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(arr[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return ans;
    }

    public static int searchInsert(int[] arr, int target) {
        int st = 0, end = arr.length - 1;
        int ans = arr.length;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return arr[ans] == target ? ans : ans + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 6, 7, 9, 9, 10};
        System.out.println(lowerBound(arr, 9));
    }
}