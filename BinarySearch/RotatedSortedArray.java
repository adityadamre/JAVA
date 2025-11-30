package BinarySearch;

public class RotatedSortedArray {
    public static int search(int[] nums, int target) {  // nums contain unique elements
        int st = 0, end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            
            if(nums[st] <= nums[mid]) {    // Left Sorted
                if(nums[mid] > target && nums[st] <= target) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {    // Right Sorted
                if(nums[mid] < target && nums[end] >= target) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static boolean isPresent(int[] nums, int target) {  // nums may contain duplicate elements
        int st = 0, end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid] == target) {
                return true;
            }
            
            if(nums[st] == nums[mid] && nums[mid] == nums[end]) {  // Ambiguity...
                st++; end--;
            } else if(nums[st] <= nums[mid]) {    // Left Sorted
                if(nums[mid] > target && nums[st] <= target) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {    // Right Sorted
                if(nums[mid] < target && nums[end] >= target) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mini = Integer.MAX_VALUE;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(nums[l] <= nums[r]) {
                mini = Math.min(mini, nums[l]);
                break;
            }

            if(nums[l] <= nums[mid]) {
                mini = Math.min(mini, nums[l]);
                l = mid + 1;
            } else {
                mini = Math.min(mini, nums[mid]);
                r = mid - 1;
            }
        }

        return mini;
    }

    public static int peakElement(int[] arr) {  // return index
        int n = arr.length;
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        int l = 1, r = n - 2;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;

            if(arr[mid] > arr[mid - 1]) l = mid + 1;
            else if(arr[mid] < arr[mid - 1]) r = mid - 1;
        }

        return -1;
    }

    public static int findKRotation(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mini = Integer.MAX_VALUE, idx = -1;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(nums[l] <= nums[r]) {
                if(nums[l] < mini) {
                    mini = nums[l];
                    idx = l;
                }
                break;
            }

            if(nums[l] <= nums[mid]) {
                if(nums[l] < mini) {
                    mini = nums[l];
                    idx = l;
                }
                l = mid + 1;
            } else {
                if(nums[mid] < mini) {
                    mini = nums[mid];
                    idx = mid;
                }
                r = mid - 1;
            }
        }

        return idx;
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 1, 2, 3, 4};

        System.out.println(search(arr, 8));
        System.out.println(isPresent(new int[] {3, 3, 4, 5, 3, 3, 3, 3, 3}, 5));
        System.out.println(findMin(arr));
        System.out.println(findKRotation(arr));
    }
}
