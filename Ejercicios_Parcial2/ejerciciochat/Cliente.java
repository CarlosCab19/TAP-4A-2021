package ejerciciochat;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import ejerciciochat.HiloCliente;
public class Cliente extends JFrame implements ActionListener {
    Socket socket1;
    BufferedReader in;
    PrintWriter out;
    JPanel panelce,panelinf,panelsup;
    JButton btn_enviar,btn_salir;
    JTextArea area;
    JTextField escritura;
    JLabel titulo,leyendainf,leyendasup;
    String nombre;
    public Cliente() throws UnknownHostException, IOException {
        initComponents();
        nombre=JOptionPane.showInputDialog(null,"Ingrese su nombre de usuario");
        socket1 = new Socket("localhost", 5000);
        new HiloCliente(socket1,nombre);
    }
    
    public void initComponents(){
        this.setSize(500,600);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        try{
            Cliente c = new Cliente();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
