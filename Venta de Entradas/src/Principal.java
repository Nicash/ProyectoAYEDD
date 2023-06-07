public class Principal{
        
    public static void main(String[] args) throws Exception {

        // ARRANCAMOS CON LA SECUENCIA DEL PROGRAMA
               
        Cliente.crearCuentaAdmin("33469835","Nicolas","Chaves","nicash14@gmail.com","3412294741");
        
        Estadio.randomizarEstadio(); //damos lugares aleatorios al estadio para simular compras anteriores
        Menu.ejecutarMenu(); //llamamos al bucle del menu

    }
    
}