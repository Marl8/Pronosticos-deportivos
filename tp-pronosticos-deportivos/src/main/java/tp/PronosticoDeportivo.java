
package tp;

/**
 *
 * @author Grupo 4
 */

public class PronosticoDeportivo {
   
    private ListaParticipantes participantes;
    private ListaPartidos partidos;

    public PronosticoDeportivo() {
    }

    public PronosticoDeportivo(ListaParticipantes participantes, ListaPartidos partidos) {
        this.participantes = participantes;
        this.partidos = partidos;
    }

    public ListaParticipantes getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ListaParticipantes participantes) {
        this.participantes = participantes;
    }

    public ListaPartidos getPartidos() {
        return partidos;
    }

    public void setPartidos(ListaPartidos partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return "PronosticoDeportivo{" + "participantes=" + participantes + ", partidos=" + partidos + '}';
    }
    
    public void play () {
    }
}
