// The skeleton program for Server
import java.net.*;
import java.io.*;

public class Server
{
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    public Server(int port)
    {
        try{
            server = new ServerSocket(port);
            System.out.println("Server has started");

            System.out.println("Wait for client to connect ...");

            socket = server.accept();
            System.out.println("Client connection accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //message from client
            String line = '';
            //listen
            while(!line.equals("Done with connection"))
            {
                try{
                    line = in.readUTF();
                    System.out.println(line)}
            }
                catch(IOException i)
                { System.out.println(i);
                }
            }
            socket.close(); //closing the connection
            in.close();
            catch(IOException i)
            {
            System.out.println(i);
            }
    }
}

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}
