package DynamicProgramming.Tabulation;

public class BuyAndSellStock {
    public static void main(String[] args) {

        int[] prices = {7,5,1,3,2,4,8,3};

        System.out.println(maxProfit(prices));
        System.out.println(fastMaxProfit(prices));

        System.out.println("dhhchcce".indexOf("hello"));
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 0 ; i < prices.length; i++){
            for(int j = i+1 ; j < prices.length; j++){
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }

        return ans;
    }

    public static int fastMaxProfit(int[] prices){
        int minPrice = prices[0];

        int pointer = 0;

        int profit = 0;

        while (++pointer < prices.length){
            if(minPrice > prices[pointer]){
                minPrice = prices[pointer];
            }
            else if(minPrice < prices[pointer]){
                profit = Math.max(profit, prices[pointer] - minPrice);
            }
        }
        return profit;
    }
}
