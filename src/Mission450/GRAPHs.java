package Mission450;

import java.util.Arrays;
import java.util.*;

/**
 * https://www.oriient.me/
 * Graph : directed and undirected
 * <p>
 * degree of a node = number of edge connected to a node (undirected graph)
 * <p>
 * indegree = number of edge coming towards that node
 * outdegree = number of edge going from that node
 * <p>
 * weighted graph
 * <p>
 * Graph
 * /   \
 * adjacency matrix     Adjacency list
 * <p>
 * Adjacency Matrix
 * n = number of nodes (4 let say)
 * <p>
 * 2d array
 * 0  1   2   3
 * 1 [ ] [ ] [ ]
 * 2 [ ] [ ] [ ]
 * 3 [ ] [ ] [ ]
 * where matrix(i,j) == 1 if there's path from ith node to jth node
 * 0, otherwise
 * <p>
 * Adjacency List
 * 0 -> List0
 * 1 -> List1
 * .    . . .
 * .    . . .
 * n -> Listn
 * <p>
 * where (0, 1, ... , n) is the nodes and list associated with them represent all connected nodes
 * eg
 * (0) ----------- (1)
 * |               | \
 * |               |  (2)
 * |               | /
 * (4) ----------- (3)
 * 0 -> {1, 4}
 * 1 -> {0, 2, 3}
 * 2 -> {1, 3}
 * 3 -> {1, 2, 4}
 * 4 -> {0, 3}
 * <p>
 * Map<Integer, List<Integer>> graph
 */

// Graph class
class Graph<T> {
    Map<T, List<T>> graph;

    Graph() {
        graph = new HashMap<>();
    }

    public void addEdge(T a, T b, boolean isDirected) {
        if (graph.containsKey(a)) graph.get(a).add(b);
        else graph.put(a, new ArrayList<>(List.of(b)));

        if (!isDirected) {
            if (graph.containsKey(b)) graph.get(b).add(a);
            else graph.put(b, new ArrayList<>(List.of(a)));
        }
    }

