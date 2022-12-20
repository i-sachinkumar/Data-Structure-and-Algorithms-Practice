package Mission450;

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.*;

public class DP{
    public static void main(String[] args) {

        System.out.println(getSumOpt(1,1,1));
        System.out.println(getSum(1, 1, 1));

        System.out.println(FindMaxSum(new int[]{34, 343, 12, 5543, 233, 444, 543, 236}, 8));

        System.out.println(lcs(6,6,"ABCDGH", "AEDFHR"));
        StringBuilder s = new StringBuilder("abcdefgh");
        s.setCharAt(s.length()-1, 'z');
        System.out.println(s);
        System.out.println(count(new int[]{1,2,3}, 3, 4));
    }

    // Coin Change
    public static long count(int[] coins, int N, int sum) {
        long[][] dp = new long[sum+2][N+2];
        for(int i = 0 ; i <= sum; i++){
            java.util.Arrays.fill(dp[i], -1);
        }
        return count(coins, N, sum, 0, dp);
    }
    public static long count(int[] coins, int N, int sum, int l, long[][] dp) {
        if(sum == 0) return 1;
        if(sum < 0) return 0;
        if(dp[sum][l] != -1) return dp[sum][l];

        long ans = 0;
        for(int coin : coins){
            long op1 = count(coins, N, sum-coin, l, dp);
            long op2 = count(coins, N, sum, l+1, dp);
            ans = op1+op2;
            return dp[sum][l] = ans;
        }
        return dp[sum][l] = ans;
    }

//    public static long canSum(int sum , int[] coins){
//        long[][] dp = new long[sum+1][coins.length];
//        for(int i = 0 ; i < coins.length ; i++){
//            dp[0][i] = 1;
//        }
//
//        for(int i = 0; i < sum+1 ; i++){
//             for (int j = 0 ; j < coins.length ; j++) {
//                    if (i + coins[j] < target + 1) dp[i+num]++;
//                }
//            }
//        }
//        return dp[target];
//    }


    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int[] wt, int[] val, int n)
    {
        int[][] dp = new int[W+2][n+2];
        return knapSack(W, wt, val, n, dp);
    }
    static int knapSack(int W, int[] wt, int[] val, int n, int[][] dp)
    {
        if(n == 0 || W < 0) return 0;
        if(dp[W][n] > 0) return dp[W][n];
        if(W >= wt[n-1]){
            int res = Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1, dp), knapSack(W, wt, val, n-1, dp));
            dp[W][n] = res;
            return res;
        }
        int res = knapSack(W, wt, val, n-1, dp);
        dp[W][n] = res;
        return res;
    }
    static int knapSack(int W, int[] wt, int[] val, int n, int i, int[][] dp)
    {
        if(i == n || W < 0) return 0;
        if(dp[W][i] > 0) return dp[W][i];

        if(W >= wt[i]){
            int res = Math.max(val[i] + knapSack(W-wt[i], wt, val, n, i+1, dp), knapSack(W, wt, val, n, i+1, dp));
            dp[W][i] = res;
            return res;
        }
        int res = knapSack(W, wt, val, n, i+1, dp);
        dp[W][i] = res;
        return res;
    }

    //combination - binomial
    static int nCr(int n, int r)
    {
        return nCr(n, r, new int[1002][1002]);
    }
    static int nCr(int n, int r, int[][] dp)
    {
        if(r == 1) return n;
        if(r == 0) return 1;
        if(n == r) return 1;
        if(dp[n][r] > 0) return dp[n][r];
        if(r > n) return 0;

        int res = (nCr(n-1, r, dp) + nCr(n-1, r-1, dp))%1000000007;
        dp[n][r] = res;
        dp[n][n-r] = res;
        return res;
    }


    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n) {
        BigInteger[] dp = new BigInteger[n+1];
        return findCatalan(n, dp);
    }
    public static BigInteger findCatalan(int n, BigInteger[] dp)
    {
        if(n == 0) return new BigInteger("1");
        if(n == 1) return new BigInteger("1");
        if(n < 0) return new BigInteger("0");
        if(dp[n] != null) return dp[n];
        int mult = 2*n*(2*n -1);
        int div = (n+1)*n;
        BigInteger res = findCatalan(n-1).multiply(new BigInteger(String.valueOf(mult))).divide(new BigInteger(String.valueOf(div)));
        dp[n] = res;
        return res;
    }


    public static int editDistance(String s, String t) {
        dist = Integer.MAX_VALUE;
        helper(new StringBuilder(s), new StringBuilder(t), 0, 0, 0);
        return dist;
    }
    static int dist = Integer.MAX_VALUE;
    public static boolean helper(StringBuilder s, StringBuilder t, int i, int j, int count) {
        if (s.compareTo(t) == 0){
            return true;
        }
        if(j >= t.length()) return false;
        if(i < s.length() && s.charAt(i) == t.charAt(j)) return helper(s,t,i+1,j+1, count);

        if(i < s.length()){
            s.setCharAt(i, t.charAt(j));
            if(helper(s,t,i+1,j+1, count+1)){
                dist = Math.min(dist, count);
                return true;
            }
        }
        if(i <= s.length()){
            s.insert(i, t.charAt(j));
            if(helper(s,t,i+1, j+1, count+1)){
                dist = Math.min(dist, count);
                return true;
            }
        }
        if(i < s.length()){
            s.deleteCharAt(i);
            if(helper(s,t,i+1, j, count+1)) {
                dist = Math.min(dist, count);
                return true;
            }
        }
        return false;
    }

    public static int helper2(StringBuilder s, StringBuilder t, int i, int j) {
        if (s.compareTo(t) == 0){
            return 0;
        }
        if(j >= t.length()) return -1;
        if(i < s.length() && s.charAt(i) == t.charAt(j)) helper2(s,t,i+1,j+1);

        if(i < s.length()){
            char c = s.charAt(i);
            s.setCharAt(i, t.charAt(j));
            int res = 1 + helper2(s,t,i+1,j+1);
            if(res >= 0){
                dist = Math.min(dist, res);
                return res;
            }
            s.setCharAt(i, c);
        }

        if(i <= s.length()){
            s.insert(i, t.charAt(j));
            int res = 1 + helper2(s,t,i+1, j+1);
            if(res >= 0){
                dist = Math.min(dist, res);
                return res;
            }
            s.deleteCharAt(i);
        }
        if(i < s.length()){
            int res = 1 + helper2(s.deleteCharAt(i),t,i+1, j);
            if(res >= 0) {
                dist = Math.min(dist, res);
                return res;
            }
        }
        return -1;
    }


    public int editDistanceFinal(String s, String t) {
        int[][] dp = new int[s.length()+2][t.length()+2];
        return helperFinal(new StringBuilder(s), new StringBuilder(t), 0, 0, dp);
    }
    public static int helperFinal(StringBuilder s, StringBuilder t, int i, int j, int[][] dp) {
        // if (s.compareTo(t) == 0){
        //     return 0;
        // }
        if(i == s.length()) return Math.abs(t.length() - j);
        if(j == t.length()) return Math.abs(i - s.length());
        if(dp[i][j] > 0) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) return helperFinal(s, t, i+1, j+1, dp);

        int op1 = 1 + helperFinal(s, t, i, j+1, dp);
        int op2 = 1 + helperFinal(s, t, i+1, j+1, dp);
        int op3 = 1 + helperFinal(s, t, i+1, j, dp);
        int ans = Math.min(op1, Math.min(op2, op3));
        dp[i][j] = ans;
        return ans;
    }

    public long countFriendsPairings(int n)
    {
        return countFriendsPairings(n, new long[n+2]);
    }
    public long countFriendsPairings(int n, long[] dp)
    {
        if(n <= 0) return 0;
        if(n==1 || n==2) return n;
        if(dp[n] > 0) return dp[n];

        long res =  (countFriendsPairings(n-1, dp) + countFriendsPairings(n-2, dp)*(n-1))%1000000007;
        dp[n] = res;
        return res;
    }


    static int maxGold(int n, int m, int M[][])
    {
        int ans = 0;
        int dp[][] = new int[n+1][m+1];
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans, maxGold(n, m, M, i, 0, dp));
        }
        return ans;
    }

    static int maxGold(int n, int m, int M[][], int i, int j, int[][] dp)
    {
        if(i < 0 || i >= n || j < 0 || j >= m) return 0;
        if(j == m-1) return M[i][j];
        if(dp[i][j] > 0) return dp[i][j];

        int op1 = maxGold(n, m, M, i, j+1, dp);
        int op2 = maxGold(n, m, M, i+1, j+1, dp);
        int op3 = maxGold(n, m, M, i-1, j+1, dp);

        int res = M[i][j] + Math.max(op1, Math.max(op2,op3));
        dp[i][j] = res;
        return res;
    }


    /** Painting the Fence
     * diff = no of ways when color of last
     *         two posts is different
     *  same = no of ways when color of last
     *         two posts is same
     *  total ways = diff + same
     *
     * for n = 1
     *     diff = k, same = 0
     *     total = k
     *
     * for n = 2
     *     diff = k * (k-1) //k choices for
     *            first post, k-1 for next
     *     same = k //k choices for common
     *            color of two posts
     *     total = k +  k * (k-1)
     *
     * for n = 3
     *     diff = k * (k-1)* (k-1)
     *            //(k-1) choices for the first place
     *         // k choices for the second place
     *         //(k-1) choices for the third place
     *     same = k * (k-1) * 2
     *         // 2 is multiplied because consider two color R and B
     *         // R R B or B R R
     *         // B B R or R B B
     *            c'' != c, (k-1) choices for it
     *
     * Hence we deduce that,
     * total[i] = same[i] + diff[i]
     * same[i]  = diff[i-1]
     * diff[i]  = (diff[i-1] + diff[i-2]) * (k-1)
     *          = total[i-1] * (k-1)
     */
    long countWays(int n,int k)
    {
        if(n==1) return k;
        long same = k;
        long diff = k*(k-1);
        long total = same + diff;

        for(int i = 3; i<=n; i++){
            same = diff;
            diff = total*(k-1);
            total = (same+diff)%1000000007;
        }
        return total;
    }


    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int res = maximizeCuts(n, x, y, z, new int[n+2]);
        if(res < 0) return 0;
        return res;
    }
    public int maximizeCuts(int n, int x, int y, int z, int[] dp)
    {
        if(n == 0) return 0;
        if(n < 0) return -1;
        if(dp[n] != 0) return dp[n];

        int op1 = maximizeCuts(n-x, x, y, z, dp);
        int op2 = maximizeCuts(n-y, x, y, z, dp);
        int op3 = maximizeCuts(n-z, x, y, z, dp);

        int res = Math.max(op1, Math.max(op2, op3));
        if(res < 0) res = -2;
        dp[n] = res+1;
        return res+1;
    }

    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2) {
        return lcs(x, y, s1, s2, 0, 0);
    }
    static int lcs(int x, int y, String s1, String s2, int i, int j)
    {
        if(i >= x || j >= y) return 0;
        char c = s1.charAt(i);
        for(int k = j ; k < y ; k++){
            if(s2.charAt(k) == c){
                int op2 = 1 + lcs(x, y, s1, s2, i+1, k+1);
                int op1 = lcs(x, y, s1, s2, i+1, j);
                return Math.max(op1, op2);
            }
        }
        return lcs(x, y, s1, s2, i+1, j);
    }



    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        return longestSubsequence(size, a, 0, -1, new HashMap<>());
    }
    static int longestSubsequence(int n, int a[], int i, int last, Map<String, Integer> memo)
    {
        String key = i + "," + last;
        if(i >= n) return 0;
        if(memo.containsKey(key)) return memo.get(key);
        if(a[i] <= last) {
            int res = longestSubsequence(n, a, i+1, last, memo);
            memo.put(key, res);
            return res;
        }
        int op1 = 1 + longestSubsequence(n, a, i+1, a[i], memo);
        int op2 = longestSubsequence(n, a, i+1, last, memo);
        int res = Math.max(op1, op2);
        memo.put(key, res);
        return res;
    }


    // LCS of three strings
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        return LCSof3(A, B, C, n1, n2, n3, 0, 0, 0, new int[n1+1][n2+1][n3+1]);
    }
    int LCSof3(String s1, String s2, String s3, int n1, int n2, int n3, int i, int j, int k, int[][][] dp) {
        if(i >= n1 || j >= n2 || k >= n3) return 0;
        if(dp[i][j][k] > 0) return dp[i][j][k];
        char c = s1.charAt(i);
        for(int l = j ; l < n2 ; l++){
            if(s2.charAt(l) == c){
                for(int m = k; m < n3 ; m++){
                    if(s3.charAt(m) == c){
                        int op2 = 1 + LCSof3(s1, s2, s3, n1, n2, n3, i+1, l+1, m+1, dp);
                        int op1 = LCSof3(s1, s2, s3, n1, n2, n3, i+1, j, k, dp);
                        return dp[i][j][k] = Math.max(op1, op2);
                    }
                }
                return dp[i][j][k] = LCSof3(s1, s2, s3, n1, n2, n3, i+1, j, k, dp);
            }
        }
        return dp[i][j][k] = LCSof3(s1, s2, s3, n1, n2, n3, i+1, j, k, dp);
    }


    //Maximum sum increasing subsequence
    public int maxSumIS(int[] arr, int n){
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxSumIS(n, arr, 0, -1, dp);
    }
    public int maxSumIS(int n, int[] a, int i, int last, int[][] dp){
        if(i >= n) return 0;
        if(last >= 0 && dp[i][last] != -1) return dp[i][last];
        if(last != -1 && a[i] <= a[last]) {
            return dp[i][last] = maxSumIS(n, a, i+1, last, dp);
        }
        int op1 = a[i] + maxSumIS(n, a, i+1, i, dp);
        int op2 = maxSumIS(n, a, i+1, last, dp);
        if(last == -1) return Math.max(op1, op2);
        return dp[i][last] = Math.max(op1, op2);
    }




    //Function to find the maximum money the thief can get.
    public static int FindMaxSum(int arr[], int n) {
        int[][] dp = new int[2][n+2];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return FindMaxSum(arr, n, 0, 0, dp);
    }
    public static int FindMaxSum(int arr[], int n, int i, int lastLooted, int[][] dp){
        if(i >= n) return 0;
        if(dp[lastLooted][i] != -1) return dp[lastLooted][i];
        if(lastLooted == 1) return dp[lastLooted][i] = FindMaxSum(arr, n, i+1, 0, dp);
        int op1 = arr[i] + FindMaxSum(arr, n, i+1, 1, dp);
        int op2 = FindMaxSum(arr, n, i+1, 0, dp);
        return dp[lastLooted][i] = Math.max(op1, op2);
    }


    class CompareByFirst implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.x - b.y;
        }
    }

    static class Pair {
        int x;
        int y;
        public Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    int maxChainLength(Pair arr[], int n){
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.x - o1.x;
            }
        });
        int[][] dp = new int[n+2][n+2];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxChainLength(arr, n-1, n, dp);
    }
    int maxChainLength(Pair arr[], int n, int last, int[][] dp){
        if(n < 0) return 0;

        if(dp[n][last] != -1) return dp[n][last];

        if(last == arr.length || arr[n].x > arr[last].y){
            int op2 = 1 + maxChainLength(arr, n-1, n, dp);
            int op1 = maxChainLength(arr, n-1, last, dp);
            return dp[n][last] = Math.max(op1, op2);
        }
        return dp[n][last] = maxChainLength(arr, n-1, last, dp);
    }



    public static int getSum(int X, int Y, int Z) {
        for(int i = 1 ; i <= 4; i++){
            ArrayList<ArrayList<Integer>> ans =  new ArrayList<>();
            System.out.print(getSum(2, Y, Z, 3, ans, new ArrayList<>()) + " -> ");
            System.out.println(ans);
        }
        return 0;
    }
    public static long getSum(int X, int Y, int Z, int n, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> in){
        if(n > X+Y+Z){
            ans.add(new ArrayList<>(in));
            return 0;
        }
        long sum = 0;
        if(X > 0){
            in.add(4);
            long t1 = getSum(X-1, Y, Z, n, ans, in);
            //System.out.print("t1:" + t1+",");
            sum += (t1*10 + 4);
            //System.out.println(sum);
            in.remove(in.size()-1);
        }
        if(Y > 0){
            in.add(5);
            sum += (getSum(X, Y-1, Z, n, ans, in)*10 + 5);
            in.remove(in.size()-1);
        }
        if(Z > 0){
            in.add(6);
            sum += (getSum(X, Y, Z-1, n, ans, in)*10 + 6);
            in.remove(in.size()-1);
        }

        return sum;
    }
    //robust to submit
    public static int getSumOpt(int X, int Y, int Z) {
        long[][][] dp = new long[X+1][Y+1][Z+1];
        long[][][] num = new long[X+1][Y+1][Z+1]; // don't forget to take mod of it
        num[0][0][0] = 1L;
        long mod = 1000000007;
        long ans = 0L;
        for(int i = 0 ; i <= X; i++){
            for(int j = 0 ; j <= Y; j++) {
                for (int k = 0; k <= Z; k++) {
                    if(i > 0){
                        dp[i][j][k] += (10L*dp[i-1][j][k] + num[i-1][j][k]*4L)%mod;
                        num[i][j][k] += num[i-1][j][k]%mod;
                    }
                    if(j > 0){
                        dp[i][j][k] += (10L*dp[i][j-1][k] + num[i][j-1][k]*5L)%mod;
                        num[i][j][k] += num[i][j-1][k]%mod;
                    }
                    if(k > 0){
                        dp[i][j][k] += (10L*dp[i][j][k-1] + num[i][j][k-1]*6L)%mod;
                        num[i][j][k] += num[i][j][k-1]%mod;
                    }
                    ans += dp[i][j][k]%mod;
                    ans = ans%mod;
                }
            }
        }
        ans = ans%mod;
        return (int) ans;
    }




    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        int sr = 0;
        int sc = 0;
        int er = R-1;
        int ec = C-1;
        int[] ans = new int[R*C];
        int i = 0;

        while (i < ans.length){
            //left to right;
            for(int j = sc ; j <= ec; j++){
                ans[i] = a[sr][j];
                i++;
            }
            sr++;
            //top to bottom
            for(int j = sr; j <= er; j++){
                ans[i] = a[j][ec];
                i++;
            }
            ec--;
            //right to left;
            for(int j = ec; j>= sc; j--){
                ans[i] = a[er][j];
                i++;
            }
            er--;
            // bottom to top
            for(int j = er; j >= sr; j--){
                ans[i] = a[j][sc];
                i++;
            }
            sc++;
        }

        for(int l = 0, r = ans.length-1; l < r; l++,r--){
            int temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
        }
        return ans;
    }
}

