
package tp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Lemberger
 */

public class ListaPronosticos {

    private List<Pronostico> pronosticos;
    private String pronosticosCSV;

    public ListaPronosticos(List<Pronostico> pronosticos, String pronosticosCSV) {
        this.pronosticos = pronosticos;
        this.pronosticosCSV = pronosticosCSV;
    }

    public ListaPronosticos() {
        this.pronosticos = new ArrayList<>();
        this.pronosticosCSV = "pronosticos.csv";
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getPronosticosCSV() {
        return pronosticosCSV;
    }

    public void setPronosticosCSV(String pronosticosCSV) {
        this.pronosticosCSV = pronosticosCSV;
    }

    // add y remove elementos
    public void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public void removePronostico(Pronostico p) {
        this.pronosticos.remove(p);
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "pronosticos=" + pronosticos + '}';
    }

    public String listar() {
        String lista = "";
        for (Pronostico pronostico : pronosticos) {
            lista += "\n" + pronostico;
        }
        return lista;
    }

    public void cargarDeArchivo(
            int idParticipante, // id del participante que realizó el pronóstico
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
            
    ) {
        
        Equipo equipo; 
        Partido partido; 
        
        try {
            ConnectionFactory factory = new ConnectionFactory();
            final Connection con = factory.conexion();
            
            // Try/Catch with resources
            try (con) {
                
               final PreparedStatement statement = con.prepareStatement
            		("SELECT idPronostico,idParticipante,idPartido,idEquipo,resultado"
                                + " FROM pronosticos WHERE idParticipante = " + idParticipante);
               
                
                // Try/Catch with resources
                try (statement) {
                
                    statement.execute();
    
                    final ResultSet resultSet = statement.getResultSet();
                
                    // Try/Catch with resources
                    try (resultSet) {
                        while (resultSet.next()) {
                            
                          int equip = resultSet.getInt("idEquipo");             
                          partido = listapartidos.getPartido(resultSet.getInt("idPartido"));
                          
                          equipo = new Equipo();
                          
                          if(equip == 1) {
                              
                            equipo = partido.getEquipo1();
                          
                          }else if (equip == 2) {
                          
                            equipo = partido.getEquipo2();
                          }

                            Pronostico e = new Pronostico(resultSet.getInt("idPronostico"), 
                                equipo, partido, 
                        resultSet.getString("resultado").charAt(0));
                            
                            this.addPronostico(e);
                            }
                        }                                                    
                    }
                }       
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
