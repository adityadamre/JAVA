import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] arr) {    // TC --> O(N x N)
        Set<List<Integer>> ans = new HashSet<>();              // SC --> O(N) + O(No. of unique triplets)
        for(int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();

            for(int j=i+1; j < arr.length; j++) {
                int third = -(arr[i] + arr[j]);

                if(set.contains(third)) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i], arr[j], third));
                    Collections.sort(temp);
                    ans.add(temp);
                }
                set.add(arr[j]);
            }
        }

        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }

    public static List<List<Integer>> threeSumOpti(int[] nums) {    // O(N logN) + O(N x N)
        List<List<Integer>> res = new ArrayList<>();                // O(No. of unique triplets)
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum > 0) {
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = threeSumOpti(arr);
        System.out.println(res);
    }
}