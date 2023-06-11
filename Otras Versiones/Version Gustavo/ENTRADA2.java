package GUS.src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ENTRADA2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String pelicula, idioma, asiento;
            int cantidadEntradas=1;
            String nombre, apellido, email;
            double subtotal;

            // Cálculo del subtotal
            subtotal = cantidadEntradas*2500;   
            
            // Selección de película
            System.out.println("Bienvenido a nuestro sistema de compra de entradas de cine");
            System.out.println("Por favor, seleccione una película:");
            System.out.println("1. The Weeknd");
            System.out.println("2. Taylor Swift");
            System.out.println("3. Babasónicos");
            int opcionPelicula = scanner.nextInt();
            
            switch (opcionPelicula) {
                case 1:
                    pelicula = "The Weeknd";
                    break;
                case 2:
                    pelicula = "Taylor Swift";
                    break;
                case 3:
                    pelicula = "Babasónicos";
                    break;
                default:
                    System.out.println("Opción inválida. Saliendo del programa.");
                    return;
            }
            
            // Selección de idioma
            System.out.println("Seleccione el idioma:");
            System.out.println("1. Subtitulada");
            System.out.println("2. Español");
            int opcionIdioma = scanner.nextInt();
            
            if (opcionIdioma == 1) {
                idioma = "Subtitulada";
            } else if (opcionIdioma == 2) {
                idioma = "Español";
            } else {
                System.out.println("Opción inválida. Saliendo del programa.");
                return;
            }
            
            // Cantidad de entradas
            System.out.println("Ingrese la cantidad de entradas:");
            cantidadEntradas = scanner.nextInt();
            
            // Selección de asiento
            System.out.println("Seleccione un asiento:");
            System.out.println("1. 22");
            System.out.println("2. 43");
            System.out.println("3. 64");
            int opcionAsiento = scanner.nextInt();
            
            switch (opcionAsiento) {
                case 1:
                    asiento = "22";
                    break;
                case 2:
                    asiento = "43";
                    break;
                case 3:
                    asiento = "64";
                    break;
                default:
                    System.out.println("Opción inválida. Saliendo del programa.");
                    return;
            }
            
            // Datos personales
            System.out.println("Ingrese su nombre:");
            nombre = scanner.next();
            System.out.println("Ingrese su apellido:");
            apellido = scanner.next();
            System.out.println("Ingrese su correo electrónico:");
            email = scanner.next();
             
            // Validación del correo electrónico
             boolean emailValido = false;
             do {
                 System.out.println("Ingrese su correo electrónico:");
                 email = scanner.next();
                 
                 if (email.contains("@") && (email.endsWith("gmail.com") || email.endsWith("hotmail.com") || email.endsWith("yahoo.com"))) {
                     emailValido = true;
                 } else {
                     System.out.println("Correo electrónico inválido. Por favor, ingrese un correo válido.");
                 }
             } while (!emailValido);     

            // Resumen de la compra
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fechaHoraActualFormateada = fechaHoraActual.format(formatoFechaHora);
            
            System.out.println("\nResumen de la compra:");
            System.out.println("Fecha: " + fechaHoraActualFormateada);
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Película: " + pelicula);
            System.out.println("Idioma: " + idioma);
            System.out.println("Cantidad de entradas: " + cantidadEntradas);
            System.out.println("Asiento: " + asiento);
            System.out.println("Subtotal: $" + subtotal);
            
            
            // Pagar o Cambiar algo
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("1. Pagar");
            System.out.println("2. Cambiar algo de lo anterior");
            int opcionPago = scanner.nextInt();

            if (opcionPago == 1) {
                System.out.println("\nSeleccione una opción de pago:");
                System.out.println("1. Efectivo");
                System.out.println("2. Tarjeta");
                int opcionMetodoPago = scanner.nextInt();

                if (opcionMetodoPago == 1) {
                    // Pago en efectivo
                    String codigoPago = generarCodigoAleatorio();
                    System.out.println("\nMuchas gracias por su compra.");
                    System.out.println("El código de pago es: " + codigoPago);
                    System.out.println("Por favor, muestre este código en caja para abonar y retirar su entrada. Este código es válido hasta 20 min antes de la función.");
                } else if (opcionMetodoPago == 2) {
                    // Pago con tarjeta
                    System.out.println("\nIngrese los datos de la tarjeta:");
                    System.out.println("Nombre y Apellido:");
                    String nombreTarjeta = scanner.next();
                    System.out.println("Número de tarjeta:");
                    String numeroTarjeta = scanner.next();
                    System.out.println("Fecha de vencimiento (MM/YY):");
                    String fechaVencimiento = scanner.next();
                    System.out.println("Código de seguridad:");
                    String codigoSeguridad = scanner.next();

                    if (nombreTarjeta.isEmpty() || numeroTarjeta.isEmpty() || fechaVencimiento.isEmpty() || codigoSeguridad.isEmpty()) {
                        System.out.println("No se proporcionaron todos los datos necesarios. La compra ha sido cancelada.");
                    } else {
                        System.out.println("\nMuchas gracias por su compra.");
                        System.out.println("El comprobante y las entradas fueron enviados por correo electrónico.");
                    }
                } else {
                    System.out.println("Opción inválida. La compra ha sido cancelada.");
                }
            } else if (opcionPago == 2) {
                System.out.println("La compra ha sido cancelada. Puede realizar cambios en su selección anterior.");
            } else {
                System.out.println("Opción inválida. La compra ha sido cancelada.");
            }
        }
    }

    public static String generarCodigoAleatorio() {
        // Genera un código aleatorio de 8 caracteres alfanuméricos
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }
}
