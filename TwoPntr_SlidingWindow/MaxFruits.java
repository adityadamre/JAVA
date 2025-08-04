package TwoPntr_SlidingWindow;
import java.util.*;

public class MaxFruits {
    // LEETCODE 904
    public static int maxFruits(int[] arr) {
        int l = 0, r = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            if(map.size() > 2) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;

                if(map.size() <= 2) maxLen = Math.max(maxLen, r - l + 1);
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    }

    //LEETCODE 2106
    public static int maxFruit(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] prefixSum = new int[n+1];

        for(int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + fruits[i][1];
        }

        int maxFruit = 0;
        int left = 0, right = 0;

        while(right < n) {
            while(left <= right && !canReach(fruits[left][0], fruits[right][0], startPos, k)) {
                left++;
            }

            int sum = prefixSum[right + 1] - prefixSum[left];
            maxFruit = Math.max(maxFruit, sum);

            right++;
        }

        return maxFruit;
    }

    private static boolean canReach(int leftPos, int rightPos, int startPos, int k) {
        if(startPos <= leftPos) {
            return (rightPos - startPos) <= k;
        } else if(rightPos <= startPos) {
            return (startPos - leftPos) <= k;
        } else {
            int leftFirst = 2*(startPos - leftPos) + (rightPos - startPos);
            int rightFirst = 2*(rightPos - startPos) + (startPos - leftPos);
            return Math.min(leftFirst, rightFirst) <= k;
        }
    }

    public static void main(String[] args) {
        int fruits[] = {2, 1, 3, 2, 3, 3, 1};
        System.out.println(maxFruits(fruits));


        int fruit[][] = {{0,9}, {4,1}, {5,7}, {6, 2}, {7, 4}, {10, 9}}; //(pos, fruits)
        System.out.println(maxFruit(fruit, 5, 4));
    }
}
