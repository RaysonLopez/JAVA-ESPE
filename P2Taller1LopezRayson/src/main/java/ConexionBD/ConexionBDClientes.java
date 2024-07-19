/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import Login.Modelo.ModeloClienteNuevo;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.types.Binary;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Rayson
 */
public class ConexionBDClientes extends MongoBD{
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private ModeloClienteNuevo model;
    public ConexionBDClientes (){
        model = new ModeloClienteNuevo();
        CrearConexion();
    }
     public void CrearConexion(){
      try {
            // Establecer conexión con MongoDB
            mongoClient = MongoClients.create(); // Se conecta al servidor local MongoDB por defecto
            database = mongoClient.getDatabase(getDATABASE_NAME());
            collection = database.getCollection(getCOLLECTIONCLIENTES_NAME());
            System.out.println("Conexión exitosa a la base de datos: " + getCOLLECTIONCLIENTES_NAME());
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    public void guardarDatos(List<ModeloClienteNuevo> clientes) {
    // Validar que la colección no sea nula
    if (collection == null) {
        System.err.println("La colección no está inicializada.");
        return;
    }
    for (ModeloClienteNuevo cliente : clientes) {

        try {
        if (existeDocumento(cliente)) {
            JOptionPane.showMessageDialog(null,"Error: Objeto duplicado","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            // Crear un documento BSON con los datos
            Document documento = new Document()
                .append("Imagen", cliente.getImagen())
                .append("CI", cliente.getCI())
                .append("Contrasenia", cliente.getContra())
                .append("Nombres Completos", cliente.getNombres())
                .append("Telefono", cliente.getTelf())
                .append("Email", cliente.getMail())
                .append("Genero", cliente.getGenero())
                .append("Fecha", cliente.getFecha());

            // Insertar el documento en la colección
            collection.insertOne(documento);
            JOptionPane.showMessageDialog(null, "Datos guardados en MongoDB correctamente.", "Guardar en MongoDB", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}
public boolean existeDocumento(ModeloClienteNuevo cliente) {
    Bson filter = Filters.or(
        Filters.eq("CI", cliente.getCI()),
        Filters.eq("Nombres Completos", cliente.getNombres()),
        Filters.eq("Telefono", cliente.getTelf()),
        Filters.eq("Email", cliente.getMail())
    );
    MongoCollection<Document> collection = database.getCollection(getCOLLECTIONCLIENTES_NAME());
    Document documento = collection.find(filter).first();
    return documento != null;
}
    public void leerDatos(){
    } 
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
    public void cerrarConexion() {
        // Cerrar la conexión con MongoDB
        mongoClient.close();
    }

    public void crearConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 public void actualizarEnBaseDeDatos(String ci, String nombres, String telf, String mail, String genero, String fecha, byte[] image) {
        ConexionBDClientes conexion = new ConexionBDClientes();
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase(getDATABASE_NAME());
        MongoCollection<Document> collection = database.getCollection(getCOLLECTIONCLIENTES_NAME());

        // Crear el documento actualizado
        Document updatedDocument = new Document()
                .append("CI", ci)
                .append("Nombres", nombres)
                .append("Telefono", telf)
                .append("Email", mail)
                .append("Genero", genero)
                .append("FechaNacimiento", fecha)
                .append("Imagen", image);

        // Filtro para identificar el documento a actualizar
        Document filter = new Document("CI", ci);

        // Actualizar el documento en la base de datos
        collection.updateOne(filter, new Document("$set", updatedDocument));

        conexion.cerrarConexion();
    }

    public void eliminarDatos(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actualizarTablaMongo(DefaultTableModel tableModel) {
        try {
        // Create a MongoClient instance
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

    // Get the database and collection
    MongoDatabase database = mongoClient.getDatabase(getDATABASE_NAME());
    MongoCollection<Document> collection = database.getCollection(getCOLLECTIONCLIENTES_NAME());

    // Find all documents in the collection
    FindIterable<Document> documents = collection.find();

    // Create a list to store the data
    ArrayList<Object[]> data = new ArrayList<>();

    // Iterate over the documents and extract the data
    for (Document document : documents) {
        Binary imageData=document.get("Imagen",Binary.class);
        byte[] imageBytes=imageData.getData();
        ByteArrayInputStream bais=new ByteArrayInputStream(imageBytes);
        BufferedImage image=ImageIO.read(bais);
        ImageIcon icon=new ImageIcon(image);
        Object[] row = new Object[] {
            icon,
            document.getString("CI"),
            document.getString("Nombres Completos"), 
            document.getString("Telefono"),
            document.getString("Email"),
            document.getString("Genero"),
            document.getString("Fecha")
        };
        data.add(row);
    }

    // Update the table model
    tableModel.setRowCount(0);
    for (Object[] row : data) {
        tableModel.addRow(row);
    }

    // Close the MongoClient instance
    mongoClient.close();
    
    } catch (MongoException e) {
        System.err.println("Error al conectar a MongoDB: " + e.getMessage());
    } catch (IOException e) {
        System.err.println("Error al leer la imagen: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Error desconocido: " + e.getMessage());
    }  
    }
     public String obtenerContra(String ci) {
        String contra = "";
        try {
            Document query = new Document("CI", ci);
            Document result = collection.find(query).first();
            if (result != null) {
                contra = result.getString("Contrasenia");
            }
        } catch (MongoException e) {
            System.err.println("Error al obtener la contraseña: " + e.getMessage());
        }
        return contra;
    }
}
