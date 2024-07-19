    package com.mycompany.p2lab1lopezrayson;

    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;


    import javax.swing.JOptionPane;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;
import java.util.List;

    public class FacturaLopezRayson {
        private VentasLopezRayson venta;
        public FacturaLopezRayson() {
            venta=new VentasLopezRayson();
        }

     public void generarFacturaCSV(String nombreArchivo,List<ProductoLopezRayson>productos) {
            try (FileWriter writer = new FileWriter(nombreArchivo + ".csv")) {
                writer.append("Nombre,Precio,Codigo\n");
                // Suponiendo que venta.getProductosVendidos() devuelve una lista de ProductoLopezRayson
                for (ProductoLopezRayson producto : productos) {
                    writer.append(producto.getNombre()).append(",");
                    writer.append(Double.toString(producto.getPrecio())).append(",");
                    writer.append(producto.getCodigo()).append("\n");
                }
                JOptionPane.showMessageDialog(null, "Factura CSV generada exitosamente en " + nombreArchivo + ".csv");
            } catch (IOException e) {
                System.out.println("Error al generar la factura CSV: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al generar la factura CSV: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
         public void generarFacturaJSON(String nombreArchivo, List<ProductoLopezRayson> productos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos para generar la factura JSON.");
            return;
        }
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(nombreArchivo + ".json"))) {
            gson.toJson(productos, wr);
            JOptionPane.showMessageDialog(null, "Factura JSON generada exitosamente en: " + nombreArchivo + ".json", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar la factura JSON: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
 }
