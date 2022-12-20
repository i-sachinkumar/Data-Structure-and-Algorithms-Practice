package PlacementCompanies;

import java.lang.management.MemoryType;
import java.util.*;

public class Navi {
    public static void main(String[] args) {
        System.out.println(cleanVillage(10, 6,  new int[]{0, -12,4,-13,5, 6,-1, 10, 12, 11}));

        System.out.println(cleanVillage2(10, 6,  new int[]{0, -12,4,-13,5, 6,-1, 10, 12, 11}));

        System.out.println(cruelBoss(6));
        System.out.println(cruelBoss2(6));
        //System.out.println(cruelBossIdenticalFile(15));
        System.out.println(encode("HELLO"));
        System.out.println(stockProfit(6, new int[]{10, 22, 5, 75, 65, 80}, 2));
        System.out.println(vigilRange(4, new int[]{0,4,4,6}, 15));

        maximumUnionSet();
    }

    public static int cleanVillage(int m, int n, int[] location){
        if(m < n) n = m;
        Arrays.sort(location);
        int vinnie_home = Arrays.binarySearch(location, 0);
        int i = vinnie_home;
        int j = vinnie_home;
        if(i > 0) i--;
        if(j < m-1) j++;
        int cost = 0;
        while (n-- > 0) {
            if (i < 0 || location[j] < (-location[i])) {
                cost += location[j];
                j++;
                continue;
            }
            cost += (-location[i]);
            i--;
        }
        return cost;
    }

    public static int cleanVillage2(int m, int n, int[] location){
        for(int i = 0 ; i < m ; i++){
            location[i] = Math.abs(location[i]);
        }
        Arrays.sort(location);
        int cost = 0;
        for(int i = 1; i <= Math.min(m, n); i++) {
            cost += (location[i]);
        }
        return cost;
    }

    static int cruelBoss(int n){
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4 ; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-3];
        }

        return dp[n];
    }
    static int cruelBoss2(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(n == 3) return 2;

        //bundle 1;
        int op1 = cruelBoss2(n-1);

        //bundle 3
        int op2 = cruelBoss2(n-3);

        return op1 + op2;
    }

    static int cruelBossIdenticalFile(int n){
        return (n/3) + 1;
    }

    static String encode(String s){
        char[] word = s.toCharArray(); //HELLO
        int ind = 0;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();
        for(char c : word){
            if(map.containsKey(c)) sb.append(map.get(c));
            else{
                sb.append((char)('A' + ind));
                map.put(c, (char)('A' + ind));
                ind++;
            }
        }
        return sb.toString(); //ABCCD
    }

    static int stockProfit(int n, int[] arr, int k){
        int profit = 0;
        int buy_price = arr[0];
        int sell_price = arr[0];
        for (int i = 1 ; i < n ; i++){
            if(arr[i] >= sell_price){
                sell_price = arr[i];
            }
            else {
                profit += (k*(sell_price-buy_price));
                buy_price = arr[i];
                sell_price = buy_price;
            }
        }
        profit += (k*(sell_price-buy_price));
        return profit;
    }

    static int vigilRange(int n, int[] arr, int l){
        Arrays.sort(arr);
        int ans = Math.max(arr[0], l - arr[n-1]);
        for(int i = 0; i < n-1; i++){
            int dist = arr[i+1] - arr[i];
            int rad;
            if(dist%2 == 0) rad = dist/2;
            else rad = (dist+1)/2;
            ans = Math.max(ans, rad);
        }
        return ans;
    }

    static void maximumUnionSet() {
        System.out.println("union wala");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parent = new int[n];
        for(int i = 0; i < n ; i++) parent[i] = i;
        int[][] friendships = new int[n - 1][2];
        for (int i = 0; i < n-1; i++) friendships[i][0] = sc.nextInt() - 1;
        for (int i = 0; i < n-1; i++) friendships[i][1] = sc.nextInt() - 1;
        for (int[] friendship : friendships) {
            int a = friendship[0];
            int b = friendship[1];
            if(parent[a] != a || a == 0) parent[b] = a;
            else parent[a] = b;
        }
        System.out.println(Arrays.toString(parent));
        int query = sc.nextInt();
        int max = 0;
        while (query-- > 0){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            if(parent[a] == b) parent[a] = a;
            else if(parent[b] == a) parent[b] = b;
            else{
                System.out.println("max: " + max);
                continue;
            }
            max = 0;
            System.out.println(Arrays.toString(parent));
            int[] size = new int[n];
            for(int i = 0; i < n ; i++){
                int lead = find2(parent, i);
                size[lead]++;
                System.out.println("size_lead: " + lead + " -> " + size[lead]);
                max = Math.max(max, size[lead]);
            }
            System.out.println("max: " + max);
        }
        sc.close();
    }
    static int find2(int[] parent, int x){
        if(parent[x] == x) return x;
        return find2(parent, parent[x]);
    }
    static int maximumUnion(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int[] parent = new int[n];
        int[][] friendships = new int[n-1][2];
        for(int i = 1 ; i < n; i++) friendships[i][0] = sc.nextInt()-1;
        for(int i = 1 ; i < n; i++) friendships[i][1] = sc.nextInt()-1;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] friendship : friendships){
            int a = friendship[0];
            int b = friendship[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int max = 0;
        int query = sc.nextInt();
        while (query-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
        }
        return 0;
    }

    static int find(int[] parents, int x){
        if(parents[x] == x) return x;
        return find(parents, parents[x]);
    }
    static void union(int[] parent, int x, int y){
        int xPar = find(parent, x);
        int yPar = find(parent, y);
        if(xPar == yPar) return;
        parent[xPar] = yPar;
    }

    boolean isSubstitutionCipher(String s1, String s2){
        ArrayList<Integer> c1 = new ArrayList<>();
        ArrayList<Integer> c2 = new ArrayList<>();
        char[] s1chars = s1.toCharArray();
        char[] s2chars = s2.toCharArray();
        for (char s1char : s1chars) {
            c1.add(count(s1chars, s1char));
        }
        for (char s2char : s2chars) {
            c2.add(count(s2chars, s2char));
        }

        for (int i = 0 ; i < c1.size(); i++){
            if(count(c1, c1.get(i)) != count(c2, c1.get(i))) return false;
        }
        return true;
    }
    int count(char[] s, char c){
        int count = 0;
        for (int i = 0 ;i < s.length ; i++){
            if(c == s[i]) count++;
        }
        return count;
    }
    int count(ArrayList<Integer> arr, int el){
        int count = 0;
        for (int e : arr){
            if(e == el) count++;
        }
        return count;
    }


}
