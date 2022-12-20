package PlacementCompanies;
import java.util.*;

public class Uber {
    public static void main(String[] args) {

    }


    public static long pattern(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(a + " " + b);
        if(a < b){
            a = a^b;
            b = a^b;
            a = a^b;
        }
        System.out.println(a + " " + b);

        int ht;
        for (ht = 0; ; ++ht){
            if((ht * (ht + 1)) / 2 >= a + b){
                if((ht * (ht + 1)) / 2 > a + b) --ht;
                break;
            }
        }
        int[] dp = new int[a+1];
        dp[a] = 1;
        long result = 0;
        for(int h = 1; h <= ht; ++h){
            int[] dp2 = new int[a+1];
            for(int a_left = 0; a_left <= a; ++a_left){ // lefta
                int used_a =  (a - a_left);
                int used_b = (h * (h - 1) / 2) - used_a;
                int left_b = b - used_b;
                if(h <= left_b){
                    dp2[a_left] += dp[a_left];
                }
                if(h <= used_a){
                    dp2[a_left] += dp[a_left + h];
                }
                result += dp2[a_left];
            }
            dp = dp2;
        }
        return result;
    }


    public static long count_pair(int n, ArrayList<ArrayList<Integer>> A){
        Map<Double, Integer> map = new HashMap<>();
        long cnt = 0;
        for(ArrayList<Integer> point : A){
            int x = point.get(0);
            int y = point.get(1);
            double slope = ((double)x)/((double)y);
            if(map.containsKey(slope)){
                cnt += map.get(slope);
                map.replace(slope, map.get(slope)+1);
            }
            else {
                map.put(slope, 1);
            }
        }

        return cnt;
    }
    public static int sol1Opt(long[] a, long[] r){
        int a_sml_idx = 0;
        int r_sml_idx = 0;
        for(int i = 0 ; i < a.length; i++){
            if(a[a_sml_idx] > a[i]) a_sml_idx = i;
            if(r[r_sml_idx] > r[i]) r_sml_idx = i;
        }
        long ans = 0;
        long a_sml = a[a_sml_idx];
        long r_sml = r[r_sml_idx];
        for(int i = 0; i < a.length; i++){
            if(i == a_sml_idx || i == r_sml_idx) continue;
            ans = (ans + Math.min(a[i]*r_sml, a_sml*r[i]))%1000000007;
        }
        if(a_sml_idx != r_sml_idx) ans = (ans + a_sml *r_sml)%1000000007;
        return (int) ans%1000000007;
    }


    public static int sol2Correct(String wall, int k){
        int ans = 1;
        char[] wall_paint = wall.toCharArray();
        for (char c = 'a'; c <= 'z' ; c++){
            ans = Math.max(ans, helper(wall_paint, k, c, wall_paint.length));
        }
        return ans;
    }
    public static int helper(char[] wall_paint, int k, char c, int n){
        int ans = 0, left = 0, right = 0;
        int count = 0;
        while (right < n){
            if(wall_paint[right] != c) count++;
            while (count > k){
                if(wall_paint[left] != c){
                    count--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }




    static void sol3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n;  i++){
            arr[i] = sc.nextInt();
        }
        int[][][][] dp = new int[n+1][p+1][q+1][r+1];
        for(int[][][] in1 : dp){
            for(int[][] in2 : in1){
                for(int[] in3 : in2){
                    Arrays.fill(in3, -1);
                }
            }
        }
        System.out.println(sol3Helper(arr, 0, p, q, r, dp));
    }
    static int sol3Helper(int[] arr, int i, int p, int q, int r, int[][][][] dp) {
        if (i >= arr.length && p == 0 && q == 0 && r == 0) return 0;
        if (i >= arr.length) return -5000000;
        int n = arr.length;
        if(dp[i][p][q][r]!=-1) return dp[i][p][q][r];
        int d1, d2, d3, d4;
        d1 = d2 = d3 = Integer.MIN_VALUE;
        if (p > 0 && n-i>=1) d1 = sol3Helper(arr, i + 1, p - 1, q, r, dp);
        if (q > 0 && n-i>=2) d2 = sol3Helper(arr, i + 2, p, q - 1, r, dp);
        if (r > 0 && n-i>=3) d3 = sol3Helper(arr, i + 3, p, q, r - 1, dp);
        d4 = arr[i] + sol3Helper(arr, i + 1, p, q, r, dp);
        return dp[i][p][q][r] = Math.max(Math.max(d1, d2), Math.max(d3, d4));
    }



    static int sol4(boolean[][] jobs, boolean[][] candidates, int[] profit){
        int[][] graph = new int[jobs.length][candidates.length];
        for (int[] i : graph){
            Arrays.fill(i, -1);
        }
        for(int i = 0 ; i < jobs.length; i++){
            for (int j = 0; j < candidates.length; j++)
                if(canFit(jobs[i], candidates[j]))
                    graph[i][j] = profit[i];
        }
        return maxProfit(graph, 0, new boolean[jobs.length], new boolean[candidates.length]);
    }
    static int maxProfit(int[][] graph, int job_id,  boolean[] jobTaken, boolean[] candidateHired){
        if(job_id >= graph.length) return 0;
        if(jobTaken[job_id]) return 0;

        jobTaken[job_id] = true;
        int maxProfit = 0;

        for(int candidate = 0 ; candidate < graph[job_id].length; candidate++){
            if(graph[job_id][candidate] == -1) continue;
            if(candidateHired[candidate]) continue;
            candidateHired[candidate] = true;
            maxProfit = Math.max(maxProfit, graph[job_id][candidate] + maxProfit(graph, job_id+1, jobTaken, candidateHired));
            candidateHired[candidate] = false;
        }
        jobTaken[job_id] = false;
        return maxProfit;
    }
    static boolean canFit(boolean[] job, boolean[] candidate){
        for(int i = 0 ; i < job.length; i++){
            if(job[i] && !candidate[i]) return false;
        }
        return true;
    }
}
