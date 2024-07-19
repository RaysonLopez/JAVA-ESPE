/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elmain;
import Login.Vista.VistaLogin;
/**
 *
 * @author Rayson
 */
public class Main {
    public static void main(String[]args){
               // Ejecutar la GUI en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear una nueva instancia de la ventana de login y hacerla visible
                new VistaLogin().setVisible(true);
            }
        });
    }
}
