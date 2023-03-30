
package tp;

/**
 *
 * @author Grupo 4
 */

public class PronosticoDeportivo {
    
    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaParticipantes participantes;
    private ListaPronosticos pronosticos;
    private Participante parti;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        participantes = new ListaParticipantes();
        pronosticos = new ListaPronosticos();
        parti = new Participante();
    }
   

    public void play(){
        // cargar y listar los equipos
        equipos.cargarDeArchivo();
        
       // cargar y listar los partidos
        partidos.cargarDeArchivo(equipos);
        
        //cargar y listar los participantes
        participantes.cargarDeArchivo();
        
        //cargar y listar los pronosticos
        pronosticos.cargarDeArchivo(equipos, partidos, 
                                   participantes);
        
        System.out.println("Los equipos cargados son: " + equipos.listar());
        System.out.println("============================================");
        
        System.out.println("Los partidos cargados son: " + partidos.listar());
        System.out.println("============================================");
        
        System.out.println("Los particpantes cargados son: " + participantes.listar());
        System.out.println("============================================");
        
        System.out.println("Los pronosticos cargados son: " + pronosticos.listar());
        System.out.println("============================================");
    
    }  
    
    public void puntajes (){
    
        Participante.cargarPuntajes();    
    }
}
