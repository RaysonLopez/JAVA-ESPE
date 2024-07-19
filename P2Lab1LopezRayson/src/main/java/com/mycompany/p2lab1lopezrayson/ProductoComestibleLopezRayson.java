package com.mycompany.p2lab1lopezrayson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

public class ProductoComestibleLopezRayson extends ProductoLopezRayson implements FacturableLopezRayson{
		    private String fechaCaducidad;
		    public ProductoComestibleLopezRayson(String nombre, double precio, double precioTotal,String codigo, String fechaCreacion,String fechaCaducidad) {
		        super(nombre,precio, codigo,fechaCreacion, precioTotal);
		        this.fechaCaducidad = fechaCaducidad;
		    }
			public ProductoComestibleLopezRayson(){

			}
		    public String getFechaCaducidad() {
		        return fechaCaducidad;
		    }

		    public void setFechaCaducidad(String fechaCaducidad) {
                    this.fechaCaducidad = fechaCaducidad;
                }

			@Override
			public void mostrarDetalles() {
				System.out.println("Nombre: "+nombre);
				System.out.println("Precio: "+precio);
				System.out.println("IVA: "+calcularImpuesto());
				System.out.println("Precio total: "+calcularPrecioTotal());
				System.out.println("Codigo: "+codigo);
				System.out.println("Fecha de Creacion: "+fechaCreacion);
				System.out.println("Fecha de Caducidad: "+fechaCaducidad);
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
			public double calcularPrecioTotal() {
				return precio + calcularImpuesto();
			}


			@Override
			public double aplicarImpuestos() {
				return calcularImpuesto();
			}

			@Override
			public void IngresarDatos() {
        try {
            this.setNombre(JOptionPane.showInputDialog("Ingresa el nombre del Producto Alimenticio"));

            boolean codigoValido = false;
            while (!codigoValido) {
                try {
                    this.setCodigo(JOptionPane.showInputDialog("Ingresa el código del producto (10 dígitos)"));
                    codigoValido = true;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            boolean precioValido = false;
            while (!precioValido) {
                try {
                    this.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio del producto")));
                    this.setPrecioTotal(calcularPrecioTotal());
                    precioValido = true;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Precio inválido. Debe ser un número positivo.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            boolean fechaValida = false;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            while (!fechaValida) {
                String fechaCreacionStr = JOptionPane.showInputDialog("Ingresa la fecha de creación (dd-MM-yyyy)");
                String fechaCaducidadStr = JOptionPane.showInputDialog("Ingresa la fecha de caducidad (dd-MM-yyyy)");
                try {
                    LocalDate fechaCreacionT = LocalDate.parse(fechaCreacionStr, formatter);
                    this.setFechaCreacion(fechaCreacionT.format(formatter));
                    LocalDate fechaCaducidadT = LocalDate.parse(fechaCaducidadStr, formatter);
                    this.setFechaCaducidad(fechaCaducidadT.format(formatter));
                    fechaValida = true;
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida. Debe estar en el formato dd-MM-yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar los datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	}
