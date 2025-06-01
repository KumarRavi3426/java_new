package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class dijkstra {
    static class Edge{
        int wt;
        int src;
        int dest;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    /*
                | Interface    | Incoming Object  | Existing Object   | Compare Direction |
                | ------------ | ---------------- | ----------------- | ----------------- |
                | `Comparator` | `s1` (first arg) | `s2` (second arg) | New vs Existing   |
                | `Comparable` | `p2` (argument)  | `this`            | Existing vs New   |

                return -1 means the first one should come before.
    */
    public static class Pair implements Comparable<Pair>{
        // we need this Pair because we need to associate the node with distance from source, so that it can be sorted based on distance in priority queue
        // implements applied on Pair not PriorityQueue
        int node;
        int dist;
        public Pair(int n, int d){
            this.node = n;
            this.dist  = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist; // ascending
        }
    }

    // O(E + Elog(V))       // ElogV due to sortin in Prior.Queue
    public static void dijkstra(ArrayList<Edge>[] graph, int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Not a regular Queue, because we need the node which has the shortest distance in front
        int[] dist = new int[V];
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;    // initialising all other nodes' distance to infinity
            }
        }
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            // we need the node which is unvisited & has shortest dist from src
            // since it is Prior.queue we will always get the shortest dist. at the front, and we'll do anything, only if it is unvisited
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v]){   // relaxation
                        dist[v] = dist[u]+e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i:dist){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int V= 6;
        boolean[] vis = new boolean[V];
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0, V);
    }
}
