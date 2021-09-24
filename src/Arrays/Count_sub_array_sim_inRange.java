package Arrays;


public class Count_sub_array_sim_inRange {
    public static void main(String[] args) {


        long[] arr = {2, 4, 6, 8, 10};
        int n = arr.length;

        long a = 2;
        long b = 5;

        long count = MaxSubArraySum(arr, n, b) - MaxSubArraySum(arr, n, a-1);

        System.out.println(count);
    }


    static long MaxSubArraySum(long[] arr, long n,long x)
    {
        // Starting index of
        // sliding window.
        int st = 0;

        // Ending index of
        // sliding window.
        int end = 0;

        // Sum of elements currently
        // present in sliding window.
        long sum = 0;

        // To store required
        // number of subArrays.
        long count = 0;

        // Increment ending index
        // of sliding window one
        // step at a time.
        while (end < n)
        {

            // Update sum of sliding
            // window on adding a
            // new element.
            sum += arr[end];

            // Increment starting index
            // of sliding window until
            // sum is greater than x.
            while (st <= end && sum > x)
            {
                sum -= arr[st];
                st++;
            }

            // Update count of
            // number of subArrays.
            count += (end - st + 1);
            end++;
        }

        return count;
    }

}
