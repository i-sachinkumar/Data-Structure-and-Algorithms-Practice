package gfg;

import java.util.*;

public class SortingSearching{
        public static void main(String[] args) {

        }
        //Function to find the minimum number of swaps required to sort the array.
        public int minSwaps(int nums[]) {

                HashMap<Integer, Integer> map = new HashMap<>();
                int swaps = 0;
                int[] sorted = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                        sorted[i] = nums[i];
                }
                Arrays.sort(sorted);

                for (int i = 0; i < nums.length; i++) {
                        map.put(nums[i], i);
                }

                for (int i = 0; i < nums.length; i++) {
                        if (nums[i] != sorted[i]) {
                                ++swaps;
                                int temp = map.get(sorted[i]);
                                int value = nums[i];
                                int t = nums[i];
                                nums[temp] = t;
                                map.put(nums[i], i);
                                map.put(value, temp);
                        }

                }
                return swaps;
        }
}
