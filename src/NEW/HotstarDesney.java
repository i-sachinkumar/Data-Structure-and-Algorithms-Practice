package NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * Q1.  method minX
 *      find minimum value x in which
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


        int[] arr = {0, 1, 1, 0, 0, 1, 0, 0, 0, 0};
        System.out.println(numOfClick(arr,30));
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



    public static int numOfClick(int[] arr, int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<10; i++){
            if(arr[i] == 1) list.add(i);
        }
        int[] ans = {0};
        numOfClick(list,n,1,(int)Math.sqrt(n),ans,0);
        return ans[0];
    }

    public static void numOfClick(List<Integer> arr, int n, int start, int end, int[] ans,int toAdd){
        if(start > end) return;
        if(n%start == 0 && isContain(arr,n/start)){
                ans[0] = ans[0] + numOfDigit(n/start)+toAdd;
                if(start != 1)numOfClick(arr,start,1,(int)Math.sqrt(start),ans,2);
        }
        numOfClick(arr, n,start+1,end,ans,0);
    }

    public static boolean isContain(List<Integer> arr, int n){
        while(n > 0){
            if(!arr.contains(n%10)) return false;
            n = n/10;
        }
        return true;
    }

    public static int numOfDigit(int n){
        if(n<10) return 1;
        return 1 + numOfDigit(n/10);
    }
}
