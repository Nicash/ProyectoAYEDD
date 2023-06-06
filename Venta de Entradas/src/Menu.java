public  class Menu{
    
    static boolean funcionando = true;  //variable booleana que indica si debemos volver al menu luego de terminar otra accion
    static String opcion; //variable de opcion del Switch

    public static void ejecutarMenu() {
        // COMIENZA EL CICLO CONTINUO DEL MENU
        while (funcionando) {

            Utilidades.limpiarConsola(); //limpiamos la consola para mejor visibilidad

            //Saludamos y damos la información del Concierto

            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("               Bienvenido al portal de compra de entradas para el recital de " + Variables.Color.ROJO + "Los Garcia" + Variables.Color.RESET);
            System.out.println("                      Fecha: " + Variables.Color.AZUL + Variables.fechaConcierto + Variables.Color.RESET +" - Hora: " + Variables.Color.AZUL + Variables.horaConcierto + Variables.Color.RESET + " - Lugar: " + Variables.Color.AZUL + Variables.lugarConcierto  + Variables.Color.RESET );
            System.out.println("");
            System.out.println("                                   Cantidad de entradas disponibles: " + Variables.Color.VERDE + Variables.cantidadEntradasDisponibles + Variables.Color.RESET);
            System.out.println("                                        Precio de las entradas: " + Variables.Color.MAGENTA + "$" + Variables.precioEntrada + Variables.Color.RESET);
            System.out.println("");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("  [1] Comprar Entradas | [2] Ver Entradas Disponibles | [3] Mis Entradas | [4] " + Variables.Color.ROJO + "Administracion" + Variables.Color.RESET + " | [5] Salir  ");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.print("- Elige una opcion: ");
    
            opcion = Utilidades.lector.nextLine(); //el usuario debe ingresar el nro correspondiente a la opcion del menu

            switch (opcion) {

                case "1":
            
                    Utilidades.limpiarConsola();
                    Comprar.compraEntradas();
                    System.out.println("Presione 'Enter' para volver al menu...");
                    Utilidades.lector.nextLine();

                    break;

                case "2":
                    Utilidades.limpiarConsola();
                    Estadio.dibujarEstadio();
                    System.out.println("Presione 'Enter' para volver al menu...");
                    Utilidades.lector.nextLine();

                    break;

                case "3":
                    Utilidades.limpiarConsola();

                    break;

                case "4":
                    Utilidades.limpiarConsola();
                    Administracion.verInformacion();
                    System.out.println("Presione 'Enter' para volver al menu...");
                    Utilidades.lector.nextLine();

                    break;
        
                case "5":
                    Utilidades.lector.close();
                    System.out.print("Saliendo...");
                    funcionando = false;

                    break;

                default:

                    System.out.println("Opción inválida. Por favor, elige nuevamente. Presione 'Enter' para continuar...");
                    Utilidades.lector.nextLine();

                    break;

            }

        }

    }

}
