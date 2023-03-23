
package tp;

import java.util.ArrayList;

/**
 *
 * @author Grupo 4
 */

public class ListaPronosticos {
    
    private ArrayList <Pronostico> pronosticos;
    private String nombreArchivo;

    public ListaPronosticos() {
    }

    public ListaPronosticos(ArrayList<Pronostico> pronosticos, String nombreArchivo) {
        this.pronosticos = pronosticos;
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ArrayList<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String toString() {
        return "ListaPronosticos{" + "pronosticos=" + pronosticos + ", nombreArchivo=" + nombreArchivo + '}';
    }
    
    public void cargarDeArchivo () {
    }
}
