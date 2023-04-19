package test;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientThread {

    public static void main(String args[]) throws IOException {
        try {
            Socket clientsocket = new Socket("localhost", 5035);
            System.out.println("Connected at server Handshaking port "
                    + clientsocket.getPort());

            System.out.println("Client is connecting at Communication Port "
                    + clientsocket.getLocalPort());

            System.out.println("Client is Connected");
            Scanner scn = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(clientsocket.getOutputStream());

            DataInputStream dis = new DataInputStream(clientsocket.getInputStream());
            while (true) {

                String num1 = scn.nextLine();
                dos.writeUTF(num1);
                String num2 = scn.nextLine();
                dos.writeUTF(num2);
                String oparator = scn.nextLine();
                dos.writeUTF(oparator);

                if (oparator.equals("Exit")) {
                    System.out.println("Closing the connecting " + clientsocket);
                    clientsocket.close();
                    System.out.println("Connection Closed");
                    break;
                }

                String received = dis.readUTF();
                System.out.println(received);
            }
            dos.close();
            dis.close();
            clientsocket.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}