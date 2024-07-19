/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import static ConexionBD.MongoBD.getCOLLECTIONCLIENTES_NAME;
import static ConexionBD.MongoBD.getDATABASE_NAME;
import Interface.Model.MODELDatosPropiedades;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Rayson
 */
public class ConexionBDPropiedades extends MongoBD {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    public ConexionBDPropiedades (){
        CrearConexion();
    }
     public void CrearConexion(){
      try {
            // Establecer conexión con MongoDB
            mongoClient = MongoClients.create(); // Se conecta al servidor local MongoDB por defecto
            database = mongoClient.getDatabase(getDATABASE_NAME());
            collection = database.getCollection(getCOLLECTIONPROPIEDADES_NAME());
            System.out.println("Conexión exitosa a la base de datos: " + getCOLLECTIONPROPIEDADES_NAME());
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    public void guardarDatos(List<MODELDatosPropiedades>propiedades) {
    // Validar que la colección no sea nula
    if (collection == null) {
        System.err.println("La colección no está inicializada.");
        return;
    }
    for (MODELDatosPropiedades propiedad :propiedades) {

        try {
        if (existeDocumento(propiedad)) {
            JOptionPane.showMessageDialog(null,"Error: Objeto duplicado","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            // Crear un documento BSON con los datos
            Document documento = new Document()
                .append("Imagen", propiedad.getImage())
                .append("Nombres Del Dueño", propiedad.getNombres())
                .append("Dirrecion", propiedad.getDirreccion())
                .append("Descripcion de la casa", propiedad.getDescripcion())
                .append("Metros Cuadrados", propiedad.getMetros())
                .append("Precio", propiedad.getPrecio())
                .append("Disponibilidad", propiedad.getDisponibilidad())
                .append("Numero de cuartos", propiedad.getNumeroCuartos())
                .append("Ubicacion",propiedad.getUbicacion());

            // Insertar el documento en la colección
            collection.insertOne(documento);
            JOptionPane.showMessageDialog(null, "Datos guardados en MongoDB correctamente.", "Guardar en MongoDB", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}
public boolean existeDocumento(MODELDatosPropiedades propiedad) {
    Bson filter = Filters.or(
        Filters.eq("Dirrecion", propiedad.getDirreccion()),
        Filters.eq("Precio", propiedad.getPrecio()),
        Filters.eq("Descripcion", propiedad.getDescripcion()),
        Filters.eq("Imagen", propiedad.getImage())
    );
    MongoCollection<Document> collection = database.getCollection(getCOLLECTIONCLIENTES_NAME());
    Document documento = collection.find(filter).first();
    return documento != null;
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
         // Conectar a la base de datos
    MongoDatabase database = mongoClient.getDatabase(getDATABASE_NAME());
    MongoCollection<Document> collection = database.getCollection(getCOLLECTIONPROPIEDADES_NAME());

    // Buscar el documento que se va a modificar
    Bson filter = Filters.eq("CI", datos[0]);
    Document documento = collection.find(filter).first();

    // Actualizar los campos del documento
    documento.put("Nombres Completos", datos[1]);
    documento.put("Descripcion", datos[2]);
    documento.put("Dirreccion", datos[3]);
    documento.put("Precio", datos[4]);
    documento.put("Metros Cuadrados", datos[5]);
    documento.put("Numero de Cuartos", datos[6]);
    documento.put("Ubicacion", datos[7]);
    documento.put("Disponibilidad", datos[8]);

    // Actualizar el documento en la base de datos
    collection.updateOne(filter, new Document("$set", documento));

    // Cerrar la conexión a la base de datos
    mongoClient.close();
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
