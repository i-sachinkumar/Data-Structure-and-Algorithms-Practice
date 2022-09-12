package gfg;

import java.util.*;

public class BackTracking {
    public static void main(String[] args) {
        int[] nums = {3,4};
        int[] a = Arrays.copyOf(nums,nums.length);
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

}
