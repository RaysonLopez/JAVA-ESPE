/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
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

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
