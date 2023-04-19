
package Lab_report_4;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientHandler extends Thread {

    final Socket com_tunnel;

    final DataInputStream dis_tunnel;
    final DataOutputStream dos_tunnel;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.com_tunnel = s;
        this.dis_tunnel = dis;
        this.dos_tunnel = dos;

    }

    public void run() {
        while (true) {
            try {
                //dos_tunnel.writeUTF("What do you want [Date/Time]");
                String number1 = dis_tunnel.readUTF();
                int num1 = Integer.parseInt(number1);
                String number2 = dis_tunnel.readUTF();
                int num2 = Integer.parseInt(number2);
                String operator = dis_tunnel.readUTF();
                
                int total;
                String result;
                            
                
                if (operator.equals("Sum")) {
                    total = num1 + num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                } else if (operator.equals("Subtract")) {
                    total = num1 - num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                } else if (operator.equals("Multiplication")) {
                    total = num1 * num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                } else if (operator.equals("Division")) {
                    total = num1 / num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                } else if (operator.equals("Modules")) {
                    total = num1 % num2;
                    result = Integer.toString(total);
                    dos_tunnel.writeUTF(result);
                }

                System.out.println("Connection is Closing");
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