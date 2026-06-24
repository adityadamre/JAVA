package DynamicProgramming.One_D;

public class FrogJump {
    public static int frogJump1(int[] height) {  // GFG
        int n = height.length;
        if(n == 1) return 0;
        
        int prev2 = 0, prev1 = Math.abs(height[1] - height[0]);
        
        for(int i = 2; i < n; i++) {
            int jump1 = prev1 + Math.abs(height[i] - height[i-1]);
            int jump2 = prev2 + Math.abs(height[i] - height[i-2]);
            
            int curr = Math.min(jump1, jump2);
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }

    public static int frogJump2(int[] height, int k) {
        int n = height.length;
        if(n == 1) return 0;
        
        int[] dp = new int[n];
        dp[0] = 0;
        
        for(int i = 1; i < n; i++) {
            int idx = Math.max(i - k, 0);
            int mini = Integer.MAX_VALUE;

            for(; idx < i; idx++) {
                mini = Math.min(mini, dp[idx] + Math.abs(height[i] - height[idx]));
            }
            dp[i] = mini;
        }
        
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] height = { 30, 20, 50, 10, 40, 70, 60, 50 };

        System.out.println(frogJump1(height));
        System.out.println();
        System.out.println(frogJump2(height, 3));
    }
}
