import java.util.Scanner;

public class programa {

    public static Scanner sc = new Scanner(System.in);

    public static void mainMarcos(String[] args) {

        String opcion = "";

        while (opcion != "4") {

            limpiar.consola();

            menu.interfaz();

            opcion = sc.nextLine();

            esperar.unSegundo();

            switch (opcion) {

                case "1":

                    limpiar.consola();

                    estadio.mostrarEstadio();

                    informacion.evento();

                    esperar.mensaje();

                    break;

                case "2":

                    limpiar.consola();

                    estadio.mostrarEstadio();

                    eleccion.elegirPosicion();

                    break;
                
                case "3":

                    limpiar.consola();

                    administracion.informacionVentas();

                    break;

                case "4":
 
                    System.out.println("El programa ha terminado...");

                    break;

                default:

                    System.out.println("Opción incorrecta, por favor intentalo de nuevo...");

                    esperar.unSegundo();
            }

        }

        sc.close();

    }
}
