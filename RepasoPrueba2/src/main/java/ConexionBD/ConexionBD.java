/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import Modelo.Modelo;
import Vista.Vista;
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
    String databaseName="P1Eva2LopezRayson";
    String collectionName="CollectionRepaso";
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    Modelo modelo;
    Vista vista;
    public ConexionBD(Modelo modelo){
        this.modelo=modelo;
        crearConexion();
        
    }
    public void crearConexion(){
        try{
        mongoClient=MongoClients.create();
        database=mongoClient.getDatabase(databaseName);
        collection=database.getCollection(collectionName);
            System.out.println("Se ha conectado la base de datos exitosamente");
        }catch(MongoException e){
            JOptionPane.showMessageDialog(null,"Error en conectar la base de datos"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void guardarDatos(){
        try{
        for(Modelo modelo:modelo.getClientes()){
        Document document=new Document("Nombre", modelo.getNombres()).append("Edad",modelo.getEdad())
                .append("Genero",modelo.getGenero()).append("Cedula",modelo.getCedula());
        collection.insertOne(document);
        JOptionPane.showMessageDialog(null,"Exito, se guardo los datos en la BD","GREAT",JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(MongoException e){
            JOptionPane.showMessageDialog(null,"Error, No se guardaron los datos correctamente"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void eliminarDatos(String cedula){
        try{
        collection.deleteOne(eq("Cedula",cedula));
        JOptionPane.showMessageDialog(vista, "Se han eliminado correctamente los datos de la cedula: "+cedula);
        }catch(MongoException e){
            JOptionPane.showMessageDialog(vista, "Error: No se pudo eliminar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void actualizarDatos(String cedula,String nuevoNombre,int nuevaEdad,String nuevoGenero){
        collection.updateOne(eq("Cedula",cedula),new Document("$set",new Document("Nombre",nuevoNombre).append("Edad",nuevaEdad).append("Genero",nuevoGenero)));
    }

    public DefaultTableModel leerDatosTabla(){
         
        DefaultTableModel tableModel=new DefaultTableModel();
        FindIterable<Document>iterable=collection.find();
        MongoCursor<Document>cursor=iterable.iterator();
        //Obtener los nombres de las columnas
        String[] columnNames={"Cedula","Nombre","Edad","Genero"};
        tableModel.setColumnIdentifiers(columnNames);
        
        while(cursor.hasNext()){
            Document document=cursor.next();
            Object[]row=new Object[columnNames.length];
            row[0]=document.get("Cedula");
            row[1]=document.get("Nombre");
            row[2]=document.get("Edad");
            row[3]=document.get("Genero");
            tableModel.addRow(row);
        }
        return tableModel;
    }

}