    public void print() {
        for (Map.Entry<T, List<T>> e : graph.entrySet()) {
            System.out.print(e.getKey() + " -> ");
            for (T node : e.getValue()) {
                System.out.print(node + ", ");
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

        int[] parents = {0,1,2,3,4,5,6};
        int[] rank = new int[parents.length];
        unionByRank(parents, rank, 1,4);
        unionByRank(parents, rank, 6,1);
        unionByRank(parents, rank, 5, 3);
        unionByRank(parents, rank, 0, 5);
        System.out.println(findPathComp(parents, 0));
        System.out.println(findPathComp(parents, 3));
        System.out.println(findPathComp(parents, 5));


        Scanner sc1 = new Scanner(System.in);
        int N = sc1.nextInt();
        int K = sc1.nextInt();
        String dict[] = new String[N];
        for (int i = 0 ; i < N; i++){
            dict[i] = sc1.next();
        }
        System.out.println(findOrder(dict, N, K));

        System.out.println(ladderLength("hit", "cog", new ArrayList<>(List.of("hot","dot","dog","lot","log")))) ;

        bfs(6, new Pair(4,5), new Pair(1,1), new boolean[7][7]);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(2)));
        adj.add(new ArrayList<>(List.of(1, 3)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(isCyclicDfs(adj));


        Scanner sc = new Scanner(System.in);
        //undirected graph
        Graph<Integer> graph = new Graph<>();

        System.out.println("Enter number of edges");
        int m = sc.nextInt();

        System.out.println("Enter edges");
        for (int i = 0; i < m; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt(), false);
        }

        graph.print();
        System.out.println(graph);
    }

    /**
     * Function to return Breadth First Traversal of given graph.
     *
     * @param adj = graph
     * @return List of values by traversing
     */
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 0) return ans;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) bfsOfGraph(adj, i, ans, vis);
        }
        return ans;
    }

    public void bfsOfGraph(ArrayList<ArrayList<Integer>> adj, int i, ArrayList<Integer> ans, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis[i] = true;
        while (!q.isEmpty()) {
            int curr_node = q.poll();
            ans.add(curr_node);
            for (int neighbor : adj.get(curr_node)) {
                if (!vis[neighbor]) {
                    q.offer(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
    }


    /**
     * Function to return Depth First Traversal of given graph.
     *
     * @param adj = graph
     * @return List of values by traversing
     */
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 0) return ans;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfsOfGraph(adj, i, ans, vis);
        }
        return ans;
    }

    public void dfsOfGraph(ArrayList<ArrayList<Integer>> adj, int i, ArrayList<Integer> ans, boolean[] vis) {
        if (vis[i]) return;
        vis[i] = true;
        ans.add(i);
        for (int neighbour : adj.get(i)) {
            dfsOfGraph(adj, neighbour, ans, vis);
        }
    }

    /**
     * Function to check if graph is Cyclic using bfs.
     *
     * @param adj = graph
     * @return true if there is cycle in graph
     */
    public boolean isCyclicBfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        boolean ans = false;
        if (n == 0) return false;
        boolean[] vis = new boolean[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) ans = ans || isCyclicBfs(adj, i, vis, parent);
        }
        return ans;
    }

    public boolean isCyclicBfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        parent[i] = -1;
        vis[i] = true;
        while (!q.isEmpty()) {
            int curr_node = q.poll();
            //ans.add(curr_node);
            for (int neighbor : adj.get(curr_node)) {
                if (!vis[neighbor]) {
                    q.offer(neighbor);
                    parent[neighbor] = curr_node;
                    vis[neighbor] = true;
                } else {
                    if (neighbor != parent[curr_node]) return true;
                }
            }
        }
        return false;
    }


    public static boolean isCyclicDfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        if (n == 0) return false;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i] && isCyclicDfs(adj, i, -1, vis)) return true;
        }
        return false;
    }

    //imp
    public static boolean isCyclicDfs(ArrayList<ArrayList<Integer>> adj, int curr, int parent, boolean[] vis) {
        vis[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!vis[neighbor]) {
                boolean cycleDetected = isCyclicDfs(adj, neighbor, curr, vis);
                if (cycleDetected) return true;
            } else if (neighbor != parent) return true;
        }
        return false;
    }


    // Function to detect cycle in a directed graph.
    public boolean isCyclicDfsDirected(int n, ArrayList<ArrayList<Integer>> adj) {
        if (n == 0) return false;
        boolean[] vis = new boolean[n];

        /**
         * dfsVis will store all the prev visited nodes, will turn itself false while returning
         */
        boolean[] dfSVis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i] && isCyclicDfsDirected(adj, vis, i, dfSVis)) return true;
        }
        return false;
    }

    public boolean isCyclicDfsDirected(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i, boolean[] dfsVis) {
        if (dfsVis[i]) return true;
        else if (vis[i]) {
            return false;
        }
        vis[i] = true;
        dfsVis[i] = true;
        for (int neighbor : adj.get(i)) {
            if (isCyclicDfsDirected(adj, vis, neighbor, dfsVis)) {
                return true;
            }
        }
        dfsVis[i] = false;
        return false;
    }


    public boolean isCyclic2(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, List<Integer> prev) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis[i] = true;
        while (!q.isEmpty()) {
            int curr_node = q.poll();
            prev.add(curr_node);
            for (int neighbor : adj.get(curr_node)) {
                if (!vis[neighbor]) {
                    q.offer(neighbor);
                    vis[neighbor] = true;
                } else if (prev.contains(neighbor)) {
                    return true;
                }
            }
        }
        return false;
    }

    // rat in maze - 1
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        findPath(m, n, 0, 0, ans, new boolean[n][n], "");
        return ans;
    }
    public static void findPath(int[][] m, int n, int i, int j, ArrayList<String> arr, boolean[][] vis, String curr) {
        if(n == 0) return;
        if(i < 0 || i >= n || j < 0 ||  j >= n) return;
        if(m[i][j] == 0) return;
        if(vis[i][j]) return;
        if(i == n-1 && j == n-1){
            arr.add(curr);
        }
        vis[i][j] = true;
        findPath(m, n, i, j+1, arr, vis, curr+"R");
        findPath(m, n, i, j-1, arr, vis, curr+"L");
        findPath(m, n, i-1, j, arr, vis, curr+"U");
        findPath(m, n, i+1, j, arr, vis, curr+"D");
        vis[i][j] = false;
    }

    //Function to find out minimum steps Knight needs to reach target position.
    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N){
        return bfs(N, new Pair(KnightPos[0], KnightPos[1]), new Pair(TargetPos[0], TargetPos[1]), new boolean[N+1][N+1]);
    }
    static class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static int bfs(int n, Pair knight, Pair target, boolean[][] vis){
        int count  = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(knight);
        while (!q.isEmpty()){
            Pair currPos = q.poll();
            if(knight.a == target.a && knight.b == target.b) return count;

            int a = currPos.a;
            int b = currPos.b;
            vis[a][b] = true;
            if(a + 2 <= n && b + 1 <= n && !vis[a+2][b+1]) q.offer(new Pair(a+2, b+1));
            if(a + 2 <= n && b - 1 > 0 && !vis[a+2][b-1]) q.offer(new Pair(a+2, b-1));
            if(a - 2 > 0 && b + 1 <= n && !vis[a-2][b+1]) q.offer(new Pair(a-2, b+1));
            if(a - 2 > 0 && b - 1 > 0 && !vis[a-2][b-1]) q.offer(new Pair(a-2, b-1));
            if(a + 1 <= n && b + 2 <= n && !vis[a+1][b+2]) q.offer(new Pair(a+1, b+2));
            if(a + 1 <= n && b - 2 > 0 && !vis[a+1][b-2]) q.offer(new Pair(a+1, b-2));
            if(a - 1 > 0 && b + 2 <= n && !vis[a-1][b+2]) q.offer(new Pair(a-1, b+2));
            if(a - 1 > 0 && b - 2 > 0 && !vis[a-1][b-2]) q.offer(new Pair(a-1, b-2));
            count ++;
        }
        return -1;
    }
