package Greedy;

import java.util.Arrays;

// LEETCODE 135
public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i = 1; i < n; i++) {            //In this iteration we are satisfying
            if(ratings[i] > ratings[i - 1]) {   //INCREASING ratings
                candies[i] = candies[i - 1] + 1;
            }
        }

        for(int i = n-2; i >= 0; i--) {         //In this iteration we are satisfying
            if(ratings[i] > ratings[i + 1]) {   //DECREASING ratings as well
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandy = 0;

        for(int num: candies) {
            totalCandy += num;
        }

        return totalCandy;
    }

    public static void main(String[] args) {
        int ratings[] = {1, 3, 4, 3, 2, 1};

        System.out.println(candy(ratings));
    }
}
