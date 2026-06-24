import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class ShortestPath {
    static class Edge {
        int adj, wt;

        public Edge(int a, int w) {
            adj = a;
            wt = w;
        }
    }

    public static void createGraph(int[][] edges, ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }   
        
        for(int[] e: edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
        }
    }
    
    private static void toposort(Stack<Integer> st, ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        vis[curr] = true;
        
        for(Edge edge: graph[curr]) {
            if(!vis[edge.adj]) {
                toposort(st, graph, vis, edge.adj);
            }
        }
        
        st.push(curr);
    }

    public static int[] shortestPath(ArrayList<Edge>[] graph, int V) {        // DAG
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) toposort(st, graph, vis, i);
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        
        while(!st.isEmpty()) {
            int curr = st.pop();
            
            for(Edge e: graph[curr]) {
                int adj = e.adj;
                int wt = e.wt;
                
                if(dist[adj] > dist[curr] + wt) {
                    dist[adj] = dist[curr] + wt;
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(dist[i] == (int) 1e9) dist[i] = -1;
        }
        
        return dist;
    }

    public static int[] dijkstra(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // node, dist respectively
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {src, 0});

        while(!pq.isEmpty()) {
            int curr = pq.peek()[0];
            int d = pq.peek()[1];
            pq.poll();
            
            for(Edge e: graph[curr]) {
                if(e.wt + d < dist[e.adj]) {
                    dist[e.adj] = d + e.wt;
                    pq.offer(new int[] {e.adj, dist[e.adj]});
                }
            }
        }

        for(int i = 0; i < V; i++) {
            if(dist[i] == (int) 1e9) dist[i] = -1;
        }

        return dist;
    }

    public static int[] bellmanFord(int[][] edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;
        
        for(int i = 0; i < V-1; i++) {
            for(int[] e: edges) {
                if(dist[e[0]] != (int) 1e8 && dist[e[1]] > e[2] + dist[e[0]]) {
                    dist[e[1]] = e[2] + dist[e[0]];
                }
            }
        }
        
        for(int[] e: edges) {
            if(dist[e[0]] != (int) 1e8 && dist[e[1]] > e[2] + dist[e[0]]) {
                return new int[] { -1 };
            }
        }
        
        return dist;
    }

    public static void main(String[] args) {
        int V = 8;
        int[][] edges = { {0, 1, 1}, {1, 2, 2}, {1, 3, 3}, {2, 4, 4}, {3, 4, 3}, {4, 5, 5}, {4, 6, 1}, {5, 7, 2}, {6, 7, 7} };
        
        //        --> 2       -> 5
        //       /     \     /     \
        // 0--> 1       -> 4        -> 7
        //       \     /     \     /
        //        --> 3       -> 6
        //

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(edges, graph);

        int[] res1 = shortestPath(graph, V);
        for(int i: res1) System.out.print(i + ", ");
        
        System.out.println();
        
        int[] res2 = dijkstra(graph, 0);
        for(int i: res2) System.out.print(i + ", ");

        System.out.println();

        int[] res3 = bellmanFord(edges, V, 0);
        for(int i: res3) System.out.print(i + ", ");
    }
}
