import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numUno= obtenerInteger(scanner, "Ingresa el primer numero entero: ");
        int numDos= obtenerInteger(scanner, "Ingresa el segundo numero entero: ");
        int numTres= obtenerInteger(scanner, "Ingresa el tercer numero entero: ");
        int suma= resultadoSuma(numUno,numDos,numTres);
        int promedio= resultadoPromedio(suma);
        System.out.println("El resultado de la suma es: " + suma);
        System.out.println("El promedio es: " + promedio);
    }

    /** Metodo que retorna un valor capturado por la terminal
     *
     * @param scanner -> previamente declarado en main
     * @param mensaje -> es un parametro
     * @return -> int
     */
    public static int obtenerInteger(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        return scanner.nextInt();
    }

    /** Metodo que retorna el resultado de la suma de las variables numUno,numDos,numTres
     *
     * @param numUno -> previamente declarado en main como valor entero
     * @param numDos -> previamente declarado en main como valor entero
     * @param numTres -> previamente declarado en main como valor entero
     * @return -> int de suma
     */
    public static int resultadoSuma(int numUno, int numDos, int numTres){
        return (numUno + numDos + numTres);
    }

    /** Metodo que retorna el resultado de la operacion para calcular el promedio
     *
     * @param suma -> resultado de la operacion de suma de los tres numeros enteros
     * @return -> int de promedio
     */
    public static int resultadoPromedio(int suma){
        return (suma / 3);
    }
}
