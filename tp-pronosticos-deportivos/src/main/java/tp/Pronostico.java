
package tp;

/**
 *
 * @author Grupo 4
 */

public class Pronostico {
    
    private int idPronostico;
    private Equipo equipo;
    private Partido partido;
    private char Resultado;
    
    public Pronostico() {
        
    }

    public Pronostico(int idPronostico, Equipo equipo, Partido partido, char Resultado) {
        this.idPronostico = idPronostico;
        this.equipo = equipo;
        this.partido = partido;
        this.Resultado = Resultado;
    }

    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
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
        return Resultado;
    }

    public void setResultado(char Resultado) {
        this.Resultado = Resultado;
    }
    
    public String toString() {
        String res = "\nApuesto a que en el partido:\n"+
                this.getIdPronostico()+
                this.getPartido()+
                this.getEquipo().getNombre()+" obtiene el siguiente Resultado: "+
                this.getResultado()+"\n";
        return res;
    }
    
    public int puntos () {
     
        return 0;
    }
}
