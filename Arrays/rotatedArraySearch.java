package Arrays;

public class rotatedArraySearch {
    public static int search(int arr[], int target) {
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[start] <= arr[mid]) {
                if(arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            else {
                if(arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    static int recursiveSearch(int arr[], int key, int st, int end) {
        int mid = st + (end - st)/2;

        if(st > end) {
            return -1;
        }

        if(arr[mid] == key) {
            return mid;
        }

        if(arr[st] <= arr[mid]) {
            if(arr[st] <= key && key <= arr[mid]) {
                return recursiveSearch(arr, key, st, mid - 1);
            } else {
                return recursiveSearch(arr, key, mid + 1, end);
            }
        } else {
            if(arr[mid] <= key && key <= arr[end]) {
                return recursiveSearch(arr, key, mid + 1, end);
            } else {
                return recursiveSearch(arr, key, st, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {13, 3, 6, 7, 9};
        int target = 9;
        System.out.println("Target element is at index location : " + recursiveSearch(arr, target, 0, arr.length - 1));
    }
}