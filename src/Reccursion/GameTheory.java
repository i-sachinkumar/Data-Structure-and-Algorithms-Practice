package Reccursion;

public class GameTheory {
    public static void main(String[] args) {
        int[] c = {5, 3, 7, 10};
        System.out.println(maxCoins(c, 0, 3));
    }

    public static int maxCoins(int[] coins, int l, int r) {
        if (l + 1 == r) return Math.max(coins[l], coins[r]);
        return Math.max(coins[l] + Math.min(maxCoins(coins, l + 2, r), maxCoins(coins, l + 1, r - 1)),
                coins[r] + Math.min(maxCoins(coins, l + 1, r - 1), maxCoins(coins, l, r - 2)));
    }
}
