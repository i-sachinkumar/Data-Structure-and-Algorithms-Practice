package Arrays;

import java.util.*;


/**
 * Given an array A of N elements.
 * Find the majority element in the array.
 * A majority element in an array A of size N is an element
 * that appears more than N/2 times in the array.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 3
 * A[] = {1,2,3}
 * Output:
 * -1
 * Explanation:
 * Since, each element in
 * {1,2,3} appears only once so there
 * is no majority element.
 * Example 2:
 *
 * Input:
 * N = 5
 * A[] = {3,1,3,3,2}
 * Output:
 * 3
 * Explanation:
 * Since, 3 is present more
 * than N/2 times, so it is
 * the majority element.
 *
 * Your Task:
 * The task is to complete the function
 * majorityElement() which returns the majority element in the array.
 * If no majority exists, return -1.
 *
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 */

public class MajorityElement {
    public static void main(String[] args) {

        int[] a = {2,7,4,5,5,6,7,7,7,7,7};
        int size = a.length;

        System.out.println(majorityElement(a,size));

    }


    // Method
    // O(size) solution
    static int majorityElement(int[] a, int size)
    {
        Map<Integer,Integer> m = new HashMap<>();
        int maxKey = 0;
        int maxOccur = 0;
        for(int i = 0 ; i < size ; i++){
            if(m.containsKey(a[i])){
                int prevCount = m.get(a[i]);
                m.replace(a[i],prevCount+1);
                maxOccur = Math.max(prevCount+1,maxOccur);
                if(maxOccur == prevCount+1){
                    maxKey = a[i];
                }
            }
            else{
                m.put(a[i],1);
                if(maxOccur == 0){
                    maxOccur++;
                    maxKey = a[i];
                }
            }
        }

        if(maxOccur > size/2) return maxKey;
        return -1;
    }
}
