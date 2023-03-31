/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Liver
 */
public class PronosticoDeportivoTest {
    
    public PronosticoDeportivoTest() {
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
     * Test of cargarPuntajes method, of class PronosticoDeportivo.
     */
    @Test
    public void testCargarPuntajes() {
        System.out.println("cargarPuntajes");
        ListaEquipos listaEquip = new ListaEquipos();
        ListaPartidos partido = new ListaPartidos();
        ListaParticipantes parti = new ListaParticipantes();
        ListaPronosticos pronos = new ListaPronosticos();
        
        listaEquip.cargarDeArchivo();
        partido.cargarDeArchivo(listaEquip);
        parti.cargarDeArchivo();
        pronos.cargarDeArchivo(listaEquip, partido, parti);
        
        PronosticoDeportivo.cargarPuntajes(listaEquip, partido, parti, pronos);

    }
    
    /**
     * Test of cargarPuntajes method, of class PronosticoDeportivo.
     */
    @Test
    public void testCargarPuntajes1() {
        System.out.println("cargarPuntajes");
        ListaEquipos listaEquip = new ListaEquipos();
        ListaPartidos partido = new ListaPartidos();
        ListaParticipantes parti = new ListaParticipantes();
        ListaPronosticos pronos = new ListaPronosticos();
        
        Equipo eq1 = new Equipo(1, "Independiente", "El rey de copas");
        Equipo eq2 = new Equipo(2, "Racing", "chiquito");
        Equipo eq3 = new Equipo(3, "Boca", "Boca");
        Equipo eq4 = new Equipo(4, "Independiente", "Millonario");
        
        listaEquip.addEquipo(eq1);
        listaEquip.addEquipo(eq2);
        listaEquip.addEquipo(eq3);
        listaEquip.addEquipo(eq4);
        
        Partido partido1 = new Partido(1, eq1, eq2, 4, 0);
        Partido partido2 = new Partido(2, eq3, eq4, 0, 1);
        
        partido.addPartidos(partido1);
        partido.addPartidos(partido2);
        
        Participante part1 = new Participante(1, "juan", pronos, 0);
        Participante part2 = new Participante(2, "Carlos", pronos, 0);
        Participante part3 = new Participante(1, "Miguel", pronos, 0);
        
        Pronostico pronos1 = new  Pronostico(1, part3, eq4, partido2, 'E');
        Pronostico pronos2 = new  Pronostico(2, part1, eq1, partido1, 'G');
        Pronostico pronos3 = new  Pronostico(3, part2, eq3, partido2, 'P');
        Pronostico pronos4 = new  Pronostico(4, part1, eq3, partido2, 'G'); 
        Pronostico pronos5 = new  Pronostico(5, part2, eq2, partido1, 'P');
        Pronostico pronos6 = new  Pronostico(6, part3, eq1, partido1, 'G');
        
        pronos.addPronostico(pronos1);
        pronos.addPronostico(pronos2);
        pronos.addPronostico(pronos3);
        pronos.addPronostico(pronos4);
        pronos.addPronostico(pronos5);
        pronos.addPronostico(pronos6);
        
        PronosticoDeportivo.cargarPuntajes(listaEquip, partido, parti, pronos);

    }    
}
