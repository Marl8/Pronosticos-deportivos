
package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Grupo 4
 */

public class ListaPronosticos {
    
    private ArrayList <Pronostico> pronosticos;
    private String pronosticosCSV;

    public ListaPronosticos() {
        
        this.pronosticos = new ArrayList<Pronostico>();
        this.pronosticosCSV = "pronosticos.csv";
    }

    public String getPronosticosCSV() {
        return pronosticosCSV;
    }

    public void setPronosticosCSV(String pronosticosCSV) {
        this.pronosticosCSV = pronosticosCSV;
    }

    public ListaPronosticos(ArrayList<Pronostico> pronosticos, String nombreArchivo) {
        this.pronosticos = pronosticos;
        this.pronosticosCSV = nombreArchivo;
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ArrayList<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }  

     // add y remove elementos
    public void addPronostico(Pronostico pronos) {
        this.pronosticos.add(pronos);
    }
    public void removePronostico(Pronostico pronos) {
        this.pronosticos.remove(pronos);
    }
    
    @Override
    public String toString() {
        return "ListaPronosticos{" + "pronosticos=" + pronosticos + ", pronosticosCSV=" + pronosticosCSV + '}';
    }
    
     public String listar() {
        String lista = "";
        for (Pronostico pronos : pronosticos) {
            lista += "\n" + pronos;
        }           
        return lista;
    }
    
     // cargar desde el archivo
    public void cargarDeArchivo(ListaEquipos listaEq, ListaPartidos listaPartidos, 
                                ListaParticipantes listaParticip) {
        // para las lineas del archivo csv
        String datosPronostivo;
        // para los datos individuales de cada linea
        String vectorPronostico[];
        // para el objeto en memoria
        Pronostico pronos;
        Participante parti; 
        Partido partido;
        Equipo equipo;
        int fila = 0;
        int i = 1; 
       
        try { 
            Scanner sc = new Scanner(new File("./pronosticos.csv"));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPronostivo = sc.next();
                System.out.println(datosPronostivo);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPronostico = datosPronostivo.split(",");   
                
                 
                if (vectorPronostico.length > 0 && vectorPronostico[i] != null
                        && Integer.parseInt(vectorPronostico[i]) >= 0) {
                // graba el equipo en memoria
                //convertir un string a un entero;
                int idParticipante = Integer.parseInt(vectorPronostico[0]);
                int idPartido = Integer.parseInt(vectorPronostico[1]);
                int idEquipo = Integer.parseInt(vectorPronostico[2]);
                char resultado = vectorPronostico[3].charAt(i);
                
                parti = listaParticip.getParticipante(idParticipante);
                equipo = listaEq.getEquipo(idEquipo);
                partido = listaPartidos.getPartido(idPartido);
                
                // crea el objeto en memoria
                pronos = new Pronostico(parti, equipo, partido, resultado);
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addPronostico(pronos);
                }
            }
            //closes the scanner
            sc.close();
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }   
        i++;
    }
}
