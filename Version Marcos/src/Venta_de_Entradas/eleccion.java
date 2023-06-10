public class eleccion {

    public static int pick_fila;
    public static int pick_columna;

    public static void elegirPosicion() {

        if (informacion.cantidad_entradas_vendidas == 0) {

            System.out.println("Tienes que comprar entradas para elegir asientos...");
            System.out.println("ingresa a la opción 1 del menú para hacerlo...");
            System.out.println("");

            esperar.mensaje();

        } else {

            for (int i = 0; i < informacion.cantidad_entradas_vendidas; i ++) {

            do {

                System.out.print("Elige la fila del asiento n°" + (i + 1) + ": ");

                pick_fila = programa.sc.nextInt() - 1;
        
                if (pick_fila < 0 || pick_fila >= estadio.estadio.length) {

                    System.out.println("Has elegido una fila inexistente, por favor inténtalo de nuevo.");

                }

            } while (pick_fila < 0 || pick_fila >= estadio.estadio.length);
        
            do {

                System.out.print("Elige la columna del asiento n°" + (i + 1) + ": ");

                pick_columna = programa.sc.nextInt() - 1;
        
                if (pick_columna < 0 || pick_columna >= estadio.estadio[pick_fila].length) {

                    System.out.println("Has elegido una columna inexistente, por favor inténtalo de nuevo.");

                }

            } while (pick_columna < 0 || pick_columna >= estadio.estadio[pick_fila].length);
        
            if (!estadio.estadio[pick_fila][pick_columna].equals("")) {

                System.out.println("Has elegido una posición que no está disponible, por favor inténtalo de nuevo.");

                i --;

            } else {

                System.out.println("");
                System.out.println("El asiento n°" + (i + 1) + " se encuentra en la fila " + (pick_fila + 1) + " y en la columna " + (pick_columna + 1));

            }
        }

        }
     
    }
}