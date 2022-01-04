package DynamicProgramming.Memoization;

import java.util.*;
// TODO "need further optimization"

public class CoinChange {
    public static void main(String[] args) {

        List<Long> l = new ArrayList<>(List.of(3L,6L,2L, 5L));
        int n = 10;
        System.out.println(getWays(10, new ArrayList<>(l),0, new HashMap<>()));

        long[] dp = new long[n+1];
        dp[0] = 1;
        int coin_num = 0;

        for (int i = 0 ; i < n+1; i++){
            if(dp[i] != 0){
                for(int j = coin_num; j < l.size(); j++){
                    int coin = l.get(j).intValue();
                    if(i + coin < n+1) dp[i+coin] += dp[i];
                }
                coin_num++;
            }
        }

        System.out.println(dp[n]);

    }

    public static long getWays(int n, List<Long> c, int curr,  Map<Integer, Map<Integer, Long>> memo) {
        if(n < 0) return 0;
        else if(n == 0) return 1;
        if(memo.containsKey(n) && memo.get(n).containsKey(curr)) return memo.get(n).get(curr);

        long result = 0;

        for(int i = curr ; i < c.size(); i++, curr++){
            result += getWays(n-c.get(i).intValue(), c, curr, memo);
        }

        if(memo.containsKey(n)){
            memo.get(n).put(curr, result);
        }
        else{
            memo.put(n, new HashMap<>());
            memo.get(n).put(curr, result);
        }
        return result;
    }

}
