public class administracion {
    
    public static void estadisticas() {

        System.out.println("");
        System.out.println("Informe de ventas: ");
        System.out.println("");

        int monto_recaudado = (informacion.cantidad_entradas_vendidas + informacion.espacios_ocupados) * informacion.PRECIO;

        int entredas_disponibles = informacion.ENTRADAS - informacion.cantidad_entradas_vendidas - informacion.espacios_ocupados;

        System.out.println("Se han vendido " + (informacion.cantidad_entradas_vendidas + informacion.espacios_ocupados + " hasta ahora."));

        System.out.println("Cantidad recaudada: $" + (monto_recaudado));

        System.out.println("De las " + informacion.ENTRADAS + " entradas iniciales quedan " + entredas_disponibles + " entradas disponibles.");

        venta_de_entradas.sc.close();
    
    }
}