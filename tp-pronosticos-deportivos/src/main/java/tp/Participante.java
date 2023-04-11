package tp;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Grupo 4
 */

public class Participante {
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

        return 
                "Participante: " +
                "nombre: " + nombre + "\n" +
                "El id del Participante es: " + idParticipante + "\n" +
                "Sus pronosticos son: " + pronosticos + "\n" +
                "Su puntaje final es " + getPuntaje() + " puntos" + "\n" +
                "La cantidad de aciertos es: " + getAciertos() + " aciertos" + "\n" +
                "=======================================" + " \n";
    }    
    
    void cargarPronosticos (ListaEquipos equipos, ListaPartidos partidos) {
        this.pronosticos.cargarDeArchivo(this.getIdParticipante(), equipos, partidos);
    }
    
    public List<Participante> ordenarPorPuntajes (List<Participante> participantes) {

            participantes.sort(Comparator.comparing(Participante::getPuntaje).reversed());
            
            return participantes;
    }
    
    public Participante ganador (List<Participante> participantes) {
    
        this.ordenarPorPuntajes(participantes);
        
        Participante participante = participantes.get(0);
        
        return participante;
    }
}

    // Y finalmente armar un metodo que cargue desde un JSON

