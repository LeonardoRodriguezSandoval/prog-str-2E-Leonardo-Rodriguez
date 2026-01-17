import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int numero= obtenerNumero(sc, "Ingrese un numero entero no negativo:");
        int resultado= realizarSuma(numero);
        System.out.println("El resultado es: " + resultado);

        sc.close();
    }

    /** Metodo que retorna un valor capturado por la terminal
     *
     * @param sc -> Declarado en main
     * @param mensaje -> es un parametro
     * @return -> double
     */
    public static int obtenerNumero(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /** Metodo que devuelve el resultado de la suma acumulativa de un numero introducido por el usuario
     *
     * @param numero -> expresado como un numero entero que no sea negativo
     * @return -> int de suma
     */
    public static int realizarSuma(int numero){
        int suma= 0;

        for(int i=1;i<=numero;i++){
            suma += i;
        }
        return suma;
    }
}
