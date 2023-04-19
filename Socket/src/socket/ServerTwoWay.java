
package socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTwoWay {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket (5000);

        System.out.println("Server is connected at port no: " + ss.getLocalPort());

        System.out.println("Server is connecting\n");
        System.out.println("Waiting for the client\n");
        Socket s = ss.accept();
        System.out.println("Client request is accepted at port no: " + s.getPort());

        System.out.println("Server’s Communication Port: "+s.getLocalPort());
        

        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream input = new DataInputStream(s.getInputStream());
        
        String str1 = "";        
        String str = "";
        while(!str.equals("stop")){
            str = input.readUTF();
            System.out.println("Client Says: "+str );
            str1 = read.readLine();
            output.writeUTF(str1);
        }

        output.close();
        read.close();
        input.close();
        
        s.close();

    }

}
