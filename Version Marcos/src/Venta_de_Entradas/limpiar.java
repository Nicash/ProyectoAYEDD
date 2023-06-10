public class limpiar {
    
    public static void consola() {

        try {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            
        } catch (Exception e) {

            //No hacer nada.

        }
    }
}