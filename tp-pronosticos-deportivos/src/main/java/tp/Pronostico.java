
package tp;

/**
 *
 * @author Martin Lemberger
 */

public class Pronostico {
    
    private int idPronostico;
    private Participante participante;
    private Equipo equipo;
    private Partido partido;
    private char resultado;


    public Pronostico(int idPronostico, int idParticipante, Equipo equipo, Partido partido, char resultado) {
        this.idPronostico = idPronostico;
        this.participante = (Participante) (Object) idParticipante;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }


    public Pronostico(int idPronostico, Equipo equipo, Partido partido, char resultado) {
        this.idPronostico = idPronostico;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }


    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char Resultado) {
        this.resultado = Resultado;
    }

    @Override
    public String toString() {
        return "Pronostico{" 
                + "equipo=" + equipo + 
                ", partido=" + partido +
                ", resultado=" + resultado + '}';
    }

    
    public int puntos () {
     
        int puntos = 0;

        if (partido.getResultado(this.equipo) == this.resultado) {       
            puntos = 1;
        }     
        return puntos;
    }
}
