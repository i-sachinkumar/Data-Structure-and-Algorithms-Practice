package Reccursion.Memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * 2D(m x n) grid is given we have to find no of possible path
 * to go from top-left corner to bottom-right corner
 * we can only move rightward or downward direction
 */

public class GridTraveller {
    public static void main(String[] args) {

        //fast traveller result
        System.out.println(fastGridTraveller(50,50, new HashMap<>()));

        // time taken by fastTraveller in 50x50 grid <<<<<< time taken by fastTraveller in 17x17 grid

        // slow traveller result
        System.out.println(slowGridTraveller(17,17));
    }

    public static int slowGridTraveller(int m, int n){
        if( m == 0 || n == 0) return 0;
        if( m == 1 && n == 1) return 1;

        return slowGridTraveller(m-1, n) + slowGridTraveller(m, n-1);
    }

    public static long fastGridTraveller(int m, int n, Map<String, Long> memo){
        if( m == 0 || n == 0) return 0;
        if( m == 1 && n == 1) return 1;
        String key = m + "," + n;
        if( memo.containsKey(key)) return memo.get(key);

        long result = fastGridTraveller(m-1, n, memo) + fastGridTraveller(m, n-1, memo);
        memo.put(key, result);
        memo.put(n + "," + m , result);
        return result;
    }
}
