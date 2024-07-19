    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login.Controlador;

import ConexionBD.ConexionBDClientes;
import static ConexionBD.MongoBD.getCOLLECTIONCLIENTES_NAME;
import static ConexionBD.MongoBD.getDATABASE_NAME;
import Login.Modelo.ModeloClienteNuevo;
import Login.Vista.VistaClienteNuevo;
import Login.Vista.VistaLogin;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Rayson
 */
public final class ControladorClienteNuevo{
    private ModeloClienteNuevo model;
    private VistaClienteNuevo view;
    private ConexionBDClientes conexion;
    public ControladorClienteNuevo(VistaClienteNuevo view){
        view.InitComponents();
        this.view=view;
        this.conexion=new ConexionBDClientes();
        this.model=new ModeloClienteNuevo();
        this.model.setClientes(new ArrayList<>());

        view.saveTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTable();
            }
        });
        view.backMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backMenu();
            }
        });
        view.exitMenuAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitMenu();
            }
        });
        view.languajeCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chanceLanguaje();
            }
        });
        view.adjuntarButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adjuntarImage();
            }
        });
        view.modificateTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                modificateTable();
            }
        });
        view.deleteTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                deleteTable();
            }
        });
        view.confirmarEdicion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        view.confirmarEdicion.setVisible(false);
        view.errorNames.setVisible(false);
        view.errorCedula.setVisible(false);
        view.errorPhone.setVisible(false);
        view.errorContra.setVisible(false);
        view.errorEmail.setVisible(false);
        view.setDefaultCloseOperation(VistaLogin.EXIT_ON_CLOSE);
        Redimensionador(view.checkModificacion,"/IngresoClienteNuevo/Menu1.jpeg");
    }
         public  void Redimensionador(JComponent componente, String ruta) {
        ImageIcon imagenFondo = cargarImagen(ruta);
        Icon fondoRedimensionado = redimensionarImagen(imagenFondo, componente.getWidth(), componente.getHeight());
        aplicarImagen(componente, fondoRedimensionado);
        centrarVentana();
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
            // Manejar otros tipos de componentes si es necesario
            // Por ejemplo, podrías lanzar una excepción o hacer algo por defecto
            throw new IllegalArgumentException("El componente debe ser un JLabel o JButton");
        }
    }

    // Centrar la ventana relativa a la pantalla
    private void centrarVentana() {
        view.setLocationRelativeTo(null);
    }
