import java.util.*;
import java.util.LinkedList;

public class Graph {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        //       
        //   1 -- 3
        //  /     | \
        // 0      |  5 -- 6
        //  \     | /
        //   2 -- 4
        //       

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static ArrayList<Integer> bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                bfsUtil(res, graph, vis, i);
            }
        }

        return res;
    }

    private static void bfsUtil(ArrayList<Integer> arr, ArrayList<Edge>[] graph, boolean[] vis, int st) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(st);
        vis[st] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();

            if(!vis[curr]) {
                arr.add(curr);
                vis[curr] = true;
                for(Edge e: graph[curr]) {
                    if(!vis[e.dest]) {
                        q.offer(e.dest);
                    }
                }
            }
        }
    }

    public static ArrayList<Integer> dfs(ArrayList<Edge>[] graph) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                dfsUtil(res, graph, vis, i);
            }
        }

        return res;
    }

    private static void dfsUtil(ArrayList<Integer> res, ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        res.add(curr);
        vis[curr] = true;

        for(Edge e: graph[curr]) {
            if(!vis[e.dest]) {
                dfsUtil(res, graph, vis, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] vis, int src, int dest) {
        if(src == dest) return true;

        vis[src] = true;

        for(Edge e: graph[src]) {
            if(!vis[e.dest] && hasPath(graph, vis, e.dest, dest)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(bfs(graph));

        System.out.println(dfs(graph));

        System.out.println(hasPath(graph, new boolean[V], 0, 5));
    }
}