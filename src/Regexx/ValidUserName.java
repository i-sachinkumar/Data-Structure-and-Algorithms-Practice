package Regexx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Valid User name :
 * 1. no. of characters should be in range [8-30]
 * 2. only alphanumeric chars are allowed along with _ (underscore)
 * 3. first char should be alphabet only (upper or lower case)
 */

public class ValidUserName {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]{7,29}");
        //{7,29} is the range means after first valid char remaining 7 to 29 chars can be added

        Matcher m = p.matcher("i_SachinKumar91");

        if(m.matches()) System.out.println("valid username");
        else System.out.println("invalid username");
    }
}
