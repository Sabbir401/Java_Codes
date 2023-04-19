
package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        Socket s = new Socket("localhost", 5000);
        System.out.println("Client Connected at server Handshaking port " + s.getPort());

        System.out.println("Client’s communcation port " + s.getLocalPort());
        System.out.println("Client is Connected");
        System.out.println("Enter the number of message");
        int n = in.nextInt();
        System.out.println("Enter the messages that you want to send:");
        
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                              
        String str = "";
        String msg= Integer.toString(n);
        output.writeUTF(msg);
        while (n>0) {
            str = read.readLine();
            output.writeUTF(str);
            n--;           
        }
        output.close();
        read.close();
        s.close();
    }

}

