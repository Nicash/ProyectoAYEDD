public class Principal{
        
    public static void main(String[] args) throws Exception {

        // ARRANCAMOS CON LA SECUENCIA DEL PROGRAMA   

        Cliente.crearCuentaAdmin("33469835","Nicolás","Chaves","nicash14@gmail.com","3412294741"); //creamos un usuario para pruebas
        Cliente.crearCuentaAdmin("36372460","Gustavo","Valkovich","gustavo.valkovich@gmail.com","3516844989");
        Cliente.crearCuentaAdmin("46044313","Marcos","Gómez","marcosgomez100704@gmail.com","3462224824");
        Cliente.crearCuentaAdmin("1","Prueba","Pruebencio","test@gmail.com","testtel");
        Estadio.randomizarEstadio(); //damos lugares aleatorios al estadio para simular compras anteriores

        Menu.ejecutarMenu(); //llamamos al bucle del menu

    }
    
}