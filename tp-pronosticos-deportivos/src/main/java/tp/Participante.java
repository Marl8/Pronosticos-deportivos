
package tp;

/**
 *
 * @author Grupo 4
 */

public class Participante {
    
    private int idParticipante;
    private String nombre;
    private ListaPronosticos pronosticos;
    private int puntaje;

    public Participante() {
    }

    public Participante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Participante(int idParticipante, String nombre) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
    }

    public Participante(int idParticipante, String nombre, ListaPronosticos pronosticos, int puntaje) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = pronosticos;
        this.puntaje = puntaje;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPronosticos getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ListaPronosticos pronosticos) {
        this.pronosticos = pronosticos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Participante{" + "idParticipante=" + idParticipante + ", nombre=" + nombre + '}';
    }
    
     public static void cargarPuntajes () {
        
       ListaPronosticos pronos = new ListaPronosticos();
       
       ListaParticipantes parti = new ListaParticipantes();
       
       ListaPartidos partido = new ListaPartidos();
       
       Partido partido2 = new Partido();
       
       ListaEquipos listaEquip = new ListaEquipos();
       
       listaEquip.cargarDeArchivo();
       System.out.println("============================================");
       partido.cargarDeArchivo(listaEquip);
       System.out.println("============================================");
       parti.cargarDeArchivo();
       System.out.println("============================================");
       pronos.cargarDeArchivo(listaEquip,partido,parti);
       System.out.println("============================================");
       
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
            System.out.println("La contidad de aciertos para el participantes es: " + contadorAciertos + " aciertos");
        }    
    }
}
