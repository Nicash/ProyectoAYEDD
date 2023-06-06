import java.util.Random; //Utilidad para generar numeros aleatorios

public class Estadio {
    
    //VARIABLES DEL ESTADIO
    public static final int ASIENTOSRANDOMOCUPADOS = 20; //Cantidad aleatoria de asientos para simular compras anteriores
    public static final int FILAS = 10; //Cantidad de Filas
    public static final int COLUMNAS = 10; //Cantidad de Columnas
    public static String[][] estadio = new String[FILAS][COLUMNAS];  //Array de las ubicaciones del estadio

    //METODO PARA DAR LUGARES ALEATORIOS AL INICIO DEL PROGRAMA PARA SIMULAR COMPRAS ANTERIORES
    public static void randomizarEstadio() {

        for (int i = 0; i < FILAS; i++) {
    
            for (int j = 0; j < COLUMNAS; j++) {

                estadio[i][j] = "";
            }
        }


        Random random = new Random(1234);

        for (int i = 0; i < ASIENTOSRANDOMOCUPADOS; i++) {

            int fila, columna;

            do {

                fila = random.nextInt(FILAS);
                columna = random.nextInt(COLUMNAS);

            } while(estadio[fila][columna].equals("x"));
            

            estadio[fila][columna] = "x";

        }

        Variables.cantidadEntradasDisponibles -= ASIENTOSRANDOMOCUPADOS;

    }

    //METODO PARA DIBUJAR EL ESTADIO CON LAS POSICIONES OCUPADAS
    public static void dibujarEstadio(){
        
        System.out.println( Variables.Fuente.NEGRITA + "");
        System.out.println("-----------------------------------");
        System.out.println("        ASIENTOS DISPONIBLES       ");
        System.out.println("                (" + Variables.cantidadEntradasDisponibles + ")");
        System.out.println("         Las posiciones con        ");
        System.out.println("      una 'X' estan ocupadas.      ");
        System.out.println("-----------------------------------");

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
            
            System.out.println("-----------------------------------");
            System.out.println("" + Variables.Fuente.RESET);
    
    }
}
