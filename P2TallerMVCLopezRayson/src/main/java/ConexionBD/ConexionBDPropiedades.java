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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Rayson
 */
public class ConexionBDPropiedades extends MongoBD implements MongoDBCRUD {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    public ConexionBDPropiedades(){
        crearConexion();
    }
     public void crearConexion(){
      try {
            // Establecer conexión con MongoDB
            mongoClient = MongoClients.create(); // Se conecta al servidor local MongoDB por defecto
            database = mongoClient.getDatabase(getDATABASE_NAME());
            collection=database.getCollection(getCOLLECTIONPROPIEDADES_NAME());
            System.out.println("Conexión exitosa a la base de datos: " + getDATABASE_NAME());
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

        try {
            // Crear un documento BSON con los datos
            Document documento = new Document()
                .append("Nombres Completos", datos[0])
                .append("CI", datos[1])
                .append("Telefono", datos[2])
                .append("Email", datos[3])
                .append("Genero",datos[4]);

            // Insertar el documento en la colección
            collection.insertOne(documento);
            System.out.println("Datos guardados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public void leerDatos(){
       // Realizar una consulta para obtener todos los documentos de la colección
        FindIterable<Document> documents = collection.find();

        // Obtener un cursor para iterar sobre los documentos
        MongoCursor<Document> cursor = documents.iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                // Extraer los campos relevantes del documento (nombre, id, telefono, email)
                String nombre = doc.getString("Nombres Completos");
                String id = doc.getString("CI");
                String telefono = doc.getString("Telefono");
                String email = doc.getString("Email");
                
                // Aquí puedes imprimir los datos o manejarlos según tus necesidades
                System.out.println("Nombre: " + nombre);
                System.out.println("ID: " + id);
                System.out.println("Teléfono: " + telefono);
                System.out.println("Email: " + email);
                System.out.println("----------------------");
            }
        } finally {
            // Cerrar el cursor correctamente
            cursor.close();
        }
    } 
    public void actualizarTablaMongo(DefaultTableModel tableModel) {
    // Create a MongoClient instance
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

    // Get the database and collection
    MongoDatabase database = mongoClient.getDatabase(getDATABASE_NAME());
    MongoCollection<Document> collection = database.getCollection(getCOLLECTIONPROPIEDADES_NAME());

    // Find all documents in the collection
    FindIterable<Document> documents = collection.find();

    // Create a list to store the data
    ArrayList<Object[]> data = new ArrayList<>();

    // Iterate over the documents and extract the data
    for (Document document : documents) {
        Object[] row = new Object[] {
            document.getString("Nombres Completos"),
            document.getString("CI"),
            document.getString("Telefono"),
            document.getString("Email"),
            document.getString("Genero")
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
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
    public void cerrarConexion() {
        // Cerrar la conexión con MongoDB
        mongoClient.close();
    }

    public void actualizarDatos(String[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarDatos(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean existeDocumento(String[] strings) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
