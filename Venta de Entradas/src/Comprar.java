public class Comprar{
    // DATOS DE ENTRADA:

    public static int cantidadEntradasComprar = 0; //La cantidad de entradas que va a querer comprar el usuario.
    public static String emailComprador = ""; //El email del comprador, donde se enviará el comprobante de compra.
    public static long numeroCelularComprador = 0; //El nro de telefono del comprador, donde se enviará el comprobante de compra.

    public static void compraEntradas(){
        System.out.print("Ingrese su numero de DNI: ");
        String dniCompra = Utilidades.lector.nextLine();

        if(!Cliente.existeCliente(dniCompra)){
            System.out.println("No tienes cuenta creada. Vamos a crearte una.");
            System.out.println("+ Ingresa tus datos:");
            Cliente.crearCuenta(dniCompra);
        }
        
        Utilidades.limpiarConsola();
        Estadio.dibujarEstadio(); //antes de elegir cuantas entradas quiere comprar dibujamos el estadio y mostramos la cantidad disponible
    
        do {
            System.out.println("Bienvenido, " + Cliente.getNameByDNI(dniCompra) + "."); //Saludamos con el nombre
            System.out.print("Ingrese la cantidad de entradas que desea comprar: "); //Preguntamos la cantidad de entradas a comprar. El usuario debe ingresar la cantidad.

            cantidadEntradasComprar = Utilidades.lector.nextInt();
            Utilidades.lector.nextLine(); //salto de linea para q no me de error luego al leer el String

            if (cantidadEntradasComprar > Variables.cantidadEntradasDisponibles) {

                System.out.println("La cantidad de entradas que usted desea comprar es mayor a las entradas disponibles, intentelo de nuevo.");

            } else if (cantidadEntradasComprar <= 0) {

                System.out.println("La cantidad ingresada es incorrecta, intentelo de nuevo.");
            }


        } while (cantidadEntradasComprar <= 0 || cantidadEntradasComprar > Variables.cantidadEntradasDisponibles);

        int[][] entradasCompradasArray = new int[cantidadEntradasComprar][2];

        // Luego de elegir la cantidad le decimos que elija la posicion de las mismas.

        int pick_fila, pick_columna;

        for (int i = 0; i < cantidadEntradasComprar; i ++) {

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

            } while (pick_fila < 0 || pick_fila >= Estadio.estadio.length);
        
            do {

                System.out.print("Introduzca n° de COLUMNA: ");

                pick_columna = Utilidades.lector.nextInt() - 1;
                Utilidades.lector.nextLine();
        
                if (pick_columna < 0 || pick_columna >= Estadio.estadio[pick_fila].length) {

                    System.out.println("Has elegido una columna inexistente, por favor inténtalo de nuevo. Presione 'Enter' para continuar...");
                    Utilidades.lector.nextLine();
                }

            } while (pick_columna < 0 || pick_columna >= Estadio.estadio[pick_fila].length);
        
            if (!Estadio.estadio[pick_fila][pick_columna].equals("")) {

                System.out.println("Has elegido una posición que no está disponible, por favor inténtalo de nuevo. Presione 'Enter' para continuar...");
                Utilidades.lector.nextLine();
                i --;

            } else {

                System.out.println("Boleto N°" + (i + 1) + ". Lugares guardados: Fila " + (pick_fila + 1) + " Columna " + (pick_columna + 1));
                Estadio.estadio[pick_fila][pick_columna] = "x";
                entradasCompradasArray[i][0] = pick_fila;
                entradasCompradasArray[i][1] = pick_columna;
                System.out.println("");


                
                Utilidades.esperar(1);

                Utilidades.limpiarConsola();
                Estadio.dibujarEstadio();
            }
            
        }
        Utilidades.limpiarConsola();
        System.out.println("Muchas gracias por su compra.");
        System.out.println("Comprobante enviado a: " + Cliente.getEmailByDNI(dniCompra)); 

        //IMPRIMIMOS EL COMPROBANTE DE COMPRA
        System.out.println(Variables.Color.CYAN);
        System.out.println("-----------------------------------");
        System.out.println("       COMPROBANTE DE COMPRA       ");
        System.out.println("-----------------------------------");
        System.out.println("Cliente: " + Cliente.getNameByDNI(dniCompra) + " " + Cliente.getApellidoByDNI(dniCompra));
        System.out.println("DNI: " + dniCompra);
        System.out.println("-----------------------------------");
        for(int j = 0; j < cantidadEntradasComprar; j++){
            int posFila = entradasCompradasArray[j][0];
            int posColumna = entradasCompradasArray[j][1];
            
            System.out.println(Variables.Fuente.SUBRAYADO + "Boleto N°" + (j + 1) + ":" + Variables.Fuente.RESET + Variables.Color.CYAN + " Fila " + (posFila+1) + " - Columna: " + (posColumna+1));
            
            Cliente.agregarBoleto(dniCompra,(posFila+1),(posColumna+1));
        }

        System.out.println("-----------------------------------");
        System.out.println(Variables.Color.RESET);
    }

}
