/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login.Controlador;

import ConexionBD.ConexionBDClientes;
import static ConexionBD.MongoBD.getCOLLECTIONADMINS_NAME;
import static ConexionBD.MongoBD.getCOLLECTIONCLIENTES_NAME;
import static ConexionBD.MongoBD.getDATABASE_NAME;
import MenuPrincipal.View.MenuPrincipalAdmin;
import MenuPrincipal.View.MenuPrincipalCliente;
import Login.Modelo.ModeloLogin;
import Login.Vista.VistaClienteNuevo;
import Login.Vista.VistaLogin;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import org.bson.Document;

/**
 *
 * @author Rayson
 */
public class ControladorLogin implements ActionListener{
    private VistaLogin view;
    private ModeloLogin model;
    public ControladorLogin(VistaLogin view){
        view.InitComponents();
        this.view=view;
        this.model=new ModeloLogin();
        //Implementar los ActionListener a los botones que haya en la interfaz
        view.ButtomIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Iniciar();
            }
        });
        view.CheckMostrarContra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPassword();
            }
        });
        view.RegistrarseButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        view.exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        view.languajeCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chanceLanguaje();
            }
        });
        model = new ModeloLogin();
        model.setPrefs(Preferences.userRoot().node(this.getClass().getName()));
        String rememberedUserId = model.getPrefs().get("userId", "");
        if (!rememberedUserId.isEmpty()) {
        view.idText.setText(rememberedUserId);
        view.CheckMostrarContra.setSelected(true);
        }
        Redimensionador(view.FONDO, "/Login/LOGIN.png",view);
        view.setDefaultCloseOperation(VistaLogin.EXIT_ON_CLOSE);
        view.errorId.setVisible(false);
        view.errorPassword.setVisible(false);
    }

    public void Iniciar(){
        String userId = view.idText.getText().trim(); // Obtener el ID ingresado
        String userPassword = new String(view.passwordText.getPassword()); // Obtener la contraseña ingresada
        if (userId.isEmpty()) {
            view.errorId.setText("El ID no puede estar vacío");
            view.errorId.setVisible(true);
        } else if (!userId.matches("\\d{10}")) {
            view.errorId.setText("ID debe contener exactamente 10 dígitos numéricos");
            view.errorId.setVisible(true);
        } else {
            view.errorId.setVisible(false);
        }

        // Verificar la contraseña
        if (userPassword.isEmpty()) {
            view.errorPassword.setText("La contraseña no puede estar vacía");
            view.errorPassword.setVisible(true);
        } else {
            view.errorPassword.setVisible(false);
        }

        // Si ambos campos son válidos, intentar el inicio de sesión
        if (view.errorId.isVisible() || view.errorPassword.isVisible()) {
            return; // No proceder si hay errores
        }
        ConexionBDClientes cliente=new ConexionBDClientes();
    MongoClient mongoClient = MongoClients.create(); // Se conecta al servidor local MongoDB por defecto
    MongoDatabase database = mongoClient.getDatabase(getDATABASE_NAME());
    MongoCollection<Document> collection = database.getCollection(getCOLLECTIONCLIENTES_NAME());
    Document query=new Document("CI",userId).append("Contrasenia",userPassword);
    FindIterable<Document>result=collection.find(query);

    if (result.iterator().hasNext()) {
        Document clienteDoc = result.iterator().next();
        String nombreCliente = clienteDoc.getString("Nombres Completos");
        String apellidoCliente = clienteDoc.getString("Apellidos");
        String emailCliente = clienteDoc.getString("Email");
        String telefonoCliente = clienteDoc.getString("Telefono");

        // Guardar los datos del cliente en variables
        model.setNombreCliente(nombreCliente);
        model.setEmailCliente(emailCliente);
        model.setTelefonoCliente(telefonoCliente);

        JOptionPane.showMessageDialog(view, "Inicio de sesión exitoso.", "Login", JOptionPane.INFORMATION_MESSAGE);
        abrirMenuCliente(); // Método para abrir la siguiente ventana

        // Reiniciar los campos después del inicio de sesión exitoso
        view.idText.setText("");
        view.passwordText.setText("");
        view.errorId.setVisible(false);
        view.errorPassword.setVisible(false);
    } else {
        JOptionPane.showMessageDialog(view, "ID o contraseña incorrecta", "Login", JOptionPane.ERROR_MESSAGE);
        view.idText.setText("");
        view.passwordText.setText("");
    }

    MongoCollection<Document>collectionP=database.getCollection(getCOLLECTIONADMINS_NAME());
    Document queryA=new Document("Usuario",userId).append("Contrasenia",userPassword);
    FindIterable<Document>resultA=collectionP.find(queryA);
    if(resultA.iterator().hasNext()){
        Document adminDoc = resultA.iterator().next();
        String nombreAdmin = adminDoc.getString("Nombre");

        // Guardar los datos del administrador en variables
        model.setNombreAdmin(nombreAdmin);

        JOptionPane.showMessageDialog(view,"Inicio exitoso ADMINISTRADOR");
        abrirMenuAdmin();
        view.idText.setText("");
        view.passwordText.setText("");
        view.errorId.setVisible(false);
        view.errorPassword.setVisible(false);
    }else{
        JOptionPane.showMessageDialog(view,"ID o contraseña incorrecta","Login",JOptionPane.ERROR_MESSAGE);
    } 
    }
     private void abrirMenuAdmin(){
        MenuPrincipalAdmin menu=new MenuPrincipalAdmin();
        menu.setVisible(true);
        view.setVisible(false);
        
    }
     private void abrirMenuCliente() {
        // Crear una instancia de menuPrincipal y hacerla visible
        MenuPrincipalCliente menu = new MenuPrincipalCliente();
        menu.setVisible(true);
        // Ocultar la ventana de login actual
        view.setVisible(false);
    }
    public void register() {
        // Crear una instancia de menuPrincipal y hacerla visible
        VistaClienteNuevo menu = new VistaClienteNuevo();
        menu.setVisible(true);
        // Ocultar la ventana de login actual
        view.setVisible(false);
    }
    public void exit(){
                int confirm = JOptionPane.showOptionDialog(
            view,
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
    private void showPassword(){
               if (view.CheckMostrarContra.isSelected()) {
        view.passwordText.setEchoChar((char) 0); // Mostrar la contraseña
    } else {
        view.passwordText.setEchoChar('*'); // Ocultar la contraseña
    }
    }
    // Centrar la ventana relativa a la pantalla
    private void centrarVentana(JFrame ventana) {
        ventana.setLocationRelativeTo(null);
    }
    public void chanceLanguaje(){
         String selectedLanguage = (String) view.languajeCombo.getSelectedItem();
    if ("Español".equals(selectedLanguage)) {
        // Textos en español
        view.login.setText("Ingresar");
        view.usuarioL.setText("USUARIO");
        view.passwordL.setText("CONTRASEÑA");
        view.errorId.setText("ID Invalido");
        view.errorPassword.setText("Password Incorrecta");
        view.ButtomIniciar.setText("Ingresar");
        view.exitButton.setText("Salir");
        view.CheckMostrarContra.setText("Mostrar Contraseña");
        view.RegistrarseButtom.setText("REGISTRARSE");
        view.eresNuevoLabel.setText("Eres nuevo por aqui, Registrate");
        System.out.println("Se cambio el idioma a "+selectedLanguage);
    } else if ("Ingles".equals(selectedLanguage)) {
        // Textos en inglés
        view.login.setText("Login");
        view.usuarioL.setText("USER");
        view.passwordL.setText("PASSWORD");
        view.errorId.setText("Invalid ID");
        view.errorPassword.setText("Incorrect Password");
        view.ButtomIniciar.setText("Login");
        view.exitButton.setText("Exit");
        view.CheckMostrarContra.setText("Show Password");
        view.RegistrarseButtom.setText("REGISTER");
        view.eresNuevoLabel.setText("You are new here, Register");
        System.out.println("Se cambio el idioma a "+selectedLanguage);
    }
    // Forzar la actualización de la interfaz
    view.revalidate();
    view.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.ButtomIniciar){
            Iniciar();
        }else
        if(e.getSource()==view.CheckMostrarContra){
            showPassword();
        }else if(e.getSource()==view.RegistrarseButtom){
            register();
        }else if(e.getSource()==view.exitButton){
            exit();
        }else if(e.getSource()==view.languajeCombo){
            chanceLanguaje();
        }            
    }
}
