import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static double a;
    public static double b;
    public static double resultado;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("Bienvenido");
            System.out.println("Menu:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Seleccione la opcion que desea realizar");


            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el primer valor a sumar");
                    a = scanner.nextDouble();
                    System.out.println("Ingrese el segundo valor a sumar");
                    b = scanner.nextDouble();
                    resultado= a + b;
                    System.out.println("Operacion realizada: Suma");
                    System.out.println("Valores ingresados: " + "a: " + a + " b: " + b);
                    System.out.println("Resultado de la suma: " + resultado);
                    break;
                case 2:
                    System.out.println("Ingrese el primer valor a restar");
                    a = scanner.nextDouble();
                    System.out.println("Ingrese el segundo valor a restar");
                    b = scanner.nextDouble();
                    resultado= a - b;
                    System.out.println("Operacion realizada: Resta");
                    System.out.println("Valores ingresados: " + "a: " + a + " b: " + b);
                    System.out.println("Resultado de la resta: " + resultado);
                    break;
                case 3:
                    System.out.println("Ingrese el primer valor a multiplicar");
                    a = scanner.nextDouble();
                    System.out.println("Ingrese el segundo valor a multiplicar");
                    b = scanner.nextDouble();
                    resultado= a * b;
                    System.out.println("Operacion realizada: Multiplicar");
                    System.out.println("Valores ingresados: " + "a: " + a + " b: " + b);
                    System.out.println("Resultado de la multiplicacion: " + resultado);
                    break;
                case 4:
                    System.out.println("Ingrese el primer valor a dividir");
                    a = scanner.nextDouble();
                    System.out.println("Ingrese el segundo valor a dividir");
                    b = scanner.nextDouble();
                    if (b == 0){
                        System.out.println("No se puede dividir entre cero");
                    } else {
                        resultado= a / b;
                        System.out.println("Operacion realizada: Dividir");
                        System.out.println("Valores ingresados: " + "a: " + a + " b: " + b);
                        System.out.println("Resultado de la division: " + resultado);
                    }
                    break;
                case 5:
                    System.out.println("Seleccionaste salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.println();

           } while (opcion != 5);
        }
    }