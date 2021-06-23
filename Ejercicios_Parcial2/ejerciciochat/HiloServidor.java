package ejerciciochat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
public class HiloServidor extends Thread {
    Socket c;
    BufferedReader in;
    PrintWriter out;
    List<Socket> sockets;
    int cont;
    public HiloServidor(Socket client,int cont) throws IOException {
        this.cont=cont;
        this.c = client;
        //this.sockets = ss;
        in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        out = new PrintWriter(c.getOutputStream());
    }
    public String getIp(){
        InetAddress ip=c.getInetAddress();
        String texto="\nUsuario ("+cont+") se conecto desde:"+ip.getHostAddress();
        return texto;
    }
}
