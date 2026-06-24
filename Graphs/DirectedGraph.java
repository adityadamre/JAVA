import java.util.*;
import java.util.LinkedList;

public class DirectedGraph {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }   
        
        //        --> 2       -> 5
        //       /     \     /
        // 0--> 1       -> 4
        //       \     /     \
        //        --> 3       -> 6
        //

        graph[0].add(new Edge(0, 1));
        
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 5));
        // graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 6));
    }

    private static boolean isCycleDFSUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for(Edge e: graph[curr]) {
            if(stack[e.dest]) return true;

            if(!vis[e.dest] && isCycleDFSUtil(graph, vis, stack, e.dest)) return true;
        }

        stack[curr] = false;
        return false;
    }

    public static boolean isCycleDFS(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycleDFSUtil(graph, vis, stack, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void toposortDFSUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> st, int curr) {
        vis[curr] = true;

        for(Edge e: graph[curr]) {
            if(!vis[e.dest]) toposortDFSUtil(graph, vis, st, e.dest);
        }

        st.push(curr);
    }

    public static ArrayList<Integer> toposortDFS(ArrayList<Edge>[] graph) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                toposortDFSUtil(graph, vis, st, i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) res.add(st.pop());

        return res;
    }

    public static ArrayList<Integer> toposortBFS(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        for(ArrayList<Edge> arr: graph) {
            for(Edge e: arr) {
                indeg[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0) q.offer(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for(Edge e: graph[curr]) {
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) q.offer(e.dest);
            }
        }

        return res;
    }

    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, StringBuilder sb, ArrayList<String> res) {
        sb.append(src);

        if(src == dest) {
            res.add(sb.toString());
            sb.delete(sb.length() - 1, sb.length());
            return;
        }

        for(Edge e: graph[src]) {
            allPaths(graph, e.dest, dest, sb, res);
        }

        sb.delete(sb.length() - 1, sb.length());
    }

    private static void dfs(ArrayList<Integer> arr, ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        arr.add(curr);

        for(Edge e: graph[curr]) {
            if(!vis[e.dest]) dfs(arr, graph, e.dest, vis);
        }
    }

    public static ArrayList<ArrayList<Integer>> kosaraju(ArrayList<Edge>[] graph) { // Strongly Connected Components
        int n = graph.length;
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(!vis[i]) toposortDFSUtil(graph, vis, st, i);
        }

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[n];
        for(int i = 0; i < transpose.length; i++) transpose[i] = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            vis[i] = false;
            for(Edge e: graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while(!st.isEmpty()) {
            int curr = st.pop();

            if(!vis[curr]) {
                ArrayList<Integer> list = new ArrayList<>();
                dfs(list, transpose, curr, vis);
                res.add(new ArrayList<>(list));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCycleDFS(graph));

        System.out.println(toposortDFS(graph));

        System.out.println(toposortBFS(graph));

        ArrayList<String> arr = new ArrayList<>();
        allPaths(graph, 0, 6, new StringBuilder(), arr);
        System.out.println(arr);

        System.out.println();
        System.out.println(kosaraju(graph));
    }
}

// // Just for Fun :)
// class Solution {
//     private int dfs(ArrayList<Integer>[] graph, boolean[] vis, boolean[] pathVis, int curr) {
//         vis[curr] = true;
//         pathVis[curr] = true;

//         for(int adj: graph[curr]) {
//             if(pathVis[adj]) return adj;
//             if(vis[adj]) continue;

//             int temp = dfs(graph, vis, pathVis, adj);
//             if(temp != -1) return temp;
//         }

//         pathVis[curr] = false;
//         return -1;
//     }

//     private boolean helper(ArrayList<Integer>[] graph, Set<Integer> set, boolean[] vis, int node) {
//         vis[node] = true;
//         set.add(node);

//         for(int adj: graph[node]) {
//             if(vis[adj]) return true;
//             if(!vis[adj] && helper(graph, set, vis, adj)) return true;
//         }

//         set.remove(node);
//         return false;
//     }
        
//     public int[] findRedundantDirectedConnection(int[][] edges) {
//         int n = edges.length;
//         ArrayList<Integer>[] graph = new ArrayList[n+1];
//         for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
//         int[] indeg = new int[n+1];
//         int idx = -1;
        
//         for(int[] e: edges) {
//             graph[e[0]].add(e[1]);
//             indeg[e[1]]++;

//             if(indeg[e[1]] > 1) {
//                 idx = e[1];
//             }
//         }

//         if(idx != -1) {
//             for(int i = n-1; i >= 0; i--) {
//                 if(edges[i][1] == idx) return edges[i];
//             }
//         }

//         Stack<Integer> st = new Stack<>();
//         boolean[] vis = new boolean[n+1], pathVis = new boolean[n+1];
//         int node = 0;

//         for(int i = 0; i <= n; i++) {
//             if(!vis[i]) {
//                 int temp = dfs(graph, vis, pathVis, i);
//                 if(temp != -1) {
//                     node = temp;
//                     break;
//                 }
//             }
//         }
//         // System.out.println(node);

//         Set<Integer> set = new HashSet<>();
//         vis = new boolean[n+1];
//         helper(graph, set, vis, node);
//         // System.out.println(set);

//         for(int i = n-1; i >= 0; i--) {
//             if(set.contains(edges[i][0]) && set.contains(edges[i][1])) return edges[i];
//         }

//         return new int[] { 0, 0 };
//     }
// }

// class Solution1 {
//     static class DisjointSet {
//         int[] par;
//         int[] size;

//         public DisjointSet(int n) {
//             par = new int[n];
//             size = new int[n];

//             for(int i = 0; i < n; i++) par[i] = i;
//             for(int i = 0; i < n; i++) size[i] = 1;
//         }

//         public int findPar(int x) {
//             if(par[x] == x) return x;

//             return par[x] = findPar(par[x]);
//         }

//         public void union(int a, int b) {
//             int parA = findPar(a), parB = findPar(b);

//             if(parA == parB) return;
//             if(size[parA] >= size[parB]) {
//                 par[parB] = parA;
//                 size[parA] += size[parB];
//             } else {
//                 par[parA] = parB;
//                 size[parB] += size[parA];
//             }
//         }
//     }

//     public int[] findRedundantDirectedConnection(int[][] edges) {
//         int n = edges.length;
//         ArrayList<Integer>[] graph = new ArrayList[n+1];
//         for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

//         for(int[] e: edges) {
//             graph[e[0]].add(e[1]);
//         }

//         DisjointSet ds = new DisjointSet(n+1);
//         for(int[] e: edges) {
//             int parA = ds.findPar(e[0]), parB = ds.findPar(e[1]);

//             if(parA == parB) return e;

//             ds.union(parA, parB);
//         }

//         return new int[] { 0, 0 };
//     }
// }