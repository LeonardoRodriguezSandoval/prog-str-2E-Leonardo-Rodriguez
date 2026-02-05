import java.util.Scanner;

public class InputValidator {

    public static double leerDoubleEnRango(String mensaje, Scanner sc) {
        double valor;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= 0.1 && valor <= 50.0) {
                    return valor;
                }
                System.out.println("El numero ingresado no es valido(Solo numeros de 0.1 a 50.0)");
            } else {
                System.out.println("El dato ingresado no es numerico (Solo se aceptan numeros)");
                sc.nextLine();
            }
        }
    }

    public static int leerIntEnRango(String mensaje, Scanner sc) {
        int valor;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= 1 && valor <= 2000) {
                    return valor;
                }
                System.out.println("El numero ingresado no es valido(Solo numeros de 1 a 2000)");
            } else {
                System.out.println("El dato ingresado no es numerico (Solo se aceptan numeros)");
                sc.nextLine();
            }
        }
    }

    public static boolean leerBoolean(String mensaje, Scanner sc) {
        boolean valor;
        String entradaDelUsuario;

        while (true) {
            System.out.println(mensaje);
            entradaDelUsuario = sc.nextLine().toLowerCase();

            if (entradaDelUsuario.equals("true")) {
                valor = true;
                break;
            } else if (entradaDelUsuario.equals("false")) {
                valor = false;
                break;
            } else {
                System.out.println("Error,solamente se acepta true o false");
            }
        }
        return valor;
    }

    public static int obtenerTipoDeServicio(String mensaje, Scanner sc){
        int valor;
        
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                if (valor==1){
                    return valor;
                } else if (valor==2) {
                    return valor;
                } else {
                    System.out.println("La opcion seleccionada no es valida,solamente se permite 1 y 2");
                }
                System.out.println("La opcion ingresada no es numerica,solo se acepta 1 y 2");
            }
        }
    }
}