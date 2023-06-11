public class informacion {

    public static final int PRECIO = 2400;

    public static final int ENTRADAS = 100;

    public static int espacios_ocupados = 32;

    public static int cantidad_entradas_vendidas = 0;

    public static void evento() {

        do {

            System.out.print("Ingrese la cantidad de entradas que desea comprar: ");

            cantidad_entradas_vendidas = programa.sc.nextInt();

            programa.sc.nextLine();

            if (cantidad_entradas_vendidas > (ENTRADAS - espacios_ocupados)) {

                System.out.println("La cantidad de entradas que usted desea comprar es mayor a las entradas disponibles, intentelo de nuevo.");

            } else if (cantidad_entradas_vendidas <= 0) {

                System.out.println("La cantidad ingresada es incorrecta, intentelo de nuevo.");
            }


        } while (cantidad_entradas_vendidas <= 0 || cantidad_entradas_vendidas > (ENTRADAS - espacios_ocupados));

    }
}
