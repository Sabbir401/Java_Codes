
package Assignment_2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientOneWay {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000);
        System.out.println("Client Connected at server Handshaking port " + s.getPort());

        System.out.println("Client’s communcation port " + s.getLocalPort());
        System.out.println("Client is Connected");
        
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        DataInputStream input = new DataInputStream(s.getInputStream());
        String str = "";
        String str1 = "";
         while(!str.equals("stop")){
            str=read.readLine();
            output.writeUTF(str);
            str1 = input.readUTF();
            System.out.println("Server say's: " +str1);
            
            
        }

        output.close();
        read.close();
        s.close();
        input.close();
    }
}
