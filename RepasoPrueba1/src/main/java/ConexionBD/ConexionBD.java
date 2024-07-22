/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import Modelo.Modelo;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Rayson
 */
public class ConexionBD {
    String collectionName;
    String databaseName;
    MongoDatabase database;
    MongoClient mongoClient;
    Modelo modelo;
    MongoCollection<Document>collection;
    public void guardarDatos(){
        Document document=new Document("Cedula",modelo.getCedula()).append("Nombre",modelo.getNombres());
        collection.insertOne(document);
    }
    public DefaultTableModel leerDatosTabla(){
        DefaultTableModel tableModel=new DefaultTableModel();
        FindIterable<Document>iterable=collection.find();
        MongoCursor<Document>cursor=iterable.iterator();
        String[]columnNames={"Cedula","Nombre","Pais"};
        tableModel.setColumnIdentifiers(columnNames);
        while(cursor.hasNext()){
            Document document=cursor.next();
            Object[]row=new Object[columnNames.length];
            row[0]=document.get("Cedula");
            
            tableModel.addRow(row);
        }
        return tableModel;
    }
    public void eliminar(String cedula){
        collection.deleteOne(eq("Cedula",cedula));
    }
    public void update(String nuevoNombre,String nombresNuevos){
        collection.updateOne(eq("cedula",modelo.getCedula()),new Document("$set",new Document("Nombre",nuevoNombre).append("Nombres",nombresNuevos)));
    }
}
