import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Servidor
 */
public class Servidor {
    ServerSocket server;
    ArrayList<Socket> sockets;

    public Servidor() throws IOException {
        server = new ServerSocket(5000);
        sockets = new ArrayList<>();
    }

    public void start() throws IOException {
        while (true) {
            System.out.println("Escuchando un nuevo cliente");
            Socket cc = server.accept();
            sockets.add(cc);
            new Atendedor(cc, sockets).start();
        }
    }

    public static void main(String args[]) {
        try {
            Servidor s = new Servidor();
            s.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}