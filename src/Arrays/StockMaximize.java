package Arrays;


import java.util.Arrays;
import java.util.List;

/**
 * Hackerrank Question:
 * Link: (https://www.hackerrank.com/challenges/stockmax/problem)
 *
 * Statement:
 *
 * Your algorithms have become so good at predicting the market
 * that you now know what the share price of Wooden Orange Toothpicks Inc.
 * (WOT) will be for the next number of days.
 *
 * Each day, you can either buy one share of WOT,
 * sell any number of shares of WOT that you own,
 * or not make any transaction at all.
 * What is the maximum profit you can obtain with an optimum trading strategy?
 *
 * Example
 *
 * Buy one share day one, and sell it day two for a profit of . Return .
 *
 *
 * No profit can be made so you do not buy or sell stock those days. Return .
 *
 * Function Description
 *
 * Complete the stockmax function in the editor below.
 *
 * stockmax has the following parameter(s):
 *
 * prices: an array of integers that represent predicted daily stock prices
 * Returns
 *
 * int: the maximum profit achievable
 * Input Format
 *
 * The first line contains the number of test cases .
 *
 * Each of the next  pairs of lines contain:
 * - The first line contains an integer , the number of predicted prices for WOT.
 * - The next line contains n space-separated integers , each a predicted stock price for day .
 *
 * Constraints
 *
 * Output Format
 *
 * Output  lines, each containing the maximum profit which can be obtained for the corresponding test case.
 */

public class StockMaximize {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(1,2,100);
        System.out.println(stockmax(prices));
    }

    public static long stockmax(List<Integer> buy_price) {
        int n = buy_price.size();

        int[] sell_price = new int[n];
        sell_price[n-1] = buy_price.get(n-1);

        for(int i = n-2; i >=0 ; i--){
            sell_price[i] = Math.max(sell_price[i+1], buy_price.get(i));
        }

        long profit = 0;
        for(int i = 0 ; i < n ; i++){
            int curr_profit = sell_price[i] - buy_price.get(i);
            if(curr_profit > 0){
                profit += curr_profit;
            }
        }

        return profit;

    }

}

