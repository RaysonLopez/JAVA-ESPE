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
import org.bson.Document;
/**
 *
 * @author Rayson
 */
public class ConexionBD {
    private static final String DATABASE_NAME = "MiPrimerDataBase"; // Nombre de tu base de datos
    private static final String COLLECTION_NAME = "clientes"; // Nombre de tu colección
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    
    public ConexionBD() {
        // Establecer conexión con MongoDB
        mongoClient = MongoClients.create(); // Se conecta al servidor local MongoDB por defecto
        database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }
    public void guardarDatos(String[] datos) {
        // Crear un documento BSON con los datos
        Document documento = new Document()
                .append("nombre", datos[0])
                .append("id", datos[1])
                .append("telefono", datos[2])
                .append("email", datos[3]);
        
        // Insertar el documento en la colección
        collection.insertOne(documento);
    }
    public void cerrarConexion() {
        // Cerrar la conexión con MongoDB
        mongoClient.close();
    }
    public MongoDatabase getDatabase() {
        return database;
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
                String nombre = doc.getString("nombre");
                String id = doc.getString("id");
                String telefono = doc.getString("telefono");
                String email = doc.getString("email");

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
    
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
