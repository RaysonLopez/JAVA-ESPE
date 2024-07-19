/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.p2lab1lopezrayson;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rayson
 */
public class FacturaLopezRaysonIT {
    
    public FacturaLopezRaysonIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generarFacturaCSV method, of class FacturaLopezRayson.
     */
    @Test
    public void testGenerarFacturaCSV() {
        System.out.println("generarFacturaCSV");
        String nombreArchivo = "";
        List<ProductoLopezRayson> productos = null;
        FacturaLopezRayson instance = new FacturaLopezRayson();
        instance.generarFacturaCSV(nombreArchivo, productos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarFacturaJSON method, of class FacturaLopezRayson.
     */
    @Test
    public void testGenerarFacturaJSON() {
        System.out.println("generarFacturaJSON");
        String nombreArchivo = "";
        List<ProductoLopezRayson> productos = null;
        FacturaLopezRayson instance = new FacturaLopezRayson();
        instance.generarFacturaJSON(nombreArchivo, productos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
