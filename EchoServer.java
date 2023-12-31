import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterInfo;

public class EchoServer {
    public static void main(String[] args) {
        int port = 4243; 

        if(args.length > 0) port = Integer.parseInt(args[0]); 
        try {
            //Server socket which does not need of ip address cause we use the machine's address
            ServerSocket sock = new ServerSocket(port);

            //Show connection by printing port
            System.out.println("The port used is " + sock.getLocalPort()); 

            String message = "";

            while(!message.equalsIgnoreCase("quit")) {
                //Accept connection with the client
                Socket client = sock.accept(); 

                //Print the client's port
                System.out.println("The remote client's port is " + client.getPort()); 

                //Read message from the client
                Scanner input = new Scanner(client.getInputStream());
                message = input.nextLine(); 

                //Send message to client
                PrintWriter output = new PrintWriter(client.getOutputStream());
                String response = "Message received. The message was " + message; 
                output.println(response);
                output.flush();

                //Close streams
                input.close();
                output.close();
                client.close();
            }

            sock.close();
        } catch (IOException ioe) {
            System.out.println("Problem connecting" + ioe.getMessage()); 
        }
    }
}
