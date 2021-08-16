package NEW;

import java.util.ArrayList;

/** Change base from 2 to 6 */
public class ChangeOfBase {
    public static void main(String[] args) {
        boolean[] binary = {true, true, false, false,true,true};
        int[] a = changeBase(binary);
        for(int e : a){
            System.out.print(e+" ");
        }


    }
    static int[] changeBase(boolean[] binary){
        int decimal = 0;
        int pow = 0;
        for(int i = binary.length-1 ; i>=0 ; i--){
            if(binary[i]){
                decimal = decimal + (int)Math.pow(2,pow);
            }
            pow++;
        }
        ArrayList<Integer> hex = new ArrayList<>();
        while (decimal>0){
            hex.add(0,decimal%6);
            decimal /= 6;
        }
        int[] ans = new int[hex.size()];
        for(int i =0; i<hex.size(); i++){
            ans[i] = (int)hex.get(i);
        }
        return ans;
    }
}
