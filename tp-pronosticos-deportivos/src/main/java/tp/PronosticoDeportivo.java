
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
    
    
    public static void cargarPuntajes (ListaEquipos listaEquip, ListaPartidos partido, 
                                      ListaParticipantes parti, ListaPronosticos pronos) {

        int puntos = 0;
        int aciertos = 0;
        int puntaje = 0;
        int contadorAciertos = 0;

        
        for (int k   = 0; k < parti.getParticipantes().size(); k++) {
            
            System.out.println("Nombre participante: " + parti.getParticipantes().get(k).getNombre() 
                    + " " + "El Id es: " + parti.getParticipantes().get(k).getIdParticipante());
            
            puntaje = 0;
            contadorAciertos =  0;
        
            for (int i = 0; i < pronos.getPronosticos().size(); i++) { 
                
                if (parti.getParticipantes().get(k).getIdParticipante() == 
                    pronos.getPronosticos().get(i).getParticipante().getIdParticipante()){
            
                    for (int j = 0; j < partido.getPartidos().size(); j++) {  
                    
                        if (partido.getPartidos().get(j).getIdPartido() ==
                            pronos.getPronosticos().get(i).getPartido().getIdPartido()){
                            
                            if
                            (partido.getPartidos().get(j).getResultado(pronos.getPronosticos().get(i).getEquipo()) 
                            ==  pronos.getPronosticos().get(i).getResultado()){
          
                               puntos = 3;
                               aciertos = 1;
                               puntaje += puntos;
                               contadorAciertos += aciertos;
                            }   
                        }
                    }    
                }
            }
            System.out.println("El puntaje para el participante es: " + puntaje + " puntos");
            System.out.println("La cantidad de aciertos para el participantes es: " + contadorAciertos + " aciertos");
        }    
    }
    
    public void puntajes (){
    
        PronosticoDeportivo.cargarPuntajes(equipos, partidos, participantes, pronosticos);    
    }
}
