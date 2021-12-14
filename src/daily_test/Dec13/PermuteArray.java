package daily_test.Dec13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteArray {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        for (int[] each: permute(a)) {
            System.out.println(Arrays.toString(each));
        }
    }
    public static List<int[]> permute(int[] nums) {
        List<int[]> ans = new ArrayList<>();
        permute(nums,ans,0, nums.length-1);
        return ans;
    }
    public static void permute(int[] nums, List<int[]> ans, int l, int r) {
        if(l == r) System.out.println(Arrays.toString(nums));;
        for(int i = l ; i<= r ; i++){
            int temp = nums[i];
            nums[i] = nums[l];
            nums[l] = temp;
            permute(nums, ans, l+1, r);
            temp = nums[i];
            nums[i] = nums[l];
            nums[l] = temp;
        }
    }
}
