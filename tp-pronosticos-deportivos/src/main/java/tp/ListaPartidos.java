
package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Grupo 4
 */

public class ListaPartidos {
    
    private ArrayList <Partido> partidos;
    private String partidosCSV;

    public ListaPartidos() {
        this.partidos = new ArrayList<Partido>();
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
    public void cargarDeArchivo() {
        // para las lineas del archivo csv
        String datosPartidos;
        // para los datos individuales de cada linea
        String vectorPartidos[];
        // para el objeto en memoria
        Partido partido;
        Equipo equipo1;
        Equipo equipo2;
        int i = 0;
        
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File("./partidos.csv"));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPartidos = sc.next();
                System.out.println(datosPartidos);  //muestra los datos levantados 
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
                
                equipo1 = new Equipo(idEquipo1);
                equipo2 = new Equipo(idEquipo2);
                
                partido  = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2);
                // llama al metodo add para grabar el equipo en la lista en memoria
                
                addPartidos(partido);
                }         
            }
            //closes the scanners
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
        i++;
    }
}
