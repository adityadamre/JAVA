import java.util.*;

public class FreqFollowKey {
    static int freqFollowing(ArrayList<Integer> nums, int key) {
        int[] result = new int[1000];
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == key) {
                result[nums.get(i+1) - 1]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0; i < 1000; i++) {
            if(max < result[i]) {
                max = result[i];
                ans = i+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(1);
        arr.add(6);
        arr.add(1);
        arr.add(1);
        arr.add(6);

        System.out.println(freqFollowing(arr, 1));
    }
}
