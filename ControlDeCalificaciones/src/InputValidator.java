import java.util.Scanner;

public class InputValidator {

    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double value;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("El dato esta fuera de rango");
            } else {
                System.out.println("El dato no es numerico");
                sc.next();
            }
        }

    }

    public int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int value;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("El dato esta fuera de rango");
            } else {
                System.out.println("El dato no es numerico");
                sc.next();
            }
        }
    }

    public boolean leerBoolean(String msg, Scanner sc) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("El valor no es boolean");
                sc.nextLine();
            }
        }
    }

    public String leerTextoNoVacio(String msg, Scanner sc) {
        String texto;

        do {
            System.out.println(msg);
            texto = sc.nextLine();
            if (texto.isBlank()){
                System.out.println("Error,no se a introducido ningun texto");
            }
        } while (texto.isBlank());
        return texto;
    }


}
