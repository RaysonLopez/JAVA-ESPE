package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ventana extends JFrame{
    public  JPanel panel;
    public ventana(){
        setSize(500, 500);//Establecemos el tamanio de la ventana
        
        setTitle("LA PRIMERA VENTANA");//establecemos el titulo de la ventana
        //setLocation(100, 200);//Establecemos la posicion principal de la ventana.
        //setBounds(100, 200, 500, 500);//Engloba el setSize y setLocation
        setLocationRelativeTo(null);//Establecemos la ventana del centro
        //Establecemos si se puede cambiar el tamanio o no
        setMinimumSize(new Dimension(200,200));//Establecemos el tamanio minimo
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Hacemos que cuando cierre la ventana , se cierra el  procesos
    }
    private void iniciarComponentes(){
         colocarPaneles();
         //colocarEtiquetas();
         colocarBotones();
    }
    private void colocarBotones(){
        JButton boton1=new JButton();
        boton1.setText("Click");//Estabelecemos un tezto para el boton
        boton1.setBounds(100, 100, 200, 60);
        boton1.setEnabled(true);//Esteblecemos la interracion del boton
        boton1.setMnemonic('a');
        boton1.setForeground(Color.GRAY);//Establecemos el color de la letra del boton
        boton1.setFont(new Font("arial",3,30));
        panel.add(boton1);
    }
    private void colocarPaneles(){
        panel= new JPanel();//Creacion de un panel
        //panel.setBackground(Color.GREEN);//Establecemos el color del panel
        panel.setLayout(null);//Desactivamos el disenio
        this.getContentPane().add(panel);//Agregamos el panel a la ventana
    }
    private void colocarEtiquetas(){
                //etiqueta.1 etiqueta tipo imagen
        JLabel etiqueta = new JLabel("Mundial 2018",SwingConstants.CENTER);//Creamos una etiqueta ademas de que la alineacion del texto
        //etiqueta.setText("Hola");//Establecemos el texto a la etiqueta
        etiqueta.setBounds(0, 0, 500, 100);//Establecemos el tamanio de la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);//Cambiamos el color de la letra
        //etiqueta.setOpaque(true);//Damos permiso para que pinte la etiqueta
        //etiqueta.setBackground(Color.YELLOW);//Cambiamos el color de la ventana
        etiqueta.setFont(new Font("cooper black",0,50));
        panel.add(etiqueta);//Agrergamos la etiqueta al panel
        //Etiqueta 2- etiqueta tipo imagen
        ImageIcon imagen=new ImageIcon("balon.jpg");
        JLabel etiqueta2= new JLabel();//Creamos etiqueta imagen
        etiqueta2.setBounds(80, 90,300, 300);
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(),etiqueta2.getHeight(),Image.SCALE_SMOOTH)));
        panel.add(etiqueta2);
    }
}