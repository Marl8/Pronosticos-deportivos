/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tp;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liver
 */
public class ParticipanteTest {
    
    public ParticipanteTest() {
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
     * Test of getPuntaje method, of class Participante.
     */
    @Test
    public void testGetPuntaje() {
        System.out.println("getPuntaje");
        Participante instance = new Participante();
        int expResult = 1;
        int result = instance.getPuntaje();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getAciertos method, of class Participante.
     */
    @Test
    public void testGetAciertos() {
        System.out.println("getAciertos");
        Participante instance = new Participante();
        int expResult = 0;
        int result = instance.getAciertos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of ordenarPorPuntajes method, of class Participante.
     */
    @Test
    public void testOrdenarPorPuntajes() {
        System.out.println("ordenarPorPuntajes");
        List<Participante> participantes = null;
        Participante instance = new Participante();
        List<Participante> expResult = null;
        List<Participante> result = instance.ordenarPorPuntajes(participantes);
        assertEquals(expResult, result);
    }

    /**
     * Test of ganador method, of class Participante.
     */
    @Test
    public void testGanador() {
        System.out.println("ganador");
        List<Participante> participantes = null;
        Participante instance = new Participante();
        Participante expResult = null;
        Participante result = instance.ganador(participantes);
        assertEquals(expResult, result);
    }
    
}
