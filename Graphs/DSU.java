import java.util.*;

public class DSU {
    static class DisjointSet {
        int[] par;
        int[] rank;
        int[] size;
        int n;

        public DisjointSet(int n) {
            this.n = n;
            par = new int[n];
            rank = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) par[i] = i;
            for(int i = 0; i < n; i++) size[i] = 1;
        }

        public int find(int x) {
            if(par[x] == x) return x;

            return par[x] = find(par[x]);
        }

        public void unionByRank(int a, int b) {
            int parA = find(a), parB = find(b);

            if(parA == parB) return;
            if(rank[parA] == rank[parB]) {
                par[parB] = parA;
                rank[parA]++;
            } else if(rank[parA] > rank[parB]) {
                par[parB] = parA;
            } else {
                par[parA] = parB;
            }
        }

        public void unionBySize(int a, int b) {
            int parA = find(a), parB = find(b);

            if(parA == parB) return;
            if(size[parA] >= size[parB]) {
                par[parB] = parA;
                size[parA] += size[parB];
            } else {
                par[parA] = parB;
                size[parB] += size[parA];
            }
        }
    }

    public static int kruskal(int edges[][], int n) {
        DisjointSet ds = new DisjointSet(n);
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int cnt = 0, cost = 0;

        for(int i = 0; cnt < n-1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            int parU = ds.find(u), parV = ds.find(v);

            if(parU != parV) {
                ds.unionBySize(parU, parV);
                cost += wt;
                cnt++;
            }
        }

        return cost;
    }
    
    public static void main(String[] args) {
        int V = 8;
        int[][] edges = { {0, 1, 1}, {1, 2, 2}, {1, 3, 3}, {2, 4, 4}, {3, 4, 3}, {4, 5, 5}, {4, 6, 1}, {5, 7, 2}, {6, 7, 7} };

        System.out.println(kruskal(edges, V));
    }
}
