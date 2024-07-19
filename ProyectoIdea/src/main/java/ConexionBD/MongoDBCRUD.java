/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Rayson
 */
public interface MongoDBCRUD {
    public abstract void crearConexion();
    public abstract void cerrarConexion();
    public abstract boolean existeDocumento(String[]datos);
    public abstract void guardarDatos(String[] datos); // Create
    public abstract void leerDatos(); // Read
    public abstract void actualizarDatos(String[] datos); // Update
    public abstract void eliminarDatos(String id); // Delete

    public abstract void actualizarTablaMongo(DefaultTableModel tableModel);
    public abstract void close();
}
