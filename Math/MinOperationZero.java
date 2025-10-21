package Math;

public class MinOperationZero {
    // LEETCODE 2749. Minimum Operations to Make the Integer Zero
    public static int minimumOperations(int num1, int num2) {
        if(num1 == 0) return 0;

        for(int i = 1; i <= 60; i++) {
            long target = (long) num1 - (long) i * num2;

            if(target < 0) continue;

            if(Long.bitCount(target) <= i && i <= target) {
                return i;
            }
        }

        return -1;
    }

    // LEETCODE 3495. Minimum Operations to Make Array Elements Zero
    public static long minOperations(int[][] queries) {
        long operations = 0;

        for(int[] query: queries) {
            int l = query[0], r = query[1];
            long rangeSum = 0;  // Operations required in one query

            int currPower = 1;  // 4^0
            int level = 1;  // No of Operation

            while(currPower <= r) {
                int nextPower = Math.min((currPower * 4) - 1, r);

                if(nextPower >= l) {
                    int st = Math.max(currPower, l), end = nextPower;

                    if(st <= end) {
                        long count = end - st + 1;
                        rangeSum += count * level;
                    }
                }

                currPower *= 4;
                level++;
            }

            operations += (rangeSum + 1) / 2;
        }

        return operations;
    }

    public static void main(String[] args) {
        int num1 = 112577768, num2 = -501662198;    // Expected = 16
        System.out.println(minimumOperations(num1, num2));

        int[][] arr = {{1, 2}, {2, 4}, {2, 7}, {2, 6}};
        System.out.println(minOperations(arr));
    }
}
