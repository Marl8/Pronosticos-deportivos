
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
        
        System.out.println("Los participantes cargados son: " + participantes.listar());
        System.out.println("============================================");
        
        System.out.println("Los pronosticos cargados son: " + pronosticos.listar());
        System.out.println("============================================");
    
    }  
    
    
    public static void cargarPuntajes (ListaEquipos listaEquip, ListaPartidos partido, 
                                      ListaParticipantes parti, ListaPronosticos pronos) {

        int puntos = 0;
        int aciertos = 0;
        int puntaje = 0;
        int contadorAciertos = 0;
        
        System.out.println("""
                           PUNTAJES 
                           (1 acierto = 3 puntos) \n
                           Los puntajes totales son: \n""");

        // Itero sobre los participantes
        for (int k = 0; k < parti.getParticipantes().size(); k++) {
            
            System.out.println("Nombre participante: " + parti.getParticipantes().get(k).getNombre() 
                    + " " + "el Id es: " + parti.getParticipantes().get(k).getIdParticipante());
            
            // Reseteo acumuladores para cada nuevo participante
            puntaje = 0;
            contadorAciertos =  0;
        
            // Itero sobre los pronósticos
            for (int i = 0; i < pronos.getPronosticos().size(); i++) { 
                
                // Valido si el ID del participante coincide con el ID de participante del pronóstico
                if (parti.getParticipantes().get(k).getIdParticipante() == 
                    pronos.getPronosticos().get(i).getParticipante().getIdParticipante()){
            
                    // Si la validación es TRUE itero sobre los partidos
                    for (int j = 0; j < partido.getPartidos().size(); j++) {  
                    
                        // Valido si el ID del partido es igual al ID del partido del pronóstico
                        if (partido.getPartidos().get(j).getIdPartido() ==
                            pronos.getPronosticos().get(i).getPartido().getIdPartido()){
                            
                        // Si la valición es TRUE comparo los resultado del partido y del pronostico   
                            if
                            (partido.getPartidos().get(j).getResultado(pronos.getPronosticos().get(i).getEquipo()) 
                            ==  pronos.getPronosticos().get(i).getResultado()){
          
                            // Asigno puntos y los acumulo y lo mismo con los aciertos    
                               puntos = 3;
                               aciertos = 1;
                               puntaje += puntos;
                               contadorAciertos += aciertos;
                            }   
                        }
                    }    
                }
            }
            System.out.println("El puntaje para el participante es: " 
                              + puntaje + " puntos" + "\n"
                              + "La cantidad de aciertos para el participante es: " 
                              + contadorAciertos + " aciertos" + "\n"
                              + "--------------------------------------------");
        }   
    }
    
    public void mostarPuntajes (){
    
        PronosticoDeportivo.cargarPuntajes(equipos, partidos, participantes, pronosticos);    
    }
}
