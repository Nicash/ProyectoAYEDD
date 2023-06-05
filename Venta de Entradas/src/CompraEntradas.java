import java.util.Scanner; //Esta utilidad la vamos a usar para que el usuario introduzca un valor por consola y asignarlo a una variable
import java.util.Random; //Utilidad para generar numeros aleatorios

public class CompraEntradas {
    // DECLARAMOS E INICIALIZAMOS LAS VARIABLES QUE VAMOS A UTILIZAR
    
    //Creamos la herramienta que nos va a servir para leer los valores ingresados por el usuario
    public static Scanner lector = new Scanner(System.in);   

    // DATOS DE ENTRADA:

    public static int cantidadEntradasComprar = 0; //La cantidad de entradas que va a querer comprar el usuario.
    public static String emailComprador = ""; //El email del comprador, donde se enviará el comprobante de compra.
    public static long numeroCelularComprador = 0; //El nro de telefono del comprador, donde se enviará el comprobante de compra.

    // DATOS DE SALIDA:

    public static int cantidadEntradasDisponibles = 100; //La cantidad de entradas disponibles que el usuario puede comprar.
    public static int precioEntrada = 500 ; //El precio de las entradas.

    public static String nombreBanda = "Los Garcia"; //Nombre de la banda
    public static String fechaConcierto = "09/07/2023"; //La fecha en que se realizará el concierto.
    public static String horaConcierto = "20:00"; //La hora en la que se realizará el concierto.
    public static String lugarConcierto = "Estadio River Plate"; //El lugar donde se realizará el concierto.

    public static int cantidadEntradasVendidas = 0; //La cantidad total de entradas vendidas.
    public static int cantidadDineroRecaudado = 0; //La cantidad total de dinero recaudado.

    //VARIABLES DEL ESTADIO
    public static final int ASIENTOSRANDOMOCUPADOS = 20; //Cantidad aleatoria de asientos para simular compras anteriores
    public static final int FILAS = 10; //Cantidad de Filas
    public static final int COLUMNAS = 10; //Cantidad de Columnas
    public static String[][] estadio = new String[FILAS][COLUMNAS];  //Array de las ubicaciones del estadio

    //COLORES
    // Colores ANSI para la consola
    public static String COLOR_RESET = "\u001B[0m";
    public static String COLOR_NEGRO = "\u001B[30m";
    public static String COLOR_ROJO = "\u001B[31m";
    public static String COLOR_VERDE = "\u001B[32m";
    public static String COLOR_AMARILLO = "\u001B[33m";
    public static String COLOR_AZUL = "\u001B[34m";
    public static String COLOR_MAGENTA = "\u001B[35m";
    public static String COLOR_CYAN = "\u001B[36m";
    public static String COLOR_BLANCO = "\u001B[37m";

    // Estilos de texto ANSI para la consola
    public static String FUENTE_NEGRITA = "\u001B[1m";
    public static String FUENTE_SUBRAYADO = "\u001B[4m";
    public static String FUENTE_PARPADEO = "\u001B[5m";
    public static String FUENTE_INVERSO = "\u001B[7m";



