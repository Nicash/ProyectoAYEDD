public class Comprar{
    // DATOS DE ENTRADA:

    public static int cantidadEntradasComprar = 0; //La cantidad de entradas que va a querer comprar el usuario.
    public static String emailComprador = ""; //El email del comprador, donde se enviará el comprobante de compra.
    public static long numeroCelularComprador = 0; //El nro de telefono del comprador, donde se enviará el comprobante de compra.

    public static void compraEntradas(){
        
        //Preguntamos la cantidad de entradas a comprar. El usuario debe ingresar la cantidad.

        Estadio.dibujarEstadio(); //antes de elegir cuantas entradas quiere comprar dibujamos el estadio y mostramos la cantidad disponible
    
        do {

            System.out.print("Ingrese la cantidad de entradas que desea comprar: ");

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
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo (1000 milisegundos)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Utilidades.limpiarConsola();
                Estadio.dibujarEstadio();
            }
            
        }

        System.out.println("");
        System.out.println("Sus asientos se han guardado exitosamente.");
        
        for(int j = 0; j < cantidadEntradasComprar; j++){
            System.out.println(Variables.Fuente.SUBRAYADO + "Boleto N°" + (j + 1) + ":" + Variables.Fuente.RESET + " Fila " + (entradasCompradasArray[j][0]+1) + " - Columna: " + (entradasCompradasArray[j][1]+1));
        }
        
        System.out.println("");
    

    

    //Preguntamos el email para enviar el comprobante
        System.out.print("- Introduzca un email para enviar el comprobante de compra: ");
        emailComprador = Utilidades.lector.nextLine();

    //Preguntamos el celular para enviar el comprobante
        System.out.print("- Introduzca un numero de celular para enviar el comprobante de compra: ");
        numeroCelularComprador = Utilidades.lector.nextLong();
    
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

}
