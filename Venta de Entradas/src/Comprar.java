import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;



public class Comprar{
    
    public static int cantidadEntradasComprar = 0; //La cantidad de entradas que va a querer comprar el usuario.
    public static String emailComprador = ""; //El email del comprador, donde se enviará el comprobante de compra.
    public static long numeroCelularComprador = 0; //El nro de telefono del comprador, donde se enviará el comprobante de compra.
    public static String pago; //variable de opcion del Switch
    public static String codigoPago;

    public static void compraEntradas(){
        System.out.println(Variables.Color.VERDE + "---------------------------------------------------------------------");
        System.out.println("                         Comprar Entradas                              ");
        System.out.println("  Para realizar la compra deberá poseer una cuenta asociada a su DNI");
        System.out.println("---------------------------------------------------------------------" + Variables.Fuente.RESET);

        System.out.print("Ingrese su número de DNI: "); //Pedimos el DNI al usuario
        String dniCompra = Utilidades.lector.nextLine();

        if(!Cliente.existeCliente(dniCompra)){ //Llamamos al metodo que checkea mediante el DNI si el Cliente existe
            System.out.println("No tienes cuenta creada. Vamos a crearte una."); 
            System.out.println("+ Ingresa tus datos:");
            Cliente.crearCuenta(dniCompra); //En caso de que no exista vamos a llamar al metodo que crea una cuenta llevando ya como parametro el DNI
        }
        
        Utilidades.limpiarConsola(); //Limpiamos la consola
        Estadio.dibujarEstadio(); //Antes de elegir cuantas entradas quiere comprar dibujamos el estadio y mostramos la cantidad disponible
        
        System.out.println("¡Bienvenido, " + Variables.Color.MAGENTA + Cliente.getNameByDNI(dniCompra) + Variables.Color.RESET + "!"); //Saludamos con el nombre invocando un metodo para obtener el nombre del usuario mediante el DNI

        do { //Este bucle se va a repetir hasta que el usuario ingrese un numero valido (no negativo, ni mayor al numero de entradas disponibles)
            
            System.out.print("Ingrese la cantidad de entradas que desea comprar: "); //Preguntamos la cantidad de entradas a comprar. El usuario debe ingresar la cantidad.

            cantidadEntradasComprar = Utilidades.lector.nextInt();

            Utilidades.lector.nextLine(); //Salto de linea para q no me de error luego al leer el String

            if (cantidadEntradasComprar > Variables.cantidadEntradasDisponibles) { //Comprobamos que el numero ingresado no sea mayor al numero de entradas disponibles

                System.out.println("La cantidad de entradas que usted desea comprar es mayor a las entradas disponibles, intentelo de nuevo.");

            } else if (cantidadEntradasComprar <= 0) { //Comprobamos que el usuario no ingrese un numero negativo

                System.out.println("La cantidad ingresada es incorrecta, intentelo de nuevo.");
            }
        
    } while (cantidadEntradasComprar <= 0 || cantidadEntradasComprar > Variables.cantidadEntradasDisponibles); //condicion del bucle: seguira repitiendose si el numero ingresado es negativo o cero, o si es mayor al numero de entradas disponibles
       
    int[][] entradasCompradasArray = new int[cantidadEntradasComprar][2]; //Creamos un array para guardar las posiciones que elija en cada uno de los boletos que vaya a comprar

        // Luego de elegir la cantidad le decimos que elija la posicion de las mismas.

        int pick_fila, pick_columna;

        for (int i = 0; i < cantidadEntradasComprar; i ++) { //Bucle que recorre la cantidad de entradas a comprar

            //Para cada eleccion vamos a limpiar la consola y volver a dibujar el Estadio actualizado con las compras que se van ingresando
            do {
                Utilidades.limpiarConsola();
                Estadio.dibujarEstadio();

                System.out.println(Variables.Fuente.SUBRAYADO + "Boleto N°" + (i + 1) + ":" + Variables.Fuente.RESET);
                System.out.print("Introduzca n° de FILA: ");

                pick_fila = Utilidades.lector.nextInt() - 1;
                Utilidades.lector.nextLine();
        
                if (pick_fila < 0 || pick_fila >= Estadio.estadio.length) {

                    System.out.println("Has elegido una fila inexistente, por favor inténtalo de nuevo. Presione 'Enter' para continuar...");
                    Utilidades.lector.nextLine();
                }

            } while (pick_fila < 0 || pick_fila >= Estadio.estadio.length); //El bucle se repite hasta que el usuario ingrese un numero de Fila correcto, es decir: no negativo, ni mayor a la capacidad del estadio.
        
            do {

                System.out.print("Introduzca n° de COLUMNA: ");

                pick_columna = Utilidades.lector.nextInt() - 1;
                Utilidades.lector.nextLine();
        
                if (pick_columna < 0 || pick_columna >= Estadio.estadio[pick_fila].length) {

                    System.out.println("Has elegido una columna inexistente, por favor inténtalo de nuevo. Presione 'Enter' para continuar...");
                    Utilidades.lector.nextLine();
                }

            } while (pick_columna < 0 || pick_columna >= Estadio.estadio[pick_fila].length); //Al igual que con las filas, el bucle se repetira hasta que el usuario ingrese un numero de columna valido
        
            if (!Estadio.estadio[pick_fila][pick_columna].equals("")) {
                
                //En caso que las posiciones sea correctas pero el lugar esté ocupado vamos a tener que restar 1 a la suma del bucle For para mantener la cantidad de entradas que se quieren comprar
                
                System.out.println("Has elegido una posición que no está disponible, por favor inténtalo de nuevo. Presione 'Enter' para continuar...");
                Utilidades.lector.nextLine();
                i --;

            } else {

                //En el caso que las posiciones sean correctas y no esten ocupadas vamos a marcar la posicion en el diagrama del Estadio como ocupada asignandole una X

                System.out.println("Boleto N°" + (i + 1) + ". Lugares guardados: Fila " + (pick_fila + 1) + " Columna " + (pick_columna + 1));
                Estadio.estadio[pick_fila][pick_columna] = "x"; //Ponemos una x en el diagrama del Estadio para indicar que la posicion está ocupada
                Variables.cantidadEntradasDisponibles -= 1;
                entradasCompradasArray[i][0] = pick_fila; //Guardamos la fila elegida en el array de entradasCompradas, en la posicion de las filas (0)
                entradasCompradasArray[i][1] = pick_columna; //Guardamos la columna elegida en el array de entradasCompradas, en la posicion de las columnas (1)
                System.out.println(""); //Dejamos un espacio
                
                Utilidades.esperar(1000); //Esperamos un segundo luego de mostar el mensaje de eleccion de fila y columna para que de tiempo a leer
                Utilidades.limpiarConsola(); //Limpiamos la consola
                Estadio.dibujarEstadio(); //Volvemos a dibujar el estadio

            }
            
        }
        System.out.println("Su selección se ha guardado correctamente:");
        for(int j = 0; j < cantidadEntradasComprar; j++){

            int posFila = entradasCompradasArray[j][0];
            int posColumna = entradasCompradasArray[j][1];
            
            System.out.println(Variables.Fuente.SUBRAYADO + "Boleto N°" + (j + 1) + ":" + Variables.Fuente.RESET + " Fila " + (posFila+1) + " - Columna: " + (posColumna+1));
            
            Cliente.agregarBoleto(dniCompra,(posFila+1),(posColumna+1)); //con este Metodo agregamos las entradas una por una al array que posee cada usuario para tal fin
        }
        System.out.println(Variables.Fuente.SUBRAYADO + "Total a pagar:" + Variables.Fuente.RESET + Variables.Color.VERDE + " $" + cantidadEntradasComprar*Variables.precioEntrada + Variables.Color.RESET);
        System.out.println(" ");
 


        System.out.println(Variables.Fuente.SUBRAYADO + "Formas de pago:" + Variables.Fuente.RESET);
        System.out.println("[1] PAGO CON TARJETA | [2] PAGO CON EFECTIVO");

        boolean condicion = false;
        boolean comprobante = false;
        do {
        System.out.print("Elija un medio de pago: "); 
        pago = Utilidades.lector.nextLine(); //El usuario debe ingresar el nro correspondiente a la opcion de pago
            switch(pago){
                case "1":
                    Comprar.pagotarjeta(); //Llama al metodo especifico para la Compra con tarjeta
                    condicion = true;
                    comprobante = true;
                    break;
                                
                case "2":
                    Comprar.pagoefectivo(); //Llama al metodo especifico para la Compra con efectivo
                    condicion = true;
                    comprobante = false;
                    break;

                default:
                    System.out.println("");
                    System.out.println(Variables.Color.ROJO + "Opción inválida. Por favor, seleccione una opción válida." + Variables.Color.RESET);
                    System.out.println("");
                    break;
            }
        }while (!condicion);

        //Una vez terminado el bucle del total de entradas a comprar limpiamos la consola y generamos el comprobante con los datos de la compra
        //Utilidades.limpiarConsola();
        System.out.println("");
        System.out.println("¡Muchas gracias por su compra!");
        System.out.println("Comprobante enviado a: " + Cliente.getEmailByDNI(dniCompra)); 

        //IMPRIMIMOS EL COMPROBANTE DE COMPRA
        Date fechaHoraActual = new Date(); //llamo a la clase Date para incluirla en el comprobante
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy HH:mm");
        String fechaHoraFormateada = formato.format(fechaHoraActual);
        

        System.out.println(Variables.Color.CYAN);
        System.out.println("-----------------------------------");
        System.out.println("       COMPROBANTE DE COMPRA       ");
        System.out.println("-----------------------------------");
        System.out.println("Fecha y Hora: " + fechaHoraFormateada);
        System.out.println("Cliente: " + Cliente.getNameByDNI(dniCompra) + " " + Cliente.getApellidoByDNI(dniCompra));
        System.out.println("DNI: " + dniCompra);
        System.out.println("-----------------------------------");

        for(int j = 0; j < cantidadEntradasComprar; j++){

            int posFila = entradasCompradasArray[j][0];
            int posColumna = entradasCompradasArray[j][1];
            
            System.out.println(Variables.Fuente.SUBRAYADO + "Boleto N°" + (j + 1) + ":" + Variables.Fuente.RESET + Variables.Color.CYAN + " Fila " + (posFila+1) + " - Columna: " + (posColumna+1));
            
        }
        
        System.out.println("-----------------------------------");
        
        if (comprobante){
            System.out.println("FORMA DE PAGO: "+ Variables.Color.VERDE + "TARJETA" + Variables.Color.RESET);
            System.out.println(Variables.Color.CYAN +"TOTAL: $" + cantidadEntradasComprar * Variables.precioEntrada); 
        }else {
            System.out.println("FORMA DE PAGO: " + Variables.Color.VERDE + "EFECTIVO" + Variables.Color.RESET);
            System.out.println(Variables.Color.CYAN +"TOTAL: $" + cantidadEntradasComprar * Variables.precioEntrada);           
            System.out.println("");
            System.out.println(Variables.Color.CYAN + "CODIGO DE RESERVA: "+ Variables.Color.MAGENTA + codigoPago);
            System.out.println(Variables.Color.CYAN + "(RESERVA VALIDA HASTA 20 min \nPREVIO AL INICIO DEL SHOW)");
            
        }

        System.out.println("-----------------------------------" + Variables.Color.RESET);
        System.out.println("");
    }
    

