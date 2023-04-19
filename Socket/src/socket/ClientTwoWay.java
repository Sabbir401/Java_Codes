package socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientTwoWay {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("localhost", 5000);
        System.out.println("Client Connected at server Handshaking port " + s.
        getPort());

        System.out.println("Client’s communcation port " + s.getLocalPort());
        System.out.println("Client is Connected");
        System.out.println("Enter a messages: ");
        
        
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream input = new DataInputStream(s.getInputStream());
        
        String str1 = "";
        
        String str = "";
        while(!str.equals("stop")){   
            str = read.readLine();
            output.writeUTF(str);
            str1 = input.readUTF();
            System.out.println("Server Says: "+str1 );                                              
        }

        output.close();
        read.close();       
        input.close();      
        s.close();
    }
}