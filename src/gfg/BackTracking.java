package gfg;

import java.util.*;

public class BackTracking {
    public static void main(String[] args) {

        int[][] mines = {{1, 1, 1},
                {1, 1, 1}};
        System.out.println(findShortestPath(mines));
        System.out.println(lastStoneWeightII(new int[]{31,26,33,21,40}));

        System.out.println(equalPartition(3, new int[]{1,5,5}));
        System.out.println(removeInvalidParentheses("()((((()"));

        List<String> dict = List.of("cats", "cat", "and", "sand", "dog");
        String s = "catsanddog";


        System.out.println(wordBreak(5, dict, s));



        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        //String s = "dwefqwfq";

        SolveSudoku(grid);
        printGrid(grid);

//        int[] nums = {3,4};
//        int[] a = Arrays.copyOf(nums,nums.length);
    }

    //Rat in a Maze Problem - I
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> arr = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        findPath(m, n, 0, 0, arr, vis, "");
        if(arr.size() == 0) {
            arr.add("-1");
        }
        return arr;
    }
    public static boolean findPath(int[][] m, int n, int i, int j, ArrayList<String> arr, boolean[][] vis, String curr) {
        // Your code here
        if(n == 0) return false;
        if(i < 0 || i >= n || j < 0 || j >= n){
            return false;
        }


        if(m[i][j] == 0) return false;
        if(vis[i][j]) return false;
        if(n == 1 && m[0][0] == 1) return true;
        if(i == n-1 && j==n-1){
            arr.add(curr);
            return true;
        }

        vis[i][j] = true;

        findPath(m, n, i-1, j, arr, vis, curr + "U");
        findPath(m, n, i+1, j, arr, vis, curr + "D");
        findPath(m, n, i, j-1, arr, vis, curr + "L");
        findPath(m, n, i, j+1, arr, vis, curr + "R");

        vis[i][j] = false;
        return true;
    }

    /**
     *  Combination Sum II
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);

        backTrack(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, ArrayList<Integer> inner, int[] candidates,
                           int target, int start) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(inner));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            if(i>start && candidates[i] == candidates[i-1]) { continue; }
            inner.add(candidates[i]);
            backTrack(result, inner, candidates, target-candidates[i], i+1);
            inner.remove(inner.size()-1);
        }
    }


    // Combination Sum III
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        backTrack(result, new ArrayList<Integer>(), n, 1, k);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, ArrayList<Integer> inner, int n, int start, int k) {
        if(n == 0 && k == 0) {
            result.add(new ArrayList<Integer>(inner));
            return;
        }
        if(n < 0 || k < 0) {
            return;
        }
        for(int i=start; i<= 9; i++) {
            inner.add(i);
            backTrack(result, inner, n-i, i+1, k-1);
            inner.remove(inner.size()-1);
        }
    }


    /**
     * Combination Sum IV
     * Given an array of distinct integers nums and a target integer target,
     * return the number of possible combinations that add up to target
     */
    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new HashMap<>());
    }

    public int combinationSum4(int[] nums, int target, Map<Integer, Integer> memo) {
        if(target == 0){
            return 1;
        }
        if(target < 0) return 0;
        if(memo.containsKey(target)) return memo.get(target);

        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            int res = combinationSum4(nums, target - nums[i], memo);
            sum += res;
        }

        memo.put(target, sum);
        return sum;
    }


    //Function to return a list of indexes denoting the required
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //Set<Integer> set = new HashSet<>(A);
        //A = new ArrayList<Integer>(set);
        Collections.sort(A);
        backTrack(result, new ArrayList<Integer>(), A, B, 0);
        return result;
    }


    private static void backTrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> inner, ArrayList<Integer> A,
                                  int B, int start) {
        if(B == 0) {
            result.add(new ArrayList<Integer>(inner));
            return;
        }
        if(B < 0) {
            return;
        }
        for(int i=start; i<A.size(); i++) {
            if(i>start && A.get(i) == A.get(i-1)) { continue; }
            inner.add(A.get(i));
            backTrack(result, inner, A, B-A.get(i), i);
            inner.remove(inner.size()-1);
        }
    }


    //nQueen
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        nQueen(n, new boolean[n][n], 0, ans, curr);
        //System.out.println(curr);
        return ans;
    }

    static void nQueen(int n, boolean[][] chess, int i, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr) {
        if(i == n){
            ans.add(new ArrayList<>(curr));
            return;
        }


        for(int j = 0 ; j < n ; j++){
            if(isSafe(chess, i, j, n)){
                curr.add(j+1);
                chess[i][j] = true;
                nQueen(n, chess, i+1, ans, curr);
                chess[i][j] = false;
                curr.remove(curr.size()-1);
            }
        }
    }

    private static boolean isSafe(boolean[][] board,int row,int col, int n){

        for (int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }

        int maxiLeft=Math.min(row,col);
        for(int j=1;j<=maxiLeft;j++){
            if(board[row-1][col-1]){
                return false;
            }
        }

        int maxiRight=Math.min(row,board.length-col-1);
        for(int j=1;j<=maxiRight;j++){
            if(board[row-1][col+1]){
                return false;
            }
        }
        return true;
    }



    //Function to find a solved Sudoku.(done)
    static boolean SolveSudoku(int[][] grid)
    {
        return SolveSudoku(grid, grid.length, 0);
    }

    //Function to print grids of the Sudoku.
    static void printGrid (int[][] grid)
    {
        for(int[] r : grid){
            for(int c: r){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    static boolean SolveSudoku(int[][] grid, int n, int i)
    {
        if(i > 80) return true;
        if(grid[i/9][i%9] != 0) return SolveSudoku(grid,n,i+1);

        for(int e = 1; e <= 9; e++){
            if(isSafe(grid, n, i/9, i%9, e)){
                grid[i/9][i%9] = e;
                if(SolveSudoku(grid, n, i+1)) return true;
                grid[i/9][i%9] = 0;
            }
        }

        return false;
    }

    static boolean isSafe(int[][] grid, int n, int i, int j, int e){
        //row
        for(int c = 0; c < n ; c++){
            if(grid[i][c] == e) return false;
        }

        // col
        for(int r = 0 ; r < n ;r++){
            if(grid[r][j] == e) return false;
        }

        //grid
        int r = 0;
        int c = 0;

        if(i >= 6) r = 6;
        else if(i >= 3) r = 3;

        if(j >= 6) c = 6;
        else if(j >= 3) c = 3;

        for(int p = 0; p < 3 ; p++){
            for(int q = 0 ; q < 3 ; q++){
                if(grid[r+p][c+q] == e) return false;
            }
        }

        return true;
    }

    // Word Break - Part 2
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        List<String> ans = new ArrayList<>();
        wordBreak(n, dict, s, 0, "", "", ans);
        return ans;
    }
    static void wordBreak(int n, List<String> dict, String s, int i, String word, String sentence, List<String> ans)
    {
        if(i >= s.length()){
            ans.add(sentence.trim());
            return;
        }
        for(int j = i ; j < s.length() ; j++){
            word = word + s.charAt(j);
            if(dict.contains(word)){
                String tmp = sentence;
                sentence = sentence + word + " ";
                wordBreak(n, dict, s, j+1, "", sentence, ans);
                sentence = tmp;
            }
        }
    }



    //Remove Invalid Parentheses
    public static List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;

        max_len = -1;

        String strt = "";
        String end = "";
        while(i < n){
            char c = s.charAt(i);
            if(c == ')');
            else if(c == '(') break;
            else strt = strt + c;
            i++;
        }

        while(j >= 0){
            char c = s.charAt(j);
            if(c == '(');
            else if(c == ')') break;
            else end = c + end;
            j--;
        }

        if(i<j) s = strt + s.substring(i, j+1) + end;
        else{
            String tmp = "";
            for(int p = 0 ; p < n ; p++){
                char c = s.charAt(p);
                if(c != '(' && c != ')') tmp = tmp + c;
            }
            s = tmp;
        }

        List<String> ans = new ArrayList<>();

        if(isBalanced(s)){
            ans.add(s);
            return ans;
        }
        Set<String> set = new HashSet<>();
        removeInvalidParentheses(s, 0, set);
        return new ArrayList<>(set);
    }

    static int max_len = -1;
    public static void removeInvalidParentheses(String s, int i, Set<String> ans) {
        if(s.length() < max_len) return;
        if(isBalanced(s)){
            if(s.length() == max_len)ans.add(s);
            if(s.length() > max_len){
                ans.clear();
                max_len = s.length();
                ans.add(s);
            }
        }
        if(i >= s.length()) return;

        String tmp = s;
        String curr = "";
        for(int j = 0 ; j < s.length(); j++){
            if(j == i) continue;
            curr = curr + s.charAt(j);
        }
        //System.out.println(curr);
        if(s.charAt(i) == '(' || s.charAt(i) == ')') removeInvalidParentheses(curr, i, ans);

        s = tmp;
        removeInvalidParentheses(s, i+1, ans);
    }

    public static boolean isBalanced(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != '(' && c != ')') continue;
            if(c == '(') st.push('(');
            else if(!st.empty() && st.peek() == '(') st.pop();
            else return false;
        }
        return st.empty();
    }


    // Find all possible palindromic partitions of a String
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        allPalindromicPerms(S, 0, ans, new ArrayList<>());
        return ans;
    }
    static void allPalindromicPerms(String s, int i, ArrayList<ArrayList<String>> ans, ArrayList<String> in) {
        if(i >= s.length()){
            ans.add(new ArrayList<>(in));
        }

        for(int j = i ; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                in.add(s.substring(i, j+1));
                allPalindromicPerms(s, j+1, ans, in);
                in.remove(in.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s, int i, int j){
        if(i >= j) return true;
        if(s.charAt(i) != s.charAt(j)) return false;
        else return isPalindrome(s, i+1, j-1);
    }


    static int equalPartition(int N, int[] arr)
    {
        int sum = 0;
        for(int i : arr){
            sum += i;
        }

        if(equalPartition(N, arr, 0, sum, 0)) return 1;
        return 0;
    }
    static boolean equalPartition(int n, int[] arr, int i, int total, int curr){
        if(2*curr == total) return true;
        if(i >= n) return false;
        return (equalPartition(n, arr, i+1, total, curr) ||
                equalPartition(n, arr, i+1, total, curr+arr[i]));
    }


    public static int findShortestPath(int[][] mat) {
        // code here
        int n =  mat.length;
        int m = mat[0].length;
        int[][] nMat = new int[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                nMat[i][j] = 1;
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(mat[i][j] == 0){
                    nMat[i][j] = 0;
                    if(i > 0) nMat[i-1][j] = 0;
                    if(i < n-1) nMat[i+1][j] = 0;
                    if(j > 0) nMat[i][j-1] = 0;
                    if(j < m-1) nMat[i][j+1] = 0;
                }
            }
        }
//        for(int i = 0 ; i < n ; i++){
            findShortestPath(nMat, 0, 0, n, m, new boolean[n][m], 0);
//        }
        if(minimum == Integer.MAX_VALUE) return -1;
        return minimum+1;
    }
    static int minimum = Integer.MAX_VALUE;
    public static void findShortestPath(int[][] nMat, int i, int j, int n, int m, boolean[][] vis, int path) {
        if(i >= n || i < 0 || j >= m || j < 0) return;
        if(vis[i][j]) return;
        if(j == m-1){
            if(path < minimum){
                minimum = path;
            }
            return;
        }
        vis[i][j] = true;
        findShortestPath(nMat, i-1, j, n, m, vis, path+1);
        findShortestPath(nMat, i+1, j, n, m, vis, path+1);
        findShortestPath(nMat, i, j-1, n, m, vis, path+1);
        findShortestPath(nMat, i, j+1, n, m, vis, path+1);
        if(j == 0) return;
        if(nMat[i][j] == 0) return;
        vis[i][j] = false;
    }


    public static int lastStoneWeightII(int[] stones) {
        return dfs(0,0,stones);
    }

    public static int dfs(int index, int sum , int[] stones) {
        String key = index+","+sum;
        if(index== stones.length) {
            return sum;
        }
        int currentValue = stones[index];
        int left = dfs(index+1,sum+currentValue,stones);
        int right = dfs(index+1,Math.abs(sum-currentValue),stones);
        return Math.min(left,right);
    }







    int total = 0;
    public int lastStoneWeightII2(int[] stones) {
        for(int i : stones){
            total += i;
        }
        lastStoneWeightII2(stones, 0, 0, new HashMap<>());
        return min;
    }
    int min = Integer.MAX_VALUE;
    public void lastStoneWeightII2(int[] stones, int i, int sum, Map<String, Integer> memo) {
        String key = i + "," + sum;
        if(i >= stones.length) {
            return;
        }
        if(memo.containsKey(key)){
            min = Math.min(min, memo.get(key));
        }
        if(Math.abs(total-sum - sum) < min){
            memo.put(key, min);
            min = Math.abs(total-sum - sum);
        }
        int curr = stones[i];
        lastStoneWeightII2(stones, i+1, sum + curr, memo);
        lastStoneWeightII2(stones, i+1, sum, memo);
    }

}
