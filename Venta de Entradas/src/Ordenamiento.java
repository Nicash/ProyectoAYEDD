import java.util.ArrayList;

//Ordenamiento por burbuja
public class Ordenamiento {
    public static ArrayList<Cliente> ordenarLista(Cliente[] listaDesordenada){
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        for (Cliente cliente : listaDesordenada) {
            if(cliente != null){
                listaClientes.add(cliente);
            }
        }

        for(int i=0;i<listaClientes.size();i++){
            for(int j=0;j<listaClientes.size()-i-1;j++){
                int actual = listaClientes.get(j).getDNI();
                int siguiente = listaClientes.get(j+1).getDNI();
                
                if(actual > siguiente){
                    Cliente temporal = listaClientes.get(j);
                    listaClientes.set(j, listaClientes.get(j+1));
                    listaClientes.set(j+1, temporal);
                }

            }
        }

        return listaClientes;
    }
}


