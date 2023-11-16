import java.util.ArrayList;

public class Administracion {
    
    public static void pedirContraseña(){
        System.out.println(Variables.Color.ROJO + "---------------------------------------------------------------------");
        System.out.println("            Acceso Restringido a Usuarios Autorizados                 ");
        System.out.println("     Si ingresó por error escriba 'SALIR' en lugar de la contraseña   ");
        System.out.println("---------------------------------------------------------------------" + Variables.Fuente.RESET);
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
        else if(claveIngresada.equalsIgnoreCase("SALIR")){
            System.out.print("Volviendo al menú principal");
            Utilidades.esperar(500);
            System.out.print(".");
            Utilidades.esperar(500);
            System.out.print(".");
            Utilidades.esperar(500);
            System.out.print(".");
            Utilidades.esperar(500);
            break;
        }
        else{
            System.out.println("La contraseña ingresada es incorrecta");
            intentos++;
        }
        }
       if (intentos>=3) {
            System.out.println("");
            System.out.println(Variables.Color.ROJO + "Has excedido el número máximo de intentos." + Variables.Color.RESET);
            System.out.println("Presione 'Enter' para volver al menú..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
             
            intentos = 0;
            Utilidades.lector.nextLine();
       }

   
    }

    public static void menuAdmin(){
        boolean menuA = true; 

        while (menuA){
        Utilidades.limpiarConsola();

        System.out.println(Variables.Color.VERDE + "                         Administración                              " + Variables.Color.RESET);

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("  [1] Información de ventas | [2] Listado de clientes | [3] Ordenamiento | [4] Salir   ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        
        System.out.print("- Elige una opción: ");

        
            String opcion = Utilidades.lector.nextLine();
        
           
            switch(opcion){
                
                case "1":
                Variables.cantidadEntradasVendidas = Variables.cantidadInicialEntradas - Variables.cantidadEntradasDisponibles;
                
                Utilidades.limpiarConsola();
                System.out.println( Variables.Fuente.SUBRAYADO + "Información de ventas:" + Variables.Fuente.RESET);
                System.out.println("Cantidad entradas vendidas: " + (Variables.cantidadEntradasVendidas));
                System.out.println("Cantidad entradas disponibles: " + (Variables.cantidadEntradasDisponibles));
                System.out.println("Dinero recaudado: $" + (Variables.cantidadEntradasVendidas * Variables.precioEntrada));
                System.out.println("");

                System.out.println("Presione 'Enter' para volver al menú..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
                Utilidades.lector.nextLine();
                Utilidades.limpiarConsola();
            break;

            case "2":
            Utilidades.limpiarConsola();
            System.out.println(Variables.Color.VERDE + "------------------------------------------------");
            System.out.println("                    CLIENTES");
            System.out.println("------------------------------------------------" + Variables.Color.RESET);
            System.out.println("");
            for ( int i=0 ; i<Variables.arrayClientes.length ; i++ ) {
                if (Variables.arrayClientes[i] != null){
                     System.out.println(Variables.Color.AZUL +"Cliente n° " + (i+1) + Variables.Color.RESET );
                    Cliente.imprimirDatos(i);
                }
            }
                System.out.println("");
                System.out.println("Presione 'Enter' para volver al menú..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
                Utilidades.lector.nextLine();
                Utilidades.limpiarConsola();
            break;

            case "3":
            Utilidades.limpiarConsola();
            ArrayList<Cliente> lista = new ArrayList<>();
            lista = Ordenamiento.ordenarLista(Variables.arrayClientes);
            
            System.out.println(Variables.Color.VERDE + "------------------------------------------------");
            System.out.println("                    CLIENTES");
            System.out.println("------------------------------------------------" + Variables.Color.RESET);
            
            int contador = 1;
            for (Cliente cliente : lista){
                
                System.out.println("");
                System.out.println(Variables.Color.AZUL +"Posicion n° " + contador + Variables.Color.RESET );
                System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
                System.out.println("DNI: " + cliente.getDNI());
                contador++;
            }
            contador = 0;

            System.out.println("");
            System.out.println("Presione 'Enter' para volver al menú..."); //Una vez terminado todo lo anterior esperamos que el usuario presione Enter para volver al menu
            Utilidades.lector.nextLine();
            Utilidades.limpiarConsola();

            break;

            case "4":
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
