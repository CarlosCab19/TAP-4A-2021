package ejerciciochat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class HiloCliente extends Thread{
    Socket client;
    BufferedReader in;
    PrintWriter out;
    String nombre;
    public HiloCliente(Socket c,String nombre)throws IOException{
        this.client=c;
        this.nombre=nombre;
        in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        out=new PrintWriter(client.getOutputStream());
    }
    public String getNombre(){
        return nombre;
    }
    public void run(){
        while (true) {
            try {
                
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
    public void write(String mensaje) throws IOException {
        out.println(mensaje);
        out.flush();
        String line = in.readLine();
        System.out.println(line);
    }
    public void bye() throws IOException {
        in.close();
        out.close();
    }
}

