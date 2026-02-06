import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        GradeService gradeService = new GradeService();
        InputValidator inputValidator = new InputValidator();
        Scanner sc = new Scanner(System.in);

        String nombre= inputValidator.leerTextoNoVacio( "Introduce el nombre del alumno", sc);
        double a= inputValidator.leerDoubleEnRango(sc, "Introduce la primera calificacion", 0, 10);
        double b= inputValidator.leerDoubleEnRango(sc, "Introduce la segunda calificacion", 0, 10);
        double c= inputValidator.leerDoubleEnRango(sc,"Introduce la tercera calificacion", 0, 10);
        int asistencia= inputValidator.leerIntEnRango(sc,"Introduce la cantidad de asistencias", 0, 100);
        boolean entregoProyecto= inputValidator.leerBoolean("Entrego proyecto? true/false", sc);

        double calcularPromedio = gradeService.calcularPromedio(a, b, c);
        double calcularFinal = gradeService.calcularFinal(calcularPromedio, asistencia);
        String determinarEstado = gradeService.determinarEstado(calcularFinal, asistencia, entregoProyecto);

        System.out.println("Nombre del Alumno: " + nombre);
        System.out.println("Parciales: " + " Parcial 1: " + a + " Parcial 2: " + b + " Parcial 3: " + c);
        System.out.println("Promedio: " + calcularPromedio);
        System.out.println("Asistencia: " + asistencia);
        System.out.println("Entrego proyecto: " + entregoProyecto);
        System.out.println("Promedio final: " + calcularFinal);
        System.out.println("Estado: " + determinarEstado);


    }
}