    public static void main(String[] args) throws Exception {

        // ARRANCAMOS CON LA SECUENCIA DEL PROGRAMA

        randomizarEstadio(); //damos lugares aleatorios al estadio para simular compras anteriores
        
        // COMIENZA EL CICLO CONTINUO DEL MENU

        boolean funcionando = true;  //variable booleana que indica si debemos volver al menu luego de terminar otra accion
        String opcion; //variable de opcion del Switch

        while (funcionando) {

        limpiarConsola(); //limpiamos la consola para mejor visibilidad

        //Saludamos y damos la información del Concierto

        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("               Bienvenido al portal de compra de entradas para el recital de " + COLOR_ROJO + "Los Garcia" + COLOR_RESET);
        System.out.println("                      Fecha: " + COLOR_AZUL + fechaConcierto + COLOR_RESET +" - Hora: " + COLOR_AZUL + horaConcierto + COLOR_RESET + " - Lugar: " + COLOR_AZUL + lugarConcierto  + COLOR_RESET );
        System.out.println("");
        System.out.println("                                   Cantidad de entradas disponibles: " + COLOR_VERDE + cantidadEntradasDisponibles + COLOR_RESET);
        System.out.println("                                        Precio de las entradas: " + COLOR_MAGENTA + precioEntrada + COLOR_RESET);
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("  [1] Comprar Entradas | [2] Ver Entradas Disponibles | [3] Mis Entradas | [4] " + COLOR_ROJO + "Administracion" + COLOR_RESET + " | [5] Salir  ");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.print("- Elige una opcion: ");
        
        opcion = lector.nextLine(); //el usuario debe ingresar el nro correspondiente a la opcion del menu

        switch (opcion) {

            case "1":
                
                limpiarConsola();
                compraEntradas();
                System.out.println("Presione 'Enter' para volver al menu...");
                lector.nextLine();
                break;

            case "2":
                limpiarConsola();
                verEntradasDisponibles();
                System.out.println("Presione 'Enter' para volver al menu...");
                lector.nextLine();
                break;

            case "3":
                limpiarConsola();
                break;

            case "4":
                limpiarConsola();
                verInformacionAdministracion();
                System.out.println("Presione 'Enter' para volver al menu...");
                lector.nextLine();
                break;
            
            case "5":
                lector.close();
                System.out.print("Saliendo...");
                funcionando = false;
                break;

            default:

                System.out.println("Opción inválida. Por favor, elige nuevamente. Presione 'Enter' para continuar...");
                lector.nextLine();
                break;

        }

    }
    
}
    public static void compraEntradas(){
        
        //Preguntamos la cantidad de entradas a comprar. El usuario debe ingresar la cantidad.

        dibujarEstadio(); //antes de elegir cuantas entradas quiere comprar dibujamos el estadio y mostramos la cantidad disponible
    
        do {

            System.out.print("Ingrese la cantidad de entradas que desea comprar: ");

            cantidadEntradasComprar = lector.nextInt();
            lector.nextLine(); //salto de linea para q no me de error luego al leer el String

            if (cantidadEntradasComprar > cantidadEntradasDisponibles) {

                System.out.println("La cantidad de entradas que usted desea comprar es mayor a las entradas disponibles, intentelo de nuevo.");

            } else if (cantidadEntradasComprar <= 0) {

                System.out.println("La cantidad ingresada es incorrecta, intentelo de nuevo.");
            }


        } while (cantidadEntradasComprar <= 0 || cantidadEntradasComprar > cantidadEntradasDisponibles);

        int[][] entradasCompradasArray = new int[cantidadEntradasComprar][2];


        // Luego de elegir la cantidad le decimos que elija la posicion de las mismas.

        int pick_fila, pick_columna;

        for (int i = 0; i < cantidadEntradasComprar; i ++) {

            do {
                limpiarConsola();
                dibujarEstadio();

                System.out.println(FUENTE_SUBRAYADO + "Boleto N°" + (i + 1) + ":" + COLOR_RESET);
                System.out.print("Introduzca n° de FILA: ");

                pick_fila = lector.nextInt() - 1;
                lector.nextLine();
        
                if (pick_fila < 0 || pick_fila >= estadio.length) {

                    System.out.println("Has elegido una fila inexistente, por favor inténtalo de nuevo. Presione 'Enter' para continuar...");
                    lector.nextLine();
                }

            } while (pick_fila < 0 || pick_fila >= estadio.length);
        
            do {

                System.out.print("Introduzca n° de COLUMNA: ");

                pick_columna = lector.nextInt() - 1;
                lector.nextLine();
        
                if (pick_columna < 0 || pick_columna >= estadio[pick_fila].length) {

                    System.out.println("Has elegido una columna inexistente, por favor inténtalo de nuevo. Presione 'Enter' para continuar...");
                    lector.nextLine();
                }

            } while (pick_columna < 0 || pick_columna >= estadio[pick_fila].length);
        
            if (!estadio[pick_fila][pick_columna].equals("")) {

                System.out.println("Has elegido una posición que no está disponible, por favor inténtalo de nuevo. Presione 'Enter' para continuar...");
                lector.nextLine();
                i --;

            } else {

                System.out.println("Boleto N°" + (i + 1) + ". Lugares guardados: Fila " + (pick_fila + 1) + " Columna " + (pick_columna + 1));
                estadio[pick_fila][pick_columna] = "x";
                entradasCompradasArray[i][0] = pick_fila;
                entradasCompradasArray[i][1] = pick_columna;
                System.out.println("");
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo (1000 milisegundos)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                limpiarConsola();
                dibujarEstadio();
            }
            
        }

        System.out.println("");
        System.out.println("Sus asientos se han guardado exitosamente.");
        
        for(int j = 0; j < cantidadEntradasComprar; j++){
            System.out.println(FUENTE_SUBRAYADO + "Boleto N°" + (j + 1) + ":" + COLOR_RESET + " Fila " + (entradasCompradasArray[j][0]+1) + " - Columna: " + (entradasCompradasArray[j][1]+1));
        }
        
        System.out.println("");
    

    

    //Preguntamos el email para enviar el comprobante
        System.out.print("- Introduzca un email para enviar el comprobante de compra: ");
        emailComprador = lector.nextLine();

    //Preguntamos el celular para enviar el comprobante
        System.out.print("- Introduzca un numero de celular para enviar el comprobante de compra: ");
        numeroCelularComprador = lector.nextLong();
    
        System.out.println(""); //Cadena vacia para dejar un espacio

    //Mensaje final de confirmación de compra
        System.out.println("Muchas gracias por su compra :)");
        System.out.println("Comprobante enviado al email y celular proporcionado.");
        System.out.println("Recuerde presentarlo en puerta para entrar.");

        System.out.println(""); //Cadena vacia para dejar un espacio

    //IMPRIMIMOS EL COMPROBANTE DE COMPRA


        System.out.println("COMPROBANTE DE COMPRA:");
        System.out.println("+ CANTIDAD DE ENTRADAS COMPRADAS: " + cantidadEntradasComprar);
        System.out.println("+ EMAIL DE COMPRA: " + emailComprador);
        System.out.println("+ CELULAR DE COMPRA: " + numeroCelularComprador);

        System.out.println(""); //Cadena vacia para dejar un espacio

    }
    public static void verEntradasDisponibles(){
            dibujarEstadio();
    }
    public static void verInformacionAdministracion(){
         //MOSTRAMOS INFORMACION PARA LA EMPRESA y la Imprimimos

         System.out.println("INFORMACION VENTAS:");
         System.out.println("+ CANTIDAD DE ENTRADAS VENDIDAS: " + cantidadEntradasVendidas);
         System.out.println("+ TOTAL DINERO RECAUDADO: " + cantidadDineroRecaudado);
         System.out.println("+ CANTIDAD DE ENTRADAS DISPONIBLES: " + cantidadEntradasDisponibles);
 
         System.out.println(""); //Cadena vacia para dejar un espacio
 
    }
    public static void randomizarEstadio(){     
            
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

            cantidadEntradasDisponibles -= ASIENTOSRANDOMOCUPADOS;
    }
    public static void dibujarEstadio(){
        
        System.out.println(FUENTE_NEGRITA + "");
        System.out.println("-----------------------------------");
        System.out.println("        ASIENTOS DISPONIBLES       ");
        System.out.println("                (" + cantidadEntradasDisponibles + ")");
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
            System.out.println("" + COLOR_RESET);
    
    }
    public static void limpiarConsola(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
    }
}
