package Hackerrank.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestReach {
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        List<List<Integer>> edges = new ArrayList<>(2);
        edges.add(List.of(1,2));
        edges.add(List.of(1, 3));

        int s = 1;
        List<Integer> distances = bfs(n,m,edges,s);
        System.out.println(distances);
    }

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m; i++){
            graph.get(edges.get(i).get(0)-1).add(edges.get(i).get(1)-1);
            graph.get(edges.get(i).get(1)-1).add(edges.get(i).get(0)-1);
        }

        List<Integer> ans = new ArrayList<>(n);
        for(int i = 0 ; i < n; i++){
            ans.add(-1);
        }
        ans.set(s-1, 0);

        shortest_distance(graph, s-1, ans);
        ans.remove(s-1);
        return ans;

    }

    public static void shortest_distance(ArrayList<ArrayList<Integer>> graph, int source, List<Integer> ans){
        boolean[] isVisited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        isVisited[source] = true;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int vert : graph.get(curr)){
                if(!isVisited[vert]){
                    q.add(vert);
                    isVisited[vert] = true;
                    ans.set(vert, ans.get(curr)+6);
                }
            }
        }
    }

}
