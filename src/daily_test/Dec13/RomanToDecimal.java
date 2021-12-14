package daily_test.Dec13;

// Qs. Link = {https://leetcode.com/problems/roman-to-integer/}

public class RomanToDecimal {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int num = 0;

        for(int i = 0 ; i < s.length()-1; i++){
            if(s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                num--;
            }
            else if(s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                num -= 10;
            }
            else if(s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                num -= 100;
            }
            else {
                num = getVal(s, num, i);
            }

        }

        int i = s.length()-1;

        num = getVal(s, num, i);

        return num;
    }

    private static int getVal(String s, int num, int i) {
        switch (s.charAt(i)) {
            case 'I' -> num++;
            case 'V' -> num += 5;
            case 'X' -> num += 10;
            case 'L' -> num += 50;
            case 'C' -> num += 100;
            case 'D' -> num += 500;
            case 'M' -> num += 1000;
        }
        return num;
    }
}
