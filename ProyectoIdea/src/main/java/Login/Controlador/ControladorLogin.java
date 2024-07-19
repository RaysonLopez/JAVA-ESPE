/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login.Controlador;

import ConexionBD.ConexionBDClientes;
import static ConexionBD.MongoBD.getCOLLECTIONADMINS_NAME;
import static ConexionBD.MongoBD.getCOLLECTIONCLIENTES_NAME;
import static ConexionBD.MongoBD.getDATABASE_NAME;
import InterfaceMenuPrincipalView.MenuPrincipalAdmin;
import InterfaceMenuPrincipalView.MenuPrincipalCliente;
import Login.Vista.IngresoClienteNuevo;
import Login.Vista.Login;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Rayson
 */
public class ControladorLogin {
    private Login login;
    public ControladorLogin(Login login){
        this.login=login;
    }
    public ControladorLogin(){
        
    }
    public void Iniciar(Login ventana){
        String userId = ventana.id.getText().trim(); // Obtener el ID ingresado
        String userPassword = new String(ventana.password.getPassword()); // Obtener la contraseña ingresada
        if (userId.isEmpty()) {
            ventana.errorId.setText("El ID no puede estar vacío");
            ventana.errorId.setVisible(true);
        } else if (!userId.matches("\\d{10}")) {
            ventana.errorId.setText("ID debe contener exactamente 10 dígitos numéricos");
            ventana.errorId.setVisible(true);
        } else {
            ventana.errorId.setVisible(false);
        }

        // Verificar la contraseña
        if (userPassword.isEmpty()) {
            ventana.errorPassword.setText("La contraseña no puede estar vacía");
            ventana.errorPassword.setVisible(true);
        } else {
            ventana.errorPassword.setVisible(false);
        }

        // Si ambos campos son válidos, intentar el inicio de sesión
        if (ventana.errorId.isVisible() || ventana.errorPassword.isVisible()) {
            return; // No proceder si hay errores
        }
       ConexionBDClientes cliente=new ConexionBDClientes();
       MongoClient mongoClient = MongoClients.create(); // Se conecta al servidor local MongoDB por defecto
       MongoDatabase database = mongoClient.getDatabase(getDATABASE_NAME());
       MongoCollection<Document> collection = database.getCollection(getCOLLECTIONCLIENTES_NAME());
        Document query=new Document("CI",userId).append("Contrasenia",userPassword);
        FindIterable<Document>result=collection.find(query);
        if (result.iterator().hasNext()) {
            JOptionPane.showMessageDialog(ventana, "Inicio de sesión exitoso.", "Login", JOptionPane.INFORMATION_MESSAGE);
            abrirMenuPrincipal(ventana); // Método para abrir la siguiente ventana

            // Reiniciar los campos después del inicio de sesión exitoso
            ventana.id.setText("");
            ventana.password.setText("");
            ventana.errorId.setVisible(false);
            ventana.errorPassword.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(ventana, "ID o contraseña incorrecta", "Login", JOptionPane.ERROR_MESSAGE);
            ventana.password.setText(""); // Limpiar el campo de contraseña en caso de error
        }
        MongoCollection<Document>collectionP=database.getCollection(getCOLLECTIONADMINS_NAME());
        Document queryA=new Document("Usuario",userId).append("Contrasenia",userPassword);
        FindIterable<Document>resultA=collectionP.find(queryA);
        if(resultA.iterator().hasNext()){
            JOptionPane.showMessageDialog(ventana,"Inicio exitoso ADMINISTRADOR");
            abrirMenuAdmin(ventana);
            ventana.id.setText("");
            ventana.password.setText("");
            ventana.errorId.setVisible(false);
            ventana.errorPassword.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(ventana,"ID o contraseña incorrecta","Login",JOptionPane.ERROR_MESSAGE);
        } 
    }
     private void abrirMenuAdmin(Login ventana){
        MenuPrincipalAdmin menu=new MenuPrincipalAdmin();
        menu.setVisible(true);
        ventana.setVisible(false);
        
    }
     private void abrirMenuPrincipal(Login ventana) {
        // Crear una instancia de menuPrincipal y hacerla visible
        MenuPrincipalCliente menu = new MenuPrincipalCliente();
        menu.setVisible(true);
        // Ocultar la ventana de login actual
        ventana.setVisible(false);
    }
         public void abrirIngresoClientes(Login ventana) {
        // Crear una instancia de menuPrincipal y hacerla visible
        IngresoClienteNuevo menu = new IngresoClienteNuevo();
        menu.setVisible(true);
        // Ocultar la ventana de login actual
        ventana.setVisible(false);
    }
    public void MensajeConfirmacion(JFrame ventana){
                int confirm = JOptionPane.showOptionDialog(
            ventana,
            "¿Estás seguro de que quieres salir?",
            "Confirmación de salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"Sí", "No"},
            "No"
        );

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
     public void Redimensionador(JComponent componente, String ruta,JFrame ventana) {
        ImageIcon imagenFondo = cargarImagen(ruta);
        Icon fondoRedimensionado = redimensionarImagen(imagenFondo, componente.getWidth(), componente.getHeight());
        aplicarImagen(componente, fondoRedimensionado);
        centrarVentana(ventana);
    }

    // Cargar la imagen desde la ruta especificada
    private ImageIcon cargarImagen(String ruta) {
        return new ImageIcon(getClass().getResource(ruta));
    }

    // Redimensionar la imagen a las dimensiones especificadas
    private Icon redimensionarImagen(ImageIcon imagen, int ancho, int alto) {
        return new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
    }

    // Aplicar la imagen al componente, si es un JLabel
    private void aplicarImagen(JComponent componente, Icon imagen) {
        if (componente instanceof JLabel) {
            ((JLabel) componente).setIcon(imagen);
        } else if (componente instanceof JButton) {
            ((JButton) componente).setIcon(imagen);
        } else {
            throw new IllegalArgumentException("El componente debe ser un JLabel o JButton");
        }
    }

    // Centrar la ventana relativa a la pantalla
    private void centrarVentana(JFrame ventana) {
        ventana.setLocationRelativeTo(null);
    }
    public void CambioDeLenguaje(Login ventana){
         String selectedLanguage = (String) ventana.languaje.getSelectedItem();
    if ("Español".equals(selectedLanguage)) {
        // Textos en español
        ventana.login.setText("Ingresar");
        ventana.usuarioL.setText("USUARIO");
        ventana.passwordL.setText("PASSWORD");
        ventana.errorId.setText("ID Invalido");
        ventana.errorPassword.setText("Password Incorrecta");
        ventana.ButtomIniciar.setText("Ingresar");
        ventana.exitButton.setText("Salir");
        ventana.CheckMostrarContra.setText("Mostrar Contrasenia");
    } else if ("Ingles".equals(selectedLanguage)) {
        // Textos en inglés
        ventana.login.setText("Login");
        ventana.usuarioL.setText("USER");
        ventana.passwordL.setText("PASSWORD");
        ventana.errorId.setText("Invalid ID");
        ventana.errorPassword.setText("Incorrect Password");
        ventana.ButtomIniciar.setText("Login");
        ventana.exitButton.setText("Exit");
        ventana.CheckMostrarContra.setText("Show Password");
    }
    // Forzar la actualización de la interfaz
    ventana.revalidate();
    ventana.repaint();
    }
}
