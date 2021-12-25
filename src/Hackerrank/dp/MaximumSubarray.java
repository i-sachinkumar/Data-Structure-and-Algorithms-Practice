package Hackerrank.dp;


import java.util.List;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(String.valueOf(maxSubarray(List.of(-1, -2, -3, -5, -6))));
    }

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int max_sum_subarray = Integer.MIN_VALUE;
        int max_sum_subsequence = 0;
        int sum = 0;
        int max_entry = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.size() ; i++){
            if(arr.get(i) > 0) max_sum_subsequence += arr.get(i);
            max_entry = Math.max(max_entry, arr.get(i));
            sum += arr.get(i);
            max_sum_subarray = Math.max(max_sum_subarray, sum);
            if(sum < 0) sum = 0;
        }
        if(max_sum_subsequence == 0){
            max_sum_subsequence = max_entry;
        }
        return List.of(max_sum_subarray, max_sum_subsequence);
    }
}
