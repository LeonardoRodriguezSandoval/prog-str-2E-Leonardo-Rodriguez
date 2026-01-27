import java.util.Scanner;

public class Main {

    public static double FACTOR_CONVERSION=1.8;
    public static double DESP_PUNTO_CERO=32;
    public static double FACTOR_CONVERSION_F=0.5555;
    public static double MILLAS=0.621371;
    public static double KILOMETROS=1.60934;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        double kilometros;
        double millas;
        int contadorGeneral=0;
        int contadorCentigrados=0;
        int contadorFahrenheit=0;
        int contadorKilometros=0;
        int contadorMillas=0;

        do {

            System.out.println("Bienvenido");
            System.out.println("Menu:");
            System.out.println("1. Convertir °C a °F");
            System.out.println("2. Convertir °F a °C");
            System.out.println("3. Convertir Km a Millas");
            System.out.println("4. Convertir Millas a Km");
            System.out.println("5. Salir");
            System.out.print("Seleccione la opcion que desea realizar");


            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    double gradCentigrados= obtenerDouble(sc,"Ingrese los grados Centigrados a convertir");
                    double cenAfahrent= calcularGrados(gradCentigrados);
                    System.out.println("Grados centigrados a Fahrenheit: " + "°" + cenAfahrent);
                    contadorCentigrados ++;
                    contadorGeneral ++;
                    System.out.println("Seleccionaste convertir grados Centigrados a Fahrenheit");
                    break;
                case 2:
                    double gradFahrenheit= obtenerDouble(sc, "Ingrese los grados Fahrenheit a convertir");
                    double fahACentigrados= calcularGradosFahrenheit(gradFahrenheit);
                    System.out.println("Grados Fahrenheit a Centigrados: " + "°" + fahACentigrados);
                    contadorFahrenheit++;
                    contadorGeneral++;
                    System.out.println("Seleccionaste convertir grados Fahrenheit a Centigrados");
                    break;
                case 3:
                    kilometros= obtenerDouble(sc, "Ingrese los Kilometros a convertir");
                    millas= calcularMillas(kilometros);
                    System.out.println("Kilometros a Millas: " + millas);
                    contadorMillas ++;
                    contadorGeneral ++;
                    System.out.println("Seleccionaste convertir Kilometros a Millas");
                    break;
                case 4:
                    millas= obtenerDouble(sc, "Ingrese las Millas a convertir");
                    kilometros= calcularKilometros(millas);
                    System.out.println("Millas a Kilometros: " + kilometros);
                    contadorMillas ++;
                    contadorGeneral ++;
                    System.out.println("Seleccionaste convertir Millas a Kilometros");
                case 5:
                    System.out.println("Seleccionaste salir");
                    System.out.println("Conversiones totales: " + contadorGeneral);
                    System.out.println("Conversiones de grados Centigrados a Fahrenheit: " + contadorCentigrados);
                    System.out.println("Conversiones de grados Fahrenheit a Centigrados: " + contadorFahrenheit);
                    System.out.println("Conversiones de Kilometros a Millas: " + contadorKilometros);
                    System.out.println("Conversiones de Millas a Kilometros: " + contadorMillas);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.println();

        } while (choice != 5);


    }

    /** * Metodo que retorna un valor capturado por la terminal
     *  * @param sc -> previamente declarado en main
     *  * @param mensaje -> es un parametro
     *  * @return -> double
     *  */
    public static double obtenerDouble(Scanner sc, String mensaje){
        double valorValido;

        while(true){
            System.out.println(mensaje);
            if (sc.hasNextDouble()){
                valorValido= sc.nextDouble();
            } else {
                System.out.println("El valor ingresado no es un valor numerico");
                sc.next();
            }
            return sc.nextDouble();
        }
    }

    /** Metodo que convierte los grados Centigrados a Fahrenheit
     *
     * @param gradCentrigrados -> grados Centigrados expresados con el simbolo "°"
     * @return -> double de cenAfahrent
     */
    public static double calcularGrados(double gradCentrigrados) {
        return (gradCentrigrados*FACTOR_CONVERSION) + DESP_PUNTO_CERO;
    }

    /** Metodo que convierte los grados Fahrenheit a Centigrados
     *
     * @param gradFahrenheit -> grados Fahrenheit expresados con el simbolo "°"
     * @return -> double de fahACentigrados
     */
    public static double calcularGradosFahrenheit(double gradFahrenheit) {
        return ((gradFahrenheit-DESP_PUNTO_CERO)*FACTOR_CONVERSION_F);
    }

    /** Metodo que convierte los Kilometros a Millas
     *
     * @param kilometros -> valor previamente solicitado al usuario
     * @return -> double de millas
     */
    public static double calcularMillas(double kilometros){
        return (kilometros*MILLAS);
    }

    /** Metodo que convierte las Millas a Kilometros
     *
     * @param millas -> valor previamente solicitado al usuario
     * @return -> doubke de kilometros
     */
    public static double calcularKilometros(double millas){
        return (millas*KILOMETROS);
    }

}