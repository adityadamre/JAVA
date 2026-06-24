package DynamicProgramming.Subsequences;
import java.util.*;

public class CoinChange {
    private static int helper(int[] coins, int[][] dp, int target, int idx) {
        if(idx == 0) {
            if(target % coins[idx] == 0) return target / coins[idx];
            else return (int) 1e9;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = helper(coins, dp, target, idx-1);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= target) take = 1 + helper(coins, dp, target - coins[idx], idx);

        return dp[idx][target] = Math.min(take, notTake);
    }

    public static int coinChangeMem(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        
        int res = helper(coins, dp, target, n-1);
        return res >= (int) 1e9 ? -1 : res;
    }

    public static int coinChangeTab(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        
        for(int i = 0; i <= target; i++) {
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = (int) 1e9;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= target; j++) {
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j) take = 1 + dp[i][j-coins[i]];

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[n-1][target] >= (int) 1e9 ? -1 : dp[n-1][target];
    }

    public static int coinChangeTabOpti(int[] coins, int target) {
        int n = coins.length;
        int[] prev = new int[target+1], curr = new int[target+1];
        
        for(int i = 0; i <= target; i++) {
            if(i % coins[0] == 0) prev[i] = i / coins[0];
            else prev[i] = (int) 1e9;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= target; j++) {
                int notTake = prev[j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j) take = 1 + curr[j-coins[i]];

                curr[j] = Math.min(take, notTake);
            }
            prev = curr;
        }

        return prev[target] >= (int) 1e9 ? -1 : prev[target];
    }

    private static int helper2(int[] coins, int[][] dp, int target, int idx) {
        if(idx == 0) {
            return target % coins[0] == 0 ? 1 : 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = helper2(coins, dp, target, idx-1);
        int take = 0;
        if(coins[idx] <= target) take = helper2(coins, dp, target - coins[idx], idx);

        return dp[idx][target] = take + notTake;
    }

    public static int countCoinChangeMem(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return helper2(coins, dp, target, n-1);
    }

    public static int countCoinChangeTabOpti(int[] coins, int target) {
        int n = coins.length;
        int[] prev = new int[target+1], curr = new int[target+1];
        
        for(int i = 0; i <= target; i++) {
            if(i % coins[0] == 0) prev[i] = 1;
            else prev[i] = 0;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= target; j++) {
                int notTake = prev[j];
                int take = 0;
                if(coins[i] <= j) take = curr[j-coins[i]];

                curr[j] = take + notTake;
            }
            prev = curr;
        }

        return prev[target];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 5, 6, 9 };

        System.out.println(coinChangeMem(coins, 11));
        
        System.out.println(coinChangeTab(coins, 11));
        
        System.out.println(coinChangeTabOpti(coins, 11));

        int[] coins2 = { 1, 2, 3 };

        System.out.println(countCoinChangeMem(coins2, 4));
        
        System.out.println(countCoinChangeTabOpti(coins2, 4));
    }
}