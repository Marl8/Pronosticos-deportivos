
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
    
    public void cargarPuntajes () {
        
       ListaPronosticos pronos = new ListaPronosticos();
       
       ListaParticipantes parti = new ListaParticipantes();
       
       ListaPartidos partido = new ListaPartidos();
       
       Partido partido2 = new Partido();
       
       pronos.cargarDeArchivo();
       System.out.println("============================================");
       partido.cargarDeArchivo();
       System.out.println("============================================");
       parti.cargarDeArchivo();
       System.out.println("============================================");
        
        int puntos = 0;
        puntaje = 0;
        
        for (int k = 0; k < parti.getParticipantes().size(); k++) {
            
            System.out.println("Nombre participante: " + parti.getParticipantes().get(k).getNombre() 
                    + " " + "El Id es: " + parti.getParticipantes().get(k).getIdParticipante());
            
            puntaje = 0;
        
            for (int i = 0; i < pronos.getPronosticos().size(); i++) { 
            
            for (int j = 0; j < partido.getPartidos().size(); j++) {
               
                    if (parti.getParticipantes().get(k).getIdParticipante() == 
                    pronos.getPronosticos().get(i).getParticipante().getIdParticipante()){     
                    
                        if  (
                            partido.getPartidos().get(j).getResultado(pronos.getPronosticos().get(i).getEquipo()) == 
                            pronos.getPronosticos().get(i).getResultado()){
          
                               puntos = 1;
                               puntaje += puntos;
                        }
                    }    
                }
            }
             System.out.println("El puntaje para el participante es: " + puntaje + " puntos");
        }    
    }    
}
