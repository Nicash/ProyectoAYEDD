public class administracion {

    public static void informacionVentas() {

        String contraseña = "admin";
        String try_contraseña = "";

        while (contraseña.equals(try_contraseña) != true) {

            System.out.print("Ingrese la contraseña de administración: ");
            try_contraseña = programa.sc.nextLine();

            esperar.unSegundo();

            if (contraseña.equals(try_contraseña) != true) {

                System.out.println("La contraseña es incorrecta, por favor, intentelo de nuevo.");

            } else {

                System.out.println("Contraseña correcta. Entrado a administración...");
            }
        }


        System.out.println("");
        System.out.println("Informe de ventas: ");
        System.out.println("");

        int monto_recaudado = (informacion.cantidad_entradas_vendidas + informacion.espacios_ocupados) * informacion.PRECIO;

        int entredas_disponibles = informacion.ENTRADAS - informacion.cantidad_entradas_vendidas - informacion.espacios_ocupados;

        System.out.println("Entradas vendidas: " + (informacion.cantidad_entradas_vendidas + informacion.espacios_ocupados));

        System.out.println("Cantidad recaudada: $" + (monto_recaudado));

        System.out.println("Entradas disponibles: " + entredas_disponibles);

        System.out.println("");

        esperar.mensaje();
    }
}