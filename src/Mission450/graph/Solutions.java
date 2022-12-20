package Mission450.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solutions {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<ArrayList<Vertex>> directedGraph = new ArrayList<>();
        ArrayList<ArrayList<Vertex>> unDirectedGraph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> unWDirected = new ArrayList<>();
        File file = new File("C:\\Users\\rjskg\\IdeaProjects\\Java-Code\\src\\Mission450\\graph\\input.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
        int e = sc.nextInt();
        for(int i = 0; i < n; i++){
            directedGraph.add(new ArrayList<>());
            unDirectedGraph.add(new ArrayList<>());
            unWDirected.add(new ArrayList<>());
        }
        for(int i = 0 ; i < e ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            directedGraph.get(start).add(new Vertex(end, weight));
            unDirectedGraph.get(start).add(new Vertex(end, weight));
            unDirectedGraph.get(end).add(new Vertex(start, weight));
            unWDirected.get(start).add(end);
        }


        completeJob(unWDirected, n);
        //System.out.println(directedGraph);
        System.out.println(Arrays.toString(shortestPathDag(directedGraph, n, 1)));
        System.out.println(Arrays.toString(shortestDistDijkstra(unDirectedGraph, n, 0)));
    }
    public static int[] shortestPathDag(ArrayList<ArrayList<Vertex>> graph, int n, int src){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[] vis = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n; i++){
            if(!vis[i]) TopologicalSort(graph, stack, vis, i);
        }
        while (!stack.empty()){
            int top = stack.pop();
            if(dist[top] == Integer.MAX_VALUE) continue;
            ArrayList<Vertex> neighbors = graph.get(top);
            for(Vertex neighbor : neighbors){
                int next = neighbor.data;
                int cost = neighbor.weight;
                if(dist[top] + cost < dist[next]) dist[next] = dist[top] + cost;
            }
        }
        return dist;
    }
    public static void TopologicalSort(ArrayList<ArrayList<Vertex>> graph, Stack<Integer> stack, boolean[] vis, int i){
        if(vis[i]) return;
        vis[i] = true;
        ArrayList<Vertex> neighbors = graph.get(i); // i == parent
        for(Vertex neighbor : neighbors){
            int ind = neighbor.data;
            TopologicalSort(graph, stack, vis, ind);
        }
        stack.push(i);
    }


    public static int[] shortestDistDijkstra(ArrayList<ArrayList<Vertex>> und_graph, int n, int src){
        PriorityQueue<Vertex> pq = new PriorityQueue<>(n, Comparator.comparingInt(o -> o.weight));
        int[] dist = new int[n];
        for (int i = 0; i <n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        pq.offer(new Vertex(src, 0));

        while (!pq.isEmpty()){
            Vertex parent = pq.poll();
            ArrayList<Vertex> children = und_graph.get(parent.data);
            for (Vertex child : children){
                if(dist[parent.data] + child.weight < dist[child.data]){
                    dist[child.data] = dist[parent.data] + child.weight;
                    pq.offer(child);
                }
            }
        }
        return dist;
    }

    static class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.b));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        pq.add(new Pair(S, 0));
        while(!pq.isEmpty()){
            Pair parent = pq.poll();
            ArrayList<ArrayList<Integer>> neighbors = adj.get(parent.a);
            for(ArrayList<Integer> neighbor : neighbors){
                int child = neighbor.get(0);
                int cost = neighbor.get(1);
                if(dist[parent.a] + cost < dist[child]){
                    dist[child] = dist[parent.a] + cost;
                    pq.offer(new Pair(child, cost));
                }
            }
        }
        return dist;
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
        int xPar = findPathComp(parents, x);
        int yPar = findPathComp(parents, y);
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

    int[] moves = {1, 2, 3, 4, 5, 6};
    public int snakesAndLadders(int[][] board, int i, int n, HashSet<Integer> snake) {
        if(i == (n*n)-1) return 0;
        if(i >= (n*n)) return -1;
        int min = 100000;
        for(int move : moves){
            int next = i + move;
            int r = n - 1 - next/n;
            int c = next%n;
            if(next >= (n*n)) continue;
            if(board[r][c] == -1){
                //nothing
                min = Math.min(min, 1 + snakesAndLadders(board, i+move, n, snake));
            }
            else if (board[r][c] < next){
                //it's a ladder
                min = Math.min(min, 1 + snakesAndLadders(board, board[r][c], n, snake));
            }
            else{
                //oh my god, It's snake
                if(!snake.add(next)) continue;
                min = Math.min(min, 1 + snakesAndLadders(board, board[r][c], n, snake));
            }
        }

        if(min == 100000) return -1;
        return min;
    }


    // https://www.geeksforgeeks.org/minimum-time-taken-by-each-job-to-be-completed-given-by-a-directed-acyclic-graph/
    static void completeJob(ArrayList<ArrayList<Integer>> graph, int n){
        int[] inDegree = new int[n];
        int[] time = new int[n];
        for(int i = 0 ; i < n; i++){
            for (int el : graph.get(i)){
                inDegree[el]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(inDegree[i] == 0) {
                q.offer(i);
                time[i] = 1;
            }
        }

        while (!q.isEmpty()){
            int parent = q.poll();

            for(int neighbor : graph.get(parent)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    time[neighbor] = time[parent] + 1;
                    q.offer(neighbor);
                }
            }
        }
        System.out.println(Arrays.toString(time));
    }


    //Prim's algo //https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTreePrim(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[] vis = new boolean[V];
        int[] weight = new int[V];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        for(int i = 0 ; i < V; i++){
            int min = Integer.MAX_VALUE;
            int ind = 0;
            for(int j = 0 ; j < V; j++){
                if(!vis[j] && weight[j] < min){
                    ind = j;
                    min = weight[j];
                }
            }
            vis[ind] = true;
            ArrayList<ArrayList<Integer>> neighbors = adj.get(ind);
            for(ArrayList<Integer> neighbor : neighbors){
                int node = neighbor.get(0);
                int w = neighbor.get(1);
                if(!vis[node] && w < weight[node]){
                    weight[node] = w;
                }
            }
        }
        int ans = 0;
        for(int i : weight) ans += i;
        return ans;
    }


    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTreeKrukshal(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Add your code here //krushkal's algo
        int[] parents = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parents[i] = i;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ArrayList<ArrayList<Integer>> neighbors = adj.get(i);
            for (ArrayList<Integer> neighbor : neighbors) {
                int j = neighbor.get(0);
                int w = neighbor.get(1);
                if (i < j) edges.add(new ArrayList<>(List.of(i, j, w)));
            }
        }
        int ans = 0;
        edges.sort(Comparator.comparingInt(o -> o.get(2)));
        for (ArrayList<Integer> edge : edges) {
            int x = edge.get(0);
            int y = edge.get(1);
            int w = edge.get(2);
            int xPar = findPathComp(parents, x);
            int yPar = findPathComp(parents, y);
            if (xPar == yPar) continue;
            unionByRank(parents, rank, x, y);
            ans += w;
        }
        return ans;
    }
}
