
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 
public class get {
    public static void main(String[] args) throws MalformedURLException,IOException {
        URL myUrl = new URL("https://g...content-available-to-author-only...u.bd");
 
        HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();
 
        conn.setRequestMethod("GET");
 
        int responseCode = conn.getResponseCode();
        System.out.print("Value of http created is: "+conn.HTTP_OK+"\n");
 
        if( responseCode == conn.HTTP_OK){
            System.out.println("The Response Code: "+responseCode);
            System.out.print("The response Message: "+conn.getResponseMessage()+"\n");
        }
        else{
            System.out.println("Get Lost");
        }
 
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
 
        BufferedReader buffer = new BufferedReader(in);
 
        StringBuffer fromServer = new StringBuffer();
 
        String eachLine = null;
 
        while((eachLine=buffer.readLine()) != null){
            fromServer.append(eachLine);
            fromServer.append(System.lineSeparator());
        }
        buffer.close();
        System.out.println("Here is our posted content: \n"+fromServer);
 
 
 
    }    
}
