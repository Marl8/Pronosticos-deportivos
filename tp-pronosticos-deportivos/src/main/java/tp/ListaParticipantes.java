
package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Grupo 4
 */

public class ListaParticipantes {
    
    private ArrayList <Participante> participantes;
    private String particpantesCSV;

    public ListaParticipantes() {
        
        this.participantes = new ArrayList<Participante>();
        this.particpantesCSV = "particpantes.csv";
    }

    public ListaParticipantes(ArrayList<Participante> participantes, String nombreArchivo) {
        this.participantes = participantes;
        this.particpantesCSV = nombreArchivo;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getParticpantesCSV() {
        return particpantesCSV;
    }

    public void setParticpantesCSV(String particpantesCSV) {
        this.particpantesCSV = particpantesCSV;
    }
    
       // add y remove elementos
    public void addParticpante(Participante parti) {
        this.participantes.add(parti);
    }
    public void removeParticipante(Participante parti) {
        this.participantes.remove(parti);
    }
    
     public Participante getParticipante (int idParticipante) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Participante encontrado = null;
        
        // Recorro la lista de equipos que está cargada
        for (Participante parti : this.getParticipantes()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (parti.getIdParticipante()== idParticipante) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = parti;
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
        return "ListaParticipantes{" + "participantes=" + participantes + ", participantesCSV=" + particpantesCSV + '}';
    }
    
     public String listar() {
        String lista = "";
        for (Participante parti: participantes) {
            lista += "\n" + parti;
        }           
        return lista;
    }
    
     // cargar desde el archivo
    public void cargarDeArchivo() {
        // para las lineas del archivo csv
        String datosParticipantes;
        // para los datos individuales de cada linea
        String vectorParticipantes[];
        // para el objeto en memoria
        Participante participante;
        int i = 0;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File("./participantes.csv"));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosParticipantes = sc.next();
                System.out.println(datosParticipantes);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorParticipantes = datosParticipantes.split(",");   
                
                 
                if (vectorParticipantes.length > 0 && vectorParticipantes[i] != null
                        && Integer.parseInt(vectorParticipantes[i]) >= 0) {
                // graba el equipo en memoria
                int idparticipante = Integer.parseInt(vectorParticipantes[0]);
                String nombre = vectorParticipantes[1];

                // crea el objeto en memoria
                participante = new Participante(idparticipante, nombre);
                System.out.println(participante);
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addParticpante(participante);
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
