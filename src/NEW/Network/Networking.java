package NEW.Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Networking {
        public String getText(String url) throws Exception {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();

            return response.toString();
        }
}
