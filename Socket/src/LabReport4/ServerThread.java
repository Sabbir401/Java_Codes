package LabReport4;

import java.io.*;
import java.net.*;

public class ServerThread {

    public static void main(String args[]) throws IOException {
        ServerSocket handshake = new ServerSocket(5022);
        System.out.println("Server connected at " + handshake.getLocalPort());
        System.out.println("Server is connecting\n");
        System.out.println("Wait for the client\n");
        int n = 0;

        while (n < 5) {
            Socket com_socket = handshake.accept();
            System.out.println("A new client is connected " + com_socket);
            DataOutputStream dos = new DataOutputStream(com_socket.
                    getOutputStream());

            DataInputStream dis = new DataInputStream(com_socket.getInputStream());

            System.out.println("A new thread is assigning");
            java.lang.Thread new_tunnel = new ClientHandler(com_socket, dis, dos);
            new_tunnel.start();
            n++;
        }

    }
}
