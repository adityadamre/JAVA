package Greedy;
import java.util.*;

public class FractionalKnapsack {
    public static double knapsack(int[] weight, int[] val, int w) {
        double maxVal = 0;
        int capacity = w;

        double[][] ratio = new double[weight.length][2];
        for(int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for(int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) {
                capacity -= weight[idx];
                maxVal += val[idx];
            } else {
                maxVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120, 140, 150};
        int[] weight = {10, 20, 30, 40, 50};
        int w = 80;

        System.out.println(knapsack(weight, val, w));
    }
}
