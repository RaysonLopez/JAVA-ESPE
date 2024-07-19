/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Rayson
 */
public class MongoBD {
    private static final String DATABASE_NAME = "MiPrimerDataBase"; // Nombre de tu base de datos
    private static final String COLLECTIONCLIENTES_NAME = "Usuarios de Clientes"; // Nombre de tu colección
    private static final String COLLECTIONPROPIEDADESPR_NAME="Propiedades Por Revisar";
    private static final String COLLECTIONPROPIEDADES_NAME="Propiedades Publicadas"; 
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public static String getDATABASE_NAME() {
        return DATABASE_NAME;
    }

    public static String getCOLLECTIONCLIENTES_NAME() {
        return COLLECTIONCLIENTES_NAME;
    }
    

    public static String getCOLLECTIONPROPIEDADESPR_NAME() {
        return COLLECTIONPROPIEDADESPR_NAME;
    }

    public static String getCOLLECTIONPROPIEDADES_NAME() {
        return COLLECTIONPROPIEDADES_NAME;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }
    
}
