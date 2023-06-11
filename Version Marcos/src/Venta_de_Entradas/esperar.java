public class esperar {

    public static void mensaje() {

        System.out.print("Presione enter para continuar...");

        programa.sc.nextLine();
        
    }

    public static void unSegundo() {

        try {

            System.out.print("Espera un segundo");

            for (int i = 0; i < 3; i ++) {

                Thread.sleep(500);

                System.out.print(".");

            }

            borrarLinea();

        } catch (InterruptedException e) {
  
            e.printStackTrace();

        }

    }

    public static void borrarLinea() {

            System.out.print("\033[1A");

            System.out.print("\033[2K");

    }

}
