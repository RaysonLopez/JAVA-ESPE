/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;
import Modelo.Modelo;
import com.mongodb.client.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Rayson
 */
public class ConexionBD {
    String baseName="Prueba1DATABASE";
    String ColleccionName="Prueba1Collecion";
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document>collection;
    
    Modelo model;
    public ConexionBD(Modelo model){
        this.model=model;
        CrearConexion();
    }
    public void CrearConexion(){
        mongoClient=MongoClients.create();
        database=mongoClient.getDatabase(baseName);
        collection=database.getCollection(ColleccionName);

    }

    public void GuardarDatos(){
                Document document=new Document("codigo",model.getCodigo())
                .append("Nombres", model.getNombres())
                .append("Precio",model.getPrecio())
                .append("Categoria", model.getCategoria());
        collection.insertOne(document);
        
    }
    public void eliminarDatos(Long codigo){
        collection.deleteOne(eq("codigo",codigo));
    }
    public void actualizarDatos(String codigo,String nuevoNombre,double nuevoPrecio){
        collection.updateOne(eq("codigo", codigo),new Document("$set",new Document("Nombres",nuevoNombre).append("Precio",nuevoPrecio)));
    }
    public List<Modelo> leerdatos(){
        List<Modelo> datos=new ArrayList<>();
        FindIterable<Document>iterable=collection.find();
        for(Document document:iterable){
            long codigo=document.getLong("codigo");
            String nombres=document.getString("Nombres");
            double precio=document.getDouble("Precio");
            String categoria=document.getString("Categoria");
            Modelo modelo=new Modelo(codigo,nombres,precio,categoria);
            datos.add(modelo);
        }
        return datos;
    }

}
