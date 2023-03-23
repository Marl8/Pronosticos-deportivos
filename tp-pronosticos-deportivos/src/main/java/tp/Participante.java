
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
        return "Participante{" + "nombre=" + nombre + ", pronosticos=" + pronosticos + ", puntaje=" + puntaje + '}';
    }
    
    public void cargarPronosticos () {
    }
}
