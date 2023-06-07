public class Cliente{
    
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int[][] entradasCompradas; //en este array se van a guardar una por una las posiciones de las entradas que compre el usuario
    private int contadorEntradas; //con este contador vamos a saber el total de entradas que compró el usuario
    
    //Constructor de la clase Cliente
    public Cliente(String dni, String nombre, String apellido, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.entradasCompradas = new int[100][2];
        this.contadorEntradas = 0;
    }

    //Metodo para agregar un Cliente al Array de Clientes en la primera posicion vacia que se encuentre
    public void agregarCliente(Cliente nuevoCliente) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i] == null) { // Encuentra el primer índice vacío
                Variables.arrayClientes[i] = nuevoCliente; // Almacena el cliente en ese índice
                break; // Sal del bucle una vez que se haya agregado el cliente
            }
        }
    }

    //Metodo que devuelve un booleano que indica si ya existe un usuario con el DNI que se indica
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

    //Metodo que por medio del DNI proporcionado nos indica en qué posicion del array de clientes se encuentra el usuario
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

    //Metodo que devuelve el Nombre del Usuario al proporcionarle el DNI del mismo
    public static String getNameByDNI(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i].dni.equals(dni)) {
                return Variables.arrayClientes[i].nombre;
            }
            
        }
        return "error";
    }

    //Metodo que devuelve el Apellido del Usuario al proporcionarle el DNI del mismo
    public static String getApellidoByDNI(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i].dni.equals(dni)) {
                return Variables.arrayClientes[i].apellido;
            }
            
        }
        return "error";
    }

    //Metodo que devuelve el eMail del Usuario al proporcionarle el DNI del mismo
    public static String getEmailByDNI(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i].dni.equals(dni)) {
                return Variables.arrayClientes[i].email;
            }
        }
        return "error";
    }

    //Metodo que devuelve el Telefono del Usuario al proporcionarle el DNI del mismo
    public static String getTelefonoByDNI(String dni) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i].dni.equals(dni)) {
                return Variables.arrayClientes[i].telefono;
            }
            
        }
        return "error";
    }
    
    //Con este Metodo creamos una cuenta con los parametros que le proporcionemos al iniciar el programa, sirve para testear
    public static void crearCuentaAdmin(String dni, String nombre, String apellido, String email, String telefono) {
        for (int i = 0; i < Variables.arrayClientes.length; i++) {
            if (Variables.arrayClientes[i] == null) { // Encuentra el primer índice vacío
                
                Variables.arrayClientes[i] = new Cliente(dni, nombre, apellido, email, telefono);

                break; // Sal del bucle una vez que se haya agregado el cliente

            }
        }
    }

    //Con este Metodo vamos a pedirle todos los datos necesarios al usuario para crear el objeto Usuario y meterlo en el array de Clientes en la primera posicion vacia que encuentre
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

    //Con este Metodo vamos a poder ir agregando cada entrada que compre el Usuario al array de entradas compradas por el mismo
    public static void agregarBoleto(String dni, int fila, int columna) {

        int posCliente = posCliente(dni);
        int posEntrada = Variables.arrayClientes[posCliente].contadorEntradas;

        Variables.arrayClientes[posCliente].entradasCompradas[posEntrada][0] = fila;
        Variables.arrayClientes[posCliente].entradasCompradas[posEntrada][1] = columna;
        Variables.arrayClientes[posCliente].contadorEntradas += 1;
                    
        
    }

    //Metodo para ver el total de entradas compradas por el usuario
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
            
        }                     

        else{
            System.out.println(Variables.Color.ROJO + "No tienes cuenta creada." + Variables.Color.RESET);
            System.out.println("");

        } 
    }


}
