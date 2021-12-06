package Regexx;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegex {
    public static void main(String[] args) {


        // find:  1. lower case alphabet,
        // 2. upper case,
        // 3. numeric char,
        // 4. special char
        // in String "aBKciL@2#7.com"


        // lower case alphabet
        System.out.println("lower case alphabet");
        Pattern p1 = Pattern.compile("[a-z]");  // the patter which is to be searched in target String
        Matcher m1 = p1.matcher("aBKciL@2#7.Com");

        while(m1.find()){
            System.out.println(m1.start() + ": " + m1.group());
        }


        // upper case alphabet
        System.out.println("upper case alphabet");
        Pattern p2 = Pattern.compile("[A-Z]");  // the patter which is to be searched in target String
        Matcher m2 = p2.matcher("aBKciL@2#7.Com");

        while(m2.find()){
            System.out.println(m2.start() + ": " + m2.group());
        }

        // numeric char
        System.out.println("numeric char");
        Pattern p3 = Pattern.compile("[0-9]");  // the patter which is to be searched in target String
        Matcher m3 = p3.matcher("aBKciL@2#7.Com");

        while(m3.find()){
            System.out.println(m3.start() + ": " + m3.group());
        }


        // special char
        System.out.println("special char");
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");  //the patter which is to be searched in target String
        Matcher m4 = p4.matcher("aBKciL@2#7.Com");

        while(m4.find()){
            System.out.println(m4.start() + ": " + m4.group());
        }

/******************************* Quantifier ***********************************************************************/

        System.out.println("*********** Quantifier **************************************");
        Pattern p5 = Pattern.compile("a*");  // the patter which is to be searched in target String
        Matcher m5 = p5.matcher("abs@Aaabdaaaaabdbabbcuc");

        while (m5.find()){
            System.out.println(m5.start()+ ": " + m5.group() );
        }

        System.out.println("*********** Quantifier **************************************");
        Pattern p6 = Pattern.compile("a+");  // the patter which is to be searched in target String
        Matcher m6 = p6.matcher("abs@Aaabdaaaaabdbabbcuc");

        while (m6.find()){
            System.out.println(m6.start()+ ": " + m6.group() );
        }

/******************************* Split ***********************************************************************/
        System.out.println("***************** Split **********************************************");

        Pattern p7 = Pattern.compile("\\s");
        String[] s7 = p7.split("Hello Sachin, how are you?");
        System.out.println(Arrays.toString(s7));

        Pattern p8 = Pattern.compile("a");
        String[] s8 = p8.split("Hello Sachin, how are you?");
        System.out.println(Arrays.toString(s8));



/******************************* Mobile No. Validator ***********************************************************************/
        // Rules for 10 digit
        // 1. No. of digit should be 10
        // first digit should be 6, 7, 8, or 9

        // but number can also start with 0 or 91

        Pattern p9 = Pattern.compile("(0|91)?[6-9][0-9]{9}");
        Matcher m9 = p9.matcher("08474839435");
        if(m9.matches()) System.out.println("Valid Contact");
        else System.out.println("Invalid Contact");

/******************************* Email Validator ***********************************************************************/
        // patter should be like : xyz@abc.pqr

        Pattern p10 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m10 = p10.matcher("19b080022@iitb.ac.in");
        if(m10.matches()) System.out.println("Valid Email");
        else System.out.println("Invalid Email");


/******************************* Date Validator ***********************************************************************/

//        Pattern p11 = Pattern.compile("[0-3]/[0-2]/[1-2][0-9]{3}");
//        Matcher m11 = p11.matcher("2/2/2002");
//        if(m11.matches()) System.out.println("Valid DOB");
//        else System.out.println("Invalid DOB");

    }
}
