package NEW.Network;

import NEW.JSON;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

public class Main {
    public static void main(String[] args) throws Exception {
        Networking n = new Networking();
        String js = n.getText("https://www.instagram.com/ihrsachin");
        System.out.println(js);
    }
}
