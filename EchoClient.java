import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        int port = 4243; 

        try {
            //Create a connection to the server by creating a socket
            
        } catch (IOException ioe) {
            System.out.println("Problem connecting" + ioe.getMessage()); 
        }
    }
}
