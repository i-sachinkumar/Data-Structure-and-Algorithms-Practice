package DynamicProgramming.Memoization;

// Qs. Link = {https://leetcode.com/problems/min-cost-climbing-stairs/}


import java.util.HashMap;
import java.util.Map;

public class MinCostClimb {
    public static void main(String[] args) {
        int[] cost = {0,1,100,1,1,1,100,1,1,100,1};

        System.out.println(minCostClimbingStairs(cost, 0, new HashMap<>()));


        /**
         *   {1,100,1,1,1,100,1,1,100,1}
         *
         */
    }



    public static int minCostClimbingStairs(int[] cost, int i, Map<Integer, Integer> memo) {
        if(cost.length <= i) return 0;
        if(cost.length == i+1) return cost[i];
        if(cost.length == i+2) return cost[i];
        if(memo.containsKey(i)) return memo.get(i);


        int res = Math.min(cost[i] + minCostClimbingStairs(cost, i+1, memo),
                cost[i] + minCostClimbingStairs(cost, i+2, memo));
        memo.put(i, res);
        return res;

    }
}
