package com.mycompany.p2lab1lopezrayson;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

public class ProductoNoComestibleLopezRayson extends ProductoLopezRayson implements FacturableLopezRayson{ 
	private String tipoMaterial;
	
	public ProductoNoComestibleLopezRayson() {
		
	}
    public ProductoNoComestibleLopezRayson(String nombre, double precio,double precioTotal, String codigo,String fechaCreacion,String tipoMaterial) {
        super(nombre, precio,codigo,fechaCreacion,precioTotal);
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
    public void IngresarDatos() {
  this.setNombre(JOptionPane.showInputDialog("Ingresa el nombre del Producto No Comestible"));

        boolean precioValido = false;
        while (!precioValido) {
            String precioStr = JOptionPane.showInputDialog("Ingresa el precio del producto");
            try {
                this.setPrecio(Double.parseDouble(precioStr));
                precioValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio inválido. Debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        boolean codigoValido = false;
        while (!codigoValido) {
            String codigoStr = JOptionPane.showInputDialog("Ingresa el código del producto (10 dígitos)");
            if (codigoStr != null && codigoStr.matches("\\d{10}")) {
                this.setCodigo(codigoStr);
                codigoValido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Código inválido. Debe ser un número de 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        boolean fechaValida = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (!fechaValida) {
            String fechaStr = JOptionPane.showInputDialog("Ingresa la fecha de creación (dd-MM-yyyy)");
            try {
                LocalDate fechaCreacion = LocalDate.parse(fechaStr, formatter);
                this.setFechaCreacion(fechaCreacion.format(formatter));
                fechaValida = true;
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha inválida. Debe estar en el formato dd-MM-yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        this.setTipoMaterial(JOptionPane.showInputDialog("Ingresa el tipo de material del producto"));
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Precio: "+precio);
        System.out.println("codigo: "+codigo);
        System.out.println("Fecha de Creacion: "+fechaCreacion);
        System.out.println("Tipo de material: "+tipoMaterial);
    }
    @Override
    public double calcularImpuesto() {
        return precio*0.15;
        
    }
    @Override
    public double aplicarDescuento(double porcentaje) {
        return precio -(precio*(porcentaje/100));
    }
    @Override
    public double calcularPrecioTotal(){
        return precio+calcularImpuesto();
    }

    @Override
    public double aplicarImpuestos() {
        return calcularImpuesto();
    }
}
