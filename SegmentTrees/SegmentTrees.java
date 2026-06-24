class SubarraySumSG {
    static int[] tree;

    public SubarraySumSG(int n) {
        tree = new int[4*n];
    }

    public int buildTree(int[] arr, int i, int st, int end) {
        if(st == end) return tree[i] = arr[st];
        
        int mid = st + (end - st) / 2;
        buildTree(arr, 2*i+1, st, mid);
        buildTree(arr, 2*i+2, mid+1, end);

        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    private int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if(qi > sj || qj < si) {
            return 0;
        } else if(qi <= si && qj >= sj) {
            return tree[i];
        } else {
            int mid = si + (sj - si) / 2;
            return getSumUtil(2*i+1, si, mid, qi, qj) + getSumUtil(2*i+2, mid+1, sj, qi, qj);
        }
    }

    public int getSum(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    private void updateUtil(int i, int si, int sj, int idx, int diff) {
        if(si > idx || idx > sj) return;

        tree[i] += diff;
        if(si != sj) {
            int mid = si + (sj - si) / 2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }

    public void update(int[] arr, int idx, int newVal) {
        int n = arr.length;
        int diff = arr[idx] - newVal;
        arr[idx] = newVal;

        updateUtil(0, 0, n-1, idx, diff);
    }
}

class MaxMinSG {    // I have build this one for Maximum, though we can update it for Minimum in no time
    static int[] tree;

    public MaxMinSG(int n) {
        tree = new int[4*n];
    }

    public void buildTree(int i, int[] arr, int si, int sj) {
        if(si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = si + (sj - si) / 2;
        buildTree(2*i+1, arr, si, mid);
        buildTree(2*i+2, arr, mid+1, sj);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    private int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if(qi > sj || qj < si) return Integer.MIN_VALUE;
        else if(qi <= si && qj >= sj) return tree[i];

        int mid = si + (sj - si) / 2;
        int l = getMaxUtil(2*i+1, si, mid, qi, qj);
        int r = getMaxUtil(2*i+2, mid+1, sj, qi, qj);

        return Math.max(l, r);
    }

    public int getMax(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    private void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if(idx < si || idx > sj) return;

        if(si == sj) {
            tree[i] = newVal;
        } else {
            int mid = si + (sj - si) / 2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
            tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
        }
    }

    public void update(int[] arr, int idx, int newVal) {
        int n = arr.length;
        updateUtil(0, 0, n-1, idx, newVal);
    }
}

public class SegmentTrees {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        SubarraySumSG sg = new SubarraySumSG(n);
        sg.buildTree(arr, 0, 0, n-1);
        System.out.println(sg.getSum(arr, 1, 5));
        sg.update(arr, 2, 4);
        System.out.println(sg.getSum(arr, 1, 5));

        int[] nums = { 6, 3, -2, 0, 13, 9, 7 };
        int m = nums.length;

        MaxMinSG sg2 = new MaxMinSG(m);
        sg2.buildTree(0, nums, 0, m-1);
        System.out.println(sg2.getMax(nums, 1, 5));
        sg2.update(nums, 4, 8);
        System.out.println(sg2.getMax(nums, 1, 5));
    }
}