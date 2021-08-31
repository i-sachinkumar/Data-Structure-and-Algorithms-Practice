package Regexx;

import java.util.Scanner;

/**
 * Write a class called MyRegex which will contain a string pattern.
 * You need to write a regular expression and assign it to the pattern
 * such that it can be used to validate an IP address. Use the following definition of an IP address:
 *
 * IP address is a string in the form "A.B.C.D",
 * where the value of A, B, C, and D may range from 0 to 255. Leading zeros are allowed.
 * The length of A, B, C, or D can't be greater than 3.
 * Some valid IP address:
 *
 * 000.12.12.034
 * 121.234.12.12
 * 23.45.12.56
 * Some invalid IP address:
 *
 * 000.12.234.23.23
 * 666.666.23.23
 * .213.123.23.32
 * 23.45.22.32.
 * I.Am.not.an.ip
 * In this problem you will be provided strings containing any combination
 * of ASCII characters. You have to write a regular expression to find the valid IPs.
 *
 * Just write the MyRegex class which contains a String .
 * The string should contain the correct regular expression.
 *
 * (MyRegex class MUST NOT be public)
 *
 * Sample Input
 *
 * 000.12.12.034
 * 121.234.12.12
 * 23.45.12.56
 * 00.12.123.123123.123
 * 122.23
 * Hello.IP
 * Sample Output
 *
 * true
 * true
 * true
 * false
 * false
 * false
 */

public class JavaRegex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String IP = in.next();
//            System.out.println(IP.matches(new MyRegex().pattern));
//        }
//        System.out.println((int)'9');
//        System.out.println('A' - 'a');
//        String s = "ytfyug";
//        System.out.println(s.substring(1).toUpperCase());
//
//
        int n = 5;
        int ans  = 0 ;
        for(int i = 0 ; i < 32 ; i++){
            if(((n>>i) & 1) == 1){
                ans = i;
            }
        }
        System.out.println(ans);

    }
}
class MyRegex {
    String num = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
    String pattern = num + "." +  num + "." +  num + "." + num;
}