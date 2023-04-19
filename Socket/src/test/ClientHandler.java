/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientHandler extends Thread {
    //DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    //DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

    final Socket com_tunnel;

    final DataInputStream dis_tunnel;
    final DataOutputStream dos_tunnel;
    String received = "";
    String toreturn = "";
    int total;
    String result;

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
                int num1 = Integer.parseInt(received);
                received = dis_tunnel.readUTF();
                int num2 = Integer.parseInt(received);
                String operator = dis_tunnel.readUTF();

                if (operator.equals("sum")) {
                    total = num1 + num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                } else if (operator.equals("sum")) {
                    total = num1 - num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                } else if (operator.equals("sum")) {
                    total = num1 * num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                } else if (operator.equals("sum")) {
                    total = num1 / num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                }

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
