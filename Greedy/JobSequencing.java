package Greedy;
import java.util.*;

public class JobSequencing {
    static class Job {
        int Id;
        int deadline;
        int profit;

        Job(int i, int d, int p) {
            Id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void jobScheduling(ArrayList<Job> arr, int n, int maxi) {
        Collections.sort(arr, (a, b) -> b.profit - a.profit);

        int[] result = new int[maxi + 1];
        for(int i = 0; i <= maxi; i++) {
            result[i] = -1;
        }

        int countJobs = 0, jobProfit = 0;

        for(int i = 0; i < n; i++) {
            for(int j = arr.get(i).deadline; j > 0; j--) {
                if(result[j] == -1) {   // Searching for free slot if available
                    result[j] = arr.get(i).Id;
                    countJobs++;
                    jobProfit += arr.get(i).profit;
                    break;
                }
            }
        }

        // Output from here on
        for(int i = 0; i <= maxi; i++) {
            if(result[i] > 0) {
                System.out.print("J" + result[i] + " ");
            }
        }

        System.out.println("\nMaximum Profit: " + jobProfit);
        System.out.println("Maximum Jobs Scheduled: " + countJobs);
    }

    public static void main(String[] args) {
        int[][] jobInfo = {{4, 50}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();
        int maxi = 0;   // Maximum deadline

        for(int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i+1, jobInfo[i][0], jobInfo[i][1]));
            if(jobs.get(i).deadline > maxi) maxi = jobs.get(i).deadline;
        }

        jobScheduling(jobs, jobInfo.length, maxi);

        // WRONG ON SOME EXTENT
        // Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);  // DESCENDING ORDER

        // ArrayList<Integer> seq = new ArrayList<>();

        // int time = 0;
        // for(int i = 0; i < jobs.size(); i++) {
        //     Job curr = jobs.get(i);
        //     if(curr.deadline > time) {
        //         time++;
        //         seq.add(curr.Id);
        //     }
        // }

        // for(int i = 0; i < seq.size(); i++) {
        //     System.out.print(seq.get(i) + " ");
        // }

        // System.out.println("\nMaximum Jobs: " + seq.size());
    }
}