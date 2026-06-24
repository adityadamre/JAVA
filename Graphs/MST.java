import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {
    static class Edge {
        int adj, wt;

        public Edge(int a, int w) {
            adj = a;
            wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        //       5 
        //    1 --- 3
        //  2/      | \7
        //  /       |  \
        // 0       1|   5 ---- 6
        //  \       |  /   5
        //  3\      | /2   
        //    2 --- 4
        //       4 

        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(2, 3));

        graph[1].add(new Edge(0, 2));
        graph[1].add(new Edge(3, 5));
        
        graph[2].add(new Edge(0, 3));
        graph[2].add(new Edge(4, 4));
        
        graph[3].add(new Edge(1, 5));
        graph[3].add(new Edge(4, 1));
        graph[3].add(new Edge(5, 7));

        graph[4].add(new Edge(2, 4));
        graph[4].add(new Edge(3, 1));
        graph[4].add(new Edge(5, 2));

        graph[5].add(new Edge(3, 7));
        graph[5].add(new Edge(4, 2));
        graph[5].add(new Edge(6, 5));

        graph[6].add(new Edge(5, 5));
    }

    private static int prims(ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[] { 0, 0 });
        int cost = 0;

        while(!pq.isEmpty()) {
            int curr = pq.peek()[0];
            int weight = pq.poll()[1];
            if(vis[curr]) continue;

            vis[curr] = true;
            cost += weight;

            for(Edge e: graph[curr]) {
                if(!vis[e.adj]) {
                    pq.offer(new int[] { e.adj, e.wt });
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(prims(graph));
    }
}
