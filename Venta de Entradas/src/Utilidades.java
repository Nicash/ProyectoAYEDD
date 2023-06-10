import java.util.Scanner; //Esta utilidad la vamos a usar para que el usuario introduzca un valor por consola y asignarlo a una variable

public class Utilidades {
    
    //Creamos la herramienta que nos va a servir para leer los valores ingresados por el usuario
    public static Scanner lector = new Scanner(System.in);   
    
    //La utilidad de limpiar la consola permite visualizar mejor el programa y dejarlo más pulido
    public static void limpiarConsola(){
        
        try {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception e) {

            /*No hacer nada*/

        }

    }

    //Con esta utilidad podemos hacer pausas en la que se muestra un mensaje por una cantidad especificada de segundos
    public static void esperar(int milisegundos){
        
        try {

            Thread.sleep(milisegundos); // Pausa de 1 segundo (1000 milisegundos)

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
        
    }

}