//    public static int bfs(int n, int si, int sj, int ti, int tj, int[][] vis){
//        int count = 0;
//        Queue<Integer> qi = new LinkedList<>();
//        Queue<Integer> qj = new LinkedList<>();
//        qi.offer(si);
//        qj.offer(sj);
//        vis[si][sj] = 0;
//        while (!qi.isEmpty()){
//            int i = qi.poll();
//            int j = qj.poll();
//            int curr = vis[i][j];
//
//            if(i + 2 <= n && j + 1 <= n && vis[i+2][j+1] != -1){
//                vis[i+2][j+1] = curr+1;
//            }
//            if(i + 2 <= n && j - 1 > 0 && vis[i+2][j-1] != -1) {
//                vis[i+2][j-1] = curr+1;
//                qi.offer()
//            }
//            if(i - 2 > 0 && j + 1 <= n && vis[i-2][j+1] != -1) {
//                vis[i-2][j+1] = curr+1;
//                qi.offer()
//            }
//            if(i - 2 > 0 && j - 1 > 0 && vis[i-2][j-1] != -1) {
//                vis[i-2][j-1] = curr+1;
//                qi.offer()
//            }
//            if(i + 1 <= n && j + 2 <= n && vis[i+1][j+2] != -1) {
//                vis[i+1][j+2] = curr+1;
//                qi.offer()
//            }
//            if(i + 1 <= n && j - 2 > 0 && vis[i+1][j-2] != -1) {
//                vis[i+1][j-2] = curr+1;
//                qi.offer()
//            }
//            if(i - 1 > 0 && j + 2 <= n && vis[i-1][j+2] != -1) {
//                vis[i-1][j+2] = curr+1;
//                qi.offer()
//            }
//            if(i - 1 > 0 && j - 2 > 0 && vis[i-1][j-2] != -1) {
//                vis[i-1][j-2] = curr+1;
//                qi.offer()
//            }
//
//        }
//    }



    //Function to find out minimum steps Knight needs to reach target position.
    public static int minStepToReachTargetBFS(int[] KnightPos, int[] TargetPos, int N){
        return bfs(N, new Pair(KnightPos[0]-1, KnightPos[1]-1), new Pair(TargetPos[0]-1, TargetPos[1]-1));
    }
    public static int bfs(int n, Pair knight, Pair target){

        // if source and destination is same then return 0
        if(knight.a == target.a && knight.b == target.b) return 0;

        // boolean array to keep record is any vertex is visited
        boolean[][] isVisited = new boolean[n][n];

        // it keeps record of distance of any vertex with the source
        // initially all entries are zero
        int[][] distances = new int[n][n];

        int[][] moves = {
                {2, 1},
                {2, -1},
                {-2, 1},
                {-2, -1},
                {1, 2},
                {1,-2},
                {-1, 2},
                {-1, -2}
        };

        Queue<Pair> q = new LinkedList<>();
        q.add(knight);
        isVisited[knight.a][knight.b] = true;
        while(!q.isEmpty()){
            Pair parent = q.remove();
            for(int[] move : moves){
                Pair neighbor = new Pair(parent.a + move[0], parent.b + move[1]);
                if(neighbor.a >= 0 &&
                        neighbor.a < n &&
                        neighbor.b>=0 &&
                        neighbor.b < n &&
                        !isVisited[neighbor.a][neighbor.b]){

                    q.add(neighbor);
                    isVisited[neighbor.a][neighbor.b] = true;

                    //updating distance as distance of parent+1;
                    //when parent is source itself then distance = 0 and keep increasing by 1 on every cycle
                    distances[neighbor.a][neighbor.b] = distances[parent.a][parent.b]+1;
                }
                if(neighbor.a == target.a && neighbor.b == target.b) return distances[neighbor.a][neighbor.b];
            }
        }
        return -1;
    }



    // wired connection // row 365
    public int makeConnected(int n, int[][] connections) {
        int wires = connections.length;
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] connection : connections){
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        int components = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n ; i++){
            if(!vis[i]){
                components++;
                dfs(graph, vis, i);
            }
        }
        if(wires >= n-1){
            return components - 1;
        }
        return -1;
    }
    public void dfs(Map<Integer, ArrayList<Integer>> graph, boolean[] vis, int i){
        if(vis[i]) return;
        vis[i] = true;
        for (int neighbour : graph.get(i)) {
            dfs(graph, vis, neighbour);
        }
    }


    static public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String, HashSet<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        wordList.add(endWord);
        for(String word : wordList){
            graph.put(word, new HashSet<>());
        }
        for(String parent : wordList){
            for(String neighbor : wordList){
                if(isNeighbor(parent, neighbor)) graph.get(parent).add(neighbor);
            }
        }
        System.out.println(graph);
        return shortest_path(beginWord, endWord, graph);

    }

    static boolean isNeighbor(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return false;
        boolean isDiffered = false;
        for(int i = 0; i < s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(!isDiffered) isDiffered = true;
                else return false;
            }
        }
        return true;
    }

    static int shortest_path(String src, String dest, Map<String, HashSet<String>> graph){
        if(src.equals(dest)) return 1;
        Map<String, Boolean> vis = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        dist.put(src, 1);
        Queue<String> q = new LinkedList<>();
        q.offer(src);
        vis.put(src, true);

        while (!q.isEmpty()){
            String parent = q.poll();
            HashSet<String> neighbors = graph.get(parent);
            for(String neighbor : neighbors){
                if(!vis.containsKey(neighbor)) {
                    q.offer(neighbor);
                    vis.put(neighbor, true);
                    dist.put(neighbor, dist.get(parent) + 1);
                }
                if(neighbor.equals(dest)) {
                    System.out.println(dist);
                    return dist.get(dest);
                }
            }
        }
        return -1;
    }


    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Pair2 implements Comparable<Pair2>{
        int src;
        int wt;
        public Pair2(int src, int wt){
            this.src = src;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair2 o) {
            return this.wt - o.wt;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Pair2> pq = new PriorityQueue<>();
        pq.add(new Pair2(S, 0));
        distance[S] = 0;
        while(!pq.isEmpty()){
            Pair2 node = pq.poll();
            int curr_node = node.src;
            int dist_from_src = node.wt;
            ArrayList<ArrayList<Integer>> neighbors = adj.get(curr_node);
            for(ArrayList<Integer> neighbor : neighbors){
                int destination = neighbor.get(0);
                int costToReach = neighbor.get(1);
                if(dist_from_src + costToReach < distance[destination]){
                    distance[destination] = dist_from_src + costToReach;
                    pq.add(new Pair2(destination, dist_from_src + costToReach));
                }
            }
        }
        return distance;
    }



    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] ans = new int[V];
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]) topoSort(V, adj, st, i, vis);
        }
        for(int i = 0 ; i < V; i++){
            ans[i] = st.pop();
        }
        return ans;
    }
    static void topoSort(int V, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int i, boolean[] vis){
        if(i >= adj.size()) return;
        if(vis[i]) return;

        vis[i] = true;
        ArrayList<Integer> neighbors = adj.get(i);
        for(int neighbor : neighbors){
            topoSort(V, adj, st, neighbor, vis);
        }
        st.push(i);
    }



    //Function to return list containing vertices in Topological order.
    static int[] topoSort2(int V, ArrayList<ArrayList<Integer>> adj){
        int[] ans = new int[V];
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                ans[i] = 1;
                topoSort2(V, adj, ans, i, vis);
            }
        }
        return ans;
    }
    static void topoSort2(int V, ArrayList<ArrayList<Integer>> adj, int[] ans, int i, boolean[] vis){
        if(i >= adj.size()) return;
        if(vis[i]) return;
        vis[i] = true;
        ArrayList<Integer> neighbors = adj.get(i);
        for(int neighbor : neighbors){
            ans[neighbor] = ans[i] + 1;
            topoSort2(V, adj, ans, neighbor, vis);
        }
    }



    public boolean isPossible(int N, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] course : prerequisites){
            graph.get(course[0]).add(course[1]);
        }
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(topoSort2(N, graph, i, vis, new boolean[N])) return false;
        }
        return true;
    }
    static boolean topoSort2(int N, ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, boolean[] dfsVis){
        if(dfsVis[i]) return true;
        if(vis[i]) return false;
        vis[i] = true;
        dfsVis[i] = true;
        ArrayList<Integer> neighbors = adj.get(i);
        for(int neighbor : neighbors){
            if(topoSort2(N, adj, neighbor, vis, dfsVis)){
                return true;
            }
        }
        dfsVis[i] = false;
        return false;
    }




    //Hamiltonian Path
    //Qs: https://practice.geeksforgeeks.org/problems/hamiltonian-path2522/1
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> Edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(ArrayList<Integer> edge: Edges){
            adj.get(edge.get(0)-1).add(edge.get(1)-1);
            adj.get(edge.get(1)-1).add(edge.get(0)-1);
        }
        for(int i = 0 ; i < n ; i++){
            if(helper(n, adj, i, 0, new boolean[n], 0)) return true;
        }
        return false;
    }
    boolean helper(int n, ArrayList<ArrayList<Integer>> adj, int i, int st, boolean[] vis, int count){
        if(count == n) return true;
        if(vis[i]) return false;
        vis[i] = true;
        ArrayList<Integer> neighbors = adj.get(i);
        for(int neighbor : neighbors){
            if(helper(n, adj, neighbor, st, vis, count+1)) return true;
        }
        vis[i] = false;
        return false;
    }




    // Function to find the number of islands.
    // Qs: https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    numIslands(n, m, grid, i, j, vis);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void numIslands(int n, int m, char[][] grid, int i , int j, boolean[][] vis) {
        if(i<0 || i >=n || j<0 || j>=m) return;
        if(grid[i][j] == '0') return;
        if(vis[i][j]) return;
        vis[i][j] = true;
        int[][] moves = {{-1,-1}, {-1,1}, {1, -1}, {1, 1}, {0,1}, {0,-1}, {-1,0}, {1, 0}};
        for(int[] move : moves){
            numIslands(n, m, grid, i+move[0], j + move[1], vis);
        }
    }



    public static String findOrder(String [] dict, int N, int K){
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < K; i++){
            adj.add(new HashSet<>());
        }
        for(int i = 0 ; i < dict.length-1; i++) {
            char[] curr = dict[i].toCharArray();
            char[] next = dict[i + 1].toCharArray();
            for (int j = 0; j < Math.min(curr.length, next.length); j++) {
                if (curr[j] == next[j]) continue;
                adj.get(curr[j] - 'a').add(next[j] - 'a');
                break;
            }
        }
        boolean[] vis = new boolean[K];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < K; i++){
            helper(adj, st, i, vis);
        }
        String ans = "";
        while (!st.empty()) ans = ans + (char)('a' + st.pop());
        return ans;
    }
    // using topological sort
    public static void helper(ArrayList<HashSet<Integer>> adj, Stack<Integer> st, int i, boolean[] vis){
        if(vis[i]) return;
        vis[i] = true;
        HashSet<Integer> neighbors = adj.get(i);
        for(int neighbor : neighbors) {
            helper(adj, st, neighbor, vis);
        }
        st.push(i);
    }


    /**
     * Union find & Disjoint set
     */
    public static int find(int[] parents, int x){
        if(parents[x] == x) return x;
        return find(parents, parents[x]);
    }
    public static int findPathComp(int[] parents, int x){
        if(parents[x] == x) return x;
        return parents[x] = findPathComp(parents, parents[x]);
    }
    public static void union(int[] parents, int x, int y){
        int xPar = find(parents, x);
        int yPar = find(parents, y);

        if(xPar == yPar) return;
        parents[xPar] = yPar;
    }
    public static void unionByRank(int[] parents, int[] rank, int x, int y){
        int xPar = find(parents, x);
        int yPar = find(parents, y);

        if(xPar == yPar) return;

        if(rank[xPar] == rank[yPar]){
            parents[xPar] = yPar;
            rank[yPar]++;
            return;
        }
        if(rank[xPar] < rank[yPar]){
            parents[xPar] = yPar;
            return;
        }
        parents[yPar] = xPar;
    }

}
