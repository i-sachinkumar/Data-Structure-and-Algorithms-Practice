package gfg;

public class STRING {
    public static void main(String[] args) {

    }


    public static String largestOddNumber(String num) {
        for(int i = num.length()-1; i>=0 ; i--){
            if((num.charAt(i) - '0')%2 == 1){
                return num.substring(0, i+1);
            }
        }
        return "";
    }

    String longestCommonPrefix(String[] arr, int n){
        // code here
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; true; i++){
            boolean found = true;
            if(i >= arr[0].length()) return ans.toString();
            char c = arr[0].charAt(i);
            for(String word : arr){
                if(i >= word.length()) return ans.toString();
                found = word.charAt(i) == c;
                if(!found) break;
            }
            if(!found) break;
            ans.append(c);
        }

        if(ans.length() > 0) return ans.toString();
        return "-1";
    }


}
