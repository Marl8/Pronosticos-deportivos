
package tp;

public class TP {

    public static PronosticoDeportivo PRODE;
    
   
    public static void main(String[] args) {
        System.out.println ("Sistema de simulación de pronósticos deportivos.");
        System.out.println ("Ejecutándose desde:"+System.getProperty("user.dir"));
        
        PRODE = new PronosticoDeportivo();

        PRODE.play();
        
       PRODE.mostrarPuntajes();
        
       PRODE.mostarPuntajesOrdenados();
        
       PRODE.mostrarGanador();
    }
    
}
