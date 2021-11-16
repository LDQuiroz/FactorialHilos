import java.util.logging.Logger;

public class FactHilos implements Runnable {
    /*
    Desarrollar un programa en Java que a través de la línea de comandos reciba una lista de n números
    enteros y calcule el número factorial correspondiente a cada uno de los números en la lista.
    El cómputo de cada factorial se debe realizar en hilo (thread).
     */


    //long porque a partir de ciertos numeros, sus factoriales son muy grandes
    private long num;


    public FactHilos(int n) {
        num = n;
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No se encontraron argumentos");
        }
        int cantidad = args.length;
        int n;
        for (int i = 0; i < cantidad; i++) {
            n = Integer.parseInt(args[i]);
            Thread hilo = new Thread( new FactHilos(n) );
            hilo.start();
        }


    }

    @Override
    public void run() {
        long fact=1;
        for (long i = num; i > 0; i--) {
            fact *= i;
        }
        String nombre = Thread.currentThread().getName();
        System.out.println(nombre+ " calculó el factorial de " + num + ": " + fact);
    }
}
