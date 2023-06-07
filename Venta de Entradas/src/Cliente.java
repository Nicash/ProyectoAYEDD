public class Cliente{
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int[][] entradasCompradas;
    private int contadorEntradas;
    
    public Cliente(String dni, String nombre, String apellido, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.entradasCompradas = new int[100][2];
        this.contadorEntradas = 0;
    }

    public void agregarCliente(Cliente nuevoCliente) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i] == null) { // Encuentra el primer índice vacío
                Variables.arrayClientes[i] = nuevoCliente; // Almacena el cliente en ese índice
                break; // Sal del bucle una vez que se haya agregado el cliente
            }
        }
    }

    public static boolean existeCliente(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i] != null) {
                if (Variables.arrayClientes[i].dni.equals(dni)) {
                return true;
                }
            }
        }
        return false;

    }

    public static int posCliente(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i] != null) {
                if (Variables.arrayClientes[i].dni.equals(dni)) {
                return i;
                }
            }
        }
        return 1000;

    }

    public static String getNameByDNI(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i].dni.equals(dni)) {
                return Variables.arrayClientes[i].nombre;
            }
            
        }
        return "error";
    }

    public static String getApellidoByDNI(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i].dni.equals(dni)) {
                return Variables.arrayClientes[i].apellido;
            }
            
        }
        return "error";
    }

    public static String getEmailByDNI(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i].dni.equals(dni)) {
                return Variables.arrayClientes[i].email;
            }
        }
        return "error";
    }

    public static String getTelefonoByDNI(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i].dni.equals(dni)) {
                return Variables.arrayClientes[i].telefono;
            }
            
        }
        return "error";
    }
    
    public static void crearCuentaAdmin(String dni, String nombre, String apellido, String email, String telefono) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i] == null) { // Encuentra el primer índice vacío
                
                Variables.arrayClientes[i] = new Cliente(dni, nombre, apellido, email, telefono);

                break; // Sal del bucle una vez que se haya agregado el cliente

            }
        }
    }


    public static void crearCuenta(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i] == null) { // Encuentra el primer índice vacío
                
                System.out.print(Variables.Fuente.SUBRAYADO + "Nombre:" + Variables.Fuente.RESET + " ");
                String nombre = Utilidades.lector.nextLine();

                System.out.print(Variables.Fuente.SUBRAYADO + "Apellido:" + Variables.Fuente.RESET + " ");
                String apellido = Utilidades.lector.nextLine();

                System.out.print(Variables.Fuente.SUBRAYADO + "eMail:" + Variables.Fuente.RESET + " ");
                String email = Utilidades.lector.nextLine();

                System.out.print(Variables.Fuente.SUBRAYADO + "Telefono:" + Variables.Fuente.RESET + " ");
                String telefono = Utilidades.lector.nextLine();

                Variables.arrayClientes[i] = new Cliente(dni, nombre, apellido, email, telefono);

                System.out.println("Cuenta creada con exito.");

                break; // Sal del bucle una vez que se haya agregado el cliente
            }
        }
    }

    public static void agregarBoleto(String dni, int fila, int columna) {

        int posCliente = posCliente(dni);
        int posEntrada = Variables.arrayClientes[posCliente].contadorEntradas;

                        Variables.arrayClientes[posCliente].entradasCompradas[posEntrada][0] = fila;
                        Variables.arrayClientes[posCliente].entradasCompradas[posEntrada][1] = columna;
                        Variables.arrayClientes[posCliente].contadorEntradas += 1;
                    
        
    }

    public static void verEntradas(){

        System.out.print("Ingrese su numero de DNI: ");
        String dni = Utilidades.lector.nextLine();
        System.out.println("");

        
        if(Cliente.existeCliente(dni)){
            
            int pos = posCliente(dni);
            
            System.out.print(Variables.Color.VERDE + "+ " + Variables.Fuente.SUBRAYADO + "Cliente:" + Variables.Fuente.RESET + " ");
            System.out.println(Variables.arrayClientes[pos].nombre + " " + Variables.arrayClientes[pos].apellido);
            System.out.println(Variables.Color.VERDE + "+ " + Variables.Fuente.SUBRAYADO + "Entradas Compradas:" + Variables.Fuente.RESET + " ");

            for(int j = 0; j < Variables.arrayClientes[pos].entradasCompradas.length;j++){

                if(Variables.arrayClientes[pos].entradasCompradas[j][0] != 0){
                        System.out.print("     " + Variables.Fuente.SUBRAYADO + "Boleto Nro " + (j+1) + ":" + Variables.Fuente.RESET);
                        System.out.println(" Fila: " + Variables.arrayClientes[pos].entradasCompradas[j][0] + " - Columna: " + Variables.arrayClientes[pos].entradasCompradas[j][1]);
                }

            }
            System.out.println("");
            System.out.println("Presione 'Enter' para volver al menu.");
            Utilidades.lector.nextLine();
            
        }                     

        else{
            System.out.println(Variables.Color.ROJO + "No tienes cuenta creada." + Variables.Color.RESET);
            System.out.println("");
            System.out.println("Presione 'Enter' para volver al menu...");
            Utilidades.lector.nextLine();

        } 
    }


}
