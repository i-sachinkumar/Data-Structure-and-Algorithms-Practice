package daily_test.Dec14;

// Qs Link = {https://leetcode.com/problems/patching-array/}

public class PatchingArray {
    public static void main(String[] args) {
        int[] nums = {1,2,31,33};

        System.out.println(minPatches(nums,2147483647));
        int i = 12;
        char[] c = String.valueOf(i).toCharArray();
    }

    public static int minPatches(int[] nums, int n) {
        int nums_pointer = 0;
        int patch_pointer = 1;
        int prev_sum = 0;
        int patch_count = 0;

        while (patch_pointer <= n) {

            int curr_num;
            if(nums_pointer < nums.length) curr_num = nums[nums_pointer];       // critical
            else curr_num = n;                                                  //    ""


            if(curr_num == patch_pointer){
                prev_sum += patch_pointer;
                nums_pointer++;
            }
            else if(curr_num > patch_pointer){
                patch_count++;
                prev_sum += patch_pointer;
            }
            else{
                prev_sum += nums[nums_pointer];
                nums_pointer++;
            }
            if((prev_sum+1) > 0)patch_pointer = (prev_sum+1);
            else return patch_count;  // critical point;
        }
        return patch_count;
    }
}
