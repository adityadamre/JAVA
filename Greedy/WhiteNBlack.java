package Greedy;

// LEETCODE 2938
public class WhiteNBlack {
    public static long computeSwaps(String s) {    // In this approach we compute the no. of swaps required for
        long whitePos = 0, currPos = 0;       // each white ball to come forth (i.e. before every other black ball)
        long totalSwaps = 0;

        while(currPos < s.length()) {
            if(s.charAt((int)currPos) == '0') {
                totalSwaps += currPos - whitePos;
                whitePos++;
            }
            currPos++;
        }

        return totalSwaps;
    }

    public static long computeSwaps_1(String s) {   // In this approach we keep count of black balls before the white ball
        long blackBall = 0;                   // And add to totalSwap whenever white ball appears
        long totalSwaps = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                totalSwaps += blackBall;
            } else {
                blackBall++;
            }
        }

        return totalSwaps;
    }

    public static void main(String[] args) {
        String s = "01101011001";

        System.out.println(computeSwaps(s));
    }
}
