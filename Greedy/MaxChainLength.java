package Greedy;
import java.util.*;

public class MaxChainLength {
    public static int maxChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int maxLen = 1, prevEnd = pairs[0][1]; // End of current chain -> prevEnd

        for(int i = 0; i < pairs.length; i++) {
            if(prevEnd < pairs[i][0]) {
                maxLen++;
                prevEnd = pairs[i][1];
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        System.out.println(maxChain(pairs));
    }
}
