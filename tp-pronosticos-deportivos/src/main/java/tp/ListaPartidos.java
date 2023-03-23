
package tp;

import java.util.ArrayList;

/**
 *
 * @author Grupo 4
 */

public class ListaPartidos {
    
    private ArrayList <Partido> partidos;
    private String nombreArchivo;

    public ListaPartidos() {
    }

    public ListaPartidos(ArrayList<Partido> partidos, String nombreArchivo) {
        this.partidos = partidos;
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String toString() {
        return "ListaPartidos{" + "partidos=" + partidos + ", nombreArchivo=" + nombreArchivo + '}';
    }
    
    public void cargarDeArchivo () {
    }
}
