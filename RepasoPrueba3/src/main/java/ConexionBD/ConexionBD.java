/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import Modelo.Modelo;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
    
/**
 *
 * @author Rayson
 */
public class ConexionBD {
    String databaseName="P1Eva2LopezRayson3";
    String collectionName="Repaso1";
    MongoClient mongoCliente;
    MongoDatabase database;
    Modelo model;
    MongoCollection<Document>collection;
    public ConexionBD(Modelo model){
        this.model=new Modelo();
        crearConexion();
}
    public void crearConexion(){
        try{
        mongoCliente=MongoClients.create();
        database=mongoCliente.getDatabase(databaseName);
        collection=database.getCollection(collectionName);
        JOptionPane.showMessageDialog(null,"Se ha creado la base de datos con exito");
        }catch(MongoException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void guardar(){
        Document document=new Document("Cedtula", this)
    }
    public void eliminar(String cedula){
        collection.deleteOne(eq("Cedula",cedula));
    }
    public void actualizar(String cedula,String nuevosNombres,int nuevaEdad,String nuevoGenero){
        collection.updateOne(eq("Cedula",cedula), new Document("$set",new Document("Nombre",nuevosNombres).append("Edad",nuevaEdad).append("Genero", nuevoGenero)));
    }
    public void leer(){
        DefaultTableModel tableModel=new DefaultTableModel();
        FindIterable<Document>iterable=collection.find();
        MongoCursor<Document>cursor=iterable.iterator();
        String[]columnNames={"Cedula","Nombres","Edad","Genero"};
        tableModel.setColumnIdentifiers(columnNames);
        while(cursor.hasNext()){
            Document document=cursor.next();
            Object[]row=new Object[columnNames.length];
        }
    }
}

