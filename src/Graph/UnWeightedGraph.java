package Graph;

import java.util.*;

// undirected graph
public class UnWeightedGraph {

    static ArrayList<ArrayList<Integer>> graph;

    UnWeightedGraph(int v) {
        graph = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    // weight of all path is 1
    public static int shortest_distance(int source, int destination){
        // if source and destination is same then return 0
        if(source == destination) return 0;

        // boolean array to keep record is any vertex is visited
        boolean[] isVisited = new boolean[graph.size()];

        // it keeps record of distance of any vertex with the source
        // initially all entries are zero
        int[] distances = new int[graph.size()];

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        isVisited[source] = true;
        while(!q.isEmpty()){
            int parent = q.remove();
            for(int vert : graph.get(parent)){
                if(!isVisited[vert]){
                    q.add(vert);
                    isVisited[vert] = true;

                    //updating distance as distance of parent+1;
                    //when parent is source itself then distance = 0 and keep increasing by 1 on every cycle
                    distances[vert] = distances[parent]+1;
                }
                if(vert == destination) return distances[vert];
            }
        }
        return -1;
    }

    public static boolean isPathAvailable(int source, int destination){
        // inefficient using bfs
        return !(shortest_distance(source,destination) == -1);
    }

    public static boolean isPath(int source,  int destination){
        if(source == destination) return true;
        boolean[] isVisited = new boolean[graph.size()];

        Stack<Integer> s = new Stack<>();
        s.push(source);
        isVisited[source] = true;

        while (!s.empty()){
            for(int vert : graph.get(s.pop())){
                if(!isVisited[vert]) {
                    s.push(vert);
                    isVisited[vert] = true;
                }
                if (vert == destination) return true;
            }
        }
        return false;
    }



    public static boolean isPathRec(int source, int destination){
        boolean[] isVisited = new boolean[graph.size()];
        return isPathRec(source,destination,isVisited);
    }
    public static boolean isPathRec(int source, int destination, boolean[] isVisited){
        if(source == destination) return true;

        isVisited[source] = true;
        for(int vert : graph.get(source)){
            if(!isVisited[vert]){

                // or bitwise operation for each vertex
                // check if any path possible till end or till it find one
                boolean isConnected = isPathRec(vert, destination,isVisited);
                if(isConnected) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        new UnWeightedGraph(v);

        List<Integer> ans = new ArrayList<>(v);


        /*
                [4] -------------[3]
               /  |              /|
             /    |            /  |
           /      |          /    |
        [0]       |        /      |             [5]
           \      |      /        |
             \    |    /          |
               \  |  /            |
                 [1] ------------[2]


             WHERE:
             [.] => VERTEX
             REMEMBER: [5] has no edge with others

         */

        addEdge(0, 1);
        addEdge(0, 4);
        addEdge(1, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(3, 4);

        // when 5 is unreachable
        System.out.println(shortest_distance(0, 5));
        System.out.println(isPathAvailable(0, 5));
        System.out.println(isPath(0, 5));
        System.out.println(isPathRec(1, 5));

        //adding edge (2-5)
        addEdge(2, 5);

        System.out.println(shortest_distance(0, 5));
        System.out.println(isPathAvailable(0, 5));
        System.out.println(isPath(0, 5));
        System.out.println(isPathRec(0, 5));
    }
}