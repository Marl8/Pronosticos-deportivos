
package tp;

import java.util.ArrayList;

/**
 *
 * @author Grupo 4
 */

public class ListaEquipos {
    
    private ArrayList <Equipo> equipos;
    private String nombreArchivo;

    public ListaEquipos() {
    }

    public ListaEquipos(ArrayList<Equipo> equipos, String nombreArchivo) {
        this.equipos = equipos;
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
   
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + ", nombreArchivo=" + nombreArchivo + '}';
    }
    
    public void cargarDeArchivo () {
    }
}
