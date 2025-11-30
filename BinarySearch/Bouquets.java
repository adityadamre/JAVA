package BinarySearch;

public class Bouquets {
    private static boolean isPossible(int[] arr, int day, int m, int k) {
        int cnt = 0, res = 0;
        for(int num: arr) {
            if(num <= day) cnt++;
            else {
                res += cnt / k;
                cnt = 0;
            }
        }
        res += cnt / k;

        return res >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        long req = (long) m * k;
        if(req > bloomDay.length) return -1;

        int maxi = -1, mini = Integer.MAX_VALUE;
        for(int num: bloomDay) {
            if(num > maxi) maxi = num;
            if(num < mini) mini = num;
        }

        while(mini <= maxi) {
            int mid = mini + (maxi - mini) / 2;
            if(isPossible(bloomDay, mid, m, k)) {
                maxi = mid - 1;
            } else mini = mid + 1;
        }

        return mini;
    }

    public static void main(String[] args) {
        int[] arr = { 7,7,7,12,7,7,7 };
        int m = 3, k = 2;

        System.out.println(minDays(arr, m, k));
    }
}
