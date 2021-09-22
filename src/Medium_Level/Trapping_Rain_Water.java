package Medium_Level;

/**
 * Question =>
 *
 * Link GFG :
 * (https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1#)
 *
 * Statement:
 * Given an array arr[] of N non-negative integers representing the height of blocks.
 * If width of each block is 1, compute how much water can be
 * trapped between the blocks during the rainy season.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 6
 * arr[] = {3,0,0,2,0,4}
 * Output:
 * 10
 * Explanation:
 *
 * Example 2:
 *
 * Input:
 * N = 4
 * arr[] = {7,4,0,9}
 * Output:
 * 10
 * Explanation:
 * Water trapped by above
 * block of height 4 is 3 units and above
 * block of height 0 is 7 units. So, the
 * total unit of water trapped is 10 units.
 * Example 3:
 *
 * Input:
 * N = 3
 * arr[] = {6,9,9}
 * Output:
 * 0
 * Explanation:
 * No water will be trapped.
 *
 * Your Task:
 * You don't need to read input or print anything.
 * The task is to complete the function trappingWater()
 * which takes arr[] and N as input parameters and returns the total amount of water that can be trapped.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 */

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] arr = {3,0,0,2,0,4};

        System.out.println(trappingWater(arr,arr.length));

    }

    static long trappingWater(int[] arr, int n) {
        int[] before_max = new int[n];
        int[] after_max = new int[n];

        //implementing before_max
        //Contains The Highest Block before ith block
        for (int i = 1; i < n - 1; i++) {
            before_max[i] = Math.max(before_max[i - 1], arr[i - 1]);
        }

        //implementing after_max
        //Contains The Highest Block after ith block
        for (int i = n - 2; i > 0; i--) {
            after_max[i] = Math.max(after_max[i + 1], arr[i + 1]);
        }

        long water_trapped = 0;

        // water can be trapped if there is longer block before the current
        // block as well as after current block
        for (int i = 0; i < n; i++) {
            if (arr[i] < after_max[i] && arr[i] < before_max[i]) {
                water_trapped += ((Math.min(after_max[i], before_max[i]) - arr[i]));
            }
        }
        return water_trapped;
    }
}
