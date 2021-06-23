package ejerciciochat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.DimensionUIResource;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor extends JFrame implements ActionListener {
    JButton btn_reiniciar,btn_salir;
    JPanel panelce,panelinf,panelsup;
    JLabel lbl_titulo,lbl_options,lbl_center;
    JTextArea area;
    ServerSocket server;
    String texto=" \t\nS E R V I D O R\n";
    JScrollPane scroll;
    int cont=0;
    public Servidor()throws IOException{
        super("Servidor");
        server=new ServerSocket(5000);
        texto+="\n-> Servidor en funcionamiento\n";
        initComponents();
    }
    public void start()throws IOException{
        texto="";
        while(true) {
            cont++;
            texto+="\n-> Escuchando un nuevo cliente\n";
            Socket cc = server.accept();
            HiloServidor hilo=new HiloServidor(cc,cont);
            hilo.start();
            texto+=hilo.getIp();
            area.append(texto);
            texto="";
        }
    }
    public void initComponents(){
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5,5));
        //PANEL CENTRAL
        panelce=new JPanel();
        area=new JTextArea();
        area.setEditable(false);
        scroll=new JScrollPane(area);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new DimensionUIResource(450,500));
        panelce.add(scroll);
        area.append(texto);
        this.add(panelce,BorderLayout.CENTER);
        //PANEL SUPERIOR
        panelsup=new JPanel();
        panelsup.setBackground(new Color(46, 64, 83));
        Font fuente= new Font("",3,25);
        lbl_titulo=new JLabel("SERVIDOR DEL CHAT");
        lbl_titulo.setFont(fuente);

        lbl_titulo.setForeground(Color.WHITE);
        panelsup.add(lbl_titulo);
        this.add(panelsup,BorderLayout.NORTH);
        //PANEL INFERIOR
        panelinf=new JPanel();
        panelinf.setLayout(new FlowLayout());
        panelinf.setBackground(new Color(13, 71, 161));
        btn_reiniciar=new JButton("Reiniciar");
        panelinf.add(btn_reiniciar);
        btn_salir=new JButton("Salir");
        panelinf.add(btn_salir);
        this.add(panelinf,BorderLayout.SOUTH);
        try {
            start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    public static void main(String[] args) {
        try {
            Servidor serv=new Servidor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
