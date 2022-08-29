package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Amazon {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        initialize();

        while (t-- >0) {
            String[] arr_str = br.readLine().split(" ");
            int p = Integer.parseInt(arr_str[0]);
            int q = Integer.parseInt(arr_str[1]);
            int n = Integer.parseInt(arr_str[2]);

            System.out.println(z_seq(p,q,n));

        }
    }

    static int z_seq(int p, int q, int n){
        int z = 2;
        for (int i = 1; i <= n; i++) {
            int c = countSetBits(z);
            z = p*c + q;
        }
        return countSetBits(z);
    }

    // Lookup table
    static int[] BitsSetTable256 = new int[256];

    // Function to initialise the lookup table
    public static void initialize()
    {

        // To initially generate the
        // table algorithmically
        BitsSetTable256[0] = 0;
        for (int i = 0; i < 256; i++) {
            BitsSetTable256[i] = (i & 1) + BitsSetTable256[i / 2];
        }
    }

    // Function to return the count
    // of set bits in n
    public static int countSetBits(int n)
    {
        return (BitsSetTable256[n & 0xff]
                + BitsSetTable256[(n >> 8) & 0xff]
                + BitsSetTable256[(n >> 16) & 0xff]
                + BitsSetTable256[n >> 24]);
    }

//    static int countSetBits(int n)
//    {
//        // base case
//        if (n == 0)
//            return 0;
//        else
//            // if last bit set add 1 else add 0
//            return (n & 1) + countSetBits(n >> 1);
//    }

    static long getMinimumCost(int[] parcel, int k){
        if(parcel.length >= k) return 0;

        Arrays.sort(parcel);

        int curr_parcel = parcel.length;
        long min_cost = 0;

        int j  = 0;
        for(int i = 1; curr_parcel < k ; curr_parcel++, i++){
            if(j <parcel.length && parcel[j] == i){
                j++;
                curr_parcel--;
            }
            else{
                min_cost += i;
            }
        }

        return min_cost;

    }

    static int sumOfMinAbsDifferences(int[] arr, int n) {
        Arrays.sort(arr);
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
            {
                int tmp_sum = 0;
                for (int k = 0; k < n; k++)
                {
                    tmp_sum += Math.min(Math.abs(arr[k] - arr[i]), Math.abs(arr[k] - arr[j]));
                }
                sum = Math.min(sum, tmp_sum);
            }
        return sum;
    }
}
