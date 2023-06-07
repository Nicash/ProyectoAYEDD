public class Comprar{
    
    public static int cantidadEntradasComprar = 0; //La cantidad de entradas que va a querer comprar el usuario.
    public static String emailComprador = ""; //El email del comprador, donde se enviará el comprobante de compra.
    public static long numeroCelularComprador = 0; //El nro de telefono del comprador, donde se enviará el comprobante de compra.

    public static void compraEntradas(){
        System.out.print("Ingrese su numero de DNI: "); //Pedimos el DNI al usuario
        String dniCompra = Utilidades.lector.nextLine();

        if(!Cliente.existeCliente(dniCompra)){ //Llamamos al metodo que checkea mediante el DNI si el Cliente existe
            System.out.println("No tienes cuenta creada. Vamos a crearte una."); 
            System.out.println("+ Ingresa tus datos:");
            Cliente.crearCuenta(dniCompra); //En caso de que no exista vamos a llamar al metodo que crea una cuenta llevando ya como parametro el DNI
        }
        
        Utilidades.limpiarConsola(); //Limpiamos la consola
        Estadio.dibujarEstadio(); //Antes de elegir cuantas entradas quiere comprar dibujamos el estadio y mostramos la cantidad disponible
    
        do { //Este bucle se va a repetir hasta que el usuario ingrese un numero valido (no negativo, ni mayor al numero de entradas disponibles)
            System.out.println("Bienvenido, " + Cliente.getNameByDNI(dniCompra) + "."); //Saludamos con el nombre invocando un metodo para obtener el nombre del usuario mediante el DNI
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
                entradasCompradasArray[i][0] = pick_fila; //Guardamos la fila elegida en el array de entradasCompradas, en la posicion de las filas (0)
                entradasCompradasArray[i][1] = pick_columna; //Guardamos la columna elegida en el array de entradasCompradas, en la posicion de las columnas (1)
                System.out.println(""); //Dejamos un espacio
                
                Utilidades.esperar(1); //Esperamos un segundo luego de mostar el mensaje de eleccion de fila y columna para que de tiempo a leer
                Utilidades.limpiarConsola(); //Limpiamos la consola
                Estadio.dibujarEstadio(); //Volvemos a dibujar el estadio
            }
            
        }

        //Una vez terminado el bucle del total de entradas a comprar limpiamos la consola y generamos el comprobante con los datos de la compra
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
            
            Cliente.agregarBoleto(dniCompra,(posFila+1),(posColumna+1)); //con este Metodo agregamos las entradas una por una al array que posee cada usuario para tal fin
        }
        System.out.println("-----------------------------------");
        System.out.println(Variables.Color.RESET);
    }

}
