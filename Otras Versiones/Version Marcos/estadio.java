import java.util.Random;

public class estadio {

    public static final int FILAS = 10;

    public static final int COLUMNAS = 10;

    public static String[][] estadio = new String[FILAS][COLUMNAS];


    public static void mostrarEstadio() {

        System.out.println("-----------------------------------");
        System.out.println("        ASIENTOS DISPONIBLES       ");
        System.out.println("                (" + (informacion.ENTRADAS - informacion.espacios_ocupados) + ")");
        System.out.println("         Las posiciones con        ");
        System.out.println("      una 'X' estan ocupadas.      ");
        System.out.println("-----------------------------------");


        for (int i = 0; i < FILAS; i++) {

            for (int j = 0; j < COLUMNAS; j++) {

                estadio[i][j] = "";
            }
        }


        Random random = new Random(1234);

        for (int i = 0; i < informacion.espacios_ocupados; i++) {

            int fila, columna;

            do {

                fila = random.nextInt(FILAS);
                columna = random.nextInt(COLUMNAS);

            } while(estadio[fila][columna].equals("x"));
            

            estadio[fila][columna] = "x";

        }

        System.out.print("  | ");

        for (int i = 1; i <= estadio[0].length; i++) {

            System.out.print(" " + i + " ");
        }

        char letras = 'a';
   
        System.out.println("");


        for (int i = 0; i < FILAS; i++) {

            System.out.print(letras + " | ");

            for (int j = 0; j < COLUMNAS; j++) {

                if (estadio[i][j] != "x") {

                    System.out.print("[ " + estadio[i][j] + "]");
                    
                } else {

                    System.out.print("[" + estadio[i][j] + "]");
                }

            }

            System.out.println("");

            letras ++;
        }

        System.out.println("");

    }
}