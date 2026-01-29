import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int contadorFueraDeRango= 0;
    public static int contadorNoNumerico= 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int intentos = 0;
        int limiteIntentos = 7;
        int secreto = random.nextInt(max) + min;
        boolean gano = false;
        int contadorMayor = 0;
        int contadorMenor = 0;

        System.out.println("Adivina el numero entre el 1 al 100,tienes 7 intentos");

        while (intentos < limiteIntentos && !gano) {
            int valor = obtenerNumero(min, max, sc, "Intento numero: " + (intentos + 1));
            intentos++;
            if (valor == secreto) {
                System.out.println("Ganaste,  de intentos: " + intentos);
                System.out.println("Numero de veces que el numero fue mayor: " + contadorMayor);
                System.out.println("Numero de veces que el numero fue menor: " + contadorMenor);
                System.out.println("Numero de veces que el numero se paso del rango: " + contadorFueraDeRango);
                gano = true;
            } else if (valor > secreto) {
                System.out.println("El numero es menor");
                contadorMenor++;
            } else {
                System.out.println("El numero es mayor");
                contadorMayor++;
            }
        }
        if (!gano) {
            System.out.println("Perdiste,el numero secreto era: " + secreto);
            System.out.println("Perdiste,numero de intentos: " + intentos);
            System.out.println("Numero de veces que el numero fue mayor: " + contadorMayor);
            System.out.println("Numero de veces que el numero fue menor: " + contadorMenor);
            System.out.println("Numero de veces que el numero se paso del rango: " + contadorFueraDeRango);
        }
        sc.close();
    }

    public static int obtenerNumero(int min, int max, Scanner scanner, String mensaje){
        int valor;
        while(true) {
            System.out.println(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Numero fuera de rango debe de ser entre " + min + " y" + max);
                contadorFueraDeRango++;
            } else {
                System.out.println("El dato que ingresaste no es un numero");
                contadorNoNumerico++;
                scanner.next();
            }
        }

        }

    }


