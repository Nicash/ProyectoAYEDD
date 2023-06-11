import java.util.Random; //Utilidad para generar numeros aleatorios

//Todo lo referido a las Ubicaciones de las Entradas va a estar puesto acá

public class Estadio {
    
    //VARIABLES DEL ESTADIO
    public static final int ASIENTOSRANDOMOCUPADOS = 20; //Cantidad aleatoria de asientos para simular compras anteriores
    public static final int FILAS = 10; //Cantidad de Filas del diagrama de asientos
    public static final int COLUMNAS = 10; //Cantidad de Columnas del diagrama de asientos
    public static String[][] estadio = new String[FILAS][COLUMNAS];  //Array de las ubicaciones del estadio

    //METODO PARA DAR LUGARES ALEATORIOS AL INICIO DEL PROGRAMA PARA SIMULAR COMPRAS ANTERIORES
    public static void randomizarEstadio() {

        for (int i = 0; i < FILAS; i++) { //Bucle para recorrertodas las filas
    
            for (int j = 0; j < COLUMNAS; j++) {  //Bucle for anidado dentro del otro para recorrer todas las columnas

                estadio[i][j] = "";  //Damos el valor vacio a cada posicion del estadio
            }
        }

        Random random = new Random(1234); //Generador de numeros aleatorios con una semilla para que siempre ocupe los mismo lugares en cada inicio del programa

        for (int i = 0; i < ASIENTOSRANDOMOCUPADOS; i++) { //Bucle for para ir asignando todos los lugares aleatorios con el máximo prefijado antes

            int fila, columna; //Declaramos variables temporales para el lugar aleatorio en la fila y en la columna

            do { //Este bucle se repite hasta que encuentre un lugar aleatorio que no esté ocupado

                fila = random.nextInt(FILAS);
                columna = random.nextInt(COLUMNAS);

            } while(estadio[fila][columna].equals("x")); //Compara el lugar aleatorio con el string "x" que indica que la posicion está ocupada
            
            estadio[fila][columna] = "x"; //Si salió del bucle quiere decir que la posicion de las variables temporales no esta ocupada y la ocupa escribiendole el valor string "x"

        }

        Variables.cantidadEntradasDisponibles -= ASIENTOSRANDOMOCUPADOS; //Actualiza la cantidad de entradas disponibles restando los asientos aleatorios generados al total de entradas

    }

    //METODO PARA DIBUJAR EL ESTADIO CON LAS POSICIONES OCUPADAS
    public static void dibujarEstadio(){
        
        //Todo este metodo dibuja esteticamente las posicion del estadio. Consta de caracteres de adorno coloreados con Variables de Color predefinidas.

        System.out.println( Variables.Fuente.NEGRITA + "");
        System.out.println("-----------------------------------");
        System.out.println("        ASIENTOS DISPONIBLES       ");
        System.out.println("                (" + Variables.cantidadEntradasDisponibles + ")");
        System.out.println("         Las posiciones con        ");
        System.out.println("      una '" + Variables.Color.ROJO + "X" + Variables.Color.RESET + "' están ocupadas.      ");
        System.out.println("-----------------------------------");
        
        System.out.print(Variables.Fuente.SUBRAYADO +  "   | ");
            
        System.out.print(Variables.Color.CYAN);

        for (int i = 1; i <= estadio[0].length; i++) {
                
            System.out.print(" " + i + " ");
               
        }

        System.out.print(Variables.Color.RESET);

        int filaD = 1;

        System.out.println("");
    
    
        for (int i = 0; i < FILAS; i++) {
                
            if(filaD <10){
                
                System.out.print(Variables.Color.VERDE + filaD  +"  | " + Variables.Color.RESET);

            }

            else{

                System.out.print(Variables.Color.VERDE + filaD + " | " + Variables.Color.RESET);

            }

            for (int j = 0; j < COLUMNAS; j++) {
                        
                if (estadio[i][j] != "x") {
                        
                    System.out.print("[ " + estadio[i][j] + "]");
                        
                } else {
    
                    System.out.print("[" + Variables.Color.ROJO  + estadio[i][j] + Variables.Color.RESET + "]");

                }    

            }
    
                System.out.println("");
    
                filaD++;

            }
            
            System.out.println("-----------------------------------");
            System.out.println("" + Variables.Fuente.RESET);

    }

}
