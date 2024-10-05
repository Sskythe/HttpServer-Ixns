import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable{
    private Socket clientSocket;
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    @Override
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(clientSocket.getOutputStream());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

            String requestLine = in.readLine();
            System.out.println("Request : " + requestLine);

            String  gethttpResponse = "HTTP/1.1 200 OK\r\n" + 
                        "Content-Tyep: Text/html\r\n"+
                        "\r\n"+
                        "<html><body> Welcome to the server</body></html>" ;
            out.write(gethttpResponse);
            out.flush();

            in.close();
            out.close();
            clientSocket.close();
        }catch(IOException e){
            e.getLocalizedMessage();
        }
    }
}