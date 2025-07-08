import java.util.*;

// LEETCODE 53

//Kadane's Algorithm
public class MaxSubarray {
    public static int maxSubarr(int arr[]) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int i=0; i<arr.length; i++) {
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[6];
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Maximum Subarray Sum : " + maxSubarr(arr));

        sc.close();
    }
}
