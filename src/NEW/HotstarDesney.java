package NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * Q.   find minimum value x in which
 *      if we add each element of a List<Integer> from left to right, the sum never go below 1
 */

public class HotstarDesney {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(-4);
        l.add(-7);
        l.add(6);l.add(-9);l.add(3);l.add(15);

        System.out.println(minX(l));
    }
   public static int minX(List<Integer> arr){
        int n = arr.size();
        int x = 0;
        for(int i = n-1; i>=0 ; i--){
            if(arr.get(i) >= 0){
               x = Math.min(0, x + arr.get(i));
            }
            else{
                x = x + arr.get(i);
            }
        }
        return -x + 1;
    }
}
