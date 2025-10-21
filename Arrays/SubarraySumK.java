import java.util.*;

public class SubarraySumK {
    public static int subarraySumK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        map.put(0, 1);

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int req = sum - k;

            count += map.getOrDefault(req, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int subarrayXOR(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, xor = 0;
        map.put(0,1);

        for(int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            int x = xor ^ k;

            count += map.getOrDefault(x, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 2, 6, 4};
        System.out.println(subarrayXOR(arr1, 6));

        int[] arr2 = {3, 0, 3, 1, 2, 3};
        System.out.println(subarraySumK(arr2, 3));
    }
}
