package com.mycompany.p2lab1lopezrayson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class VentasLopezRayson {
	private LocalDate facturaDate;
	 private List<ProductoLopezRayson> productosVendidos;
	    public VentasLopezRayson() {
	        this.productosVendidos = new ArrayList<>();
			this.facturaDate=LocalDate.now();
	    } 
		public void agregarProducto(ProductoLopezRayson producto){
			productosVendidos.add(producto);
		}
		public String getFacturaDate(){
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return this.facturaDate.format(formatter);
		}
		public List<ProductoLopezRayson> getProductosVendidos() {
			return productosVendidos;
		}
	    public double calcularTotalVentas() {
	        double total = 0.0;
	        for (ProductoLopezRayson producto : productosVendidos) {
	            total += producto.getPrecio();
	        }
	        return total;
	    }
            
		public void mostrarProductosVendidos(){
			for(ProductoLopezRayson producto:productosVendidos){
				producto.mostrarDetalles();
				System.out.println("-----------------------------------------");
			}
		}
        public double calcularTotal() {
        double total = 0.0;
        for (ProductoLopezRayson producto : productosVendidos) {
            total += producto.getPrecio();
        }
        return total;
    }
    public void aplicarDescuento(double porcentaje){
        for(ProductoLopezRayson producto:productosVendidos){
            double precioDescuento=producto.aplicarDescuento(porcentaje);
            producto.setPrecio(precioDescuento);
        }
    }
    		public double calcularTotalImpuestos(){
			double totalImpuestos=0.0;
			for(ProductoLopezRayson producto:productosVendidos){
				totalImpuestos+=producto.calcularImpuesto();
			}
			return totalImpuestos;
		}
		void MenuPrincipal(){
			ProductoComestibleLopezRayson productoC=new ProductoComestibleLopezRayson();
			ProductoNoComestibleLopezRayson productoNC=new ProductoNoComestibleLopezRayson();
			FacturaLopezRayson factura=new FacturaLopezRayson();
			String OPC=JOptionPane.showInputDialog(null, "Menu Ingreso De Datos \n1. Producto Comestible \n 2.Producto de Limpieza\n3. Generar Archivo JSON\n4.Generar CSV", null, 0);
			switch (OPC) {
				case "1":
					productoC.IngresarDatos();
					agregarProducto(productoC);
					mostrarProductosVendidos();
					break;
				case "2":
					productoNC.IngresarDatos();
					agregarProducto(productoNC);
					mostrarProductosVendidos();
                                        break;
					case "3":
						if (!productosVendidos.isEmpty()) {
							String nombreArch = getFacturaDate();
							factura.generarFacturaJSON(nombreArch,productosVendidos);
						} else {
							JOptionPane.showMessageDialog(null, "No se han ingresado productos", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					break;
					case "4":
						if (!productosVendidos.isEmpty()) {
							String nombreArchivo = getFacturaDate();
							factura.generarFacturaCSV(nombreArchivo,productosVendidos);
						} else {
							JOptionPane.showMessageDialog(null, "No se han ingresado productos", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					break;
				default:JOptionPane.showMessageDialog(null, "Opcion Incorrecta, intentalo de nuevo", "Error",JOptionPane.ERROR_MESSAGE);
					break;
			}
		}
}
