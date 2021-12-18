package daily_test.Dec17;

import java.util.ArrayList;
import java.util.List;

public class MinPathInTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(-1)));
        triangle.add(new ArrayList<>(List.of(2,3)));
        triangle.add(new ArrayList<>(List.of(1,-1,-3)));

        System.out.println(minimumTotal2(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0, triangle.size());
    }
    public static int minimumTotal(List<List<Integer>> triangle , int i, int j, int n) {
        if(n == 0) return 0;
        if(n == 1) return triangle.get(i).get(j);
        int left = triangle.get(i).get(j) + minimumTotal(triangle, i+1, j, n-1);
        int right =  triangle.get(i).get(j) + minimumTotal(triangle, i+1, j+1, n-1);
        return Math.min(left,right);
    }


    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0) return 0;
        if(n == 1) return triangle.get(0).get(0);

        int[] dp = new int[n];

        int ind = 0;
        for(int i : triangle.get(n-1)){
            dp[ind++] = i;
        }
        int last_ind = n-2;
        while(last_ind >= 0){
            for(int i = 0 ; i < triangle.get(last_ind).size(); i++){
                dp[i] = Math.min(dp[i] + triangle.get(last_ind).get(i), dp[i+1] + triangle.get(last_ind).get(i));
            }
            last_ind--;
        }
        return dp[0];
    }
}

