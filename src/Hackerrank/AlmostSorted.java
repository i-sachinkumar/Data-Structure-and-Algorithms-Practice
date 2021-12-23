package Hackerrank;

import java.util.List;

public class AlmostSorted {
    public static void main(String[] args) {

        // TODO "yet to solve"
    }

    public static void almostSorted(List<Integer> arr) {
        int numOfSwap = 0;
        int l = 0;
        int r = 0;

        for(int i = 0 ; i < arr.size() -1; i++ ){
            for(int j = i+1 ; j < arr.size(); j++){
                if(arr.get(i) > arr.get(j)){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    l = i;
                    r = j;
                    numOfSwap++;
                }

                if(numOfSwap > 1){
                    l = -1;
                    r = -1;
                    break;
                }
            }
            if(l < 0) break;
        }

        if(l >= 0){
            System.out.println("yes");
            System.out.println("swap " + l + " " + r);
            return;
        }

        int l1 = 0;
        int r1 = 0;
        for(int i = 0 ; i < arr.size()-1; i++){
            if(arr.get(i) > arr.get(i+1)){
                l1 = i;
                i++;
                while(i < arr.size()-1 && arr.get(i)>arr.get(i+1)){
                    i++;
                }
                r1 = i;
                if((l1 == 0 || arr.get(r1) > arr.get(l1-1)) &&
                        (r1 == arr.size()-1 || arr.get(l1) < arr.get(r1+1))){
                    break;
                }
                else{
                    System.out.println("no");
                    return;
                }
            }
        }

        for(int i = r1+1 ; i< arr.size()-1; i++){
            if(arr.get(i) < arr.get(i+1)){
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
        System.out.println("reverse " + l1 + " " + r1);

    }
}
