public class comprobante {

    public static void venta() {

        int opcion;

        int bandera = 0;

        String gmail, telefono;

        do {

            System.out.println("Por favor, elige por dónde quieres recibir el comprobante: ");

            System.out.println("1. Por correo electrónico (Gmail)");

            System.out.println("2. Por teléfono");

            System.out.print("Opcion: ");

            opcion = programa.sc.nextInt();

            programa.sc.nextLine();

            System.out.println("");

            switch (opcion) {

                case 1:

                    do {

                        System.out.print("Ingrese su correo electrónico: ");

                        gmail = programa.sc.nextLine();

                        int arroba = 0;

                        int punto = 0;

                        for (int i = 0; i < gmail.length(); i++) {

                            if (gmail.charAt(i) == '@') {

                                arroba++;

                            } else if (gmail.charAt(i) == '.') {

                                punto++;
                            }
                        }

                        if (arroba == 1 && punto == 1) {

                            System.out.println("");

                            System.out.println("Su dirección de correo electrónico es válida.");

                            System.out.println("");

                            System.out.println("Su comprobante será enviado al Gmail: " + gmail);

                            bandera = 1;

                        } else {

                            System.out.println("Su dirección de correo electrónico no es válida.");

                            System.out.println("Por favor, intente ingresar su correo electrónico de nuevo.");

                            System.out.println("");

                        }

                } while (bandera != 1);

                break;

                case 2:

                    do {

                        System.out.print("Ingrese su número de teléfono: ");

                        telefono = programa.sc.nextLine();

                        if (telefono.matches("[0-9]+")) {

                            System.out.println("");

                            System.out.println("Su comprobante se enviara al número " + telefono);

                            bandera = 1;

                        } else {

                            System.out.println("Teléfono incorrecto, por favor, intentelo de nuevo.");

                        }

                    } while (bandera != 1);

                    break;

                default:

                    System.out.println("No has ingresado una opción válida, por favor, inténtalo de nuevo.");

                    System.out.println("");

                    break;
            }

        } while (bandera != 1);

    }
}