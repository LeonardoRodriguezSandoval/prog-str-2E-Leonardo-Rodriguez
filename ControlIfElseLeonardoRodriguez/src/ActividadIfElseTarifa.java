import java.util.Scanner;


public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edad;
        int tarifa = 0;
        String respuesta=" ";
        boolean esEstudiante;

        edad=obtenerEdad(scanner,"Ingrese su edad");
        if (edad>=18){
            System.out.println("Eres estudiante?");
            scanner.nextLine();
            respuesta=obtenerEstudiante(scanner,"Si o No");
            if (respuesta.equals("Si")|| respuesta.equals("si")){
                esEstudiante=true;
                tarifa = 90;
            }else if(respuesta.equals("No")|| respuesta.equals("no")){
                esEstudiante=false;
                tarifa = 120;
            }
        } else if (edad>12 && edad<=17){
            System.out.println("Eres estudiante?");
            scanner.nextLine();
            respuesta=obtenerEstudiante(scanner,"Si o No");
            if (respuesta.equals("Si")|| respuesta.equals("si")){
                esEstudiante=true;
                tarifa = 60;
            }else if(respuesta.equals("No")|| respuesta.equals("no")){
                esEstudiante=false;
                tarifa = 80;
            }
        } else if (edad<12) {
            System.out.println("Eres estudiante?");
            scanner.nextLine();
            respuesta=obtenerEstudiante(scanner,"Si o No");
            if (respuesta.equals("Si")|| respuesta.equals("si")){
                esEstudiante=true;
                tarifa = 50;
            } else if (respuesta.equals("Si")|| respuesta.equals("si")){
                esEstudiante=false;
                tarifa = 50;d
            }
        }
        if (edad <0 || edad> 120) {
            System.out.println("Edad invalida");
        } else {
            System.out.println("La edad ingresada es: " + edad);
            System.out.println("La persona es estudiante");
            System.out.println("La tarifa final es: " + tarifa);
        }

    }

    /** Metodo que retorna un valor capturado por la terminal
     *
     * @param scanner -> previamente declarado en main
     * @param mensaje -> es un parametro
     * @return -> int
     */
    public static int obtenerEdad(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        return scanner.nextInt();
    }

    /** Metodo que retorna un valor capturado por la terminal y un mensaje previamente declarado
     *
     * @param scanner -> previamente declarado en main
     * @param mensaje -> es un parametro
     * @return -> String de mensaje
     */
    public static String obtenerEstudiante(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        return scanner.nextLine();
    }
}

