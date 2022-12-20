package PlacementCompanies;

import java.lang.annotation.Retention;
import java.util.*;

public class Qure_AI {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 6, 8, 2},
                {5, 2, 4, 3},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
        };
        int[][][] dp = new int[5][4][4];
        for(int[][] in1 : dp){
            for (int[] in2 : in1){
                Arrays.fill(in2, -1);
            }
        }
        System.out.println(maxCoin(arr, 0, 0, 3, 5, 4, dp));
        generateParenthesis(3, 0, 0, "");
    }


    //meeting room - 2  |  https://www.interviewbit.com/problems/meeting-rooms/
    static class Pair{
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public int getA() {
            return a;
        }
        public int getB() {
            return b;
        }
    }
    public static int meetingRoom2(ArrayList<ArrayList<Integer>> A){
        ArrayList<Pair> critical_points = new ArrayList<>();
        for(ArrayList<Integer> meet : A){
            int start = meet.get(0);
            int end = meet.get(1);
            critical_points.add(new Pair(start, +1));
            critical_points.add(new Pair(end, -1));
        }
        critical_points.sort(Comparator.comparingInt(Pair::getA).thenComparingInt(Pair::getB));
        int max = 0;
        int curr = 0;
        for(Pair point : critical_points){
            curr += point.b;
            max = Math.max(max, curr);
        }
        return max;
    }


    //Collect maximum points in a grid using two traversals
    // https://www.geeksforgeeks.org/collect-maximum-points-in-a-grid-using-two-traversals/
    static int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static int maxCoin(int[][] grid, int i, int j1, int j2, int m, int n, int[][][] dp){
        if(i >= m || i < 0) return Integer.MIN_VALUE;
        if(j1 >= n || j1 < 0 || j2 >= n || j2 < 0) return Integer.MIN_VALUE;
        if(i == m-1 && j1 == 0 && j2 == n-1) return (j1 == j2)? grid[i][j1]: grid[i][j1] + grid[i][j2];
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for(int[] move : moves){
            int coins = grid[i][j1] + grid[i][j2];
            if(j1 == j2) coins /= 2;
            max = Math.max(max, coins + maxCoin(grid, i+1, j1 + move[0], j2 + move[1], m, n, dp));
        }

        //System.out.println(max);
        return dp[i][j1][j2] = max;
    }



    // https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses
    public static void generateParenthesis(int n, int num_open, int num_close, String curr){
        if(num_open > n) return;
        if(num_close > num_open) return;
        if(num_close == n){
            System.out.println(curr);
        }
        generateParenthesis(n, num_open+1, num_close, curr+"(");
        generateParenthesis(n, num_open, num_close+1, curr+")");
    }


    //jumbled word
}
