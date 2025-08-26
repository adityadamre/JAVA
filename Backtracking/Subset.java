package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    static int findSubset(String str, String ans, int i) {
        if(i == str.length()) {
            System.out.print(ans +" ");
            return 1;
        }
        //Choice Yes
        findSubset(str, ans + str.charAt(i), i+1);
        //Choice No
        findSubset(str, ans, i+1);
        return 1;
    }

    //LEETCODE 78
    private static void generateSubset(List<List<Integer>> res, int[] nums, List<Integer> temp, int i) {
        if(i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        generateSubset(res, nums, temp, i+1);

        temp.remove(temp.size() - 1);
        generateSubset(res, nums, temp, i+1);
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubset(res, nums, new ArrayList<>(), 0);
        
        return res;
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubset(str, new String(""), 0);

        int[] nums = {1, 2, 3};
        System.out.println("\n" + subsets(nums));
    }
}
