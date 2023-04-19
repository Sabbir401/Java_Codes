package LabReport4;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientHandler extends java.lang.Thread {
    //DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    //DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

    final Socket com_tunnel;

    final DataInputStream dis_tunnel;
    final DataOutputStream dos_tunnel;
    String received = "";
    String toreturn = "";

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.com_tunnel = s;
        this.dis_tunnel = dis;
        this.dos_tunnel = dos;

    }

    public void run() {
        while (true) {
            try {
                //dos_tunnel.writeUTF("What do you want [Date/Time]");
                received = dis_tunnel.readUTF();
                received = received.toUpperCase();
                dos_tunnel.writeUTF(received);

                System.out.println("Closing the connection");
                this.com_tunnel.close();
                break;

            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        try {
            this.dos_tunnel.close();
            this.dis_tunnel.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
