
package tp;

import java.util.ArrayList;

/**
 *
 * @author Grupo 4
 */

public class ListaParticipantes {
    
    private ArrayList <Participante> participantes;
    private String nombreArchivo;

    public ListaParticipantes() {
    }

    public ListaParticipantes(ArrayList<Participante> participantes, String nombreArchivo) {
        this.participantes = participantes;
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "participantes=" + participantes + ", nombreArchivo=" + nombreArchivo + '}';
    }
    
    public void cargarDeArchivo () {
    }
    
    public void clacularPuntaje () {
    }
}
