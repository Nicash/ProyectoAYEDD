import java.util.Scanner; //Esta utilidad la vamos a usar para que el usuario introduzca un valor por consola y asignarlo a una variable

public class CompraEntradas {
    public static void main(String[] args) throws Exception {
        // DECLARAMOS LAS VARIABLES QUE VAMOS A UTILIZAR Y LE DAMOS VALOR A LAS PREDEFINIDAS
        
        // DATOS DE ENTRADA:

            int cantidadEntradasComprar; //La cantidad de entradas que va a querer comprar el usuario.
            String emailComprador; //El email del comprador, donde se enviará el comprobante de compra.
            long numeroCelularComprador; //El nro de telefono del comprador, donde se enviará el comprobante de compra.

        // DATOS DE SALIDA:

            int cantidadEntradasDisponibles = 100; //La cantidad de entradas disponibles que el usuario puede comprar.
            int precioEntrada = 500 ; //El precio de las entradas.
            String fechaConcierto = "09/07/2023"; //La fecha en que se realizará el concierto.
            String horaConcierto = "20:00"; //La hora en la que se realizará el concierto.
            String lugarConcierto = "Estadio River Plate"; //El lugar donde se realizará el concierto.
            int cantidadEntradasVendidas = 0; //La cantidad total de entradas vendidas.
            int cantidadDineroRecaudado = 0; //La cantidad total de dinero recaudado.

        // ARRANCAMOS CON LA SECUENCIA DEL PROGRAMA

        //Saludamos y damos la información del Concierto
        
        System.out.println("Bienvenido al portal de compra de entradas para el recital de 'Los Garcia'"); //Bienvenida

        System.out.println("Fecha: " + fechaConcierto +" - Hora: " + horaConcierto + " - Lugar: " + lugarConcierto ); //Datos: Fecha, Hora y Lugar

        System.out.println("Cantidad de entradas disponibles: " + cantidadEntradasDisponibles); //Entradas disponibles

        System.out.println("Precio de las entradas: " + precioEntrada); //Precio de la entrada

        System.out.println(""); //Cadena vacia para dejar un espacio
        
        //Creamos la herramienta que nos va a servir para leer los valores ingresados por el usuario
        Scanner lector = new Scanner(System.in);

        //Preguntamos la cantidad de entradas a comprar. El usuario debe ingresar la cantidad.

        System.out.print("- Introduzca la cantidad de entradas a comprar: ");
        cantidadEntradasComprar = lector.nextInt();
        lector.nextLine(); //salto de linea para q no me de error luego al leer el String

        //Hacemos los calculos necesarios en base a la cantidad de entradas que eligió el usuario
        cantidadEntradasDisponibles = cantidadEntradasDisponibles - cantidadEntradasComprar; //restamos las compradas al total
        cantidadEntradasVendidas = cantidadEntradasVendidas + cantidadEntradasComprar; //sumamos entradas vendidas a la variable que las contabiliza
        cantidadDineroRecaudado = cantidadDineroRecaudado + (cantidadEntradasComprar * precioEntrada); //calculamos el dinero juntado con esta compra

        //Preguntamos el email para enviar el comprobante
        System.out.print("- Introduzca un email para enviar el comprobante de compra: ");
        emailComprador = lector.nextLine();

        //Preguntamos el celular para enviar el comprobante
        System.out.print("- Introduzca un numero de celular para enviar el comprobante de compra: ");
        numeroCelularComprador = lector.nextLong();
        
        //Cerramos el lector que usamos
        lector.close();
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

        //MOSTRAMOS INFORMACION PARA LA EMPRESA y la Imprimimos

        System.out.println("INFORMACION VENTAS:");
        System.out.println("+ CANTIDAD DE ENTRADAS VENDIDAS: " + cantidadEntradasVendidas);
        System.out.println("+ TOTAL DINERO RECAUDADO: " + cantidadDineroRecaudado);
        System.out.println("+ CANTIDAD DE ENTRADAS DISPONIBLES: " + cantidadEntradasDisponibles);
    }
}
