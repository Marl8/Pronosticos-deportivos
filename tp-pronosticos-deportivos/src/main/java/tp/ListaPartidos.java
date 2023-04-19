
package tp;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author  Martin Lemberger
 */

public class ListaPartidos {
    
    private ArrayList <Partido> partidos;
    private String partidosCSV;

    public ListaPartidos() {
        this.partidos = new ArrayList<>();
        this.partidosCSV = "partidos.csv";
    }

    public ListaPartidos(ArrayList<Partido> partidos, String partidosCSV) {
        this.partidos = partidos;
        this.partidosCSV = partidosCSV;
    }

    
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getPartidosCSV() {
        return partidosCSV;
    }

    public void setPartidosCSV(String partidosCSV) {
        this.partidosCSV = partidosCSV;
    }
    
    // add y remove elementos
    public void addPartidos(Partido partido) {
        
        this.partidos.add(partido);
    }
    public void removePartidos(Partido partido) {
        this.partidos.remove(partido);
    }

     public Partido getPartido (int idPartido) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Partido encontrado = null;
        
        // Recorro la lista de equipos que está cargada
        for (Partido par : this.getPartidos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (par.getIdPartido()== idPartido) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = par;
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
        return "ListaPartidos{" + "partidos=" + partidos + ", partidosCSV=" + partidosCSV + '}';
    }
    
     public String listar() {
        String lista = "";
        for (Partido partido: partidos) {
            lista += "\n" + partido;
        }           
        return lista;
    }
     
       
      // cargar desde el archivo
    public void cargarDeArchivo(ListaEquipos listaEquipos) {
        // para las lineas del archivo csv
        String datosPartidos;
        // para los datos individuales de cada linea
        String vectorPartidos[];
        // para el objeto en memoria
        Partido partido;
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo(); 
        int i = 0;
        
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File("./partidos.csv"));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPartidos = sc.next();
                
                //System.out.println(datosPartidos);  //muestra los datos levantados 
                
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPartidos = datosPartidos.split(",");   
                
                // graba el equipo en memoria
                
                if (vectorPartidos.length > 0 && vectorPartidos[i] != null
                    && Integer.parseInt(vectorPartidos[i]) >= 0) { 
      
                int idPartido = Integer.parseInt(vectorPartidos[0]);
                int idEquipo1 = Integer.parseInt(vectorPartidos[1]);
                int idEquipo2 = Integer.parseInt(vectorPartidos[2]);
                int golesEquipo1 = Integer.parseInt(vectorPartidos[3]);
                int golesEquipo2 = Integer.parseInt(vectorPartidos[4]);
                
                equipo1 = listaEquipos.getEquipo(idEquipo1);
                
                equipo2 = listaEquipos.getEquipo(idEquipo2);
                
                        
                partido  = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2);
                // llama al metodo add para grabar el equipo en la lista en memoria
                
                this.addPartidos(partido);
                }         
            }
            //closes the scanners
            sc.close();
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
        i++;
    }
     
    public void cargarDeDB(ListaEquipos listaEquipos) {
     
        Partido partido;
        Equipo equipo1;
        Equipo equipo2;
        
        try {
            ConnectionFactory factory = new ConnectionFactory();
            final Connection con = factory.conexion();
            
            // Try/Catch with resources
            try (con) {
                
                final PreparedStatement statement = con.prepareStatement
            		("SELECT idPartido, idEquipo1, idEquipo2, golesEquipo1, golesEquipo2"
                                + " FROM partidos");
                // Try/Catch with resources
                try (statement) {
                    statement.execute();
                    final ResultSet resultSet = statement.getResultSet();
                
                    // Try/Catch with resources
                    try (resultSet) {                   
                        while (resultSet.next()) {
                            equipo1 = listaEquipos.getEquipo(resultSet.getInt("idEquipo1"));
                            equipo2 = listaEquipos.getEquipo(resultSet.getInt("idEquipo2"));

                            Partido e = new Partido(
                            resultSet.getInt("idPartido"), equipo1,
                            equipo2, resultSet.getInt("golesEquipo1"),
                            resultSet.getInt("golesEquipo2"));
                            
                            this.addPartidos(e);
                            }
                        }
                    }
                }       
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
