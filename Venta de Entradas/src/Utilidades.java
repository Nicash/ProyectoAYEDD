import java.util.Scanner; //Esta utilidad la vamos a usar para que el usuario introduzca un valor por consola y asignarlo a una variable

public class Utilidades {
    //Creamos la herramienta que nos va a servir para leer los valores ingresados por el usuario
    public static Scanner lector = new Scanner(System.in);   
    
    public static void limpiarConsola(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000); // Pausa de 1 segundo (1000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
