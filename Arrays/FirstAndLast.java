public class FirstAndLast {
    public static int[] searchRange(int[] nums, int target) {
        int first = findIndex(nums, target, true);
        int last = findIndex(nums, target, false);
        return new int[] {first, last};
    }

    public static int findIndex(int[] nums, int target, boolean isFirst) {
        int st = 0, end = nums.length - 1, idx = -1;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid] == target) {
                idx = mid;
                if(isFirst) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }else if(nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 4, 5, 5, 5, 9, 9, 11};
        int tar = 3;

        int[] result = searchRange(arr, tar);

        System.out.println(result[0] + " " + result[1]);
    }
}