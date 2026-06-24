package TwoPntr_SlidingWindow;

import java.util.HashMap;

public class SubArrays {
    public static int maxLength1(int[] arr, int k) {    // Optimal if array contains both +ve & -ve
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum == k) maxLen = Math.max(maxLen, i+1);

            int rem = sum - k;

            if(map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)) map.put(sum, i);
        }
        
        return maxLen;
    }

    public static int maxLength2(int[] arr, long k) {    // Optimal if array contains only +ve
        int left = 0, right = 0;
        long sum = 0;
        int maxLen = 0;

        while(right < arr.length) {
            sum += arr[right];

            while(left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if(sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    // LEETCODE 560
    public static int countSubarray(int[] arr, int k) {    // Array contains both +ve & -ve
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int req = sum - k;

            if(map.containsKey(req)) {
                count += map.get(req);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // LEETCODE 930
    public int helper(int[] nums, int goal) {
        if(goal < 0) return 0;

        int l = 0, r = 0;
        int sum = 0, count = 0;

        while(r < nums.length) {
            sum += nums[r];
            while(l < nums.length && sum > goal) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);   // No. of valid subarrays that nums[r] can form with prev elements
            r++;
        }

        return count;
    }
    public int binarySubarray(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    // LEETCODE 1248
    private int helper2(int[] nums, int k) {  // Count subarrays with exactly k odd elements
        if(k < 0) return 0;

        int l = 0, r = 0;
        int sum = 0, res = 0;

        while(r < nums.length) {
            sum += nums[r] % 2;

            while(l <= r && sum > k) {
                if(nums[l] % 2 == 1) sum--;
                l++;
            }

            res += (r - l + 1);
            r++;
        }

        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper2(nums, k) - helper2(nums, k-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};

        System.out.println(countSubarray(arr, 3));
    }
}
