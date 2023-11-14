import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {

    private static final String RUTA_ARCHIVO_JSON = "clientes.json";

    public static void guardarClientesJson(Cliente[] arrayClientes) {
        JSONArray clientesJson = new JSONArray();

        for (Cliente cliente : arrayClientes) {
            if (cliente != null) {
                JSONObject clienteJson = new JSONObject();
                clienteJson.put("apellido", cliente.getApellido());
                clienteJson.put("nombre", cliente.getNombre());
                clienteJson.put("dni", cliente.getDNIString());
                clienteJson.put("telefono", cliente.getTelefono());
                clienteJson.put("email", cliente.getEmail());

                // Incluir las variables adicionales
                JSONArray entradasCompradasJson = new JSONArray();
                for (int[] entrada : cliente.entradasCompradas()) {
                    if(entrada[0] != 0){
                        JSONArray entradaJson = new JSONArray();
                        entradaJson.add(entrada[0]);
                        entradaJson.add(entrada[1]);
                        entradasCompradasJson.add(entradaJson);
                    }
                }
                clienteJson.put("entradasCompradas", entradasCompradasJson);
                clienteJson.put("contadorEntradas", cliente.getContadorEntradas());

                clientesJson.add(clienteJson);
            }
        }

        try (FileWriter fileWriter = new FileWriter(RUTA_ARCHIVO_JSON)) {
            fileWriter.write(clientesJson.toJSONString());
            System.out.println(Variables.Color.VERDE + "Clientes guardados correctamente." + Variables.Color.RESET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cliente[] cargarClientesJson() {
        File archivo = new File(RUTA_ARCHIVO_JSON);

        if (!archivo.exists()) {
            System.out.println("El archivo no existe. Se devolverá un array vacío.");
            return new Cliente[0];
        }
        JSONParser parser = new JSONParser();

        try (FileReader fileReader = new FileReader(RUTA_ARCHIVO_JSON)) {
            JSONArray clientesJson = (JSONArray) parser.parse(fileReader);

            Cliente[] arrayClientes = new Cliente[clientesJson.size()];

            for (int i = 0; i < clientesJson.size(); i++) {
                JSONObject clienteJson = (JSONObject) clientesJson.get(i);
                String dni = (String) clienteJson.get("dni");
                String nombre = (String) clienteJson.get("nombre");
                String apellido = (String) clienteJson.get("apellido");
                String email = (String) clienteJson.get("email");
                String telefono = (String) clienteJson.get("telefono");

        
                JSONArray entradasCompradasJson = (JSONArray) clienteJson.get("entradasCompradas");
                long contadorEntradas = (long) clienteJson.get("contadorEntradas");
                int[][] entradasCompradas = new int[entradasCompradasJson.size()][2];
                for (int j = 0; j < contadorEntradas; j++) {
                    JSONArray entradaJson = (JSONArray) entradasCompradasJson.get(j);
                    entradasCompradas[j][0] = Integer.parseInt(entradaJson.get(0).toString());
                    entradasCompradas[j][1] = Integer.parseInt(entradaJson.get(1).toString());
                }


                arrayClientes[i] = new Cliente(dni, nombre, apellido, email, telefono);
                arrayClientes[i].guardarEntradasCompradas(entradasCompradas,(int) contadorEntradas);
            }

            System.out.println("Clientes cargados desde el archivo JSON correctamente.");

            return arrayClientes;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
