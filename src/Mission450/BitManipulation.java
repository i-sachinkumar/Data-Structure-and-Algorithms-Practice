package Mission450;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BitManipulation {
    public static void main(String[] args) {

        System.out.println(square(5));
        // to check
        for (int j = 1 ; j <= 20; j++) {
            int sum = 0;
            for (int i = 1; i <= j; i++) {
                sum += countSetBits(i);
            }
            System.out.println(j + " -> " + sum);
        }

        //System.out.println(xorTillOpt(13));

        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(32));

        // to check
        int xor = 0;
        for(int i = 1; i <= 20; i++){
            System.out.println(i + " -> " + (xor^i));
            xor = xor^i;
        }
    }

    /**
     * 1^1 = 0;
     * 0^0 = 0;
     * 1^0 = 1;
     * 0^1 = 1;
     */
    public static int xorTill(int n){
        int xor = 0;
        for(int i = 1; i < n ; i++){
            xor = xor^i;
        }
        return xor;
    }
    public static int xorTillOpt(int n){
        if (n%4 == 0) return n;
        if(n%4 == 3) return 0;
        if(n%4 == 2) return n+1;
        return 1;
    }


    //Qs: https://practice.geeksforgeeks.org/problems/set-bits0143/1
    static int countSetBits(int n) {
        int count = 0;
        while(n > 0){
            n = n&(n-1);
            count++;
        }
        return count;
    }


    //Two Non Repeating Numbers
    //Qs: https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1
    public int[] singleNumber(int[] nums){
        int xor = 0;
        for(int i: nums) xor = xor^i;
        //System.out.println(xor);
        int diff = 0;
        for(int i = 0 ; i < 32; i++){
            if((xor&(1<<i)) != 0){
                diff = i;
                break;
            }
        }
        //System.out.println(diff);
        int a = 0, b = 0;
        for(int i: nums){
            if(((1<<diff)&i) == 0) a = a^i;
            else b = b^i;
        }
        return new int[]{Math.min(a,b), Math.max(a,b)};
    }


    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        if(n == 0) return false;
        return (n&(n-1)) == 0;
    }


    //Find position of set bit
    static int findPosition(int n) {
        if(n == 0) return -1;
        if((n&(n-1)) != 0) return -1;
        int ind = 0;
        while(((1<<ind)&n) == 0){
            ind++;
        }
        return ind+1;
    }


    //Qs: https://practice.geeksforgeeks.org/problems/copy-set-bits-in-range0623/1
    static int setSetBit(int x, int y, int l, int r){
        int mask = 0;
        for(int i = l-1 ; i < r ; i++){
            mask = mask|(y&(1<<i));
        }
        //System.out.println(mask);
        return (mask)|x;
    }



    static int square(int n) {
        // Base case
        if (n == 0)
            return 0;

        // Handle negative number
        if (n < 0)
            n = -n;

        // Get floor(n/2) using
        // right shift
        int x = n >> 1;

        // If n is odd
        ;
        if (n % 2 != 0)
            return ((square(x) << 2) + (x << 2) + 1);
        else // If n is even
            return (square(x) << 2);
    }
}