public void saveTable(){ 
             // Obtener los datos ingresados
    model.setCI(view.cedulaText.getText());
    model.setContra(view.contraText.getText());
    model.setNombres(view.namesText.getText()); 
    model.setTelf(view.phoneText.getText());
    model.setMail(view.emailText.getText());
    model.setGenero(view.generoCombo.getSelectedItem().toString());
    String diaB=view.diaCombo.getSelectedItem().toString();
    String mesB=view.mesCombo.getSelectedItem().toString();
    String anioB=view.anioCombo.getSelectedItem().toString();
    model.setFecha(diaB+"/"+mesB+"/"+anioB);
    // Si todos los campos son válidos, agregar a la tabla
    if (validateData()) {
  
            ImageIcon imageIcon=convertirBytesAImagen(model.getImagen());
            
            DefaultTableModel tableModel=(DefaultTableModel)view.tablaMongo.getModel();
            tableModel.addRow(new Object[]{
                imageIcon,
                model.getCI(),
                model.getNombres(),
                model.getTelf(),
                model.getMail(),
                model.getGenero(),
                model.getFecha()
            });
            view.tablaMongo.setModel(tableModel);
            GuardarTablaMongo();
            // Limpiar los campos de entrada
            view.namesText.setText("");
            view.phoneText.setText("");
            view.cedulaText.setText("");
            view.contraText.setText("");
            view.emailText.setText("");
            view.errorImagen.setText("<html>\n" +"<p>\n" +"  Seleccione una imagen con las siguientes características:<br>\n" +"  Formato: JPG, JPEG, PNG<br>\n" +"  Tamaño: 413 x 531 píxeles\n" +"</p>\n" +"</html>");
            view.generoCombo.setSelectedIndex(0);
            view.mesCombo.setSelectedIndex(0); // Reiniciar el combo box de género
            view.anioCombo.setSelectedIndex(0);

    }else{
        JOptionPane.showMessageDialog(null,"Error, no se han ingresado todos los datos","Error",JOptionPane.ERROR_MESSAGE);
    }
    }
    public ImageIcon convertirBytesAImagen(byte[] imageData){
        ByteArrayInputStream bis=new ByteArrayInputStream(imageData);
        try{
            BufferedImage bImage=ImageIO.read(bis);
            return new ImageIcon(bImage);
            
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void chanceLanguaje(){
    String selectedLanguage = (String) view.languajeCombo.getSelectedItem();
    if ("Español".equals(selectedLanguage)) {
        // Configurar los textos en español
        view.NombresLabel.setText("Nombre y Apellido");
        view.cedulaLabel.setText("Cedula");
        view.emailLabel.setText("Email");
        view.telfLabel.setText("Teléfono");
        view.genderLabel.setText("Género");
        view.errorNames.setText("Error, tiene que tener un nombre y un apellido");
        view.errorCedula.setText("Cedula Incorrecto");
        view.errorPhone.setText("Teléfono incorrecto");
        view.errorContra.setText("Email incorrecto");
        view.saveTable.setText("GUARDAR");
        view.exitMenuAdd.setText("Salir");
        view.backMenu.setText("Regresar");
        view.exitMenu.setText("Salir");
        view.adjuntarButtom.setText("Adjuntar Imagen de Perfil");
        view.contraLabel.setText("Contraseña");
        view.diaLabel.setText("Día");
        view.mesLabel.setText("Mes");
        view.anioLabel.setText("Año");
        view.languajeCombo.setToolTipText("Seleccione el idioma");
    } else if ("English".equals(selectedLanguage)) {
 // Configurar los textos en inglés
        view.NombresLabel.setText("Full Name");
        view.cedulaLabel.setText("ID");
        view.emailLabel.setText("Email");
        view.telfLabel.setText("Phone");
        view.genderLabel.setText("Gender");
        view.errorNames.setText("Error: must have a first and last name");
        view.errorCedula.setText("Incorrect ID");
        view.errorPhone.setText("Incorrect phone");
        view.errorContra.setText("Incorrect email");
        view.saveTable.setText("SAVE");
        view.exitMenuAdd.setText("Exit");
        view.anioLabel.setText("Year");
        view.backMenu.setText("Back");
        view.exitMenu.setText("Exit");
        view.adjuntarButtom.setText("Attach Profile Picture");
        view.contraLabel.setText("Password");
        view.diaLabel.setText("Day");
        view.mesLabel.setText("Month");
        view.languajeCombo.setToolTipText("Select language");
    }

    // Forzar la actualización de la interfaz
    view.revalidate();
    view.repaint();
    }
    public void GuardarTablaMongo(){
    // Crear instancia de MongoDBManager (asegúrate de importar la clase correcta)
    ConexionBD.ConexionBDClientes manager = new ConexionBD.ConexionBDClientes();
    
    // Crear objeto ModeloClienteNuevo con los datos ingresados por el usuario
    String ID = view.cedulaText.getText();
    String contra = view.contraText.getText();
    String nombres = view.namesText.getText();
    String telf = view.phoneText.getText();
    String mail = view.emailText.getText();
    String genero = view.generoCombo.getSelectedItem().toString();
    String fecha = view.diaCombo.getSelectedItem().toString() + "/" + view.mesCombo.getSelectedItem().toString() + "/" + view.anioCombo.getSelectedItem().toString();
    byte[] image = model.getImagen();
    
    ModeloClienteNuevo cliente = new ModeloClienteNuevo(ID, contra, nombres, telf, mail, genero, fecha, image);
    model.agregarCliente(cliente);
    // Guardar los datos en MongoDB
    try {
        manager.guardarDatos(model.getClientes());
        
    } catch (RuntimeException e) {
        JOptionPane.showMessageDialog(view, e.getMessage(), "Error al guardar en la base de datos Clientes", JOptionPane.ERROR_MESSAGE);
    }
    
    // Cerrar la conexión con MongoDB al finalizar
    manager.cerrarConexion();
}
    public void exitMenu(){
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
    private void backMenu(){
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
            // Ocultar la ventana actual
            if(confirm == JOptionPane.YES_OPTION){       
         view.setVisible(false);
             // Crear y mostrar la ventana de login
        new VistaLogin().setVisible(true);
        }
    }
   
    private void adjuntarImage(){
       JFileChooser fileChooser=new JFileChooser();
       fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
       fileChooser.setAcceptAllFileFilterUsed(false);
       FileNameExtensionFilter filter=new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp");
       fileChooser.setFileFilter(filter);
       
       int returnValue=fileChooser.showOpenDialog(null);
       if(returnValue==JFileChooser.APPROVE_OPTION){
           File selectedFile=fileChooser.getSelectedFile();
           try{
               BufferedImage image=ImageIO.read(selectedFile);
               ImageIcon icon=new ImageIcon(image);
               Image scaledImage = image.getScaledInstance(view.errorImagen.getWidth(), view.errorImagen.getHeight(), Image.SCALE_SMOOTH);
               
               view.errorImagen.setIcon(new ImageIcon(scaledImage));
               
               ByteArrayOutputStream bos=new ByteArrayOutputStream();
               ImageIO.write(image,"jpg", bos);
               byte[]imageData=bos.toByteArray();
               model.setImagen(imageData);
               

               
           }catch(IOException ex){
               JOptionPane.showMessageDialog(null,"Error al leer la imagen","Error",JOptionPane.ERROR_MESSAGE);
           }
       }
    }
    public ImageIcon getImageFromSelectedRow(){
        int row=view.tablaMongo.getSelectedRow();
        if(row!=-1){
            Object value=view.tablaMongo.getValueAt(row,0);
            if(value instanceof ImageIcon){
            return (ImageIcon)value;
            }else{
        JOptionPane.showMessageDialog(null,"La celda seleccionada no contienene una imagen");
            }
        }else{
                JOptionPane.showMessageDialog(null,"No se ha seleccionada niguna fila","Error",JOptionPane.ERROR_MESSAGE);
                }
        return null;
    }
    public void modificateTable(){
     int row = view.tablaMongo.getSelectedRow();
    if (row!= -1) {
        String ci = (String) view.tablaMongo.getValueAt(row, 1);
        ConexionBDClientes conexion = new ConexionBDClientes();
        MongoClient mongoClient = MongoClients.create(); // Se conecta al servidor local MongoDB por defecto
        MongoDatabase database = mongoClient.getDatabase(conexion.getDATABASE_NAME());
        MongoCollection<Document> collection = database.getCollection(conexion.getCOLLECTIONCLIENTES_NAME());
        Document filter = new Document("CI", ci);
        Document document = collection.find(filter).first();
        
        // Crear un objeto para almacenar los datos del documento
        ModeloClienteNuevo cliente = new ModeloClienteNuevo();
        cliente.setCI(ci);
        cliente.setNombres(document.getString("nombres"));
        cliente.setTelf(document.getString("telefono"));
        cliente.setMail(document.getString("email"));
        cliente.setGenero(document.getString("genero"));
        cliente.setFecha(document.getString("fecha"));
        byte[] imageData = document.get("imagen", byte[].class);
        ImageIcon imageIcon = new ImageIcon(imageData);
        view.errorImagen.setIcon(imageIcon);
        
        // Habilitar los campos para edición
        view.namesText.setEditable(true);
        view.phoneText.setEditable(true);
        view.emailText.setEditable(true);
        view.generoCombo.setEnabled(true);
        view.diaCombo.setEnabled(true);
        view.mesCombo.setEnabled(true);
        view.anioCombo.setEnabled(true);
        
        // Asignar los valores actuales a los campos de edición
        view.namesText.setText(cliente.getNombres());
        view.phoneText.setText(cliente.getTelf());
        view.emailText.setText(cliente.getMail());
        view.generoCombo.setSelectedItem(cliente.getGenero());
        String[] fechaParts = cliente.getFecha().split("/");
        view.diaCombo.setSelectedItem(fechaParts[0]);
        view.mesCombo.setSelectedItem(fechaParts[1]);
        view.anioCombo.setSelectedItem(fechaParts[2]);
        
        // Agregar un listener al botón de confirmar edición
        view.confirmarEdicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los nuevos valores de los campos de edición
                String nuevoNombres = view.namesText.getText();
                String nuevoTelf = view.phoneText.getText();
                String nuevoMail = view.emailText.getText();
                String nuevoGenero = view.generoCombo.getSelectedItem().toString();
                String nuevoDia = view.diaCombo.getSelectedItem().toString();
                String nuevoMes = view.mesCombo.getSelectedItem().toString();
                String nuevoAnio = view.anioCombo.getSelectedItem().toString();
                String nuevoFecha = nuevoDia + "/" + nuevoMes + "/" + nuevoAnio;
                
                // Actualizar el objeto cliente con los nuevos valores
                cliente.setNombres(nuevoNombres);
                cliente.setTelf(nuevoTelf);
                cliente.setMail(nuevoMail);
                cliente.setGenero(nuevoGenero);
                cliente.setFecha(nuevoFecha);
                
                // Actualizar el documento en la base de datos
                Document update = new Document("$set", new Document("nombres", nuevoNombres)
                      .append("telefono", nuevoTelf)
                      .append("email", nuevoMail)
                      .append("genero", nuevoGenero)
                      .append("fecha", nuevoFecha));
                collection.updateOne(filter, update);
                
                // Actualizar la tabla con los nuevos valores
                ((DefaultTableModel) view.tablaMongo.getModel()).setValueAt(nuevoNombres, row, 1);
                ((DefaultTableModel) view.tablaMongo.getModel()).setValueAt(nuevoTelf, row, 2);
                ((DefaultTableModel) view.tablaMongo.getModel()).setValueAt(nuevoMail, row, 3);
                ((DefaultTableModel) view.tablaMongo.getModel()).setValueAt(nuevoGenero, row, 4);
                ((DefaultTableModel) view.tablaMongo.getModel()).setValueAt(nuevoFecha, row, 5);
                
                // Deshabilitar los campos de edición
                view.namesText.setEditable(false);
                view.phoneText.setEditable(false);
                view.emailText.setEditable(false);
                view.generoCombo.setEnabled(false);
                view.diaCombo.setEnabled(false);
                view.mesCombo.setEnabled(false);
                view.anioCombo.setEnabled(false);
            }
        });
    }
    }
     
    private boolean validateData(){
     boolean isValid=true;
     if (!view.namesText.getText().matches("[A-Za-z]+\\s[A-Za-z]+")) {
        view.errorNames.setText("Error: tiene que tener un nombre y un apellido");
        view.errorNames.setVisible(true);
        isValid= false;
    } else {
        view.errorNames.setVisible(false);
    }

    if (!view.cedulaText.getText().matches("\\d{10}")) {
        view.errorCedula.setText("Error: el ID debe contener 10 dígitos");
        view.errorCedula.setVisible(true);
        isValid=false;
    } else {
        view.errorCedula.setVisible(false);
    }

    if (!view.phoneText.getText().matches("\\d{10}")) {
        view.errorPhone.setText("Error: el teléfono debe contener 10 dígitos");
        view.errorPhone.setVisible(true);
       isValid=false;
    } else {
        view.errorPhone.setVisible(false);
    }

    if (!view.emailText.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
        view.errorEmail.setText("Error: email incorrecto");
        view.errorEmail.setVisible(true);
        isValid=false;
    } else {
        view.errorEmail.setVisible(false);
    }
    if(view.contraText.getText().isEmpty()){
        view.errorContra.setText("Error: La Contrasenia es obligatoria");
        view.errorContra.setVisible(true);
        isValid= false;
    }else{
        view.errorContra.setVisible(false);
    }
    if(model.getImagen()==null){
        adjuntarImage();
        if(model.getImagen()==null){
            view.errorImagen.setText("Error: debe seleccionar una imagen");
            isValid= false;
        }else{
            view.errorImagen.setText("<html>\n" +"<p>\n" +"  Seleccione una imagen con las siguientes características:<br>\n" +"  Formato: JPG, JPEG, PNG<br>\n" +"  Tamaño: 413 x 531 píxeles\n" +"</p>\n" +"</html>");
        }
    }
    view.revalidate();
    view.repaint();
    return isValid;   
}
    public void deleteTable(){
         int row = view.tablaMongo.getSelectedRow();
        if (row != -1) {
            String ci=(String)view.tablaMongo.getValueAt(row,1);
            MongoClient mongoClient=MongoClients.create();
            MongoDatabase database=mongoClient.getDatabase(conexion.getDATABASE_NAME());
            MongoCollection<Document>collection=database.getCollection(conexion.getCOLLECTIONCLIENTES_NAME());
            Document filter=new Document("CI",ci); 
            collection.deleteOne(filter);
            conexion.close();
            ((DefaultTableModel)view.tablaMongo.getModel()).removeRow(row);
            
        }
    }
    
}
