
package tp;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Martin Lemberger
 */

public class ListaParticipantes {
    
    private List<Participante> participantes;
    private String participantesCSV;

    public ListaParticipantes(List<Participante> participantes, String participantesCSV) {
        this.participantes = participantes;
        this.participantesCSV = participantesCSV;
    }
    
    public ListaParticipantes() {
        this.participantes = new ArrayList<>();
        this.participantesCSV = "participantes.csv";
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getParticipantesCSV() {
        return participantesCSV;
    }

    public void setParticipantesCSV(String participantesCSV) {
        this.participantesCSV = participantesCSV;
    }
    
    // add y remove elementos
    public void addParticipante(Participante p) {
        this.participantes.add(p);
    }
    public void removeParticipante(Participante p) {
        this.participantes.remove(p);
    }
    
    /***
     * Este método devuelve un Participante (o null) buscandolo por idParticipante
     * @param idParticipante Identificador del equipo deseado
     * @return Objeto Participante (o null si no se encuentra)
     */
    public Participante getParticipante (int idParticipante) {
        // Defini un objeto de tipo Participante en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Participante encontrado = null;
        // Recorro la lista de participantes que está cargada
        for (Participante eq : this.getParticipantes()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdParticipante() == idParticipante) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = eq;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el Participante, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "participantes=" + participantes + '}';
    }

    public String listar() {
        String lista = "";
        for (Participante participante: participantes) {
            lista += "\n" + participante;
        }           
        return lista;
    }
    
    // cargar desde el archivo
    public void cargarDeArchivo() {
        // para las lineas del archivo csv
        String datosParticipante;
        // para los datos individuales de cada linea
        String vectorParticipante[];
        // para el objeto en memoria
        Participante participante;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File(this.getParticipantesCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosParticipante = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                
                // System.out.println(datosParticipante);  //muestra los datos levantados 
                
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorParticipante = datosParticipante.split(",");   
                
                // graba el equipo en memoria
                //convertir un string a un entero;
                int idParticipante = Integer.parseInt(vectorParticipante[0]);
                String nombre = vectorParticipante[1];
                // crea el objeto en memoria
                participante = new Participante(idParticipante, nombre);
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addParticipante(participante);
            }
            //closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
    }
    
    public void cargarDeDB() {
        
        try {
            ConnectionFactory factory = new ConnectionFactory();
            final Connection con = factory.conexion();
            
            // Try/Catch with resources
            try (con) {
                
                final PreparedStatement statement = con.prepareStatement
            		("SELECT idParticipante, Nombre FROM participantes");
                // Try/Catch with resources
                try (statement) {
                
                    statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
                
                    // Try/Catch with resources
                    try (resultSet) {
                        while (resultSet.next()) {

                            Participante e = new Participante(
                            resultSet.getInt("idParticipante"),
                            resultSet.getString("Nombre"));
                            
                            this.addParticipante(e);
                            }
                        }
                    }
                }       
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      
    public List<Participante> ordenarPorPuntajes () {

            List<Participante> parti = new ArrayList<>();
            parti.addAll(participantes);
        
            //Ordenados de Mayor a menor
            Collections.sort(parti, Collections.reverseOrder());
            
            return parti;
    }
    
    public String listaOrdenados () {
        
        List<Participante> partiOrdenados = this.ordenarPorPuntajes();
        
        String lista = "";
        
        for (Participante parti : partiOrdenados) {
        
           lista += """
                    
                    Nombre: """ + parti.getNombre() + " Puntaje: " + parti.getPuntaje() + "\n";
        }
        return lista;
    }
    
    public void ganador () {

        List<Participante> participante;
        String lista = "";
        
        participante = ordenarPorPuntajes();
        Participante ganador = participante.get(0);
        
        for (int i = 0; i < participante.size(); i++) {
            
            if (participante.get(i).getPuntaje() == ganador.getPuntaje()) {
            
                lista += "\n" + participante.get(i).getNombre() +
                    " con "    + participante.get(i).getPuntaje() + " puntos";   
            }
        }
        System.out.println("El/los ganador/es: \n" + lista);
    }
}
