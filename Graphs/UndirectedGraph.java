import java.util.*;
import java.util.LinkedList;

public class UndirectedGraph {
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
        //       
        //   1 -- 3
        //  /     | \
        // 0      |  5 -- 6
        //  \     | /
        //   2 -- 4
        //       

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static boolean isCycleBFS(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycleBFSUtil(graph, vis, i)) return true;
            }
        }

        return false;
    }

    private static boolean isCycleBFSUtil(ArrayList<Edge>[] graph, boolean[] vis, int st) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {st, -1});
        vis[st] = true;

        while(!q.isEmpty()) {
            int curr = q.peek()[0];
            int par = q.peek()[1];
            q.poll();

            for(Edge e: graph[curr]) {
                int adj = e.dest;

                if(!vis[adj]) {
                    vis[adj] = true;
                    q.offer(new int[] { adj, curr });
                } else if(adj != par) {
                    return true;
                }
            }
        }

        return false;
    }


    public static boolean isCycleDFS(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycleDFSUtil(graph, vis, i, -1)) return true;
            }
        }

        return false;
    }

    private static boolean isCycleDFSUtil(ArrayList<Edge>[] graph, boolean[] vis, int st, int par) {
        vis[st] = true;

        for(Edge e: graph[st]) {
            int adj = e.dest;

            if(!vis[adj]) {
                if(isCycleDFSUtil(graph, vis, adj, st)) return true;
            } else if(vis[adj] && adj != par) {
                return true;
            }
        }

        return false;
    }


    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] colors = new int[graph.length];
        // 0 -> No color & 1, 2 -> Available Colors

        for(int i = 0; i < colors.length; i++) {
            if(colors[i] == 0) {
                if(!isBipartiteUtil(graph, colors, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int[] colors, int st) {
        Queue<Integer> q = new LinkedList<>();
        colors[st] = 1;
        q.offer(st);

        while(!q.isEmpty()) {
            int temp = q.poll();

            for(Edge e: graph[temp]) {
                if(colors[e.dest] == 0) {
                    colors[e.dest] = colors[temp] == 1 ? 2 : 1;
                    q.offer(e.dest);
                } else if(colors[temp] == colors[e.dest]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void dfsBridge(ArrayList<Edge>[] graph, int curr, int[] dt, int[] low, boolean[] vis, int par, int[] time) {
        vis[curr] = true;
        dt[curr] = low[curr] = time[0]++;

        for(Edge e: graph[curr]) {
            if(e.dest == par) continue;
            else if(!vis[e.dest]) {
                dfsBridge(graph, e.dest, dt, low, vis, curr, time);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(dt[curr] < low[e.dest]) {
                    System.out.println(curr + "---->" + e.dest);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        int[] dt = new int[V];  // Discovery Time
        int[] low = new int[V];
        int[] time = { 1 };

        for(int i = 0; i < V; i++) {
            if(!vis[i]) dfsBridge(graph, i, dt, low, vis, -1, time);
        }
    }

    private static void dfsAP(ArrayList<Edge>[] graph, int curr, int[] dt, int[] low, 
                                boolean[] vis, boolean[] ap, int par, int[] time) {
            vis[curr] = true;
            dt[curr] = low[curr] = time[0]++;
            int children = 0;

            for(Edge e: graph[curr]) {
                if(e.dest == par) continue;
                else if(vis[e.dest]) {
                    low[curr] = Math.min(low[curr], dt[e.dest]);
                }
                else {
                    dfsAP(graph, e.dest, dt, low, vis, ap, curr, time);
                    low[curr] = Math.min(low[curr], low[e.dest]);
                    if(par != -1 && dt[curr] <= low[e.dest]) {
                        ap[curr] = true;
                    }
                    children++;
                }
            }

            if(par == -1 && children > 1) {
                ap[curr] = true;
            }
        }

    public static void tarjanAP(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V];
        int[] dt = new int[V];  // Discovery Time
        int[] low = new int[V];
        int[] time = { 1 };

        for(int i = 0; i < V; i++) {
            if(!vis[i]) dfsAP(graph, i, dt, low, vis, ap, -1, time);
        }

        for(int i = 0; i < V; i++) {
            if(ap[i]) System.out.println("AP: " + i);
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCycleBFS(graph));

        System.out.println(isCycleDFS(graph));

        System.out.println(isBipartite(graph));

        tarjanBridge(graph, V);
        System.out.println();
        tarjanAP(graph, V);
    }
}
