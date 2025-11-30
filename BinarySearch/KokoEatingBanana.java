package BinarySearch;

public class KokoEatingBanana {
    private static int findMax(int[] arr) {
        int maxi = -1;
        for(int num: arr) {
            if(num > maxi) maxi = num;
        }
        return maxi;
    }

    private static int helper(int[] arr, int speed) {
        int ans = 0;

        for(int num: arr) {
            ans += Math.ceil((double) num / (double) speed);
        }

        return ans;
    }

    public static int minHours(int[] arr, int deadline) {
        int low = 1, high = findMax(arr);

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int hrs = helper(arr, mid);

            if(hrs <= deadline) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        int deadline = 8;
        System.out.println(minHours(arr, deadline));
    }
}
