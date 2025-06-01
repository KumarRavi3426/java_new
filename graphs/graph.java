package graphs;

import java.util.*;

public class graph{

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

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){      // we need to initialize them in start otherwise it will give null pointer exception
            graph[i] = new ArrayList<>();
        }
//        graph[0].add(new Edge(0, 1));
//        graph[0].add(new Edge(0, 2));
//
//        graph[1].add(new Edge(1, 0));
//        graph[1].add(new Edge(1, 3));
//
//        graph[2].add(new Edge(2, 0));
//        graph[2].add(new Edge(2, 4));
//
//        graph[3].add(new Edge(3, 1));
//        graph[3].add(new Edge(3,4));
//        graph[3].add(new Edge(3,5));
//
//        graph[4].add(new Edge(4,2));
//        graph[4].add(new Edge(4,3));
//        graph[4].add(new Edge(4,5));
//
//        graph[5].add(new Edge(5,3));
//        graph[5].add(new Edge(5,4));
//        graph[5].add(new Edge(5,6));
//
//        graph[6].add(new Edge(6,5));

        graph[0].add(new Edge(4, 2));
        graph[0].add(new Edge(0,2));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
        graph[1].add(new Edge(1,0));

    }

    public static void bfs(ArrayList<Edge>[] graph, boolean[] vis, int start){
        Queue<Integer> q = new LinkedList<>();      // make a queue
        q.add(start);       // add first element

        while(!q.isEmpty()){        // until queue is empty
            int curr = q.remove();      // pop the top element
            if(!vis[curr]){     // if it's unvisited, visit it, and then add all its neighbours to queue
                vis[curr]= true;
                System.out.print(curr+" ");
                for(int i =0; i< graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    // O(V+E)
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        vis[curr]=true;     // visit it
        System.out.print(curr+" ");
        for(int i=0; i<graph[curr].size();i++){     // for all its neighbours/ Edges, if dest not visited, call dfs
            Edge e = graph[curr].get(i);
            if(! vis[e.dest]) dfs(graph, e.dest, vis);
        }
    }

    // O(V^V)
    public static void printAllPaths(ArrayList<Edge>[] graph, int curr, boolean[] vis, String path, int tar){
        if(curr == tar){
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                vis[curr] = true;     // backtracking in modified dfs
                printAllPaths(graph, e.dest, vis, path + e.dest, tar);
                vis[curr] = false;
            }
        }
    }
    public static boolean isCycleDirected(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] rec){     // if the node already exists in the recursion stack (here rec array), then a cycle is present
        vis[curr]=true;
        rec[curr]=true; // backtracking of rec array
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
//        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];

//        // we are traversing over the vis array, because the graph can be in different segments. This way we can cover all nodes
        for(int i=0; i<V; i++){
            if(!vis[i]){
//                bfs(graph, vis, i);
//                dfs(graph, 0, vis);
                boolean isCycle = isCycleDirected(graph, vis, 0, rec);
                if(isCycle){
                    System.out.println(isCycle);
                    break;
                }
            }
        }

//        vis[0]=true;
        printAllPaths(graph, 0, vis, "0", 5);


    }
}