package tcp_server_runnable;

import requesthandlers.AbstractRequestHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import requesthandlers.FlipRequestHandler;

public class TCPServer {

    private int port;
    private AbstractRequestHandler requestHandler;

    public TCPServer(int port) {

        this.port = port;

    }

    public void start() {
        try (ServerSocket ss = new ServerSocket(port)) {

            while (true) {
                System.out.println("Server waiting....");
                Socket socket = ss.accept();
                System.out.println("Server has accepted a client on port " + socket.getPort());

                requestHandler = new FlipRequestHandler(socket);

                new Thread(requestHandler).start();

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TCPServer server;
        server = new TCPServer(3333);
        server.start();
    }

}
