package tp;

/**
 *
 * @author Martin Lemberger
 */

public class Participante implements Comparable<Participante>{
    private Integer idParticipante;
    private String nombre;
    private ListaPronosticos pronosticos;
    
    public Participante(Integer idParticipante, String nombre, ListaPronosticos pronosticos) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = pronosticos;
    }

    public Participante(Integer idParticipante, String nombre) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = new ListaPronosticos();
    }

    public Participante() {
        this.idParticipante = null;
        this.nombre = null;
        this.pronosticos = new ListaPronosticos();
    }

    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
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

    // retorna el puntaje del participando calculando los valores de los pronosticos
    public int getPuntaje() {
        // Para ver el puntaje debo recorrer los pronosticos y ver el puntaje
        // de cada uno y acumularlo. Debo devolver el total.
        int puntaje = 0;
        // el primer mensaje corresponde al atributo pronosticos de participante
        // el segundo mensaje corresponde a la lista que tiene el atributo pronosticos
        // de esa lista se obtiene cada pronostico y se saca el puntaje acumulandolo en 
        // la variable puntaje
        for (Pronostico p : this.getPronosticos().getPronosticos()) {
            puntaje += p.puntos();
        }
        return puntaje;
    }
    
    public int getAciertos() {

        int aciertos = 0;
        
        for (Pronostico p : this.getPronosticos().getPronosticos()) {
            aciertos += p.puntos();
        }
        return aciertos;
    }

    @Override
    public String toString() {
        return "Participante{" + "idParticipante=" + idParticipante + ", nombre=" + nombre + ", pronosticos=" + pronosticos + '}';
    }
    
    
    void cargarPronosticos (ListaEquipos equipos, ListaPartidos partidos) {
        this.pronosticos.cargarDeDB(this.getIdParticipante(), equipos, partidos);
    }

     @Override
    public int compareTo(Participante parti) {
        
        int estePuntaje = this.getPuntaje();
        int otroPuntaje = parti.getPuntaje();
        
        if (estePuntaje == otroPuntaje) {
            return 0;
        
        } else if (estePuntaje > otroPuntaje) {    
            return 1;
        }else {
            
            return -1;
        }
    }
}

    // Y finalmente armar un metodo que cargue desde un JSON

