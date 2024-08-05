/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connectionBD;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import connectionBD.CRUD.DatabaseConnection;
import javax.swing.JOptionPane;
import org.bson.Document;
import connectionBD.CRUD.MongoCRUD;
import java.util.ArrayList;

/**
 *
 * @author Rayson
 */
public class ConnectionBDStudents extends ConnectionBD implements MongoCRUD,DatabaseConnection{
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    static ConnectionBDStudents instance;
    public ConnectionBDStudents(){
        instance=this;
        createConnection();
    }
    @Override
    public void delete(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static ConnectionBDStudents getInstance() {
        if(instance==null){
            instance= new ConnectionBDStudents();
        }
        return instance;
    }

    @Override
    public final void createConnection() {
        try {
           mongoClient = MongoClients.create("mongodb://localhost:27017");
           database = mongoClient.getDatabase(getDatabaseName());
           // Crear la colección si no existe
           if (!database.listCollectionNames().into(new ArrayList<>()).contains(getCollectionStudents())) {
               database.createCollection(getCollectionStudents());
           }
           collection = database.getCollection(getCollectionStudents());
           System.out.println("Se logró la conexión a la base de datos " + getDatabaseName() + " de la colección " + getCollectionStudents());
       } catch (MongoException e) {
           System.out.println("No se logró conectar con la base de datos: " + e.getMessage());
       }
    }

    @Override
    public boolean find(String user,String password) {
        Document documento=collection.find(Filters.and(Filters.eq("user",user),Filters.eq("password",password))).first();
        return documento!=null;
    } 

    @Override
    public void connect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Document document) {
        try{
            collection.insertOne(document);
        }catch(MongoException e){
            JOptionPane.showMessageDialog(null, "No ha sido posible conectarse a la base de datos"+e.getMessage());
        }
    }

    @Override
    public void update(String id, Document document) {
        try{
        collection.updateOne(eq("ID",id),new Document("$set",document));
        JOptionPane.showMessageDialog(null, "Se actualizo correctamente los datos del estudiante"+id);
        }catch(MongoException e){
            JOptionPane.showMessageDialog(null,"No se pudo actualizar los datos del estudiante: "+id+" "+e.getMessage());
        }
    }
}
