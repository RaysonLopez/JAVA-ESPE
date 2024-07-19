/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p1examenlopezrayson;

import static com.mycompany.p1examenlopezrayson.Producto.sc;

/**
 *
 * @author Rayson
 */
public class P1ExamenLopezRayson {
    char OPC='0';
     public static void main(String []args) {
        while (true) {
            System.out.println("ALMACENES TIA");
            System.out.println("1. Ingresar Producto Alimenticio");
            System.out.println("2. Validar Vigencia de Producto Alimenticio");
            System.out.println("3. Leer Productos ingresados");
            System.out.println("4. Salir");
            char opcion = sc.next().charAt(0);
            sc.nextLine(); // Consumir el salto de línea restante

            switch (opcion) {
                case '1':
                    ProductoAlimenticio productoAlimenticio = new ProductoAlimenticio(null,null,null,0);
                    productoAlimenticio.IngresarProducto();
                    break;
                case '2':
                    validarVigenciaProducto();
                    break;
                case '3':
                    leerProductosIngresados();
                    break;
                case '4':
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
      private static void validarVigenciaProducto() {
        System.out.println("Ingresa el código del producto a validar:");
        String codigo = sc.nextLine();
        System.out.println("Ingresa la fecha actual (yyyy-MM-dd):");
        String fechaActual = sc.nextLine();

        boolean encontrado = false;
        for (ProductoAlimenticio producto : ProductoAlimenticio.productosAlimenticios) {
            if (producto.getCodigo().equals(codigo)) {
                boolean vigente = producto.ValidarVigenciaProducto(fechaActual);
                if (vigente) {
                    System.out.println("El producto está vigente.");
                } else {
                    System.out.println("El producto ha expirado.");
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void leerProductosIngresados() {
        System.out.println("Productos Alimenticios ingresados:");
        for (ProductoAlimenticio producto : ProductoAlimenticio.productosAlimenticios) {
            System.out.println(producto.obtenerDatosCSV());
        }
    }
}
