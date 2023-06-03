public class eleccion {

    public static void posicion() {

        int pick_fila, pick_columna;

        for (int i = 0; i < informacion.cantidad_entradas_vendidas; i ++) {

            do {

                System.out.print("Elige la fila del asiento n°" + (i + 1) + ": ");

                pick_fila = venta_de_entradas.sc.nextInt() - 1;
        
                if (pick_fila < 0 || pick_fila >= estadio.estadio.length) {

                    System.out.println("Has elegido una fila inexistente, por favor inténtalo de nuevo.");

                }

            } while (pick_fila < 0 || pick_fila >= estadio.estadio.length);
        
            do {

                System.out.print("Elige la columna del asiento n°" + (i + 1) + ": ");

                pick_columna = venta_de_entradas.sc.nextInt() - 1;
        
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

        System.out.println("");
        System.out.println("Sus asientos se han guardado exitosamente.");
        System.out.println("");
    }
}