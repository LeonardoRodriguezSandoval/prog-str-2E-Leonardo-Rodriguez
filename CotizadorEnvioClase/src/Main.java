import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        ShippingCalculator ticket1 = new ShippingCalculator();
        InputValidator inputValidator = new InputValidator();
        Scanner sc = new Scanner(System.in);
        double pesoKg= InputValidator.leerDoubleEnRango("Ingresa el peso en kilogramos", sc);
        int distanciaKm= InputValidator.leerIntEnRango("Ingresa la distancia en Kilometros", sc);
        boolean esZonaRemota= InputValidator.leerBoolean("Es zona remota?: true/false", sc);
        int tipoDeServicio= InputValidator.obtenerTipoDeServicio("Selecciona el tipo de servicio,1.-Estandar,2.-Express", sc);

        ticket1.procesarOperaciones(pesoKg, distanciaKm, esZonaRemota, tipoDeServicio);
        ticket1.imprimirTicket(pesoKg, distanciaKm, esZonaRemota, tipoDeServicio);



    }

}
