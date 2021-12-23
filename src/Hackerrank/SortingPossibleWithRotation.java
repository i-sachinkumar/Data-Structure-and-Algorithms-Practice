package Hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SortingPossibleWithRotation {
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>(List.of(1,2,3,5,4));
        List<Integer> a2 = new ArrayList<>(List.of(1,6,5,2,4,3));

        System.out.println(larrysArray(a1));
        System.out.println(larrysArray(a2));
    }

    public static String larrysArray(List<Integer> A) {
        int n = A.size();
        int[] a = new int[n];

        for(int i = 0 ; i < n; i++){
            a[i] = A.get(i);
        }

        // num of swap used to sort the array
        // remember array of size n contain all natural num from 1 to n in any order
        // after sorting, at i+1 will be there at ith position (0-based indexing)
        int inversion = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n; j++ ){
                if(a[j] == i+1){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    if(i != j)inversion++;
                }
            }
        }

        // during rotation, there is parity of num of inversion
        // if even num of swap is required to sort the array,
        // then it is sortable using 3-letter rotation
        if(inversion%2 == 0) return "YES";
        return "NO";
    }
}
