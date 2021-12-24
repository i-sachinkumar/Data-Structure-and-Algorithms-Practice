package Hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlmostSorted {
    public static void main(String[] args) {
        List<Integer> arr  = new ArrayList<>(List.of(1,5,4,3,2,6));
        almostSorted(arr);
    }

    public static void almostSorted(List<Integer> arr) {
        int l = 0;
        int r = 0;

        List<Integer> copy = List.copyOf(arr);

        Collections.sort(arr);
        int count = 0;
        for(int i = 0 ; i < arr.size(); i++ ){
            if(arr.get(i) != copy.get(i)){
                count++;
                if(count == 1) l = i;
                else if(count == 2) r = i;
                else{
                    break;
                }
            }
        }

        if(count == 2){
            System.out.println("yes");
            System.out.println("swap " + (l+1) + " " + (r+1));
            return;
        }

        int l1 = 0;
        int r1 = 0;
        for(int i = 0 ; i < copy.size()-1; i++){
            if(copy.get(i) > copy.get(i+1)){
                l1 = i;
                i++;
                while(i < copy.size()-1 && copy.get(i)>copy.get(i+1)){
                    i++;
                }
                r1 = i;
                if((l1 == 0 || copy.get(r1) > copy.get(l1-1)) &&
                        (r1 == copy.size()-1 || copy.get(l1) < copy.get(r1+1))){
                    break;
                }
                else{
                    System.out.println("no");
                    return;
                }
            }
        }

        for(int i = r1+1 ; i< copy.size()-1; i++){
            if(copy.get(i) > copy.get(i+1)){
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
        System.out.println("reverse " + (l1+1) + " " + (r1+1));

    }
}