    public static void pagotarjeta(){
        
        System.out.println(Variables.Color.VERDE);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("                    INGRESE LOS DATOS DE LA TARJETA                    ");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(Variables.Color.RESET);

        
        do {
            System.out.print("Numero de tarjeta: "); //Pedimos los numeros de la tarjeta
            String numerodetarjeta = Utilidades.lector.nextLine();

            if (!numerodetarjeta.matches("[0-9]+")) {
                System.out.println("Por favor, ingrese los 16 numeros de su tarjeta sin letras ni espacios.");
            } else if (numerodetarjeta.length() != 16) {
                System.out.println("Por favor, ingrese los 16 numeros de su tarjeta.");
            } else if (numerodetarjeta.contains(" ")) {
                System.out.println("Por favor, ingrese los 16 numeros de su tarjeta sin letras ni espacios.");
            } else {
                break;  // Valor válido, salir del bucle
            }
        } while (true);

        do {
            System.out.print("Nombre de la tarjeta: "); //Pedimos el nombre que figura en la tarjeta
            String nombretarjeta = Utilidades.lector.nextLine();

            if (!nombretarjeta.matches("[a-zA-Z\\s]+")) {
                System.out.println("Por favor, ingresar el nombre como figura en la tarjeta.");
            } else {
                break;  // Valor válido, salir del bucle
            }
        } while (true);

        do {
        System.out.print("Código de seguridad: "); //Pedimos los numeros de seguridad de la tarjeta
        String seguridadtarjeta = Utilidades.lector.nextLine();
        
            if (!seguridadtarjeta.matches("[0-9]+")) {
                System.out.println("Por favor, ingrese solo numeros.");
            } else if (seguridadtarjeta.length() != 3) {
                System.out.println("Por favor, ingrese los 3 números de seguridad de su tarjeta.");
            } else {
                break;  // Valor válido, salir del bucle
            }
        }while (true);
        do {
        System.out.print("Cantidad de cuotas (hasta 3 cuotas sin interes): "); //Pedimos la cantidad de cuotas
        String cuotas = Utilidades.lector.nextLine();
            if (!cuotas.matches("[0-9]+")) {
                System.out.println("Por favor, ingrese el número de cuotas.");
            } else if (cuotas.length() <= 0) {
                System.out.println("Por favor, ingrese un número mayor a 0.");
            } else {
                break;  // Valor válido, salir del bucle
            }
        }while (true);

        

        System.out.print("Procesando compra");
        Utilidades.esperar(500);
        System.out.print(".");
        Utilidades.esperar(500);
        System.out.print(".");
        Utilidades.esperar(500);
        System.out.print(".");
        Utilidades.esperar(500);
    

        System.out.println(Variables.Color.VERDE + "COMPRA REALIZADA EXITOSAMENTE");
        Utilidades.esperar(2000);
        System.out.println("-----------------------------------------------------------------------" + Variables.Fuente.RESET);

    }


    static void pagoefectivo(){

        codigoPago = generarCodigoAlfanumerico(8);
        
        System.out.print("Procesando reserva");
        Utilidades.esperar(500);
        System.out.print(".");
        Utilidades.esperar(500);
        System.out.print(".");
        Utilidades.esperar(500);
        System.out.println(".");

        Utilidades.esperar(500);

        System.out.print("Generando cupón de pago");
        Utilidades.esperar(500);
        System.out.print(".");
        Utilidades.esperar(500);
        System.out.print(".");
        Utilidades.esperar(500);
        System.out.println(".");
        Utilidades.esperar(500);
        System.out.println(Variables.Color.VERDE + "RESERVA REALIZADA EXITOSAMENTE" + Variables.Color.RESET);
        System.out.println("Código generado: " + Variables.Color.MAGENTA + codigoPago + Variables.Fuente.RESET);
        Utilidades.esperar(2000);
    }

    public static String generarCodigoAlfanumerico(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }

        return codigo.toString();
    }
    
}


    
