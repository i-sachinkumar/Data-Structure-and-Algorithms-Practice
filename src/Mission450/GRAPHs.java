package Mission450;


import java.util.*;

/**
 * https://www.oriient.me/
 * Graph : directed and undirected
 *
 * degree of a node = number of edge connected to a node (undirected graph)
 *
 * indegree = number of edge coming towards that node
 * outdegree = number of edge going from that node
 *
 * weighted graph
 *
 *                              Graph
 *                              /   \
 *              adjacency matrix     Adjacency list
 *
 *   Adjacency Matrix
 *   n = number of nodes (4 let say)
 *
 *   2d array
 *   0  1   2   3
 *   1 [ ] [ ] [ ]
 *   2 [ ] [ ] [ ]
 *   3 [ ] [ ] [ ]
 *   where matrix(i,j) == 1 if there's path from ith node to jth node
 *   0, otherwise
 *
 *   Adjacency List
 *   0 -> List0
 *   1 -> List1
 *   .    . . .
 *   .    . . .
 *   n -> Listn
 *
 *   where (0, 1, ... , n) is the nodes and list associated with them represent all connected nodes
 *   eg
 *                                      (0) ----------- (1)
 *                                       |               | \
 *                                       |               |  (2)
 *                                       |               | /
 *                                      (4) ----------- (3)
 *       0 -> {1, 4}
 *       1 -> {0, 2, 3}
 *       2 -> {1, 3}
 *       3 -> {1, 2, 4}
 *       4 -> {0, 3}
 *
 *       Map<Integer, List<Integer>> graph
 *
 */

// Graph class
class Graph<T>{
    Map<T, List<T>> graph;
    Graph(){
        graph = new HashMap<>();
    }

    public void addEdge(T a, T b, boolean isDirected){
        if(graph.containsKey(a)) graph.get(a).add(b);
        else graph.put(a, new ArrayList<>(List.of(b)));

        if(!isDirected){
            if(graph.containsKey(b)) graph.get(b).add(a);
            else graph.put(b, new ArrayList<>(List.of(a)));
        }
    }
    public void print(){
        for (Map.Entry<T, List<T>> e : graph.entrySet()) {
            System.out.print(e.getKey() +  " -> ");
            for (T node : e.getValue()){
                System.out.print(node +", ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + graph +
                '}';
    }

}

public class GRAPHs {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1)));
        adj.add(new ArrayList<>(List.of(0,2,4)));
        adj.add(new ArrayList<>(List.of(1,3)));
        adj.add(new ArrayList<>(List.of(2,4)));
        adj.add(new ArrayList<>(List.of(1,3)));

        System.out.println(isCyclicDfs(adj));





        Scanner sc = new Scanner(System.in);
        //undirected graph
        Graph<Integer> graph = new Graph<>();

        System.out.println("Enter number of edges");
        int m = sc.nextInt();

        System.out.println("Enter edges");
        for(int i = 0 ; i  < m ; i++){
            graph.addEdge(sc.nextInt(), sc.nextInt(), false);
        }

        graph.print();
        System.out.println(graph);
    }

     /**
     * Function to return Breadth First Traversal of given graph.
     * @param adj = graph
     * @return List of values by traversing
     */
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        if(n == 0) return ans;
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]) bfsOfGraph(adj, i, ans, vis);
        }
        return ans;
    }
    public void bfsOfGraph(ArrayList<ArrayList<Integer>> adj, int i, ArrayList<Integer> ans, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis[i] = true;
        while (!q.isEmpty()){
            int curr_node = q.poll();
            ans.add(curr_node);
            for(int neighbor : adj.get(curr_node)){
                if(!vis[neighbor]){
                    q.offer(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
    }


    /**
     * Function to return Depth First Traversal of given graph.
     * @param adj = graph
     * @return List of values by traversing
     */
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        if(n == 0) return ans;
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]) dfsOfGraph(adj, i, ans, vis);
        }
        return ans;
    }
    public void dfsOfGraph(ArrayList<ArrayList<Integer>> adj, int i, ArrayList<Integer> ans, boolean[] vis) {
        if(vis[i]) return;
        vis[i] = true;
        ans.add(i);
        for(int neighbour : adj.get(i)){
            dfsOfGraph(adj, neighbour, ans, vis);
        }
    }

    /**
     * Function to check if graph is Cyclic using bfs.
     * @param adj = graph
     * @return true if there is cycle in graph
     */
    public boolean isCyclicBfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        boolean ans = false;
        if(n == 0) return false;
        boolean[] vis = new boolean[n];
        int[] parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]) ans = ans || isCyclicBfs(adj, i, vis, parent);
        }
        return ans;
    }
    public boolean isCyclicBfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        parent[i] = -1;
        vis[i] = true;
        while (!q.isEmpty()){
            int curr_node = q.poll();
            //ans.add(curr_node);
            for(int neighbor : adj.get(curr_node)){
                if(!vis[neighbor]){
                    q.offer(neighbor);
                    parent[neighbor] = curr_node;
                    vis[neighbor] = true;
                }
                else{
                    if(neighbor != parent[curr_node]) return true;
                }
            }
        }
        return false;
    }


    public static boolean isCyclicDfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        if(n == 0) return false;
        boolean[] vis = new boolean[n];
        int[] parents = new int[n];
        Arrays.fill(parents, -2);
        for(int i = 0 ; i < n ; i++){
            if(!vis[i] && isCyclicDfs(adj, i, -1, vis, parents)) return true;
        }
        return false;
    }
    public static boolean isCyclicDfs(ArrayList<ArrayList<Integer>> adj, int curr, int parent, boolean[] vis, int[] parents) {
        if(vis[curr]) return true;
        vis[curr] = true;
        for(int neighbor : adj.get(curr)){
            parents[neighbor] = curr;
            if(parents[curr] != neighbor && isCyclicDfs(adj, neighbor, curr, vis, parents)) return true;
        }
        return false;
    }



    // Function to detect cycle in a directed graph.
    public boolean isCyclic2(int V, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean ans = false;
        if(n == 0) return false;
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i] && isCyclic2(adj, i, vis, new ArrayList<>())) return true;
        }
        return false;
    }

    public boolean isCyclic2(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, List<Integer> prev) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis[i] = true;
        while (!q.isEmpty()){
            int curr_node = q.poll();
            prev.add(curr_node);
            for(int neighbor : adj.get(curr_node)){
                if(!vis[neighbor]){
                    q.offer(neighbor);
                    vis[neighbor] = true;
                }
                else if(prev.contains(neighbor)){
                    return true;
                }
            }
        }
        return false;
    }
}
