import java.util.Scanner;

public class Main {

    public static double CLASIFICACION_BAJA=18.5;
    public static double CLASIFICACION_MEDIA=25;
    public static double CLASIFICACION_ALTA=30;
    public static double FACTOR_CONVERSION=1.8;
    public static double DESP_PUNTO_CERO=32;
    public static double PI=3.1416;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Bienvenido");
            System.out.println("Menu:");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.print("Seleccione la opcion que desea realizar");


            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    double pesoKg= obtenerDouble(sc,"Ingresa el peso en KG");
                    double estaturaM= obtenerDouble(sc,"Ingresa la estatura en M -> 1.80");
                    double IMC= calcularIMC(pesoKg,estaturaM);
                    System.out.println("IMC: "+IMC);
                    String clasificacion= obtenerClasificicacionIMC(IMC);
                    System.out.println("Clasificación "+ clasificacion);
                    System.out.println("Seleccionaste calcular el IMC");
                    break;
                case 2:
                    double baseCm= obtenerDouble(sc, "Ingresa la base del rectangulo en Cm");
                    double alturaCm= obtenerDouble(sc, "Ingres la altura del rectangulo en Cm");
                    double areaRect= calcularArea(baseCm,alturaCm);
                    System.out.println("El area del rectangulo es: " + areaRect + " cm²");
                    System.out.println("Seleccionaste calcular el area de un rectangulo");
                    break;
                case 3:
                    double gradCentigrados= obtenerDouble(sc,"Ingrese los grados Centigrados a convertir");
                    double cenAfahrent= calcularGrados(gradCentigrados);
                    System.out.println("Grados centigrados a Fahrenheit: " + "°" + cenAfahrent);
                    System.out.println("Seleccionaste convertir grados Centigrados a Fahrenheit");
                    break;
                case 4:
                    double radio= obtenerDouble(sc, "Ingrese el radio del circulo en Cm");
                    double areaCirculo= calcAreaCirculo(radio);
                    System.out.println("El area del circulo es: " + areaCirculo + " cm");
                    break;
                case 5:
                    System.out.println("Seleccionaste salir");
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
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /** * Metodo que devuelve el IMC con formula -> peso/altura²
     * * @param pesoKg -> expresado en Kilos * @param alturaM -> expresado en Metros
     * * @return -> double de IMC
     * */
    public static double calcularIMC(double pesoKg, double estaturaM){
        return pesoKg/(estaturaM*estaturaM);
    }

    /** * Metodo que clasifica IMC segun reglas de negocio establecidas
     * * Bajo-> IMC<18.5
     * * @param IMC -> Previamente calculado por el sistema
     * * @return -> String de clasficacion */
    public static String obtenerClasificicacionIMC(double IMC){
        if(IMC<CLASIFICACION_BAJA) return "Peso Bajo";
        else if(IMC<CLASIFICACION_MEDIA) return "Medio";
        else if(IMC<CLASIFICACION_ALTA) return "Sobre peseo";
        else return "Obesidad";
    }

    /** Metodo que calcula el area de un rectangulo y devuelve el resultado
     *
     * @param baseCm -> base del rectangulo expresada en Centimetros
     * @param alturaCm -> altura del rectangulo expresada en Centimetros
     * @return -> double de areaRect
     */
    public static double calcularArea(double baseCm,double alturaCm) {
        return (baseCm*alturaCm);
    }

    /** Metodo que convierte los grados Centigrados a Fahrenheit
     *
     * @param gradCentrigrados -> grados Centigrados expresados con el simbolo "°"
     * @return -> double de cenAfahrent
     */
    public static double calcularGrados(double gradCentrigrados) {
        return (gradCentrigrados*FACTOR_CONVERSION) + DESP_PUNTO_CERO;
    }

    /** Metodo que calcula el area de un circulo y devuelve el resultado
     *
     * @param radio -> radio del circulo expresado en Centimetros
     * @return -> double de areaCirculo
     */
    public static double calcAreaCirculo(double radio) {
        return PI*(radio*radio);
    }

}