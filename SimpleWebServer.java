/*  open a port to listen
After listening it will return some kind of http response such as serving a static file



*/

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import java.io.IOException;

class SimpleWebServer{
    public static void main(String []args) throws IOException{

        // port no is assigned to the server
        int port = 8091;
        ServerSocket serverSocket = new ServerSocket(port);
        Date date = new Date();
        System.out.println(serverSocket.getLocalPort());          
      
        while(true){
            // wait for clients to connect through the defined port
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connection established at " + date);

            // Handles each client connection in a separate thread
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }
}