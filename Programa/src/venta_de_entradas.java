import java.util.Scanner;

public class venta_de_entradas {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 6) {

            System.out.println("Elige una opción: ");

            System.out.println("1: informacion del concierto.");

            System.out.println("2: ver espacios ocupados.");

            System.out.println("3: elegir asiento en el estadio.");

            System.out.println("4: comprobante.");

            System.out.println("5: administracion de ventas.");

            System.out.println("6: Salir.");

            System.out.print("Ingresa el número de la opción: ");

            opcion = venta_de_entradas.sc.nextInt();

            switch (opcion) {

                case 1:

                    informacion.evento();

                    break;

                case 2:

                    estadio.mostrarEstadio();

                    break;

                case 3:

                    eleccion.posicion();

                    break;

                case 4:

                    comprobante.imprimir();

                    break;

                case 5:

                    administracion.estadisticas();

                    break;

                case 6:

                    System.out.println("Has salido del programa.");

                    break;

                default:

                    System.out.println("Opción inválida. Por favor, elige nuevamente.");

                    break;
            }

            System.out.println("");
        }
    }
}