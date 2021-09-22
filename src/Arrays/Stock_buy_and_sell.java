package Arrays;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Given array of prices
 * buy a stock on any day and sell it to any other day after buying to maximize profit
 * O(N)
 */

public class Stock_buy_and_sell {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(3, 5, 9, 7, 1, 3, 12, 1, 3);

        System.out.println(stockmax(prices));

    }

    public static long stockmax(List<Integer> p) {
        int n = p.size();

        int min = p.get(0);
        int max = p.get(0);

        long maxProfit = 0;

        for(int  i = 1 ; i < n ; i++){
            min = Math.min(min, p.get(i));
            if(min == p.get(i)){
                max = p.get(i);
            }
            max = Math.max(max,p.get(i));
            maxProfit = Math.max(maxProfit,(max - min));
        }

        return maxProfit;
    }
}
