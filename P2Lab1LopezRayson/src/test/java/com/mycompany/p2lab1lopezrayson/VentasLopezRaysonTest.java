/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.p2lab1lopezrayson;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rayson
 */
public class VentasLopezRaysonTest {
    
    public VentasLopezRaysonTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregarProducto method, of class VentasLopezRayson.
     */
    @Test
    public void testAgregarProducto_ProductoNoComestibleLopezRayson() {
        System.out.println("agregarProducto");
        ProductoNoComestibleLopezRayson producto = null;
        VentasLopezRayson instance = new VentasLopezRayson();
        instance.agregarProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarProducto method, of class VentasLopezRayson.
     */
    @Test
    public void testAgregarProducto_ProductoComenstibleLopezRayson() {
        System.out.println("agregarProducto");
        ProductoComestibleLopezRayson producto = null;
        VentasLopezRayson instance = new VentasLopezRayson();
        instance.agregarProducto(producto);
    }

    /**
     * Test of getFacturaDate method, of class VentasLopezRayson.
     */
    @Test
    public void testGetFacturaDate() {
        System.out.println("getFacturaDate");
        VentasLopezRayson instance = new VentasLopezRayson();
        String expResult = "";
        String result = instance.getFacturaDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductosVendidos method, of class VentasLopezRayson.
     */
    @Test
    public void testGetProductosVendidos() {
        System.out.println("getProductosVendidos");
        VentasLopezRayson instance = new VentasLopezRayson();
        List<ProductoLopezRayson> expResult = null;
        List<ProductoLopezRayson> result = instance.getProductosVendidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTotalVentas method, of class VentasLopezRayson.
     */
    @Test
    public void testCalcularTotalVentas() {
        System.out.println("calcularTotalVentas");
        VentasLopezRayson instance = new VentasLopezRayson();
        double expResult = 0.0;
        double result = instance.calcularTotalVentas();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarProductosVendidos method, of class VentasLopezRayson.
     */
    @Test
    public void testMostrarProductosVendidos() {
        System.out.println("mostrarProductosVendidos");
        VentasLopezRayson instance = new VentasLopezRayson();
        instance.mostrarProductosVendidos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTotal method, of class VentasLopezRayson.
     */
    @Test
    public void testCalcularTotal() {
        System.out.println("calcularTotal");
        VentasLopezRayson instance = new VentasLopezRayson();
        double expResult = 0.0;
        double result = instance.calcularTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aplicarDescuento method, of class VentasLopezRayson.
     */
    @Test
    public void testAplicarDescuento() {
        System.out.println("aplicarDescuento");
        double porcentaje = 0.0;
        VentasLopezRayson instance = new VentasLopezRayson();
        instance.aplicarDescuento(porcentaje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTotalImpuestos method, of class VentasLopezRayson.
     */
    @Test
    public void testCalcularTotalImpuestos() {
        System.out.println("calcularTotalImpuestos");
        VentasLopezRayson instance = new VentasLopezRayson();
        double expResult = 0.0;
        double result = instance.calcularTotalImpuestos();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of MenuPrincipal method, of class VentasLopezRayson.
     */
    @Test
    public void testMenuPrincipal() {
        System.out.println("MenuPrincipal");
        VentasLopezRayson instance = new VentasLopezRayson();
        instance.MenuPrincipal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
