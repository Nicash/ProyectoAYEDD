public  class Menu{
    
    static boolean funcionando = true;  //variable booleana que indica si debemos volver al menu luego de terminar otra accion
    static String opcion; //variable de opcion del Switch

    public static void ejecutarMenu() {
        // COMIENZA EL CICLO CONTINUO DEL MENU
        while (funcionando) {

            Utilidades.limpiarConsola(); //limpiamos la consola para mejor visibilidad

            //Saludamos y damos la información del Concierto

            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("               Bienvenido al portal de compra de entradas para el recital de " + Variables.Color.ROJO + "'"+ Variables.nombreBanda + "'" + Variables.Color.RESET);
            System.out.println("                      Fecha: " + Variables.Color.AZUL + Variables.fechaConcierto + Variables.Color.RESET +" - Hora: " + Variables.Color.AZUL + Variables.horaConcierto + Variables.Color.RESET + " - Lugar: " + Variables.Color.AZUL + Variables.lugarConcierto  + Variables.Color.RESET );
            System.out.println("");
            System.out.println("                                   Cantidad de entradas disponibles: " + Variables.Color.VERDE + Variables.cantidadEntradasDisponibles + Variables.Color.RESET);
            System.out.println("                                        Precio de las entradas: " + Variables.Color.MAGENTA + "$" + Variables.precioEntrada + Variables.Color.RESET);
            System.out.println("");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("  [1] Comprar Entradas | [2] Ver Entradas Disponibles | [3] Mis Entradas | [4] " + Variables.Color.ROJO + "Administración" + Variables.Color.RESET + " | [5] Salir  ");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.print("- Elige una opción: ");
    
            opcion = Utilidades.lector.nextLine(); //El usuario debe ingresar el nro correspondiente a la opcion del menu

            switch (opcion) {

                case "1":
            
                    Utilidades.limpiarConsola(); //Limpiamos la consola
                    Comprar.compraEntradas(); //Llama al metodo especifico para la Compra de Entradas
                    System.out.println("Presione 'Enter' para volver al menú..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
                    Utilidades.lector.nextLine();

                    break;

                case "2":
                    Utilidades.limpiarConsola(); //Limpiamos la consola
                    Estadio.dibujarEstadio();  //Llama al metodo especifico para Dibujar el Estadio y mostrar las posiciones disponibles
                    System.out.println("Presione 'Enter' para volver al menú..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
                    Utilidades.lector.nextLine();

                    break;

                case "3":
                    Utilidades.limpiarConsola(); //Limpiamos la consola
                    Cliente.verEntradas(); //Llamamos al método específico para que el usuario pueda ver las entradas que compró
                    System.out.println("Presione 'Enter' para volver al menú..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
                    Utilidades.lector.nextLine();
                    break;

                case "4":
                    Utilidades.limpiarConsola(); //Limpiamos la consola
                    Administracion.pedirContraseña(); //Llamamos al método especifico de la Administración
                    

                    break;
        
                case "5":
                    Utilidades.lector.close(); //Cerramos el lector antes de salir del programa
                    System.out.print("Saliendo");  //Mensaje que avisa que el programa se está cerrando
                    Utilidades.esperar(500);
                    System.out.print(".");
                    Utilidades.esperar(500);
                    System.out.print(".");
                    Utilidades.esperar(500);
                    System.out.print(".");
                    funcionando = false;  //Ponemos en 'false' la variable booleana que hacia que el bucle del Menu funcionara, de esta manera el programa termina
                    break;

                default:

                    System.out.println("Opción inválida. Por favor, elige nuevamente. Presione 'Enter' para continuar...");  //Cada vez que se ponga una opcion invalida se avisa y se vuelve a la eleccion de opcion
                    Utilidades.lector.nextLine();

                    break;

            }

        }

    }

}
