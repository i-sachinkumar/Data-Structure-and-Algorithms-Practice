package Graph;

import java.util.*;

public class WeightedGraph {

    public static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int u, int v, int w){
        // joining vertex u and v with weight, w
        // it is undirected graph
        adj.get(u).add(new ArrayList<>(List.of(v, w)));
        adj.get(v).add(new ArrayList<>(List.of(u, w)));
    }

    public static void print(ArrayList<ArrayList<ArrayList<Integer>>> adj){
        for(int i = 0 ; i < adj.size(); i++){
            System.out.println("Node " + i + " makes edge with:");
            for(ArrayList<Integer> vert : adj.get(i)){
                System.out.println("   Node " + vert.get(0) + " with edge weight of " + vert.get(1));
            }
            System.out.println("\n");
        }
    }


    // visiting destination in all possible way and storing distance
    public static int shortest_distance(ArrayList<ArrayList<ArrayList<Integer>>> graph, int source, int destination){
        // if source and destination is same then return 0
        if(source == destination) return 0;

        // boolean array to keep record is any vertex is visited
        boolean[] isVisited = new boolean[graph.size()];

        // it keeps record of distance of any vertex with the source
        // initially all entries are zero
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        isVisited[source] = true;
        while(!q.isEmpty()){
            int parent = q.remove();
            for(ArrayList<Integer> v : graph.get(parent)){
                if(!isVisited[v.get(0)]){
                    q.add(v.get(0));
                    isVisited[v.get(0)] = true;

                    //updating distance as distance of parent+1;
                    //when parent is source itself then distance = 0 and keep increasing by 1 on every cycle
                    if(distances[parent] == Integer.MAX_VALUE) distances[v.get(0)] = Math.min(distances[v.get(0)],v.get(1));
                    else distances[v.get(0)] = Math.min(distances[v.get(0)], distances[parent] + v.get(1));
                }
            }
        }
        return distances[destination];
    }

    public static void main(String[] args) {

        int v = 5; // no. of vertex
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>(v);
        for(int i = 0 ; i < v; i++){
            graph.add(new ArrayList<>());
        }

        /*
                [4] --- (70) ----[3]
               /  |              /|
            (40)  |            /  |
           /      |          /    |
        [0]      (50)     (40)   (60)
           \      |      /        |
            (100)  |    /          |
               \  |  /            |
                 [1] --- (30) ---[2]


             WHERE:
             [.] => VERTEX
             (.) => WEIGHT

         */

        addEdge(graph,0, 1, 100);
        addEdge(graph,0, 4, 40);
        addEdge(graph,1, 4, 60);
        addEdge(graph,1, 2, 30);
        addEdge(graph,1, 3, 40);
        addEdge(graph,2, 3, 60);
        addEdge(graph,3, 4, 70);

        print(graph);
        System.out.println(shortest_distance(graph,0,1));

    }
}
