import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                Set<Integer> set = new HashSet<>();
                
                for(int k = j+1; k < arr.length; k++) {
                    long sum = arr[i] + arr[j];
                    sum += arr[k];
                    long fourth = target - sum;

                    if(set.contains((int)fourth)) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], (int)fourth));
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                    set.add(arr[k]);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }

    public static List<List<Integer>> fourSumOpti(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;

            for(int j = i+1; j < n; j++) {
                if(j > i+1 && arr[j] == arr[j-1]) continue;
                int k = j+1;
                int l = n-1;

                while(k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];

                    if(sum > target) {
                        l--;
                    } else if(sum < target) {
                        k++;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l])));
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k-1]) k++;
                        while(k < l && arr[l] == arr[l+1]) l--;
                    }
                }
            } 
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -1, -2, 2, 0, -1};

        List<List<Integer>> res = fourSumOpti(arr, 0);
        System.out.println(res);
    }
}
