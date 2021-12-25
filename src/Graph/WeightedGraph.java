package Graph;

import java.util.ArrayList;
import java.util.List;

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
            (10)  |    /          |
               \  |  /            |
                 [1] --- (30) ---[2]


             WHERE:
             [.] => VERTEX
             (.) => WEIGHT

         */

        addEdge(graph,0, 1, 10);
        addEdge(graph,0, 4, 40);
        addEdge(graph,1, 4, 50);
        addEdge(graph,1, 2, 30);
        addEdge(graph,1, 3, 40);
        addEdge(graph,2, 3, 60);
        addEdge(graph,3, 4, 70);

        print(graph);
    }
}
