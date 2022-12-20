package PlacementCompanies;

import java.util.*;

public class SAP {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(q1("bbac", 1)));
        System.out.println(q2(4, new int[]{2,4,6,5}));
    }

    public static int[] q1(String s, int d){
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        int[] ans = new int[chars.length];
        for(int i = chars.length-1; i>=0; i--){
            char c = chars[i];
            int cnt = 0;
            int ind = c - 'a';
            for(int j = ind - d; j <= ind + d; j++){
                if(j < 0 || j >= chars.length) continue;
                cnt += freq[j];
            }
            freq[ind]++;
            ans[i] = cnt;
        }
        return ans;
    }

    public static int q2(int n, int[] f){
        boolean[] prime = new boolean[100000];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 2 ; i <= Math.sqrt(100000); i++){
            if(prime[i]){
                for(int j = 0; j < n; j++) {
                    int el = f[j];
                    if (el % i == 0) {
                        if (map.containsKey(i)) map.get(i).add(j);
                        else map.put(i, new ArrayList<>(List.of(j)));
                    }
                }
                for(int j = i*2 ; j < 100000 ; j = j+i)
                    prime[j] = false;
            }
        }
        //System.out.println(map.get(2));
        int[] parents = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n ; i++)
            parents[i] = i;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> group = entry.getValue();
            if(group.size() > 1){
                int p = group.get(0);
                for(int i = 1; i < group.size(); i++){
                    unionByRank(parents, rank, p, group.get(i));
                    //System.out.println(Arrays.toString(parents));
                }
            }
        }

        Set<Integer> parentSet = new HashSet<>();
        for(int p : parents){
            parentSet.add(findPathComp(parents, p));
        }
        return parentSet.size();
    }
    public static int findPathComp(int[] parents, int x){
        if(parents[x] == x) return x;
        return parents[x] = findPathComp(parents, parents[x]);
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
//    public static int gcd(int a, int b){
//        if(a % b == 0) return b;
//        return gcd(a,b)
//    }
//    static boolean[] prime = new boolean[100000];
//    static {
//        prime[0] = false;
//        prime[1] = false;
//
//        for(int i = 2 ; i <= Math.sqrt(100000); i++){
//            if(prime[i]){
//
//            }
//        }
//    }

//    public static int q3(int n, int x, int[] arr){
//        Queue<Integer> q = new PriorityQueue<>();
//        int cnt = 0;
//        for(int el : arr) q.add(el);
//
//        while (q.size() >= n){
//            int sm = q.peek();
//        }
//    }
}
