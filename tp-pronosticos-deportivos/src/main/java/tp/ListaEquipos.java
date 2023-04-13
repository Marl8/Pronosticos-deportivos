
package tp;

/**
 *
 * @author Martin Lemberger
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaEquipos {
    
    private List<Equipo> equipos;
    private String equiposCSV;

    public ListaEquipos(List<Equipo> equipos, String equiposCSV) {
        this.equipos = equipos;
        this.equiposCSV = equiposCSV;
    }
    
    public ListaEquipos() {
        this.equipos = new ArrayList<>();
        this.equiposCSV = "equipos.csv";
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getEquiposCSV() {
        return equiposCSV;
    }

    public void setEquiposCSV(String equiposCSV) {
        this.equiposCSV = equiposCSV;
    }
    
    // add y remove elementos
    public void addEquipo(Equipo e) {
        this.equipos.add(e);
    }
    public void removeEquipo(Equipo e) {
        this.equipos.remove(e);
    }

    /***
     * Este método devuelve un Equipo (o null) buscandolo por idEquipo
     * @param idEquipo Identificador del equipo deseado
     * @return Objeto Equipo (o null si no se encuentra)
     */
    public Equipo getEquipo (int idEquipo) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Equipo encontrado = null;
        
        // Recorro la lista de equipos que está cargada
        for (Equipo eq : this.getEquipos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdEquipo() == idEquipo) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = eq;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el equipo, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }
    
    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + '}';
    }

    public String listar() {
        String lista = "";
        for (Equipo equipo: equipos) {
            lista += "\n" + equipo;
        }           
        return lista;
    }
    
     public void cargarDeArchivo() {
     
        try {
            ConnectionFactory factory = new ConnectionFactory();
            final Connection con = factory.conexion();         
            // Try/Catch with resources
            try (con) {
                
                final PreparedStatement statement = con.prepareStatement
            		("SELECT idEquipo, Nombre, Descripcion FROM equipos");
                
                // Try/Catch with resources
                try (statement) {
                statement.execute(); 
                final ResultSet resultSet = statement.getResultSet();
                
                    // Try/Catch with resources
                    try (resultSet) {
                        while (resultSet.next()) {
                            Equipo e = new Equipo(
                            resultSet.getInt("idEquipo"),
                            resultSet.getString("Nombre"),
                            resultSet.getString("Descripcion")
                            );  
                            this.addEquipo(e);
                            }
                        }
                     }
                 }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
}
