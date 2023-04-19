
package socket;
import java.io.DataInputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);

        System.out.println("Server is connected at port no: " + ss.getLocalPort());

        System.out.println("Server is connecting\n");
        System.out.println("Waiting for the client\n");
        Socket s = ss.accept();
        System.out.println("Client request is accepted at port no: " + s.getPort());

        System.out.println("Server’s Communication Port: " + s.getLocalPort());
        DataInputStream input = new DataInputStream(s.getInputStream());
        String str = "";
        
        
        
        String msg = input.readUTF();
        int n = Integer.parseInt(msg);
        String[] str_array = new String[n];
        int i=0,m=n;
        
        while (n>0) {
            str = input.readUTF();
            str_array[i]=str;
            i++;
            n--;
        }
        System.out.println("Client says: ");   
        for(int j=0;j<m;j++){
            System.out.println(str_array[j]);
        }
                
        s.close();
        input.close();       
    }
}