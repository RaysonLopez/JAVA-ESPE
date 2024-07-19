/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.logging.Filter;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;
/**
 *
 * @author Rayson
 */
public class ConexionBDClientes extends MongoBD implements MongoDBCRUD{
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    public ConexionBDClientes (){
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
    public void guardarDatos(String[] datos) {
        // Validar que la colección no sea nula
        if (collection == null) {
            System.err.println("La colección no está inicializada.");
            return;
        }
        if(existeDocumento(datos)){
            throw new RuntimeException("Los datos ya existe en la base de datos");
        }
        try {
            // Crear un documento BSON con los datos
            Document documento = new Document()
                .append("CI", datos[0])
                .append("Contrasenia", datos[1])
                .append("Nombres Completos", datos[2])
                
                .append("Telefono", datos[3])
                .append("Email", datos[4])
                .append("Genero",datos[5])
                .append("Fecha",datos[6]);

            // Insertar el documento en la colección
            collection.insertOne(documento);
            System.out.println("Datos guardados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    public boolean existeDocumento(String[] datos){
        Bson filter=Filters.and(
         Filters.eq("CI",datos[0]),
         Filters.eq("Contrasenia",datos[1]),
         Filters.eq("Nombres Completos",datos[2]),
         
         Filters.eq("Telefono",datos[3]),
         Filters.eq("Email",datos[4]),
         Filters.eq("Genero",datos[5]),
         Filters.eq("Fecha",datos[6])
        );
        MongoCollection<Document>collection=database.getCollection(getCOLLECTIONCLIENTES_NAME());
        Document documento=collection.find(filter).first();
        
        return documento !=null;
                
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

    public void actualizarDatos(String[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarDatos(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actualizarTablaMongo(DefaultTableModel tableModel) {
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
        Object[] row = new Object[] {
            document.getString("CI"),
            document.getString("Contrasenia"),
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
    }
}
