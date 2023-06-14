public class Principal{
        
    public static void main(String[] args) throws Exception {

        // ARRANCAMOS CON LA SECUENCIA DEL PROGRAMA   

        Cliente.crearCuentaAdmin("33469835","Nicolás","Chaves","nicolas@gmail.com","12345678910"); //creamos un usuario para pruebas
        Cliente.crearCuentaAdmin("36372460","Gustavo","Valkovich","gustavo@gmail.com","12345678910");
        Cliente.crearCuentaAdmin("46044313","Marcos","Gómez","marcos@gmail.com.com","12345678910");
        Cliente.crearCuentaAdmin("33805965","Emiliano","Druetta","emiliano@gmail.com","12345678910");
        Cliente.crearCuentaAdmin("33805965","Lautaro","Espil Crespo","lautaro@gmail.com","12345678910");
        Cliente.crearCuentaAdmin("33805965","Nicolas","Carril","nicolascarril@gmail.com","12345678910");
        Estadio.randomizarEstadio(); //damos lugares aleatorios al estadio para simular compras anteriores

        Menu.ejecutarMenu(); //llamamos al bucle del menu

    }
    
}