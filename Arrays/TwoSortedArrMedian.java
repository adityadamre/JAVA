// LEETCODE 4

public class TwoSortedArrMedian {
    public static double findMedian(int[] nums1, int[] nums2) { // O(m + n) -> BruteForce
        int left = 0, right = 0, idx = 0;
        double ans;
        int[] arr = new int[nums1.length + nums2.length];

        while(left < nums1.length && right < nums2.length) {
            if(nums1[left] <= nums2[right]) {
                arr[idx++] = nums1[left++];
            } else {
                arr[idx++] = nums2[right++];
            }
        }
        while(left < nums1.length) {
            arr[idx++] = nums1[left++];
        }
        while(right < nums2.length) {
            arr[idx++] = nums2[right++];
        }
        left = 0; right = arr.length - 1;

        int mid = left + (right - left) / 2;

        if(arr.length % 2 == 0) {
            ans = arr[mid] + arr[mid + 1];
            ans /= 2;
        } else {
            ans = arr[mid];
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};

        System.out.println("Median = " + findMedian(nums1, nums2));
    }
}