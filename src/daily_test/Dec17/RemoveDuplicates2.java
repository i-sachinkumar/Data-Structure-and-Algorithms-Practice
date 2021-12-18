package daily_test.Dec17;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};

        int k = removeDuplicates(a);
        for(int i = 0 ; i < k ; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        int[] temp = new int[n];

        System.arraycopy(nums, 0, temp, 0, n);

        if(n <= 2) return n;

        int fast = 1;
        int slow = 0;

        while(fast < n){
            if(temp[fast] != temp[fast-1]){
                nums[slow+1] = nums[fast];
                slow++;
                fast++;
            }
            else{
                if(fast-2 >=0 && temp[fast] == temp[fast-2]){
                    fast++;
                }
                else{
                    nums[slow+1] = nums[fast];
                    slow++;
                    fast++;
                }
            }
        }
        return slow+1;
    }
}
