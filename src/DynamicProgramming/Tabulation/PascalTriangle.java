package DynamicProgramming.Tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(5);

        for(int i = 0 ; i < numRows; i++){
            ans.add(new ArrayList<>(Collections.nCopies(i+1, 0)));
        }
        ans.get(0).set(0, 1);

        for(int i = 0 ; i < numRows; i++){
            for(int j = 0 ; j <= i ; j++){
                if(i+1 < numRows){
                    int curr = ans.get(i).get(j);
                    ans.get(i+1).set(j,curr+ans.get(i+1).get(j));
                    if(j+1 <= i+1) ans.get(i+1).set(j+1,curr+ans.get(i+1).get(j+1));
                }
            }
        }
        return ans;
    }

}
