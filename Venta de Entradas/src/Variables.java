public class Variables {
    
    public static final int cantidadInicialEntradas = 100;
    public static int cantidadEntradasDisponibles = 100; //La cantidad de entradas disponibles que el usuario puede comprar.
    public static int precioEntrada = 500 ; //El precio de las entradas.

    public static String nombreBanda = "Los García"; //Nombre de la banda
    public static String fechaConcierto = "09/07/2023"; //La fecha en que se realizará el concierto.
    public static String horaConcierto = "20:00"; //La hora en la que se realizará el concierto.
    public static String lugarConcierto = "Teatro Ideal"; //El lugar donde se realizará el concierto.

    public static int cantidadEntradasVendidas = 0; //La cantidad total de entradas vendidas.
    public static int cantidadDineroRecaudado = 0; //La cantidad total de dinero recaudado.

    public static Cliente arrayClientes[] = new Cliente[100]; //Inicializamos un arreglo del tipo Cliente con 100 posiciones, que va a tener todos los datos de los clientes con las entradas que compraron

    //Variables de Color

    public static class Color { 

        public static final String RESET = "\u001B[0m"; //Pone el color por defecto
        public static final String NEGRO = "\u001B[30m";
        public static final String ROJO = "\u001B[31m";
        public static final String VERDE = "\u001B[32m";
        public static final String AMARILLO = "\u001B[33m";
        public static final String AZUL = "\u001B[34m";
        public static final String MAGENTA = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String BLANCO = "\u001B[37m";

    }

    public static class Fuente{

        public static final String RESET = "\u001B[0m";
        public static final String NEGRITA = "\u001B[1m";
        public static final String SUBRAYADO = "\u001B[4m";
        public static final String PARPADEO = "\u001B[5m";
        public static final String INVERSO = "\u001B[7m";

    }
    
}
