package gfg;

import java.util.HashMap;
import java.util.Map;

public class DP{
    public static void main(String[] args) {
        System.out.println(count(new int[]{1,2,3}, 3, 4));
    }

    public static long count(int[] coins, int N, int sum) {
        Map<String, Long> memo = new HashMap<>();
        return count(coins, N, sum, 0, memo);
    }

    public static long count(int[] coins, int N, int sum, int l, Map<String, Long> memo) {
        if(sum == 0) return 1;
        if(sum < 0) return 0;
        String key = sum + "," + l;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        long c = 0;
        for(int i = l ; i < N ; i++){
            long curr = count(coins, N, sum-coins[i], i, memo);
            memo.put(key, curr);
            c = c + curr;
        }
        memo.put(key, c);
        return c;
    }
}

