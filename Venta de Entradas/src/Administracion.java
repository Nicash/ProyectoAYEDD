public class Administracion {
    
    public static void pedirContraseña(){

        String contraseña ="utn2023";
        String claveIngresada;
        int intentos = 0;
        
        while(intentos!=3){
        System.out.print("Ingrese contraseña: "); 
        claveIngresada = Utilidades.lector.nextLine();
   
        
        if(contraseña.equals(claveIngresada)){
            menuAdmin();
            break;
        }
        else{
            System.out.println("La contraseña ingresada es incorrecta");
            intentos++;
        }
        }
       if (intentos>=3) {
            System.out.println("Has excedido el numero maximo de intentos.");
            intentos = 0;
       }

   
    }

    public static void menuAdmin(){
        boolean menuA = true; 

        while (menuA){
        Utilidades.limpiarConsola();

        System.out.println(Variables.Color.VERDE + "                         Administracion                              " + Variables.Color.RESET);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("  [1] Informacion de ventas | [2] Listado de clientes | [3] Salir ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("");
        
        System.out.print("- Elige una opcion: ");

        
            String opcion = Utilidades.lector.nextLine();
        
           
            switch(opcion){
                
                case "1":
                Variables.cantidadEntradasVendidas = Variables.cantidadInicialEntradas - Variables.cantidadEntradasDisponibles;
                
                Utilidades.limpiarConsola();
                System.out.println( Variables.Fuente.SUBRAYADO + "Informacion de ventas:" + Variables.Fuente.RESET);
                System.out.println("Cantidad entradas vendidas: " + (Variables.cantidadEntradasVendidas));
                System.out.println("Cantidad entradas disponibles: " + (Variables.cantidadEntradasDisponibles));
                System.out.println("Dinero recaudado: $" + (Variables.cantidadEntradasVendidas * Variables.precioEntrada));
                System.out.println("");

                System.out.println("Presione 'Enter' para volver al menu..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
                Utilidades.lector.nextLine();
                Utilidades.limpiarConsola();
            break;

            case "2":
            Utilidades.limpiarConsola();
            System.out.println("Clientes:");
            System.out.println("");
            for ( int i=0 ; i<Variables.arrayClientes.length ; i++ ) {
                if (Variables.arrayClientes[i] != null){
                     System.out.println(Variables.Color.AZUL +"Cliente n°" + (i+1) + Variables.Color.RESET );
                    Cliente.imprimirDatos(i);
                }
            }
                System.out.println("");
                System.out.println("Presione 'Enter' para volver al menu..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
                Utilidades.lector.nextLine();
                Utilidades.limpiarConsola();
            break;
            
            case "3":
            System.out.println("");
            System.out.print("Saliendo.");
            Utilidades.esperar(500);
            System.out.print(".");
            Utilidades.esperar(500);
            System.out.print(".");
            Utilidades.esperar(500);
            menuA = false;
            break;
            
            default:
            
            System.out.println("Opción inválida. Por favor, elige nuevamente. Presione 'Enter' para continuar...");  //Cada vez que se ponga una opcion invalida se avisa y se vuelve a la eleccion de opcion
            Utilidades.lector.nextLine();
            
            break;
            
        }
        }


    }

}
