package DynamicProgramming.Subsequences;
import java.util.*;

public class CountSubsets {
    private static int helper(int[] arr, int[][] dp, int idx, int target) {
        if(idx == 0) {
            if(arr[idx] == 0 && target == 0) return 2;
            if(target == 0 || arr[idx] == target) return 1;
            return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = helper(arr, dp, idx-1, target);
        int take = 0;
        if(arr[idx] <= target) take = helper(arr, dp, idx-1, target-arr[idx]);

        return dp[idx][target] = take + notTake;
    }

    private static int countSubsetSum(int[] arr, int target) {  // Count subsets with sum target Memoization
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return helper(arr, dp, n-1, target);
    }

    private static int countSubsetSumOpti(int[] arr, int target) {  // Count subsets with sum target Tabulation + Space Optimization
        int n = arr.length;
        int[] prev = new int[target+1];
        if(arr[0] <= target) prev[arr[0]] = 1;
        
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        
        for(int i = 1; i < n; i++) {
            int[] curr = new int[target+1];
            for(int j = 0; j <= target; j++) {
                int notTake = prev[j];
                int take = 0;
                if(j >= arr[i]) take = prev[j - arr[i]];

                curr[j] = take + notTake;
            }
            prev = curr;
        }

        return prev[target];
    }

    private static int countSubsetDiff(int[] arr, int diff) { // Count subsets with difference Memoization
        int n = arr.length, sum = 0;
        for(int a: arr) sum += a;
        
        if(sum - diff < 0 || (sum - diff) % 2 == 1) return 0;
        
        int target = (sum - diff) / 2;
        int[][] dp = new int[n][target+1];
        for(int[] curr: dp) Arrays.fill(curr, -1);

        return helper(arr, dp, n-1, target);
    }

    private static int countSubsetDiffOpti(int[] arr, int diff) { // Count subsets with difference Tabulation + Space Optimization
        int n = arr.length, sum = 0;
        for(int a: arr) sum += a;
        
        if(sum - diff < 0 || (sum - diff) % 2 == 1) return 0;
        int target = (sum-diff) / 2;

        int[] prev = new int[target+1];
        if(target >= arr[0]) prev[arr[0]] = 1;
        
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        
        for(int i = 1; i < n; i++) {
            int[] curr = new int[target+1];
            for(int j = 0; j <= target; j++) {
                int notTake = prev[j];
                int take = 0;
                if(arr[i] <= j) take = prev[j - arr[i]];

                curr[j] = take + notTake;
            }
            prev = curr;
        }

        return prev[target];
    }

    private static int helper2(int[] arr, Map<String, Integer> map, int idx, int target) {
        if(idx == 0) {
            if(arr[idx] == 0 && target == 0) return 2;
            if(target == 0 || arr[idx] == target) return 1;
            return 0;
        }
        
        String key = idx + "," + target;
        if(map.containsKey(key)) return map.get(key);

        int notTake = helper2(arr, map, idx-1, target);
        int take = 0;
        take = helper2(arr, map, idx-1, target-arr[idx]);

        map.put(key, take + notTake);
        return take + notTake;
    }

    private static int countSubsetSum2(int[] arr, int target) {  // Count subsets with sum target Memoization ---> arr[i] < 0 possible
        int n = arr.length;
        Map<String, Integer> map = new HashMap<>();

        return helper2(arr, map, n-1, target);
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 2, 3, 4 };
        System.out.println(countSubsetSum(arr, 5));
        System.out.println(countSubsetSumOpti(arr, 5));

        System.out.println(countSubsetDiff(arr, 4));
        System.out.println(countSubsetDiffOpti(arr, 2));

        int[] nums = { 0, -1, 2, 3 };
        System.out.println(countSubsetSum2(nums, 2));
    }
}