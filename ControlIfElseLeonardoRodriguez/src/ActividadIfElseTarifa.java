import java.util.Scanner;


public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edad=0;
        String respuesta=" ";
        boolean esEstudiante;

        edad=obtenerEdad(scanner,"Ingrese su edad");
        if (edad>=18){
            System.out.println("¿Es estudiante?");
            scanner.nextLine();
            respuesta=obtenerEstudiante(scanner,"Si o No");
            if (respuesta.equals("Si")|| respuesta.equals("si")){
                esEstudiante=true;

                System.out.println("La edad ingresada es: " + edad);
                System.out.println("La persona es estudiante");
                System.out.println("La tarifa final es: 90 ");
            }else if(respuesta.equals("No")|| respuesta.equals("no")){
                esEstudiante=false;

                System.out.println("La edad ingresada es: " + edad);
                System.out.println("La persona no es estudiante");
                System.out.println("La tarifa final es: 120 ");
            }
        } else if (edad>12 && edad<=17){
            System.out.println("¿Es estudiante?");
            scanner.nextLine();
            respuesta=obtenerEstudiante(scanner,"Si o No");
            if (respuesta.equals("Si")|| respuesta.equals("si")){
                esEstudiante=true;

                System.out.println("La edad ingresada es: " + edad);
                System.out.println("La persona es estudiante");
                System.out.println("La tarifa final es: 60 ");
            }else if(respuesta.equals("No")|| respuesta.equals("no")){
                esEstudiante=false;

                System.out.println("La edad ingresada es: " + edad);
                System.out.println("La persona no es estudiante");
                System.out.println("La tarifa final es: 80 ");
            }
        } else if (edad<12) {
            System.out.println("La edad ingresada es: " + edad);
            System.out.println("La tarifa final es: 50 ");
        }
        if (edad <0 || edad> 120) {
            System.out.println("Edad invalida");
        }

    }

    public static int obtenerEdad(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        return scanner.nextInt();
    }


    public static String obtenerEstudiante(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        return scanner.nextLine();
    }
}

